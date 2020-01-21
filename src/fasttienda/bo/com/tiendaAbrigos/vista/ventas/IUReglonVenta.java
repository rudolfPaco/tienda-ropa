/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBoton;
import com.aplicacionjava.www.campos.IUAreaTexto;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleVenta;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author hotel-felipez
 */
public class IUReglonVenta extends IUPanelBD{
    
    private IUEtiqueta iuCodigoPrenda;
    private IUEtiqueta iuDescripcionPrenda;
    private IUEtiqueta iuCantidad;
    private IUEtiqueta iuPrecio;
    private IUEtiqueta iuImporte;
    private IUEtiquetaI botonVer;
    private IUEtiquetaI botonDevolucion;
    private IUEtiquetaI botonModificar;
    private DetalleVenta detalleVenta;
    
    public IUReglonVenta(Limitacion limitacion, DetalleVenta detalleVenta) {
        super(limitacion);
        setArco(15);
        this.detalleVenta = detalleVenta;
        construirPaneles(getLimitacion());
    }
    private void construirPaneles(Limitacion limite){
        iuCantidad = new IUEtiqueta("20", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(90)));
        iuCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuCantidad);
        
        iuDescripcionPrenda = new IUEtiqueta("polera lacoste M, color entero, rojo", new Limitacion(limite.getPorcentajeAncho(6), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(90)));
        add(iuDescripcionPrenda);
        
        iuCodigoPrenda = new IUEtiqueta("100154", new Limitacion(limite.getPorcentajeAncho(56), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(90)));
        iuCodigoPrenda.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuCodigoPrenda);
        
        iuPrecio = new IUEtiqueta("265.50", new Limitacion(limite.getPorcentajeAncho(66), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iuPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuPrecio);
        
        iuImporte = new IUEtiqueta("520.50", new Limitacion(limite.getPorcentajeAncho(76), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iuImporte.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuImporte);
        
        botonVer = new IUEtiquetaI("src/imagenes/observar.png", new Limitacion(limite.getPorcentajeAncho(86), limite.getPorcentajeAlto(10), limite.getPorcentajeAlto(80), limite.getPorcentajeAlto(80)));
        add(botonVer);
        
        botonDevolucion = new IUEtiquetaI("src/imagenes/devolver.png", new Limitacion(limite.getPorcentajeAncho(91), limite.getPorcentajeAlto(10), limite.getPorcentajeAlto(80), limite.getPorcentajeAlto(80)));
        add(botonDevolucion);
        
        botonModificar = new IUEtiquetaI("src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(92) + limite.getPorcentajeAlto(80), limite.getPorcentajeAlto(10), limite.getPorcentajeAlto(80), limite.getPorcentajeAlto(80)));
        add(botonModificar);
    }
}
