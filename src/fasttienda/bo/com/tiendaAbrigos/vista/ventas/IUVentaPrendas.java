/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.botones.IUBotonRadio;
import com.aplicacionjava.www.botones.IUBotonTI;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Hora;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import java.awt.Color;
import java.awt.Font;
import javafx.scene.GroupBuilder;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author hotel-felipez
 */
public class IUVentaPrendas extends IUPanelBD{
    
    private CVenta controlVentas;
    private IUPanelBD panelFactura;
    private IUPanelBD segundoPanel;
    private IUEtiqueta iuTitulo;
    private JSeparator iuInicioSeparador;
    private IUPanelCT iuFecha;
    private IUPanelCT iuHora;
    private IUPanelCT iuNroTicket;
    private ButtonGroup grupoBotones;
    private IUBotonRadio iuBotonFactura;
    private IUBotonRadio iuBotonRecibo;
    private JSeparator iuPrimerSeparador;
    private IUPanelCT iuNit;
    private IUBotonTI iuBuscarCliente;
    private IUEtiquetaI iuImagenCodigo;
    private IUPanelCT iuCodigoBarra;
    private IUBotonTI iuBuscarPrenda;
    private IUPanelCT iuNombreRazonSocial;
    private JSeparator iuSegundoSeparador;
    private IUTablaVentas iuTablaVentas;
    private IUPanelCT iuTotalPagar;
    private IUEtiqueta iuTituloTotal;
    private IUPanel tercerPanel;
    private IUBotonTI botonNuevaVenta;    
    private IUBotonTI botonCancelarVenta;
    private IUBotonTI botonModificarFila;
    private IUBotonTI botonEliminarFila;
    private IUBotonTI botonFinalizarVenta;
    
