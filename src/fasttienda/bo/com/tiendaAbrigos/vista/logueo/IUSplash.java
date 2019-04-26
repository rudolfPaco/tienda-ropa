/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.logueo;

import com.aplicacionjava.www.recursos.Limitacion;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

/**
 *
 * @author rudolf
 */
public class IUSplash {
    
    public SplashScreen splash;
    public String[] texto = {"Loading Modulos" ,"Loading Base Datos", "Loading Configuraciones",
                          "Loading  Archivos","Loading Interfaz Usuarios","Loading iconos","Loading datos iniciales",
                          "Loading usuarios", "Modificando Restricciones", "Guardando Datos", "Finalizando"};
    
    public IUSplash(){        
        splash = SplashScreen.getSplashScreen();
    }
    public boolean terminoSplash(){
        boolean verificador = false;
        
        if (splash != null){
            Limitacion limite = new Limitacion(splash.getSize().width, splash.getSize().height);
            Graphics2D g = splash.createGraphics();
            
            for(int i = 1; i <= texto.length; i++){                       
                //se pinta texto del array
                g.setColor( new Color(4, 52, 101));//color de fondo
	        g.fillRect(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(10));//203, 328,280,12);//para tapar texto anterior
                
                g.setColor(Color.WHITE);//color de texto	        
                g.drawString(texto[i-1]+"...", limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(88));                
                
                g.setColor(Color.LIGHT_GRAY);//color de barra de progeso
                g.fillRect(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(80),(i*limite.getPorcentajeAncho(90)/texto.length), limite.getPorcentajeAlto(4));//la barra de progreso
                
                //se actualiza todo
                splash.update();		
                try {
		 Thread.sleep(200);
		} catch(InterruptedException e) { }
            }
	   splash.close();
	}
        //una vez terminada la animación se muestra la aplicación principal
        try {
            verificador = true;
        }
	catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return verificador;
    }
}
