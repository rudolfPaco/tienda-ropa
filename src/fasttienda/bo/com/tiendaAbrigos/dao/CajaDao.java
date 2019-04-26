/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Caja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rudolf
 */
public class CajaDao {
    private Conexion conexion;

    public CajaDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public Caja getCajaApertura(int cajaID){
        String sql = "select * from caja where CajaID = "+cajaID;
        return getCaja(sql);
    }
    private Caja getCaja(String sql){
        Caja caja = null;
        try {            
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                caja = new Caja(rs.getInt("CajaID"));
                caja.setFechaApertura(rs.getString("fechaApertura"));
                caja.setHoraApertura(rs.getString("horaApertura"));
                caja.setFechaCierre(rs.getString("fechaCierre"));                
                caja.setHoraCierre(rs.getString("horaCierre"));                
                caja.setCajaInicial(rs.getDouble("cajaInicial"));
                caja.setVentaTotal(rs.getDouble("ventaTotal"));
                caja.setIngresoTotal(rs.getDouble("ingresoTotal"));
                caja.setGastoTotal(rs.getDouble("gastoTotal"));
                caja.setCajaTotal(rs.getDouble("cajaTotal"));                
                caja.setTiendaID(rs.getInt("TiendaID"));
            }
        } catch (SQLException e) {
            System.out.println("CajaDao.getCaja(): "+e.getMessage());
        }
        return caja;
    }
    public boolean seGuardoNuevaCaja(Caja caja){
        boolean verificador = false;
        try {
            String sql = "insert into caja values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, caja.getCajaID());
            ps.setString(2, caja.getFechaApertura());
            ps.setString(3, caja.getHoraApertura());            
            ps.setString(4, caja.getFechaCierre());
            ps.setString(5, caja.getHoraCierre());            
            ps.setDouble(6, caja.getCajaInicial());
            ps.setDouble(7, caja.getVentaTotal());
            ps.setDouble(8, caja.getIngresoTotal());
            ps.setDouble(9, caja.getGastoTotal());
            ps.setDouble(10, caja.getCajaTotal());            
            ps.setInt(11, caja.getTiendaID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("CajaDao.seGuardoNuevaCaja(Caja): "+e.getMessage());
        }
        return verificador;
    }
    /*public boolean seModificoCaja(Caja t){
        boolean verificador = false;
        try {
            String sql = "UPDATE caja SET fechaApertura=?, horaApertura=?, horaCierre=?, fechaCierre=?, unidadMonetaria=?, moneda=?, cajaInicial=?, ventaTotal=?, ingresoTotal=?, egresoTotal=?, totalCaja=?, totalEfectivo=?, sobranteFaltante=?, observacion=? WHERE `id`='"+t.getId()+"';";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                        
            ps.setString(1, t.getFechaApertura());
            ps.setString(2, t.getHoraApertura());
            ps.setString(3, t.getHoraCierre());
            ps.setString(4, t.getFechaCierre());
            ps.setString(5, t.getUnidadMonetaria());
            ps.setString(6, t.getMoneda());
            ps.setDouble(7, t.getCajaInicial());
            ps.setDouble(8, t.getVentaTotal());
            ps.setDouble(9, t.getIngresoTotal());
            ps.setDouble(10, t.getEgresoTotal());
            ps.setDouble(11, t.getTotalCaja());
            ps.setDouble(12, t.getTotalEfectivo());
            ps.setDouble(13, t.getSobranteFaltante());
            ps.setString(14, t.getObservacion());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error CajaDao.seModificoCaja(): "+e.getMessage());
        }
        return verificador;
    }*/
}
