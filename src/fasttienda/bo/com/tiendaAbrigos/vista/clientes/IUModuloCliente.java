/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.clientes;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.botones.IUBotonRadio;
import com.aplicacionjava.www.botones.IUBotonTI;
import com.aplicacionjava.www.campos.IUCampoTexto;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Limitacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author hotel-felipez
 */
public class IUModuloCliente extends IUPanel{
    
    private IUPanelBD primerPanel;
    private IUPanel segundoPanel;
    private IUPanelBD panelTabla;
    private IUEtiqueta etiquetaTitulo;
    private ButtonGroup grupoBotones;
    private IUBotonRadio botonNit;
    private IUBotonRadio botonNombre;
    private IUCampoTexto campoBuscar;
    private IUBotonIT botonBuscar;
    private IUEtiquetaI imagenBuscar;
    private IUTablaClientes tablaClientes;
    private IUPanel panelBotones;
    private IUBotonTI botonNuevoCliente;
    private IUBotonTI botonModificarCliente;
    private IUBotonTI botonEliminarCliente;
    private IUBotonTI botonImprimirCliente;
    
    public IUModuloCliente(Limitacion limitacion) {
        super(limitacion);
        construirPaneles();
        escucharEvento();
    }
    private void construirPaneles(){
        Limitacion limite = getLimitacion();
        primerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(97)));
        add(primerPanel);
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(69), limite.getPorcentajeAlto(98)));
        add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
    }   
    private void construirSegundoPanel(Limitacion limite){
        panelTabla = new IUPanelBD(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(84)));
        segundoPanel.add(panelTabla);
        construirPanelTabla(panelTabla.getLimitacion());
        
        panelBotones = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(85), limite.getAncho(), limite.getPorcentajeAlto(14)));
        segundoPanel.add(panelBotones);
        construirPanelBotones(panelBotones.getLimitacion());
    }
    private void construirPanelTabla(Limitacion limite){
        etiquetaTitulo = new IUEtiqueta("Lista de Clientes Registrados en el Sistema", new Limitacion(0, limite.getPorcentajeAlto(1), limite.getAncho(), limite.getPorcentajeAlto(5)));
        etiquetaTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(4)));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setForeground(new Color(120, 0, 0));
        panelTabla.add(etiquetaTitulo);
        
        grupoBotones = new ButtonGroup();
        botonNit = new IUBotonRadio("numero NIT", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(8), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(5)), true);
        panelTabla.add(botonNit);
        grupoBotones.add(botonNit);
        
        botonNombre = new IUBotonRadio("nombre cliente", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(8), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(5)), true);
        panelTabla.add(botonNombre);
        grupoBotones.add(botonNombre);
        
        campoBuscar = new IUCampoTexto("", new Limitacion(limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(5)));
        panelTabla.add(campoBuscar);
        
        imagenBuscar = new IUEtiquetaI("src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(95), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(4), limite.getPorcentajeAlto(5)));
        panelTabla.add(imagenBuscar);
        
        tablaClientes = new IUTablaClientes(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(13), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(85)));
        panelTabla.add(tablaClientes.tabla.deslizador);
    }
    private void construirPanelBotones(Limitacion limite){
        botonNuevoCliente = new IUBotonTI("nuevo cliente", "src/imagenes/agregar.png", new Limitacion(limite.getPorcentajeAncho(86), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(96)), 70, 70, 25);
        panelBotones.add(botonNuevoCliente);
        
        botonModificarCliente = new IUBotonTI("modificar cliente", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(71), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(96)), 60, 60, 25);
        panelBotones.add(botonModificarCliente);
        
        botonEliminarCliente = new IUBotonTI("eliminar cliente", "src/imagenes/eliminar.png", new Limitacion(limite.getPorcentajeAncho(56), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(96)), 60, 60, 25);
        panelBotones.add(botonEliminarCliente);
        
        botonImprimirCliente = new IUBotonTI("imprimir cliente", "src/imagenes/impresoraAzul.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(96)), 70, 70, 25);
        panelBotones.add(botonImprimirCliente);
    }
    private void escucharEvento(){
        botonNuevoCliente.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
        });
    }
}
