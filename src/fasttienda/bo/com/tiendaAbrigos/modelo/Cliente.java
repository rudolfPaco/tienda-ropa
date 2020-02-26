/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.ClienteDao;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;

/**
 *
 * @author hotel-felipez
 */
public class Cliente {
    
    private int idCliente;
    private String razonSocial;
    private String nitCi;
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String telefonoCelular;
    private String telefonoFijo;
    private String antecedentesCliente;
    
    public Cliente(int idCliente){
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getNitCi() {
        return nitCi;
    }
    public void setNitCi(String nitCi) {
        this.nitCi = nitCi;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getDireccionCliente() {
        return direccionCliente;
    }
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public String getTelefonoCelular() {
        return telefonoCelular;
    }
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    public String getTelefonoFijo() {
        return telefonoFijo;
    }
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    public String getAntecedentesCliente() {
        return antecedentesCliente;
    }
    public void setAntecedentesCliente(String antecedentesCliente) {
        this.antecedentesCliente = antecedentesCliente;
    }
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", razonSocial=" + razonSocial + ", nitCi=" + nitCi + ", nombreCliente=" + nombreCliente + ", direccionCliente=" + direccionCliente + ", telefonoCliente=" + telefonoCliente + ", telefonoCelular=" + telefonoCelular + ", telefonoFijo=" + telefonoFijo + ", antecedentesCliente=" + antecedentesCliente + '}';
    }
    public boolean guardarNuevo(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        ClienteDao clienteDao = new ClienteDao(conexion);
        if(clienteDao.seGuardoCliente(this))
            verificador = true;
        conexion.cerrarConexion();
        return verificador;
    }
}