/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import com.aplicacionjava.www.recursos.Fecha;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.PrendaDao;
import java.util.ArrayList;

/**
 *
 * @author hotel-felipez
 */
public class Prenda {
    private int id;
    private String codigo;
    private String categoria;
    private String marca;
    private String color;
    private String talla;
    private double precio;
    private int cantidadMinima;
    private int cantidadEntrante;
    private String ubicacion;
    private String urlPrenda;
    private int idModelo;

    public Prenda(int id) {
        this.id = id;
        this.cantidadEntrante = 0;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidadMinima() {
        return cantidadMinima;
    }
    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }
    public int getCantidadEntrante() {
        return cantidadEntrante;
    }
    public void setCantidadEntrante(int cantidadEntrante) {
        this.cantidadEntrante = cantidadEntrante;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getUrlPrenda() {
        return urlPrenda;
    }
    public void setUrlPrenda(String urlPrenda) {
        this.urlPrenda = urlPrenda;
    }
    public int getIdModelo() {
        return idModelo;
    }
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    @Override
    public String toString() {
        return "Prenda:" + "\ncod: " + codigo + "\n" + categoria + "-" + marca + "-" + talla + "-" + color;
    }
    public boolean seGuardo(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        PrendaDao prendaDao = new PrendaDao(conexion);
        
        if(prendaDao.seGuardoPrenda(this))
            verificador = true;
        
        conexion.cerrarConexion();
        return verificador;
    }    
    public boolean seModifico(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        PrendaDao prendaDao = new PrendaDao(conexion);
        
        if(prendaDao.seModificoPrenda(this))
            verificador = true;
        
        conexion.cerrarConexion();
        return verificador;
    }
    public boolean seElimino(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        PrendaDao prendaDao = new PrendaDao(conexion);
        
        if(prendaDao.seEliminoPrenda(this))            
            verificador = true;
        
        return verificador;
    }
    public boolean existePrendaDuplicada(int idPrenda){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        PrendaDao prendaDao = new PrendaDao(conexion);
        ArrayList<Prenda> lista = prendaDao.getAllPrendas(idModelo);
        int contador = 0;
        while ( contador < lista.size() &&!verificador) {
            Prenda prenda = lista.get(contador);
            if(prenda.getId() != idPrenda)
                if(prenda.getColor().equalsIgnoreCase(color) && prenda.getTalla().equalsIgnoreCase(talla))
                    verificador = true;
            contador++;
        }
        
        conexion.cerrarConexion();
        return verificador;
    }
}
