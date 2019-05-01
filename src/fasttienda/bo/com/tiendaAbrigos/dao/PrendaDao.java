/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hotel-felipez
 */
public class PrendaDao {
    
    private Conexion conexion;

    public PrendaDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardoPrenda(Prenda p){
        boolean verificador = false;        
        String sql = "insert into prenda values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                                  
            File file = new File(p.getUrlPrenda());
            FileInputStream archivo = new FileInputStream(file);
            
            ps.setInt(1, p.getId());
            ps.setString(2, p.getCodigo());
            ps.setString(3, p.getCategoria());
            ps.setString(4, p.getMarca());
            ps.setString(5, p.getColor());
            ps.setString(6, p.getTalla());
            ps.setDouble(7, p.getPrecio());
            ps.setInt(8, p.getCantidadMinima());
            ps.setString(9, p.getUbicacion());
            ps.setString(10, p.getUrlPrenda());
            ps.setBinaryStream(11, archivo, file.length());
            ps.setInt(12, p.getIdModelo());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error PrendaDao.seGuardoPrenda(): "+e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificador;
    }
    public ArrayList<Prenda> getAllPrendas(int idModelo){
        ArrayList<Prenda> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement("select p.prendaID, p.codigo, p.categoria, p.marca, p.color, p.talla, p.precio, p.cantidadMinima, p.ubicacion, p.urlPrenda, p.imagenPrenda, p.modeloID, k.cantStockActual from prenda p left join kardex k on (p.prendaID = k.prendaID) where p.modeloID = "+idModelo);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Prenda p = new Prenda(rs.getInt("prendaID"));
                p.setCodigo(rs.getString("codigo"));
                p.setCategoria(rs.getString("categoria"));
                p.setMarca(rs.getString("marca"));
                p.setColor(rs.getString("color"));
                p.setTalla(rs.getString("talla"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidadMinima(rs.getInt("cantidadMinima"));
                p.setUbicacion(rs.getString("ubicacion"));
                p.setUrlPrenda(rs.getString("urlPrenda"));
                p.setIdModelo(rs.getInt("modeloID"));
                p.setCantidadEntrante(rs.getInt("cantStockActual"));
                lista.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println("Error... PrendaDao.getAllPrendas(): "+e.getMessage());
        }
        return lista;
    }
    public boolean seModificoPrenda(Prenda p){
        boolean verificador = false;
        String sql = "UPDATE prenda SET codigo=?, categoria=?, marca=?, color=?, talla=?, precio=?, cantidadMinima=?, ubicacion=?, urlPrenda=?, imagenPrenda=? WHERE `id`='"+p.getId()+"';";        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            File file = new File(p.getUrlPrenda());
            FileInputStream archivo = new FileInputStream(file);
            
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getCategoria());
            ps.setString(3, p.getMarca());
            ps.setString(4, p.getColor());
            ps.setString(5, p.getTalla());
            ps.setDouble(6, p.getPrecio());
            ps.setInt(7, p.getCantidadMinima());
            ps.setString(8, p.getUbicacion());
            ps.setString(9, p.getUrlPrenda());
            ps.setBinaryStream(10, archivo, file.length());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error PrendaDao.seModificoPrenda(): "+e.getMessage());
        }
        return verificador;
    }
    private Prenda getPrenda(String sql){
        Prenda p = null;
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            
            while (rs.next()) {
                p = new Prenda(rs.getInt("prendaID"));
                p.setCodigo(rs.getString("codigo"));
                p.setCategoria(rs.getString("categoria"));
                p.setMarca(rs.getString("marca"));
                p.setColor(rs.getString("color"));
                p.setTalla(rs.getString("talla"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidadMinima(rs.getInt("cantidadMinima"));
                p.setUbicacion(rs.getString("ubicacion"));
                p.setUrlPrenda(rs.getString("urlPrenda"));
                p.setIdModelo(rs.getInt("idModelo"));
            }
            return p;

        } catch (SQLException e) {            
            System.out.println("Error PrendaDao.getPrenda: " + e.getMessage());
            return p;
        }
    }
}
