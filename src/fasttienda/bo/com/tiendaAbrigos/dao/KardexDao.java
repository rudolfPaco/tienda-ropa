/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleKardex;
import fasttienda.bo.com.tiendaAbrigos.modelo.Kardex;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author neo
 */
public class KardexDao {
    private Conexion conexion;

    public KardexDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardoKardex(Kardex k){
        boolean verificador = false;        
        String sql = "insert into kardex values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                                    
            ps.setInt(1, k.getId());
            ps.setString(2, k.getFechaInicial());
            ps.setString(3, k.getFechaFinal());
            ps.setString(4, k.getCodigoPrenda());
            ps.setString(5, k.getNombrePrenda());
            ps.setString(6, k.getUnidadMedida());
            ps.setInt(7, k.getCantInvInicial());
            ps.setInt(8, k.getCantCompras());
            ps.setInt(9, k.getCantDevCompras());
            ps.setInt(10, k.getCantVentas());            
            ps.setInt(11, k.getCantDevVentas());
            ps.setInt(12, k.getCantStockActual());
            ps.setDouble(13, k.getInventarioInicial());
            ps.setDouble(14, k.getComprasNetas());
            ps.setDouble(15, k.getInventarioFinal());
            ps.setDouble(16, k.getCostoVentas());
            ps.setDouble(17, k.getTotalVentas());
            ps.setInt(18, k.getIdPrenda());
            ps.setInt(19, k.getIdTienda());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error KardexDao.seGuardoKardex(): "+e.getMessage());
        }
        return verificador;
    }
    public boolean seGuardoDetalleKardex(DetalleKardex d){
        boolean verificador = false;        
        String sql = "insert into detalle_kardex values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
                                    
            ps.setInt(1, d.getId());
            ps.setString(2, d.getFechaKardex());
            ps.setString(3, d.getHoraKardex());
            ps.setString(4, d.getDetalleKardex());
            ps.setString(5, d.getCantidadEntrada());
            ps.setString(6, d.getCostoUnitarioEntrada());
            ps.setString(7, d.getTotalEntradas());
            ps.setString(8, d.getCantidadSalida());
            ps.setString(9, d.getCostoUnitarioSalida());
            ps.setString(10, d.getTotalSalidas());
            ps.setString(11, d.getCantidadExistencia());
            ps.setString(12, d.getCostoPromedioPonderado());
            ps.setString(13, d.getTotalExistencias());
            ps.setInt(14, d.getIdKardex());
            ps.setInt(15, d.getIdPrenda());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error KardexDao.seGuardoDetalleKardex(): "+e.getMessage());
        }
        return verificador;
    }
    
}
