/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleVenta;
import fasttienda.bo.com.tiendaAbrigos.vista.ventas.IUModuloVentas;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class CVenta {

    public IUModuloVentas moduloVentas;

    public CVenta() {
        moduloVentas = null;
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
}