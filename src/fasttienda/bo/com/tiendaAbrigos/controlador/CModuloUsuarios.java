/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.vista.usuarios.IUModuloUsuarios;

/**
 *
 * @author rudolf
 */
public class CModuloUsuarios {
    
    private IUModuloUsuarios iuModuloUsuarios;

    public CModuloUsuarios() {
        iuModuloUsuarios = null;
    }
    public void controlarModuloUsuarios(IUModuloUsuarios iuModuloUsuarios){
        this.iuModuloUsuarios = iuModuloUsuarios;
    }
    
}
