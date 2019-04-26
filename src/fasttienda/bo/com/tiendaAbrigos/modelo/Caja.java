/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Hora;
import fasttienda.bo.com.tiendaAbrigos.dao.CajaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;

/**
 *
 * @author neo
 */
public class Caja {
    
    private int cajaID;
    private String fechaApertura;
    private String horaApertura;
    private String fechaCierre;
    private String horaCierre;
    private double cajaInicial;
    private double ventaTotal;
    private double ingresoTotal;
    private double gastoTotal;
    private double cajaTotal;
    private int tiendaID;

    public Caja(int cajaID) {
        this.cajaID = cajaID;
    }

    public int getCajaID() {
        return cajaID;
    }
    public void setCajaID(int cajaID) {
        this.cajaID = cajaID;
    }
    public String getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    public String getHoraApertura() {
        return horaApertura;
    }
    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }
    public String getFechaCierre() {
        return fechaCierre;
    }
    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    public String getHoraCierre() {
        return horaCierre;
    }
    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    public double getCajaInicial() {
        return cajaInicial;
    }
    public void setCajaInicial(double cajaInicial) {
        this.cajaInicial = cajaInicial;
    }
    public double getVentaTotal() {
        return ventaTotal;
    }
    public void setVentaTotal(double ventaTotal) {
        this.ventaTotal = ventaTotal;
    }
    public double getIngresoTotal() {
        return ingresoTotal;
    }
    public void setIngresoTotal(double ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }
    public double getGastoTotal() {
        return gastoTotal;
    }
    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }
    public double getCajaTotal() {
        return cajaTotal;
    }
    public void setCajaTotal(double cajaTotal) {
        this.cajaTotal = cajaTotal;
    }
    public int getTiendaID() {
        return tiendaID;
    }
    public void setTiendaID(int tiendaID) {
        this.tiendaID = tiendaID;
    }
    @Override
    public String toString() {
        return "Caja{" + "cajaID=" + cajaID + ", fechaApertura=" + fechaApertura + ", horaApertura=" + horaApertura + ", fechaCierre=" + fechaCierre + ", horaCierre=" + horaCierre + ", cajaInicial=" + cajaInicial + ", ventaTotal=" + ventaTotal + ", ingresoTotal=" + ingresoTotal + ", gastoTotal=" + gastoTotal + ", cajaTotal=" + cajaTotal + ", tiendaID=" + tiendaID + '}';
    }
    public boolean seCreoCajaNueva(int idTienda){
        boolean verificador = false;
        
        setFechaApertura(new Fecha().getFecha());
        setHoraApertura(new Hora().getHora());
        setFechaCierre(null);
        setHoraCierre(null);
        setCajaInicial(0.0);
        setVentaTotal(0.0);
        setIngresoTotal(0.0);
        setGastoTotal(0.0);
        setCajaTotal(0.0);
        setTiendaID(idTienda);
        
        
        Conexion conexion = new Conexion();
        CajaDao cajaDao = new CajaDao(conexion);
        if(cajaDao.seGuardoNuevaCaja(this)){
            verificador = true;
            setCajaID(conexion.getDato("CajaID", "select CajaID from caja order by CajaID desc limit 1"));
        }
        
        conexion.cerrarConexion();
        return verificador;
    }
    public boolean recuperarDatos(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        CajaDao cajaDao = new CajaDao(conexion);
        Caja caja = cajaDao.getCajaApertura(cajaID);
        
        if(caja != null){
            setFechaApertura(caja.getFechaApertura());
            setHoraApertura(caja.getHoraApertura());
            setFechaCierre(caja.getFechaCierre());
            setHoraCierre(caja.getHoraCierre());
            setCajaInicial(caja.getCajaInicial());
            setVentaTotal(caja.getVentaTotal());
            setIngresoTotal(caja.getIngresoTotal());
            setGastoTotal(caja.getGastoTotal());
            setCajaTotal(caja.getCajaTotal());
            setTiendaID(caja.getTiendaID());
            
            verificador = true;
        }        
        
        conexion.cerrarConexion();
        return verificador;
    }
}
