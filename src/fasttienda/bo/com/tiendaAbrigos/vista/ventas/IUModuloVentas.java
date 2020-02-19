/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author rudolf
 */
public class IUModuloVentas extends IUPanel{
    
    private IUPrincipal ventanaPrincipal;
    private CVenta controlVenta;
    
    private CardLayout administradorPaneles;
    private IUPanel contenedorPaneles;
    
    private IUCuadernoVentas panelCuadernoVentas;
    private IUPanelBD panelHistorialVentas;
    private IUVentaPrendas panelNuevaVenta;
    private IUPanelBD panelConfiguracionVentas;
    private IUPanelDosificacion panelDosificacionFacturas;
    private IUPanelBD panelBusquedaVenta;
    
    private IUPanel botonesContenedorPanel;
    private IUBotonIT botonCuadernoVentas;    
    private IUBotonIT botonHistorialVentas;
    private IUBotonIT botonVentaPrendas;
    private IUBotonIT botonConfiguracionVentas;
    private IUBotonIT botonDevolucionVentas;
    private IUBotonIT botonBuscarVentas;
    
    public IUModuloVentas(CVenta controlVenta, IUPrincipal ventanaPrincipal, Limitacion limitacion) {
        super(limitacion);
        this.ventanaPrincipal = ventanaPrincipal;
        this.controlVenta = controlVenta;
        construirPanelAdministrador(getLimitacion());
        setEventos();
        
    }
    private void construirPanelAdministrador(Limitacion limite){
        administradorPaneles = new CardLayout();
        contenedorPaneles = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(90)));
        contenedorPaneles.setLayout(administradorPaneles);
        add(contenedorPaneles);
        construirPanelContenedor(contenedorPaneles.getLimitacion());
        
        botonesContenedorPanel = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(90), limite.getAncho(), limite.getPorcentajeAlto(10)));
        add(botonesContenedorPanel);
        construirControlPaneles(botonesContenedorPanel.getLimitacion());
    }   
    private void construirPanelContenedor(Limitacion limite){
        panelCuadernoVentas = new IUCuadernoVentas(controlVenta, limite);        
        panelCuadernoVentas.setColorPanel(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
        contenedorPaneles.add(panelCuadernoVentas);
        
        panelHistorialVentas = new IUPanelBD(limite);
        panelHistorialVentas.setColorPanel(Color.YELLOW, Color.YELLOW, Color.YELLOW);
        contenedorPaneles.add(panelHistorialVentas);
        
        panelNuevaVenta = new IUVentaPrendas(controlVenta, limite);
        panelNuevaVenta.setColorPanel(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
        contenedorPaneles.add(panelNuevaVenta);
        
        panelConfiguracionVentas = new IUPanelBD(limite);
        panelConfiguracionVentas.setColorPanel(Color.BLUE, Color.BLUE, Color.BLUE);
        contenedorPaneles.add(panelConfiguracionVentas);
                
        panelDosificacionFacturas = new IUPanelDosificacion(controlVenta, ventanaPrincipal, limite);
        panelDosificacionFacturas.setColorPanel(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
        contenedorPaneles.add(panelDosificacionFacturas);
        
        panelBusquedaVenta = new IUPanelBD(limite);
        contenedorPaneles.add(panelBusquedaVenta);
        
    }
    private void construirControlPaneles(Limitacion limite){        
        botonCuadernoVentas = new IUBotonIT("CUADERNO VENTAS", "src/imagenes/inicio.png", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));        
        botonCuadernoVentas.setSubrayado(true);
        botonesContenedorPanel.add(botonCuadernoVentas);
        
        botonHistorialVentas = new IUBotonIT("HISTORIAL VENTAS", "src/imagenes/historial.png", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonHistorialVentas);
        
        botonVentaPrendas = new IUBotonIT("VENDER PRENDAS", "src/imagenes/nuevaVenta.png", new Limitacion(limite.getPorcentajeAncho(58), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonVentaPrendas);
        
        botonConfiguracionVentas = new IUBotonIT("CONFIGURAR VENTAS", "src/imagenes/configuracion.png", new Limitacion(limite.getPorcentajeAncho(58), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonConfiguracionVentas);        
        
        botonDevolucionVentas = new IUBotonIT("DOSIFICACION FACTURAS", "src/imagenes/dosificacionFacturas.png", new Limitacion(limite.getPorcentajeAncho(37), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonDevolucionVentas);
        
        botonBuscarVentas = new IUBotonIT("BUSCAR VENTAS", "src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(37), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonBuscarVentas);
    }
    private void estadoSubrayado(String nombreBoton){
        switch(nombreBoton){
            case "CUADERNO VENTAS":
                botonCuadernoVentas.setSubrayado(true);
                botonHistorialVentas.setSubrayado(false);
                botonVentaPrendas.setSubrayado(false);
                botonConfiguracionVentas.setSubrayado(false);
                botonDevolucionVentas.setSubrayado(false);
                botonBuscarVentas.setSubrayado(false);
            break;
            case "HISTORIAL VENTAS":
                botonCuadernoVentas.setSubrayado(false);
                botonHistorialVentas.setSubrayado(true);
                botonVentaPrendas.setSubrayado(false);
                botonConfiguracionVentas.setSubrayado(false);
                botonDevolucionVentas.setSubrayado(false);
                botonBuscarVentas.setSubrayado(false);
            break;
            case "VENDER PRENDAS":
                botonCuadernoVentas.setSubrayado(false);
                botonHistorialVentas.setSubrayado(false);
                botonVentaPrendas.setSubrayado(true);
                botonConfiguracionVentas.setSubrayado(false);
                botonDevolucionVentas.setSubrayado(false);
                botonBuscarVentas.setSubrayado(false);
            break;
            case "CONFIGURAR VENTAS":
                botonCuadernoVentas.setSubrayado(false);
                botonHistorialVentas.setSubrayado(false);
                botonVentaPrendas.setSubrayado(false);
                botonConfiguracionVentas.setSubrayado(true);
                botonDevolucionVentas.setSubrayado(false);
                botonBuscarVentas.setSubrayado(false);
            break;
            case "DOSIFICACION FACTURAS":
                botonCuadernoVentas.setSubrayado(false);
                botonHistorialVentas.setSubrayado(false);
                botonVentaPrendas.setSubrayado(false);
                botonConfiguracionVentas.setSubrayado(false);
                botonDevolucionVentas.setSubrayado(true);
                botonBuscarVentas.setSubrayado(false);
            break;
            case "BUSCAR VENTAS":
                botonCuadernoVentas.setSubrayado(false);
                botonHistorialVentas.setSubrayado(false);
                botonVentaPrendas.setSubrayado(false);
                botonConfiguracionVentas.setSubrayado(false);
                botonDevolucionVentas.setSubrayado(false);
                botonBuscarVentas.setSubrayado(true);
            break;
        }
    }
    private void setEventos(){
        botonCuadernoVentas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonCuadernoVentas.iuTexto.getText());
                administradorPaneles.first(contenedorPaneles);
            }
        });
        botonHistorialVentas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonHistorialVentas.iuTexto.getText());
                administradorPaneles.first(contenedorPaneles);
                administradorPaneles.next(contenedorPaneles);
            }
        });
        botonVentaPrendas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonVentaPrendas.iuTexto.getText());
                administradorPaneles.first(contenedorPaneles);
                administradorPaneles.next(contenedorPaneles);
                administradorPaneles.next(contenedorPaneles);
            }
        });
        botonBuscarVentas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonBuscarVentas.iuTexto.getText());
                administradorPaneles.last(contenedorPaneles);               
            }
        });
        botonDevolucionVentas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonDevolucionVentas.iuTexto.getText());
                administradorPaneles.last(contenedorPaneles);               
                administradorPaneles.previous(contenedorPaneles);
            }
        });
        botonConfiguracionVentas.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                estadoSubrayado(botonConfiguracionVentas.iuTexto.getText());
                administradorPaneles.last(contenedorPaneles);               
                administradorPaneles.previous(contenedorPaneles);
                administradorPaneles.previous(contenedorPaneles);
            }
        });
    }    
    
    public IUPrincipal getVentanaPrincipal(){
        return ventanaPrincipal;
    }
}
