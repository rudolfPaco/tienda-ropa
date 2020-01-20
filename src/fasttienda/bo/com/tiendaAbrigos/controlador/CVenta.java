/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.vista.ventas.IUModuloVentas;

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
}
