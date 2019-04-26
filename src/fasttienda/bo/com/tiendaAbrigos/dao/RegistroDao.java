/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class RegistroDao {
    private Conexion conexion;
    
    public RegistroDao(Conexion conexion){
        this.conexion = conexion;
    }
    public Registro getRegistroActivo(){
        Registro registro = getRegistro("select * from registro where estado = 'activo'");        
        return registro;
    }
    public ArrayList<Registro> getListaRegistros(int idCaja){
        ArrayList<Registro> lista = new ArrayList<>();
        
        try {
            String sql = "select RegistroID from registro where CajaID = "+idCaja;
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("RegistroID");
                Registro registro = getRegistro("select * from registro where RegistroID = "+id);
                lista.add(registro);
            }
            
        } catch (SQLException e) {
            System.out.println("RegistroDao.getListaRegistros(CajaID): "+e.getMessage());
        }        
        
        return lista;
    }
    private Registro getRegistro(String sql){
        Registro responsable = null;
        try {            
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                responsable = new Registro(rs.getInt("RegistroID"));
                responsable.setTipo(rs.getString("tipo"));
                responsable.setEstado(rs.getString("estado"));
                responsable.setHoraEntrada(rs.getString("horaEntrada"));
                responsable.setHoraSalida(rs.getString("horaSalida"));
                responsable.setTotalDineroIntangible(rs.getDouble("totalDineroIntangible"));
                responsable.setTotalDineroTangible(rs.getDouble("totalDineroTangible"));
                responsable.setEstadoDinero(rs.getString("estadoDinero"));
                responsable.setObservacion(rs.getString("observacion"));
                responsable.setEmpleadoEntranteID(rs.getInt("EmpleadoEntranteID"));
                responsable.setEmpleadoID(rs.getInt("EmpleadoID"));
                responsable.setCajaID(rs.getInt("CajaID"));
            }
        } catch (SQLException e) {
            System.out.println("RegistroDao.getRegistro(): "+e.getMessage());
        }
        return responsable;
    }
    public boolean seGuardoNuevoRegistro(Registro registro){
        boolean verificador = false;
        try {
            String sql = "insert into registro values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, registro.getRegistroID());
            ps.setString(2, registro.getTipo());
            ps.setString(3, registro.getEstado());            
            ps.setString(4, registro.getHoraEntrada());
            ps.setString(5, registro.getHoraSalida());            
            ps.setDouble(6, registro.getTotalDineroIntangible());
            ps.setDouble(7, registro.getTotalDineroTangible());
            ps.setString(8, registro.getEstadoDinero());
            ps.setString(9, registro.getObservacion());
            ps.setInt(10, registro.getEmpleadoEntranteID());
            ps.setInt(11, registro.getEmpleadoID());
            ps.setInt(12, registro.getCajaID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("ResponsableDao.seGuardoNuevoResponsable(Responsable): "+e.getMessage());
        }
        return verificador;
    }
}