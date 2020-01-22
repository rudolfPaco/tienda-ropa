/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBotonTI;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import java.awt.Color;
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
    private IUPanelCT iuFecha;
    private IUPanelBD tercerPanel;
    private IUBotonTI botonNuevaVenta;
    private IUBotonTI botonCancelarVenta;
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
        
        segundoPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(40), 0, limite.getPorcentajeAncho(45), limite.getAlto()));
        add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(85), 0, limite.getPorcentajeAncho(15), limite.getAlto()));
        add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
    }
    private void construirPanelFactura(Limitacion limite){
        
    }
    private void construirSegundoPanel(Limitacion limite){
        iuTitulo = new IUEtiqueta("Registro de Venta", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(10)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setForeground(new Color(120, 0, 0));        
        segundoPanel.add(iuTitulo);
        
        iuFecha = new IUPanelCT("fecha", new Fecha().getFecha6(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(10)), 70, 30);
        segundoPanel.add(iuFecha);
    }
    private void construirTercerPanel(Limitacion limite){
        botonNuevaVenta = new IUBotonTI("nueva venta", "src/imagenes/new.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonNuevaVenta);
        
        botonCancelarVenta = new IUBotonTI("cancelar venta", "src/imagenes/cancel.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(19), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonCancelarVenta);
        
        botonFinalizarVenta = new IUBotonTI("finalizar venta", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        tercerPanel.add(botonFinalizarVenta);
    }
}