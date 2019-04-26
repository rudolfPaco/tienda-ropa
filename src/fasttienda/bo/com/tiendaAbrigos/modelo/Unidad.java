/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;

/**
 *
 * @author rudolf
 */
public class Unidad {
    private int unidadID;
    private String nombreUnidad;
    private String unidadMedida;

    public Unidad(int unidadID) {
        this.unidadID = unidadID;
    }
    public void agregarIDUnidad(String nombreUnidad, String unidadMedida){
        Conexion conexion = new Conexion();
        this.unidadID = conexion.getDato("unidadID", "select unidadID from unidad where nombreUnidad = '"+nombreUnidad+"' or unidadMedida = '"+unidadMedida+"'");
        conexion.cerrarConexion();
    }
    public int getUnidadID() {
        return unidadID;
    }
    public void setUnidadID(int unidadID) {
        this.unidadID = unidadID;
    }
    public String getNombreUnidad() {
        return nombreUnidad;
    }
    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }
    public String getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
