/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Caja;
import fasttienda.bo.com.tiendaAbrigos.modelo.Impuesto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author neo
 */
public class ImpuestoDao {
    private Conexion conexion;

    public ImpuestoDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public Impuesto getImpuesto(){
        Impuesto i = null;
        try {
            String sql = "select * from impuesto";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = new Impuesto(rs.getInt("ImpuestoID"));
                i.setIt(rs.getDouble("iva"));
                i.setIt(rs.getDouble("it"));                
            }
        } catch (SQLException e) {
            System.out.println("ImpuestoDao.getImpuesto(): "+e.getMessage());
        }
        return i;
    }
    public boolean seGuardoNuevoImpuesto(Impuesto i){
        boolean verificador = false;
        try {
            String sql = "insert into impuesto values(?, ?, ?)";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, i.getImpuestoID());
            ps.setDouble(2, i.getIva());
            ps.setDouble(3, i.getIt());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("ImpuestoDao.seGuardoNuevoImpuesto(Impuesto): "+e.getMessage());
        }
        return verificador;
    }
}
