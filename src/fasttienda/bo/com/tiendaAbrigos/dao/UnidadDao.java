/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Unidad;
import fasttienda.bo.com.tiendaAbrigos.modelo.UnidadModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class UnidadDao {
    private Conexion conexion;

    public UnidadDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardoUnidadModelo(UnidadModelo uM){
        boolean verificador = false;        
        String sql = "insert into unidad_modelo values(?, ?)";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                                    
            ps.setInt(1, uM.getModeloID());
            ps.setInt(2, uM.getUnidadID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error UnidadDao.seGuardoUnidadModelo(): "+e.getMessage());
        }
        return verificador;
    }
    public boolean seModificoUnidadModelo(UnidadModelo uM, int UnidadID){
        boolean verificador = false;
        String sql = "update unidad_modelo set UnidadID =? where ModeloID = "+uM.getModeloID()+" and UnidadID = "+UnidadID;
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, uM.getUnidadID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error UnidadDao.seModificoModelo(): "+e.getMessage());
        }
        return verificador;
    }  
    public ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> unidades = new ArrayList<>();
        String sql = "select * from unidad";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Unidad unidad = new Unidad(rs.getInt("UnidadID"));
                unidad.setNombreUnidad(rs.getString("NombreUnidad"));
                unidad.setUnidadMedida(rs.getString("UnidadMedida"));
                unidades.add(unidad);
            }
        } catch (SQLException e) {
            System.out.println("Error UnidadDao.getUnidades(): "+e.getMessage());
        }
        return unidades;
    }
}
