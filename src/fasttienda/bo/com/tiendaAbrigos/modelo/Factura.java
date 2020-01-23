/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import java.util.ArrayList;

/**
 *
 * @author hotel-felipez
 */
public class Factura {
    private int idFactura;
    private int nroTicket;
    private String tipo;
    private String estadoFactura;
    private String actividadEconomica;
    private String fecha;
    private String hora;
    private String responsable;
    private double totalPagar;
    private double efectivo;
    private double cambio;
    private double totalImporte;
    private String montoLiteral;
    private String codigoControl;
    private String fechaLimiteEmision;
    private String avisoLey;
    private String descripcionLey;
    private int idTienda;
    private int idCliente;
    private int idUsuario;
    private Tienda tienda;
    private Cliente cliente;
    private Usuario usuario;
    private ArrayList<DetalleFactura> listaDetalleFactura;

    public Factura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public int getNroTicket() {
        return nroTicket;
    }
    public void setNroTicket(int nroTicket) {
        this.nroTicket = nroTicket;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstadoFactura() {
        return estadoFactura;
    }
    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }
    public String getActividadEconomica() {
        return actividadEconomica;
    }
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getResponsable() {
        return responsable;
    }
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public double getEfectivo() {
        return efectivo;
    }
    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
    public double getCambio() {
        return cambio;
    }
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    public double getTotalImporte() {
        return totalImporte;
    }
    public void setTotalImporte(double totalImporte) {
        this.totalImporte = totalImporte;
    }
    public String getMontoLiteral() {
        return montoLiteral;
    }
    public void setMontoLiteral(String montoLiteral) {
        this.montoLiteral = montoLiteral;
    }
    public String getCodigoControl() {
        return codigoControl;
    }
    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
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
    public int getIdTienda() {
        return idTienda;
    }
    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Tienda getTienda() {
        return tienda;
    }
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public ArrayList<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }
    public void setListaDetalleFactura(ArrayList<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }
    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", nroTicket=" + nroTicket + ", tipo=" + tipo + ", estadoFactura=" + estadoFactura + ", actividadEconomica=" + actividadEconomica + ", fecha=" + fecha + ", hora=" + hora + ", responsable=" + responsable + ", totalPagar=" + totalPagar + ", efectivo=" + efectivo + ", cambio=" + cambio + ", totalImporte=" + totalImporte + ", montoLiteral=" + montoLiteral + ", codigoControl=" + codigoControl + ", fechaLimiteEmision=" + fechaLimiteEmision + ", avisoLey=" + avisoLey + ", descripcionLey=" + descripcionLey + ", idTienda=" + idTienda + ", idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", tienda=" + tienda + ", cliente=" + cliente + ", usuario=" + usuario + ", listaDetalleFactura=" + listaDetalleFactura + '}';
    }
}