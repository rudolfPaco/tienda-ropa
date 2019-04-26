/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda;

import fasttienda.bo.com.tiendaAbrigos.controlador.CPrincipal;
import fasttienda.bo.com.tiendaAbrigos.vista.logueo.IUSplash;

/**
 *
 * @author hotel-felipez
 */
public class FastTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicio();
    }
    public static void inicio(){
        IUSplash splash = new IUSplash();
        if(splash.terminoSplash()){
            
            CPrincipal controlPrincipal = new CPrincipal();            
            controlPrincipal.algoritmoInicioPrincipal();
        }        
    }
    
}
