/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.DosificacionDao;
import fasttienda.bo.com.tiendaAbrigos.dao.FacturaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.TiendaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.UsuarioDao;
import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleVenta;
import fasttienda.bo.com.tiendaAbrigos.modelo.Dosificacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import fasttienda.bo.com.tiendaAbrigos.vista.ventas.IUModuloVentas;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class CVenta {

    public IUModuloVentas moduloVentas;
    private Tienda tienda;
    private Usuario usuario;

    public CVenta(Tienda tienda, Usuario usuario) {
        this.moduloVentas = null;
        this.tienda = tienda;
        this.usuario = usuario;
    }
    public void controlarIUModuloVentas(IUModuloVentas moduloVentas){
        this.moduloVentas = moduloVentas;
    }
    public ArrayList<DetalleVenta> listarDetallesVentas(){
        ArrayList<DetalleVenta> lista = new ArrayList<>();
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        lista.add(new DetalleVenta());
        return lista;
    }
    public String getNroTicket(){
        Conexion conexion = new Conexion();
        FacturaDao facturaDao = new FacturaDao(conexion);
        String nroTicket = "";
        if(facturaDao.getLastIdFactura() == 0)
            nroTicket = "1";
        conexion.cerrarConexion();
        return Ayuda.getNumerosIzquierda(5, Integer.parseInt(nroTicket));
    }
    public boolean exiteDosificacion(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        if(!conexion.getCadena("DosificacionID", "select DosificacionID from dosificacion order by DosificacionID desc limit 1").isEmpty())
            verificador = true;
        conexion.cerrarConexion();
        return verificador;
    }
    public boolean guardarNuevaDosificacion(Dosificacion dosificacion){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        DosificacionDao dosificacionDao = new DosificacionDao(conexion);
        if(dosificacionDao.seGuardoDosificacion(dosificacion)){
            verificador = true;
        }
        conexion.cerrarConexion();
        return verificador;
    }
    public boolean editarDatosDosificacion(Dosificacion dosificacion){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        DosificacionDao dosificacionDao = new DosificacionDao(conexion);
        if(dosificacionDao.seModificoDosificacion(dosificacion)){
            verificador = true;
        }
        conexion.cerrarConexion();
        return verificador;
    }
    public Tienda getTienda(){        
        return tienda;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public Dosificacion getDosificacion(){
        Conexion conexion = new Conexion();
        DosificacionDao dosificacionDao = new DosificacionDao(conexion);
        Dosificacion dosificacion = dosificacionDao.getDosificacion();
        conexion.cerrarConexion();
        return dosificacion;
    }
}
