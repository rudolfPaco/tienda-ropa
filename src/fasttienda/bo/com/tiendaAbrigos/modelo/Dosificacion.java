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
    private String nroAutorizacion;
    private int numeroInicialFactura;
    private int numeroFinalFactura;
    private String fechaLimiteEmision;
    private String llaveDosificacion;
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
    public String getNroAutorizacion() {
        return nroAutorizacion;
    }
    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }
    public int getNumeroInicialFactura() {
        return numeroInicialFactura;
    }
    public void setNumeroInicialFactura(int numeroInicialFactura) {
        this.numeroInicialFactura = numeroInicialFactura;
    }
    public int getNumeroFinalFactura() {
        return numeroFinalFactura;
    }
    public void setNumeroFinalFactura(int numeroFinalFactura) {
        this.numeroFinalFactura = numeroFinalFactura;
    }
    public String getFechaLimiteEmision() {
        return fechaLimiteEmision;
    }
    public void setFechaLimiteEmision(String fechaLimiteEmision) {
        this.fechaLimiteEmision = fechaLimiteEmision;
    }
    public String getLlaveDosificacion() {
        return llaveDosificacion;
    }
    public void setLlaveDosificacion(String llaveDosificacion) {
        this.llaveDosificacion = llaveDosificacion;
    }
    public int getIdTienda() {
        return idTienda;
    }
    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    public Tienda getTienda() {
        return tienda;
    }
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    @Override
    public String toString() {
        return "Dosificacion{" + "idDosificacion=" + idDosificacion + ", nitContribuyente=" + nitContribuyente + ", nroAutorizacion=" + nroAutorizacion + ", numeroInicialFactura=" + numeroInicialFactura + ", numeroFinalFactura=" + numeroFinalFactura + ", fechaLimiteEmision=" + fechaLimiteEmision + ", llaveDosificacion=" + llaveDosificacion + ", idTienda=" + idTienda + ", tienda=" + tienda + '}';
    }
}
