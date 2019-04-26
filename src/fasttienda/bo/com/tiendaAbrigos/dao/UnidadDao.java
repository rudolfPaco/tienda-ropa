/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Unidad;
import fasttienda.bo.com.tiendaAbrigos.modelo.UnidadModelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author neo
 */
public class UnidadDao {
    private Conexion conexion;

    public UnidadDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardUnidadModelo(UnidadModelo uM){
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
}
