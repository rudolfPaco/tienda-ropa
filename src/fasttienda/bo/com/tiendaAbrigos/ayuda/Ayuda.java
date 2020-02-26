/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.ayuda;

import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaM;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code128;

/**
 *
 * @author rudolf
 */
public class Ayuda {
    
    public static int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public static boolean mensajeVerificacion(JFrame ventanaPrincipal, JDialog ventanaSecundaria, String tipo, String mensaje, String titulo){
        boolean verificador = false;
        ventanaPrincipal.setOpacity(0.5f);
        ventanaSecundaria.setOpacity(0.5f);
        IUVentanaM iuMensaje = new IUVentanaM(ventanaPrincipal, new Limitacion(ancho/2 - ancho/7, alto/2), tipo, mensaje, titulo, 10);
        iuMensaje.mostrarVentana();
        if(iuMensaje.getEstado())
            verificador = true;
        ventanaSecundaria.setOpacity(1f);
        ventanaPrincipal.setOpacity(1f);
        return verificador;
    }
    public static boolean mensajeVerificacion(JFrame ventanaPrincipal, String tipo, String mensaje, String titulo){
        boolean verificador = false;
        ventanaPrincipal.setOpacity(0.5f);
        IUVentanaM iuMensaje = new IUVentanaM(ventanaPrincipal, new Limitacion(ancho/2 - ancho/7, alto/2), tipo, mensaje, titulo, 10);
        iuMensaje.mostrarVentana();
        if(iuMensaje.getEstado())
            verificador = true;
        ventanaPrincipal.setOpacity(1f);
        return verificador;
    }
    public static String examinarArchivo(JFrame ventanaPrincipal, String direccionBuscar){
        
        String direccionArchivo = "";
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen","jpg","png");
        File archivo = new File(direccionBuscar);
        
        JFileChooser fileChooser = new JFileChooser(archivo);        
        fileChooser.setFileFilter(filter);       
        fileChooser.setVisible(true);
        
        int result = fileChooser.showOpenDialog(ventanaPrincipal);
        
        if ( result == JFileChooser.APPROVE_OPTION ){
            try {                 
                URL url = fileChooser.getSelectedFile().toURL();
                BufferedImage buffered = ImageIO.read(url);
                direccionArchivo = url.getPath();
            } 
            catch (IOException ex) {                
                System.err.println("Recurso.examinarArchivo(): "+ ex.getMessage() );
            } 
        }
        return direccionArchivo;
    }
    public static void getCodigoBarra(String codigo, String direccionCodigo, Limitacion limite){
        try {
            BufferedImage buffered = null;
            JBarcodeBean barcode = new JBarcodeBean();
            
            // nuestro tipo de codigo de barra
            //barcode.setCodeType(new Interleaved25());
            //barcode.setCodeType(new Code39());
            barcode.setCodeType(new Code128());
            
            // nuestro valor a codificar y algunas configuraciones mas
            barcode.setCode(codigo);            
            barcode.setCheckDigit(true);
            
            BufferedImage bufferedImage = barcode.draw(new BufferedImage(limite.getAncho(), limite.getAlto(), BufferedImage.TYPE_INT_RGB));
            
            // guardar en disco como png
            File file = new File(direccionCodigo);
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static double acotarNumero(double numero, int cota){
        BigDecimal big = new BigDecimal(numero);
        return big.setScale(cota, RoundingMode.HALF_UP).doubleValue();
    }
    public static int getCantidadPaneles(int numeroElementos, int limiteElementosPanel){
        int cantidadPaneles = 0;
        if(numeroElementos%limiteElementosPanel == 0)
            cantidadPaneles = numeroElementos/limiteElementosPanel;
        else
            cantidadPaneles = numeroElementos/limiteElementosPanel + 1;
        return cantidadPaneles;
    }
    public static String getNumerosIzquierda(int cantNumerosIzquierda, int numero){
        String numeroIzquierda = "";
        Formatter formato = new Formatter();
        formato.format("%0"+cantNumerosIzquierda+"d", numero);
        numeroIzquierda = formato.toString();
        return numeroIzquierda;
    }
    public static String[] getMonedaOficial(){
        Conexion conexion = new Conexion();
        ArrayList<String> lista = conexion.getColumnaTabla("NombreUnidad", "select distinct NombreUnidad from unidad where UnidadMedida like '%.-'");
        conexion.cerrarConexion();
        String[] monedas = new String[lista.size()+1];
        int indice = 0;
        for (int i = 0; i < monedas.length; i++) {
            if(i == 0)
                monedas[i] = "";
            else{
                monedas[i] = lista.get(indice);
                indice++;
            }
        }
        return monedas;
    }
    public static String[] getUnidadesMedida(){
        Conexion conexion = new Conexion();
        ArrayList<String> lista = conexion.getColumnaTabla("NombreUnidad", "select distinct NombreUnidad from unidad where UnidadMedida not like '%.-'");
        conexion.cerrarConexion();
        String[] monedas = new String[lista.size()+1];
        int indice = 0;
        for (int i = 0; i < monedas.length; i++) {
            if(i == 0)
                monedas[i] = "";
            else{
                monedas[i] = lista.get(indice);
                indice++;
            }
        }
        return monedas;
    }
    public static String[] getColumnaTabla(String nombreColumna, String sql){
        String[] categorias = {};
        Conexion conexion = new Conexion();
        ArrayList<String> lista = conexion.getColumnaTabla(nombreColumna, sql);
        if(!lista.isEmpty()){
            categorias = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                String lugar = lista.get(i);
                categorias[i] = lugar;
            }
        }        
        conexion.cerrarConexion();
        return categorias;
    }
    public static double getDatoDouble(String columna, String sql){
        Conexion conexion = new Conexion();
        double iva = conexion.getDatoDouble(columna, sql);
        conexion.cerrarConexion();
        return iva;
    }
    public static int getDatoInt(String columna, String sql){
        Conexion conexion = new Conexion();        
        int datoEntero = conexion.getDato(columna, sql);        
        conexion.cerrarConexion();
        return datoEntero;
    }
    public static String getCadena(String columna, String sql){
        Conexion conexion = new Conexion();
        String cadena = conexion.getCadena(columna, sql);
        conexion.cerrarConexion();
        return cadena;
    }
}
