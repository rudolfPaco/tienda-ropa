/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.vista.clientes.IUModuloCliente;

/**
 *
 * @author hotel-felipez
 */
public class CCliente {
    
    private IUModuloCliente iuCliente;
    public CCliente(){
        iuCliente = null;
    }
    public void controlarIUModuloCliente(IUModuloCliente iuCliente){
        this.iuCliente = iuCliente;        
    }
    
}
