/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import com.aplicacionjava.www.recursos.Fecha;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.KardexDao;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class Kardex {
    private int id;
    private String fechaInicial;
    private String fechaFinal;
    private String codigoPrenda;
    private String nombrePrenda;
    private String unidadMedida;
    private int cantInvInicial;
    private int cantCompras;
    private int cantDevCompras;
    private int cantVentas;
    private int cantDevVentas;
    private int cantStockActual;
    private double inventarioInicial;
    private double comprasNetas;
    private double inventarioFinal;
    private double costoVentas;
    private double totalVentas;
    private int idPrenda;
    private int idModelo;
    private int idTienda;
    private ArrayList<DetalleKardex> listaDetalles;

    public Kardex(int id) {
        this.id = id;
        listaDetalles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaInicial() {
        return fechaInicial;
    }
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
    public String getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public String getCodigoPrenda() {
        return codigoPrenda;
    }
    public void setCodigoPrenda(String codigoPrenda) {
        this.codigoPrenda = codigoPrenda;
    }
    public String getNombrePrenda() {
        return nombrePrenda;
    }
    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }
    public String getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public int getCantInvInicial() {
        return cantInvInicial;
    }
    public void setCantInvInicial(int cantInvInicial) {
        this.cantInvInicial = cantInvInicial;
    }
    public int getCantCompras() {
        return cantCompras;
    }
    public void setCantCompras(int cantCompras) {
        this.cantCompras = cantCompras;
    }
    public int getCantDevCompras() {
        return cantDevCompras;
    }
    public void setCantDevCompras(int cantDevCompras) {
        this.cantDevCompras = cantDevCompras;
    }
    public int getCantVentas() {
        return cantVentas;
    }
    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }
    public int getCantDevVentas() {
        return cantDevVentas;
    }
    public void setCantDevVentas(int cantDevVentas) {
        this.cantDevVentas = cantDevVentas;
    }
    public int getCantStockActual() {
        return cantStockActual;
    }
    public void setCantStockActual(int cantStockActual) {
        this.cantStockActual = cantStockActual;
    }
    public double getInventarioInicial() {
        return inventarioInicial;
    }
    public void setInventarioInicial(double inventarioInicial) {
        this.inventarioInicial = inventarioInicial;
    }
    public double getComprasNetas() {
        return comprasNetas;
    }
    public void setComprasNetas(double comprasNetas) {
        this.comprasNetas = comprasNetas;
    }
    public double getInventarioFinal() {
        return inventarioFinal;
    }
    public void setInventarioFinal(double inventarioFinal) {
        this.inventarioFinal = inventarioFinal;
    }
    public double getCostoVentas() {
        return costoVentas;
    }
    public void setCostoVentas(double costoVentas) {
        this.costoVentas = costoVentas;
    }
    public double getTotalVentas() {
        return totalVentas;
    }
    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
    public int getIdPrenda() {
        return idPrenda;
    }
    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }
    public int getIdModelo() {
        return idModelo;
    }
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    public int getIdTienda() {
        return idTienda;
    }
    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    public ArrayList<DetalleKardex> getListaDetalles() {
        return listaDetalles;
    }
    public void setListaDetalles(ArrayList<DetalleKardex> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    @Override
    public String toString() {
        return "Kardex{" + "id=" + id + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", codigoPrenda=" + codigoPrenda + ", nombrePrenda=" + nombrePrenda + ", unidadMedida=" + unidadMedida + ", cantInvInicial=" + cantInvInicial + ", cantCompras=" + cantCompras + ", cantDevCompras=" + cantDevCompras + ", cantVentas=" + cantVentas + ", cantDevVentas=" + cantDevVentas + ", cantStockActual=" + cantStockActual + ", inventarioInicial=" + inventarioInicial + ", comprasNetas=" + comprasNetas + ", inventarioFinal=" + inventarioFinal + ", costoVentas=" + costoVentas + ", totalVentas=" + totalVentas + ", idPrenda=" + idPrenda + ", idModelo=" + idModelo + ", idTienda=" + idTienda + ", listaDetalles=" + listaDetalles + '}';
    }
    public void crearNuevoKardex(Prenda prenda, Modelo modelo, int idTiendaNueva){
        setFechaInicial(new Fecha().getFecha());
        setFechaFinal(new Fecha().getFecha());
        setCodigoPrenda(prenda.getCodigo());
        setNombrePrenda(prenda.getCategoria()+"-"+prenda.getMarca());
        setUnidadMedida(modelo.getUnidades().get(1).getUnidadMedida());
        setCantInvInicial(prenda.getCantidadEntrante());
        setCantCompras(0);
        setCantDevCompras(0);
        setCantVentas(0);
        setCantDevVentas(0);
        setCantStockActual(prenda.getCantidadEntrante());
        setInventarioInicial(Ayuda.acotarNumero(modelo.getCostoUnitarioIva()*prenda.getCantidadEntrante(), 2));
        setComprasNetas(0);
        setInventarioFinal(0);
        setCostoVentas(Ayuda.acotarNumero(modelo.getCostoUnitarioIva()*prenda.getCantidadEntrante(), 2));
        setTotalVentas(0);
        setIdPrenda(prenda.getId());
        setIdModelo(prenda.getIdModelo());
        setIdTienda(idTiendaNueva);
        
        DetalleKardex detalleKardex = new DetalleKardex(0);
        detalleKardex.crearNuevoDetalleKardex(prenda, this, modelo);
        listaDetalles.add(detalleKardex);
    }
    public boolean seGuardoNuevoKardex(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        KardexDao kardexDao = new KardexDao(conexion);
        setIdPrenda(conexion.getDato("prendaID", "select prendaID from prenda order by prendaID desc limit 1"));
        if(kardexDao.seGuardoKardex(this)){
            int idKardex = conexion.getDato("kardexID", "select kardexID from kardex order by kardexID desc limit 1");            
            if(!listaDetalles.isEmpty()){
                DetalleKardex detalle = listaDetalles.get(0);
                detalle.setIdKardex(idKardex);
                detalle.setIdPrenda(idPrenda);
                if(detalle.setGuardoDetalleKardex()){
                    verificador = true;
                }
            }
        }
        conexion.cerrarConexion();
        return verificador;
    }
}