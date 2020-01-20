/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionjava.www.principal;

import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentana;
import com.aplicacionjava.www.ventanas.IUVentanaP;
import java.awt.Toolkit;

/**
 *
 * @author hotel-felipez
 */
public class Prueba {

    public static void main(String[] arg){
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        IUVentanaP iuVentana = new IUVentanaP("ventana principal");
        iuVentana.setVisible(true);
    }
}
