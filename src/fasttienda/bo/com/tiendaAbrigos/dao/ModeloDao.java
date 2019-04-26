/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Impuesto;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Unidad;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class ModeloDao {
    private Conexion conexion;

    public ModeloDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardoModelo(Modelo m){
        boolean verificador = false;        
        String sql = "insert into modelo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                                    
            ps.setInt(1, m.getModeloID());
            ps.setString(2, m.getCategoria());
            ps.setString(3, m.getMarca());
            ps.setString(4, m.getDetalle());
            ps.setString(5, m.getTipoColor());
            ps.setString(6, m.getColores());
            ps.setString(7, m.getTallas());
            ps.setString(8, m.getTela());
            ps.setString(9, m.getIndustria());
            ps.setString(10, m.getTemporada());            
            ps.setDouble(11, m.getCostoUnitario());
            ps.setDouble(12, m.getCostoUnitarioIva());
            ps.setDouble(13, m.getMargenUtilidad());
            ps.setDouble(14, m.getPrecioTope());
            ps.setDouble(15, m.getPrecioOficial());
            ps.setInt(16, m.getImpuestoID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ModeloDao.seGuardoModelo(): "+e.getMessage());
        }
        return verificador;
    }
    public ArrayList<Modelo> getAllModels(){
        ArrayList<Modelo> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement("select ModeloID from modelo");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelo modelo = getModelo("select * from modelo where ModeloID = "+rs.getInt("ModeloID"));                
                lista.add(modelo);
            }
            
        } catch (SQLException e) {
            System.out.println("Error... ModeloDao.getAllModels(): "+e.getMessage());
        }
        return lista;
    }
    
    private ArrayList<Unidad> getUnidades(int modeloID){
        
        ArrayList<Unidad> lista = new ArrayList<>();
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement("select * from unidad u, unidad_modelo um where u.unidadID = um.unidadID and um.modeloID = "+modeloID);
            ResultSet rs = preparedStatement.executeQuery();            
            
            while (rs.next()) {
                Unidad unidad = new Unidad(rs.getInt("ModeloID"));
                unidad.setNombreUnidad(rs.getString("NombreUnidad"));
                unidad.setUnidadMedida(rs.getString("UnidadMedida"));
                
                lista.add(unidad);
            }
            return lista;
        } catch (SQLException e) {            
            System.out.println("Error ModeloDao.agregarUnidades: " + e.getMessage());
            return lista;
        }        
    }
    
    private Modelo getModelo(String sql){
        Modelo modelo = null;
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            
            while (rs.next()) {
                modelo = new Modelo(rs.getInt("ModeloID"));
                modelo.setCategoria(rs.getString("Categoria"));
                modelo.setMarca(rs.getString("Marca"));
                modelo.setDetalle(rs.getString("Detalle"));
                modelo.setTipoColor(rs.getString("TipoColor"));
                modelo.setColores(rs.getString("Colores"));
                modelo.setTallas(rs.getString("Tallas"));
                modelo.setTela(rs.getString("Tela"));
                modelo.setIndustria(rs.getString("Industria"));
                modelo.setTemporada(rs.getString("Temporada"));
                modelo.setCostoUnitario(rs.getDouble("CostoUnitario"));
                modelo.setCostoUnitarioIva(rs.getDouble("CostoUnitarioIva"));
                modelo.setMargenUtilidad(rs.getDouble("MargenUtilidad"));
                modelo.setPrecioTope(rs.getDouble("PrecioTope"));
                modelo.setPrecioOficial(rs.getDouble("PrecioOficial"));
                modelo.setImpuestoID(rs.getInt("ImpuestoID"));
                modelo.setImpuesto(getImpuesto(modelo.getImpuestoID()));
                modelo.setUnidades(getUnidades(rs.getInt("ModeloID")));
            }
            return modelo;

        } catch (SQLException e) {            
            System.out.println("Error ModeloDao.getModelo: " + e.getMessage());
            return modelo;
        }
    }
    public Impuesto getImpuesto(int impuestoID){
        Impuesto impuesto = null;
        try {            
            String sql = "select * from impuesto where ImpuestoID = "+impuestoID;
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            
            while (rs.next()) {
                impuesto = new Impuesto(rs.getInt("ImpuestoID"));
                impuesto.setIva(rs.getDouble("IVA"));
                impuesto.setIt(rs.getDouble("IT"));                
            }
            return impuesto;

        } catch (SQLException e) {            
            System.out.println("Error ModeloDao.getImpuesto: " + e.getMessage());
            return impuesto;
        }
    }
}
