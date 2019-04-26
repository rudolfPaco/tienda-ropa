/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rudolf
 */
public class TiendaDao {
    
    private Conexion conexion;

    public TiendaDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public Tienda getTienda(){
        Tienda tienda = null;
        try {
            String sql = "select * from tienda order by TiendaID desc limit 1";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            
            while (rs.next()) {
                tienda = new Tienda(rs.getInt("TiendaID"));                
                tienda.setNombreTienda(rs.getString("NombreTienda"));
                tienda.setDescripcionTienda(rs.getString("DescripcionTienda"));
                tienda.setDireccionTienda(rs.getString("DireccionTienda"));
                tienda.setTelefonosTienda(rs.getString("TelefonosTienda"));
                tienda.setCiudadTienda(rs.getString("CiudadTienda"));
                tienda.setPaisTienda(rs.getString("PaisTienda"));
                tienda.setCambioDolar(rs.getDouble("CambioDolar"));
                tienda.setEstadoTienda(rs.getString("estadoTienda"));
                tienda.setUrlLogo(rs.getString("urlLogo"));                
            }
        } catch (SQLException e) {      
            System.out.println("Error TiendaDao.getTienda: " + e.getMessage());
        }
        return tienda;
    }
    public boolean seModificoTienda(Tienda t){
        boolean verificador = false;
        String sql = "UPDATE tienda SET nombreTienda=?, descripcionTienda=?, direccionTienda=?, telefonosTienda=?, ciudadTienda=?, paisTienda=?, cambioDolar=?, estadoTienda=?, urlLogo=?, LogoTienda=? WHERE `TiendaID`='"+t.getTiendaID()+"';";        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            File file = new File(t.getUrlLogo());
            FileInputStream archivo = new FileInputStream(file);
                        
            ps.setString(1, t.getNombreTienda());
            ps.setString(2, t.getDescripcionTienda());
            ps.setString(3, t.getDireccionTienda());
            ps.setString(4, t.getTelefonosTienda());
            ps.setString(5, t.getCiudadTienda());
            ps.setString(6, t.getPaisTienda());
            ps.setDouble(7, t.getCambioDolar());
            ps.setString(8, t.getEstadoTienda());            
            ps.setString(9, t.getUrlLogo());
            ps.setBinaryStream(10, archivo, file.length());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error TiendaDao.seModificoTienda(): "+e.getMessage());
        }
        return verificador;
    }
    
    public boolean seGuardoTiendaCorrectamente(Tienda t){
        boolean verificador = false;
        String sql = "insert into tienda values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            File file = new File(t.getUrlLogo());
            FileInputStream archivo = new FileInputStream(file);
                        
            ps.setInt(1, t.getTiendaID());
            ps.setString(2, t.getNombreTienda());
            ps.setString(3, t.getDescripcionTienda());
            ps.setString(4, t.getDireccionTienda());
            ps.setString(5, t.getTelefonosTienda());
            ps.setString(6, t.getCiudadTienda());
            ps.setString(7, t.getPaisTienda());
            ps.setDouble(8, t.getCambioDolar());
            ps.setString(9, t.getEstadoTienda());
            ps.setString(10, t.getUrlLogo());
            ps.setBinaryStream(11, archivo, file.length());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("TiendaDao.seGuardarTienda(): "+e.getMessage());
        }
        return verificador;
    }
}
