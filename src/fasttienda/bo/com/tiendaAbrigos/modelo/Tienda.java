/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.TiendaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.UsuarioDao;

/**
 *
 * @author rudolf
 */
public class Tienda {
    private int tiendaID;
    private String nombreTienda;
    private String descripcionTienda;
    private String direccionTienda;
    private String telefonosTienda;
    private String ciudadTienda;
    private String paisTienda;
    private double cambioDolar;
    private String estadoTienda;    
    private String urlLogo;

    private Unidad unidadMonetaria;
    private Unidad unidadCambioDolar;
    
    public Tienda(int tiendaID) {
        this.tiendaID = tiendaID;
    }

    public int getTiendaID() {
        return tiendaID;
    }
    public void setTiendaID(int tiendaID) {
        this.tiendaID = tiendaID;
    }
    public String getNombreTienda() {
        return nombreTienda;
    }
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
    public String getDescripcionTienda() {
        return descripcionTienda;
    }
    public void setDescripcionTienda(String descripcionTienda) {
        this.descripcionTienda = descripcionTienda;
    }
    public String getDireccionTienda() {
        return direccionTienda;
    }
    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }
    public String getTelefonosTienda() {
        return telefonosTienda;
    }
    public void setTelefonosTienda(String telefonosTienda) {
        this.telefonosTienda = telefonosTienda;
    }
    public String getCiudadTienda() {
        return ciudadTienda;
    }
    public void setCiudadTienda(String ciudadTienda) {
        this.ciudadTienda = ciudadTienda;
    }
    public String getPaisTienda() {
        return paisTienda;
    }
    public void setPaisTienda(String paisTienda) {
        this.paisTienda = paisTienda;
    }
    public String getEstadoTienda() {
        return estadoTienda;
    }
    public void setEstadoTienda(String estadoTienda) {
        this.estadoTienda = estadoTienda;
    }
    public double getCambioDolar(){
        return cambioDolar;
    }
    public void setCambioDolar(double cambioDolar){
        this.cambioDolar = cambioDolar;
    }
    public String getUrlLogo() {
        return urlLogo;
    }
    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
    public Unidad getUnidadMonetaria() {
        return unidadMonetaria;
    }
    public void setUnidadMonetaria(Unidad unidadMonetaria) {
        this.unidadMonetaria = unidadMonetaria;
    }
    public Unidad getUnidadCambioDolar() {
        return unidadCambioDolar;
    }
    public void setUnidadCambioDolar(Unidad unidadCambioDolar) {
        this.unidadCambioDolar = unidadCambioDolar;
    }
    @Override
    public String toString() {
        return "Tienda{" + "tiendaID=" + tiendaID + ", nombreTienda=" + nombreTienda + ", descripcionTienda=" + descripcionTienda + ", direccionTienda=" + direccionTienda + ", telefonosTienda=" + telefonosTienda + ", ciudadTienda=" + ciudadTienda + ", paisTienda=" + paisTienda + ", cambioDolar=" + cambioDolar + ", estadoTienda=" + estadoTienda + ", urlLogo=" + urlLogo + ", unidadMonetaria=" + unidadMonetaria + ", unidadCambioDolar=" + unidadCambioDolar + '}';
    }
    public boolean seGuardoCorrectamente(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        TiendaDao tiendaDao = new TiendaDao(conexion);
        
        if(tiendaDao.seGuardoTiendaCorrectamente(this))
            verificador = true;
        
        conexion.cerrarConexion();        
        return verificador;
    }
    public static Tienda getTiendaExistente(){
        Tienda tienda = null;
        Conexion conexion = new Conexion();
        TiendaDao tiendaDao = new TiendaDao(conexion);
        tienda = tiendaDao.getTienda();        
        conexion.cerrarConexion();
        return tienda;
    }
    public boolean modificarDatos(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        TiendaDao tiendaDao = new TiendaDao(conexion);
        
        if(tiendaDao.seModificoTienda(this))
            verificador = true;
        
        conexion.cerrarConexion();
        return verificador;
    }
}