    public IUVentaPrendas(CVenta controlVentas, Limitacion limitacion) {
        super(limitacion);
        this.controlVentas = controlVentas;
        construirPaneles(getLimitacion());
    }
    private void construirPaneles(Limitacion limite){
        panelFactura = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(98)));
        add(panelFactura);
        construirPanelFactura(panelFactura.getLimitacion());
        
        segundoPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(98)));
        segundoPanel.setArco(20);
        add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(85), 0, limite.getPorcentajeAncho(15), limite.getAlto()));
        add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
    }
    private void construirPanelFactura(Limitacion limite){
        
    }
    private void construirSegundoPanel(Limitacion limite){
        iuTitulo = new IUEtiqueta("Registro de Venta", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(7)));
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(4)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setForeground(new Color(120, 0, 0));
        segundoPanel.add(iuTitulo);
        
        iuInicioSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuInicioSeparador.setBounds(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(1));
        iuInicioSeparador.setForeground(new Color(120, 0, 0));
        iuInicioSeparador.setFocusable(false);
        segundoPanel.add(iuInicioSeparador);
        
        iuFecha = new IUPanelCT("fecha de venta", new Fecha().getFecha6(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(6)), 40, 60);
        iuFecha.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuFecha.iuTexto.setFocusable(false);
        iuFecha.iuTexto.setEditable(false);
        segundoPanel.add(iuFecha);
        
        iuHora = new IUPanelCT("hora de venta", new Hora().getHora()+" "+new Hora().getFormato(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(6)), 40, 60);
        iuHora.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuHora.iuTexto.setFocusable(false);
        iuHora.iuTexto.setEditable(false);
        segundoPanel.add(iuHora);
        
        iuNroTicket = new IUPanelCT("Nro Ticket", "0001", new Limitacion(limite.getPorcentajeAncho(85), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(6)), 40, 60);
        iuNroTicket.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNroTicket.iuTexto.setFocusable(false);
        iuNroTicket.iuTexto.setEditable(false);
        segundoPanel.add(iuNroTicket);
        
        grupoBotones = new ButtonGroup();
                
        iuBotonFactura = new IUBotonRadio("FACTURA", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(6)), true);
        segundoPanel.add(iuBotonFactura);
        grupoBotones.add(iuBotonFactura);
        
        iuBotonRecibo = new IUBotonRadio("RECIBO", new Limitacion(limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(6)), false);
        segundoPanel.add(iuBotonRecibo);
        grupoBotones.add(iuBotonRecibo);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(220, 220, 220));
        iuPrimerSeparador.setFocusable(false);
        segundoPanel.add(iuPrimerSeparador);
        
        iuNit = new IUPanelCT("Nro NIT", "", new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(26), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(6)), 40, 60);
        iuNit.iuTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        iuNit.iuTexto.requestFocus();
        segundoPanel.add(iuNit);
        
        iuNombreRazonSocial = new IUPanelCT("Nombre o Razon Social", "", new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(33), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(6)), 40, 60);
        iuNombreRazonSocial.iuTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        segundoPanel.add(iuNombreRazonSocial);
        
        iuBuscarCliente = new IUBotonTI("", "src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(34), limite.getPorcentajeAncho(7), limite.getPorcentajeAlto(5)), 80, 90, 0);
        segundoPanel.add(iuBuscarCliente);
        
        iuImagenCodigo = new IUEtiquetaI("src/imagenes/codigoBarra.png", new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(7)));
        segundoPanel.add(iuImagenCodigo);
        
        iuCodigoBarra = new IUPanelCT("codigo de barra", "", new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(45), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(6)), 40, 60);
        iuCodigoBarra.iuTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        segundoPanel.add(iuCodigoBarra);
        
        iuBuscarPrenda = new IUBotonTI("", "src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(7), limite.getPorcentajeAlto(5)), 80, 90, 0);
        segundoPanel.add(iuBuscarPrenda);
        
        iuSegundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuSegundoSeparador.setBounds(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(1));
        iuSegundoSeparador.setForeground(new Color(220, 220, 220));
        iuSegundoSeparador.setFocusable(false);
        segundoPanel.add(iuSegundoSeparador);
        
        iuTablaVentas = new IUTablaVentas(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(55), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(30)));
        segundoPanel.add(iuTablaVentas.tabla.deslizador);
        
        iuTituloTotal = new IUEtiqueta("Total en (Bolivianos)", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(92), limite.getPorcentajeAncho(54), limite.getPorcentajeAlto(6)));
        iuTituloTotal.setHorizontalAlignment(SwingConstants.CENTER);
        iuTituloTotal.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(3)));
        iuTituloTotal.setForeground(new Color(120, 0, 0));
        segundoPanel.add(iuTituloTotal);
        
        iuTotalPagar =new IUPanelCT("total a pagar", "1542.50", new Limitacion(limite.getPorcentajeAncho(56), limite.getPorcentajeAlto(86), limite.getPorcentajeAncho(44), limite.getPorcentajeAlto(13)), 17, 83);
        iuTotalPagar.iuTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        iuTotalPagar.iuTitulo.setForeground(new Color(120, 0, 0));
        iuTotalPagar.iuTexto.setEditable(false);
        iuTotalPagar.iuTexto.setFocusable(false);
        segundoPanel.add(iuTotalPagar);
    }
    private void construirTercerPanel(Limitacion limite){
        botonNuevaVenta = new IUBotonTI("nueva venta", "src/imagenes/new.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonNuevaVenta);
        
        botonCancelarVenta = new IUBotonTI("cancelar venta", "src/imagenes/cancel.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(19), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonCancelarVenta);
 
        botonModificarFila = new IUBotonTI("modificar fila", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(49), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 60, 70, 15);
        tercerPanel.add(botonModificarFila);
        
        botonEliminarFila = new IUBotonTI("eliminar fila", "src/imagenes/eliminar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 60, 70, 15);
        tercerPanel.add(botonEliminarFila);
        
        botonFinalizarVenta = new IUBotonTI("finalizar venta", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonFinalizarVenta);
    }
}