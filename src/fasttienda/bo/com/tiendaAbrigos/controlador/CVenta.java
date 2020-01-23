/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.FacturaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.TiendaDao;
import fasttienda.bo.com.tiendaAbrigos.dao.UsuarioDao;
import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleVenta;
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
    public Tienda getTienda(){        
        return tienda;
    }
    public Usuario getUsuario(){
        return usuario;
    }
}
