/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.UsuarioDao;

/**
 *
 * @author rudolf
 */
public class Usuario {

    private int usuarioID;    
    private String username;
    private String password;
    private int empleadoID;
    private int personaID;
    private Empleado empleado;
    
    public Usuario(int id) {
        this.usuarioID = id;
    }

    public int getId() {
        return usuarioID;
    }
    public void setId(int id) {
        this.usuarioID = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getEmpleadoID() {
        return empleadoID;
    }
    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }
    public int getPersonaID() {
        return personaID;
    }
    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    @Override
    public String toString() {
        return "Usuario{" + "usuarioID=" + usuarioID + ", username=" + username + ", password=" + password + ", empleadoID=" + empleadoID + ", personaID=" + personaID + '}';
    }   
    public boolean seGuardoCorrectamente(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        UsuarioDao usuarioDao = new UsuarioDao(conexion);
        
        if(usuarioDao.seGuardoPersonaCorrectamente(empleado.getPersona())){
            empleado.setPersonaID(empleado.getPersona().getLastPersonaID());
            if(usuarioDao.seGuardoEmpleadoCorrectamente(empleado)){
                setPersonaID(empleado.getPersona().getLastPersonaID());
                setEmpleadoID(empleado.getLastEmpleadoID());
                if(usuarioDao.seGuardoUsuarioCorrectamente(this))
                    verificador = true;
            }
        }        
        
        conexion.cerrarConexion();        
        return verificador;
    }
}