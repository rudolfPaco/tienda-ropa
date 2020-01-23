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
public class DetalleFactura {
    private int idDetalleFactura;
    private int cantidad;
    private String detalle;
    private double precio;
    private double importe;
    private int idPrenda;
    private int idFactura;
    private Prenda prenda;
    private Factura factura;

    public DetalleFactura(int idDetalleFactura){
        this.idDetalleFactura = idDetalleFactura;
    }
    
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }
    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public int getIdPrenda() {
        return idPrenda;
    }
    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }
    public int getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public Prenda getPrenda() {
        return prenda;
    }
    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    @Override
    public String toString() {
        return "DetalleFactura{" + "idDetalleFactura=" + idDetalleFactura + ", cantidad=" + cantidad + ", detalle=" + detalle + ", precio=" + precio + ", importe=" + importe + ", idPrenda=" + idPrenda + ", idFactura=" + idFactura + ", prenda=" + prenda + ", factura=" + factura + '}';
    }
}