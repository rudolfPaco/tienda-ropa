/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.prendas;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrenda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class IUModuloPrendas extends IUPanel{
    
    private IUPrincipal ventanaPrincipal;
    private CPrenda controlPrenda;
    
    private CardLayout administradorPaneles;
    private IUPanel contenedorPaneles;
    
    private IUPanelVistaModelos panelVistaModelos;
    
    private IUPanel botonesContenedorPanel;
    private IUBotonIT botonInventarioModelo;    
    private IUBotonIT botonCRUDPedidos;
    private IUBotonIT botonCRUDModelo;
    private IUBotonIT botonCRUDPrenda;
    private IUBotonIT botonAgregarPrenda;
    private IUBotonIT botonBuscarPrenda;
    
    public IUModuloPrendas(CPrenda controlPrenda, IUPrincipal ventanaPrincipal, Limitacion limitacion) {
        super(limitacion);
        this.ventanaPrincipal = ventanaPrincipal;
        this.controlPrenda = controlPrenda;
        construirPanelAdministrador(getLimitacion());
        setEventos();
        actualizarListaModelos();
    }
    private void construirPanelAdministrador(Limitacion limite){
        administradorPaneles = new CardLayout();
        contenedorPaneles = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(90)));
        contenedorPaneles.setLayout(administradorPaneles);
        add(contenedorPaneles);
        construirPaneles(contenedorPaneles.getLimitacion());
        
        botonesContenedorPanel = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(90), limite.getAncho(), limite.getPorcentajeAlto(10)));
        add(botonesContenedorPanel);
        construirControlPaneles(botonesContenedorPanel.getLimitacion());
    }    
    private void construirPaneles(Limitacion limite){
        panelVistaModelos = new IUPanelVistaModelos(controlPrenda, limite);
        contenedorPaneles.add(panelVistaModelos);                
    }   
    private void construirControlPaneles(Limitacion limite){
        botonInventarioModelo = new IUBotonIT("VER INVENTARIO MODELO", "src/imagenes/nuevoModelo.png", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonInventarioModelo);
        
        botonCRUDPedidos = new IUBotonIT("CRUD PEDIDOS", "src/imagenes/nuevoModelo.png", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonCRUDPedidos);
        
        botonCRUDModelo = new IUBotonIT("CRUD MODELOS", "src/imagenes/nuevaPrenda.png", new Limitacion(limite.getPorcentajeAncho(58), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonCRUDModelo);
        
        botonCRUDPrenda = new IUBotonIT("CRUD PRENDAS", "src/imagenes/nuevaPrenda.png", new Limitacion(limite.getPorcentajeAncho(58), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonCRUDPrenda);
        
        botonAgregarPrenda = new IUBotonIT("AGREGAR PRENDA EXISTENTE", "src/imagenes/agregarPrenda.png", new Limitacion(limite.getPorcentajeAncho(37), limite.getPorcentajeAlto(6), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonAgregarPrenda);
        
        botonBuscarPrenda = new IUBotonIT("BUSCAR PRENDA", "src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(37), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(41)));
        botonesContenedorPanel.add(botonBuscarPrenda);
    }
    private void setEventos(){
        botonCRUDModelo.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                IUModelo nuevoModelo = new IUModelo(ventanaPrincipal, controlPrenda,"formulario para crear un nuevo modelo", new Limitacion(Ayuda.ancho, Ayuda.alto), 5);
                nuevoModelo.mostrarVentana();
                actualizarListaModelos();
            }
        });
        botonCRUDPrenda.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                IUPrenda nuevaPrenda = new IUPrenda(ventanaPrincipal, controlPrenda, "formulario para crear nuevas prendas de un modelo", new Limitacion(Ayuda.ancho, Ayuda.alto), 5);
                nuevaPrenda.mostrarVentana();                
            }
        });
    }
    
    private void actualizarListaModelos(){
        ArrayList<Modelo> listarTodosModelos = controlPrenda.listarTodosModelos();
        panelVistaModelos.actualizarListaModelos(listarTodosModelos);
    }
    public IUPrincipal getVentanaPrincipal(){
        return ventanaPrincipal;
    }
}