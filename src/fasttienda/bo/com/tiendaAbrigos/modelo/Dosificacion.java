/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

/**
 *
 * @author hotel-felipez
 */
public class Dosificacion {
    private int idDosificacion;
    private String nitContribuyente;
    private String nombreApellidoRazonSocial;
    private String nroTramiteDosificacion;
    private String llaveDosificacion;
    private String nroAutorizacion;
    private int cantidad;
    private String rangoDesde;
    private String rangoHasta;
    private String fechaLimiteEmision;
    private String avisoLey;
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
        return "Dosificacion{" + "idDosificacion=" + idDosificacion + ", nitContribuyente=" + nitContribuyente + ", nombreApellidoRazonSocial=" + nombreApellidoRazonSocial + ", nroTramiteDosificacion=" + nroTramiteDosificacion + ", llaveDosificacion=" + llaveDosificacion + ", nroAutorizacion=" + nroAutorizacion + ", cantidad=" + cantidad + ", rangoDesde=" + rangoDesde + ", rangoHasta=" + rangoHasta + ", fechaLimiteEmision=" + fechaLimiteEmision + ", avisoLey=" + avisoLey + ", idTienda=" + idTienda + ", tienda=" + tienda + '}';
    }
}
