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
public class Persona {
    private int personaID;
    private String nombres;
    private String apellidos;
    private String carnetIdentidad;
    private String direccion;
    private String telefonos;
    private String email;
    private String urlFoto;

    public Persona(int personaID) {
        this.personaID = personaID;
    }
    public int getPersonaID() {
        return personaID;
    }
    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCarnetIdentidad() {
        return carnetIdentidad;
    }
    public void setCarnetIdentidad(String carnetIdentidad) {
        this.carnetIdentidad = carnetIdentidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrlFoto() {
        return urlFoto;
    }
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    public int getLastPersonaID(){
        Conexion conexion = new Conexion();
        int ultimoRegistroID = conexion.getDato("PersonaID", "select PersonaID from persona order by PersonaID desc limit 1");
        conexion.cerrarConexion();
        
        return ultimoRegistroID;
    }
    @Override
    public String toString() {
        return "Persona{" + "personaID=" + personaID + ", nombres=" + nombres + ", apellidos=" + apellidos + ", carnetIdentidad=" + carnetIdentidad + ", direccion=" + direccion + ", telefonos=" + telefonos + ", email=" + email + '}';
    }
}