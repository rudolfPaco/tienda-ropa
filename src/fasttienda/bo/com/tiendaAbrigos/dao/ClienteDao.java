/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Cliente;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
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
public class ClienteDao {
    
    private Conexion conexion;

    public ClienteDao(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public boolean seGuardoCliente(Cliente t){
        boolean verificador = false;
        String sql = "insert into cliente values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);                        
            ps.setInt(1, t.getIdCliente());
            ps.setString(2, t.getRazonSocial());
            ps.setString(3, t.getNitCi());
            ps.setString(4, t.getNombreCliente());
            ps.setString(5, t.getDireccionCliente());
            ps.setString(6, t.getTelefonoCelular());
            ps.setString(7, t.getTelefonoFijo());
            ps.setString(8, t.getAntecedentesCliente());            
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("ClienteDao.seGuardoCliente(): "+e.getMessage());
        }
        return verificador;
    }
    public ArrayList<Cliente> getListaClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            String sql = "select * from cliente";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente(rs.getInt("ClienteID"));
                cliente.setRazonSocial(rs.getString("RazonSocial"));
                cliente.setNitCi(rs.getString("NitCi"));
                cliente.setNombreCliente(rs.getString("NombreCliente"));
                cliente.setDireccionCliente(rs.getString("DireccionCliente"));
                cliente.setTelefonoCelular(rs.getString("TelefonoCelular"));
                cliente.setTelefonoFijo(rs.getString("TelefonoFijo"));
                cliente.setAntecedentesCliente(rs.getString("AntecedenteCliente"));                
                lista.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println("Error... ClienteDao.getListaClientes(): "+e.getMessage());
        }
        return lista;
    }
            
}
