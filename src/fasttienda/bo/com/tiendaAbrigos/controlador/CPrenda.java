/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.ModeloDao;
import fasttienda.bo.com.tiendaAbrigos.dao.PrendaDao;
import fasttienda.bo.com.tiendaAbrigos.modelo.Kardex;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.vista.prendas.IUModuloPrendas;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class CPrenda{

    public IUModuloPrendas moduloPrenda;

    public CPrenda() {
        moduloPrenda = null;
    }
    public void controlarIUModuloPrendas(IUModuloPrendas moduloPrenda){
        this.moduloPrenda = moduloPrenda;
    }
    public boolean seGuardoNuevoModelo(Modelo modelo){
        boolean verificador = false;
        if(modelo.seGuardo())
            verificador = true;
        return verificador;
    }
    public boolean guardarNuevaPrenda(Prenda prenda, Modelo modelo, int idTienda){
        boolean verificador = false;
        if(prenda.seGuardo()){
            Kardex kardex = new Kardex(0);
            kardex.crearNuevoKardex(prenda, modelo, idTienda);
            if(kardex.seGuardoNuevoKardex()){
                verificador = true;
            }else
                Ayuda.mensajeVerificacion(moduloPrenda.getVentanaPrincipal(), "peligro", "no se guardo el kardex", "error");
            verificador = true;            
        }            
        return verificador;
    }
    public boolean modificarPrenda(Prenda prenda){
        boolean verificador = false;
        if(prenda.seModifico())
            verificador = true;
        return verificador;
    }
    public ArrayList<Modelo> listarTodosModelos(){
        ArrayList<Modelo> listarTodosModelos = new ArrayList<>();
        Conexion conexion = new Conexion();
        
        ModeloDao modeloDao = new ModeloDao(conexion);
        listarTodosModelos = modeloDao.getAllModels();
        
        conexion.cerrarConexion();
        return listarTodosModelos;
    }
    public ArrayList<Prenda> listarTodasPrendas(Modelo m){
        ArrayList<Prenda> listarTodasPrendas = new ArrayList<>();
        Conexion conexion = new Conexion();
        
        PrendaDao modeloDao = new PrendaDao(conexion);
        listarTodasPrendas = modeloDao.getAllPrendas(m.getModeloID());
        
        conexion.cerrarConexion();
        return listarTodasPrendas;
    }
}
