/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.DosificacionDao;

/**
 *
 * @author hotel-felipez
 */
public class Dosificacion {
    private int idDosificacion;
    private String nitContribuyente;
    private String nombreApellidoRazonSocial;
    private String actividadEconomica;
    private String nroTramiteDosificacion;
    private String llaveDosificacion;
    private String nroFactura;
    private String nroAutorizacion;
    private int cantidad;
    private String rangoDesde;
    private String rangoHasta;
    private String fechaLimiteEmision;
    private String avisoLey;
    private String descripcionLey;
    private int idTienda;
    
    private Tienda tienda;

    public Dosificacion(int idDosificacion) {
        this.idDosificacion = idDosificacion;
    }
    public int getIdDosificacion() {
        return idDosificacion;
    }
    public void setIdDosificacion(int idDosificacion) {
        this.idDosificacion = idDosificacion;
    }
    public String getNitContribuyente() {
        return nitContribuyente;
    }
    public void setNitContribuyente(String nitContribuyente) {
        this.nitContribuyente = nitContribuyente;
    }
    public String getNombreApellidoRazonSocial() {
        return nombreApellidoRazonSocial;
    }
    public void setNombreApellidoRazonSocial(String nombreApellidoRazonSocial) {
        this.nombreApellidoRazonSocial = nombreApellidoRazonSocial;
    }
    public String getActividadEconomica() {
        return actividadEconomica;
    }
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
    public String getNroTramiteDosificacion() {
        return nroTramiteDosificacion;
    }
    public void setNroTramiteDosificacion(String nroTramiteDosificacion) {
        this.nroTramiteDosificacion = nroTramiteDosificacion;
    }
    public String getLlaveDosificacion() {
        return llaveDosificacion;
    }
    public void setLlaveDosificacion(String llaveDosificacion) {
        this.llaveDosificacion = llaveDosificacion;
    }
    public String getNroFactura() {
        Conexion conexion = new Conexion();
        int numero = 0;
        String cadena = conexion.getCadena("NroFactura", "select NroFactura from dosificacion order by NroFactura desc limit 1");
        if(!cadena.isEmpty())
            numero = Integer.parseInt(cadena);
        numero++;
        conexion.cerrarConexion();
        nroFactura = String.valueOf(numero);
        return nroFactura;
    }
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }
    public String getNroAutorizacion() {
        return nroAutorizacion;
    }
    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getRangoDesde() {
        return rangoDesde;
    }
    public void setRangoDesde(String rangoDesde) {
        this.rangoDesde = rangoDesde;
    }
    public String getRangoHasta() {
        return rangoHasta;
    }
    public void setRangoHasta(String rangoHasta) {
        this.rangoHasta = rangoHasta;
    }
    public String getFechaLimiteEmision() {
        return fechaLimiteEmision;
    }
    public void setFechaLimiteEmision(String fechaLimiteEmision) {
        this.fechaLimiteEmision = fechaLimiteEmision;
    }
    public String getAvisoLey() {
        return avisoLey;
    }
    public void setAvisoLey(String avisoLey) {
        this.avisoLey = avisoLey;
    }
    public String getDescripcionLey() {
        return descripcionLey;
    }
    public void setDescripcionLey(String descripcionLey) {
        this.descripcionLey = descripcionLey;
    }
    public Tienda getTienda() {
        return tienda;
    }
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    public int getIdTienda() {
        return idTienda;
    }
    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    @Override
    public String toString() {
        return "Dosificacion{" + "idDosificacion=" + idDosificacion + ", nitContribuyente=" + nitContribuyente + ", nombreApellidoRazonSocial=" + nombreApellidoRazonSocial + ", actividadEconomica=" + actividadEconomica + ", nroTramiteDosificacion=" + nroTramiteDosificacion + ", llaveDosificacion=" + llaveDosificacion + ", nroFactura=" + nroFactura + ", nroAutorizacion=" + nroAutorizacion + ", cantidad=" + cantidad + ", rangoDesde=" + rangoDesde + ", rangoHasta=" + rangoHasta + ", fechaLimiteEmision=" + fechaLimiteEmision + ", avisoLey=" + avisoLey + ", descripcionLey=" + descripcionLey + ", idTienda=" + idTienda + ", tienda=" + tienda + '}';
    }
}
