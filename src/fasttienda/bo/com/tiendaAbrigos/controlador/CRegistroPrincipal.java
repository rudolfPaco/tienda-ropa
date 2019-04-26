/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IURegistroPrincipal;

/**
 *
 * @author rudolf
 */
public class CRegistroPrincipal {
    
    private IURegistroPrincipal iuRegistro;
    
    public CRegistroPrincipal(){
        this.iuRegistro = null;
    }
    public void controlarRegistroPrincipal(IURegistroPrincipal iuRegistro){
        this.iuRegistro = iuRegistro;
    }
    public boolean seGuardaronDatosPrincipales(Tienda tienda, Usuario usuario){
        boolean verificador = false;
        if(tienda.seGuardoCorrectamente() && usuario.seGuardoCorrectamente()){
            verificador = true;
        }
        return verificador;
    }
}
