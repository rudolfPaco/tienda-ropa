/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Dosificacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rudolf
 */
public class DosificacionDao {
    
    private Conexion conexion;

    public DosificacionDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public Dosificacion getDosificacion(){
        Dosificacion dosificacion = null;
        try {
            String sql = "select * from dosificacion order by DosificacionID desc limit 1";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dosificacion = new Dosificacion(rs.getInt("DosificacionID"));
                dosificacion.setNitContribuyente(rs.getString("NitContribuyente"));
                dosificacion.setNombreApellidoRazonSocial(rs.getString("NombreApellidoRazonSocial"));
                dosificacion.setNroTramiteDosificacion(rs.getString("NroTramiteDosificacion"));
                dosificacion.setLlaveDosificacion(rs.getString("LlaveDosificacion"));
                dosificacion.setNroAutorizacion(rs.getString("NroAutorizacion"));
                dosificacion.setCantidad(rs.getInt("Cantidad"));
                dosificacion.setRangoDesde(rs.getString("RangoDesde"));
                dosificacion.setRangoHasta(rs.getString("RangoHasta"));
                dosificacion.setFechaLimiteEmision(rs.getString("FechaLimiteEmision"));
                dosificacion.setAvisoLey(rs.getString("AvisoLey"));
                dosificacion.setIdTienda(rs.getInt("TiendaID"));
            }
            return dosificacion;
        } catch (SQLException e) {
            System.out.println("Error: DosificacionDao.getDosificacion() "+e.getMessage());
        }
        return dosificacion;
    }
    public boolean seGuardoDosificacion(Dosificacion d){
        boolean verificador = false;
        String sql = "insert into dosificacion values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);                                    

            ps.setInt(1, d.getIdDosificacion());
            ps.setString(2, d.getNitContribuyente());
            ps.setString(3, d.getNombreApellidoRazonSocial());
            ps.setString(4, d.getNroTramiteDosificacion());
            ps.setString(5, d.getLlaveDosificacion());
            ps.setString(6, d.getNroAutorizacion());
            ps.setInt(7, d.getCantidad());
            ps.setString(8, d.getRangoDesde());
            ps.setString(9, d.getRangoHasta());
            ps.setString(10, d.getFechaLimiteEmision());
            ps.setString(11, d.getAvisoLey());
            ps.setInt(12, d.getIdTienda());
            
            if(ps.executeUpdate() > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error DosificacionDao.seGuardoDosificacion(): "+e.getMessage());
        } 
        return verificador;
    }
    public boolean seModificoDosificacion(Dosificacion d){
        boolean verificador = false;
        String sql = "UPDATE dosificacion SET NitContribuyente=?, NombreApellidoRazonSocial=?, NroTramiteDosificacion=?, LlaveDosificacion=?, NroAutorizacion=?, Cantidad=?, RangoDesde=?, RangoHasta=?, FechaLimiteEmision=?, AvisoLey=? WHERE `DosificacionID`='"+d.getIdDosificacion()+"';";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                        
            ps.setString(1, d.getNitContribuyente());
            ps.setString(2, d.getNombreApellidoRazonSocial());
            ps.setString(3, d.getNroTramiteDosificacion());
            ps.setString(4, d.getLlaveDosificacion());
            ps.setString(5, d.getNroAutorizacion());
            ps.setInt(6, d.getCantidad());            
            ps.setString(7, d.getRangoDesde());
            ps.setString(8, d.getRangoHasta());
            ps.setString(9, d.getFechaLimiteEmision());
            ps.setString(10, d.getAvisoLey());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error DosificacionDao.seModificoDosificacion(): "+e.getMessage());
        }
        return verificador;
    }
}
