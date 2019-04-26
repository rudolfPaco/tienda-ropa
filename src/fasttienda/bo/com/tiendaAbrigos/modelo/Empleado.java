/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;

/**
 *
 * @author neo
 */
public class Empleado {
    private int empleadoID;
    private String cargoEmpleado;
    private String fechaContratacion;
    private String estado;
    private int personaID;
    private Persona persona;

    public Empleado(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }
    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }
    public String getCargoEmpleado() {
        return cargoEmpleado;
    }
    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }
    public String getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getPersonaID() {
        return personaID;
    }
    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public int getLastEmpleadoID(){
        Conexion conexion = new Conexion();
        int ultimoRegistroID = conexion.getDato("EmpleadoID", "select EmpleadoID from empleado order by EmpleadoID desc limit 1");
        conexion.cerrarConexion();
        
        return ultimoRegistroID;
    }
    @Override
    public String toString() {
        return "Empleado{" + "empleadoID=" + empleadoID + ", cargoEmpleado=" + cargoEmpleado + ", fechaContratacion=" + fechaContratacion + ", estado=" + estado + ", personaID=" + personaID + ", persona=" + persona + '}';
    }
}