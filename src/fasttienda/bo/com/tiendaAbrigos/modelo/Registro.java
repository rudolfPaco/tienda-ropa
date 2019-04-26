/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import com.aplicacionjava.www.recursos.Hora;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.RegistroDao;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class Registro {

    private int registroID;
    private String tipo;
    private String estado;
    private String horaEntrada;
    private String horaSalida;
    private double totalDineroIntangible;
    private double totalDineroTangible;
    private String estadoDinero;
    private String observacion;
    private int empleadoEntranteID;
    private int empleadoID;
    private int cajaID;

    public Registro(int registroID) {
        this.registroID = registroID;
    }

    public int getRegistroID() {
        return registroID;
    }
    public void setRegistroID(int registroID) {
        this.registroID = registroID;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public String getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public double getTotalDineroIntangible() {
        return totalDineroIntangible;
    }
    public void setTotalDineroIntangible(double totalDineroIntangible) {
        this.totalDineroIntangible = totalDineroIntangible;
    }
    public double getTotalDineroTangible() {
        return totalDineroTangible;
    }
    public void setTotalDineroTangible(double totalDineroTangible) {
        this.totalDineroTangible = totalDineroTangible;
    }
    public String getEstadoDinero() {
        return estadoDinero;
    }
    public void setEstadoDinero(String estadoDinero) {
        this.estadoDinero = estadoDinero;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public int getEmpleadoEntranteID() {
        return empleadoEntranteID;
    }
    public void setEmpleadoEntranteID(int empleadoEntranteID) {
        this.empleadoEntranteID = empleadoEntranteID;
    }
    public int getEmpleadoID() {
        return empleadoID;
    }
    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }
    public int getCajaID() {
        return cajaID;
    }
    public void setCajaID(int cajaID) {
        this.cajaID = cajaID;
    }
    @Override
    public String toString() {
        return "Registro{" + "registroID=" + registroID + ", tipo=" + tipo + ", estado=" + estado + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", totalDineroIntangible=" + totalDineroIntangible + ", totalDineroTangible=" + totalDineroTangible + ", estadoDinero=" + estadoDinero + ", observacion=" + observacion + ", empleadoEntranteID=" + empleadoEntranteID + ", empleadoID=" + empleadoID + ", cajaID=" + cajaID + '}';
    }
    
    public boolean seCargoDatosRegistroActivo(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        RegistroDao registroDao = new RegistroDao(conexion);
        Registro registro = registroDao.getRegistroActivo();
        if(registro != null){
            
            setRegistroID(registro.getRegistroID());
            setTipo(registro.getTipo());
            setEstado(registro.getEstado());
            setHoraEntrada(registro.getHoraEntrada());
            setHoraSalida(registro.getHoraSalida());
            setTotalDineroIntangible(registro.getTotalDineroIntangible());
            setTotalDineroTangible(registro.getTotalDineroTangible());
            setEstadoDinero(registro.getEstadoDinero());
            setObservacion(registro.getObservacion());
            setEmpleadoEntranteID(registro.getEmpleadoEntranteID());
            setEmpleadoID(registro.getEmpleadoID());
            setCajaID(registro.getCajaID());
            
            verificador = true;
        }
        conexion.cerrarConexion();
        return verificador;
    }
    public ArrayList<Registro> getListaRegistros(int cajaID){
        ArrayList<Registro> listaRegistros = new ArrayList<>();
        Conexion conexion = new Conexion();
        
        RegistroDao registroDao = new RegistroDao(conexion);
        listaRegistros = registroDao.getListaRegistros(cajaID);
        
        conexion.cerrarConexion();
        return listaRegistros;
    }
    public boolean seCreoNuevoRegistro(int empleadoID, int cajaID, String tipoResponsable){
        boolean verificador = false;
        
        setTipo(tipoResponsable);
        setEstado("activo");
        setHoraEntrada(new Hora().getHora());
        setHoraSalida(null);
        setTotalDineroIntangible(0.0);
        setTotalDineroTangible(0.0);
        setEstadoDinero("");
        setObservacion("");
        setEmpleadoEntranteID(0);
        setEmpleadoID(empleadoID);
        setCajaID(cajaID);
        
        Conexion conexion = new Conexion();
        RegistroDao responsableDao = new RegistroDao(conexion);
        if(responsableDao.seGuardoNuevoRegistro(this)){            
            verificador = true;
            setRegistroID(conexion.getDato("RegistroID", "select RegistroID from registro order by RegistroID desc limit 1"));
        }
        
        conexion.cerrarConexion();
        return verificador;
    }
}
