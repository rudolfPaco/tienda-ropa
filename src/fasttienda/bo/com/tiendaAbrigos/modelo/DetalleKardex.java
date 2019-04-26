/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Hora;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.KardexDao;

/**
 *
 * @author neo
 */
public class DetalleKardex {
    
    private int id;
    private String fechaKardex;
    private String horaKardex;
    private String detalleKardex;
    private String cantidadEntrada;
    private String costoUnitarioEntrada;
    private String totalEntradas;
    private String cantidadSalida;
    private String costoUnitarioSalida;
    private String totalSalidas;
    private String cantidadExistencia;
    private String costoPromedioPonderado;
    private String totalExistencias;
    private int idKardex;
    private int idPrenda;
    private int idModelo;

    public DetalleKardex(int id) {
        this.id = id;
    }    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaKardex() {
        return fechaKardex;
    }
    public void setFechaKardex(String fechaKardex) {
        this.fechaKardex = fechaKardex;
    }
    public String getHoraKardex() {
        return horaKardex;
    }
    public void setHoraKardex(String horaKardex) {
        this.horaKardex = horaKardex;
    }
    public String getDetalleKardex() {
        return detalleKardex;
    }
    public void setDetalleKardex(String detalleKardex) {
        this.detalleKardex = detalleKardex;
    }
    public String getCantidadEntrada() {
        return cantidadEntrada;
    }
    public void setCantidadEntrada(String cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }
    public String getCostoUnitarioEntrada() {
        return costoUnitarioEntrada;
    }
    public void setCostoUnitarioEntrada(String costoUnitarioEntrada) {
        this.costoUnitarioEntrada = costoUnitarioEntrada;
    }
    public String getTotalEntradas() {
        return totalEntradas;
    }
    public void setTotalEntradas(String totalEntradas) {
        this.totalEntradas = totalEntradas;
    }
    public String getCantidadSalida() {
        return cantidadSalida;
    }
    public void setCantidadSalida(String cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }
    public String getCostoUnitarioSalida() {
        return costoUnitarioSalida;
    }
    public void setCostoUnitarioSalida(String costoUnitarioSalida) {
        this.costoUnitarioSalida = costoUnitarioSalida;
    }
    public String getTotalSalidas() {
        return totalSalidas;
    }
    public void setTotalSalidas(String totalSalidas) {
        this.totalSalidas = totalSalidas;
    }
    public String getCantidadExistencia() {
        return cantidadExistencia;
    }
    public void setCantidadExistencia(String cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
    public String getCostoPromedioPonderado() {
        return costoPromedioPonderado;
    }
    public void setCostoPromedioPonderado(String costoPromedioPonderado) {
        this.costoPromedioPonderado = costoPromedioPonderado;
    }
    public String getTotalExistencias() {
        return totalExistencias;
    }
    public void setTotalExistencias(String totalExistencias) {
        this.totalExistencias = totalExistencias;
    }
    public int getIdKardex() {
        return idKardex;
    }
    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
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
    @Override
    public String toString() {
        return "DetalleKardex{" + "id=" + id + ", fechaKardex=" + fechaKardex + ", horaKardex=" + horaKardex + ", detalleKardex=" + detalleKardex + ", cantidadEntrada=" + cantidadEntrada + ", costoUnitarioEntrada=" + costoUnitarioEntrada + ", totalEntradas=" + totalEntradas + ", cantidadSalida=" + cantidadSalida + ", costoUnitarioSalida=" + costoUnitarioSalida + ", totalSalidas=" + totalSalidas + ", cantidadExistencia=" + cantidadExistencia + ", costoPromedioPonderado=" + costoPromedioPonderado + ", totalExistencias=" + totalExistencias + ", idKardex=" + idKardex + ", idPrenda=" + idPrenda + ", idModelo=" + idModelo + '}';
    }
    public void crearNuevoDetalleKardex(Prenda p, Kardex k, Modelo m){
        setFechaKardex(new Fecha().getFecha());
        setHoraKardex(new Hora().getHora());
        setDetalleKardex("inventario inicial");
        /*entradas al detalle kardex*/
        setCantidadEntrada(String.valueOf(p.getCantidadEntrante()));
        setCostoUnitarioEntrada(String.valueOf(m.getCostoUnitarioIva()));
        setTotalEntradas(String.valueOf(Ayuda.acotarNumero(p.getCantidadEntrante()*m.getCostoUnitarioIva(), 2)));
        /**/
        setCantidadSalida(String.valueOf(0));
        setCostoUnitarioSalida(String.valueOf(0.0));
        setTotalSalidas(String.valueOf(0));
        /**/
        setCantidadExistencia(String.valueOf(p.getCantidadEntrante()));
        setCostoPromedioPonderado(String.valueOf(m.getCostoUnitarioIva()));
        setTotalExistencias(String.valueOf(Ayuda.acotarNumero(p.getCantidadEntrante()*m.getCostoUnitarioIva(), 2)));
        
        setIdKardex(0);
        setIdPrenda(p.getId());
        setIdModelo(m.getModeloID());
    }
    public boolean setGuardoDetalleKardex(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        
        KardexDao kardexDao = new KardexDao(conexion);
        if(kardexDao.seGuardoDetalleKardex(this))
            verificador = true;
        
        conexion.cerrarConexion();
        return verificador;
    }
}