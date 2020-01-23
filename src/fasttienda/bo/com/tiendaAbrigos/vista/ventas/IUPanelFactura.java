/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.campos.IUAreaTexto;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import jdk.nashorn.internal.scripts.JS;

/**
 *
 * @author hotel-felipez
 */
public class IUPanelFactura extends IUPanelBD{
    
    private Tienda tienda;
    private Usuario usuario;
    
    private IUEtiqueta iuNombreEntidad;
    private IUEtiqueta iuTipoTienda;
    private IUEtiqueta iuDireccion;
    private IUEtiqueta iuTelefono;
    private IUEtiqueta iuCiudadPais;
    private IUEtiqueta iuTitulo;
    private JSeparator iuPrimerSeparador;
    private IUEtiqueta iuNroNit;
    private IUEtiqueta iuNroFactura;
    private IUEtiqueta iuNroAutorizacion;
    private JSeparator iuSegundoSeparador;
    private IUEtiqueta iuActividadEconomica;
    private IUEtiqueta iuFecha;
    private IUEtiqueta iuHora;
    private IUEtiqueta iuNitCi;
    private IUEtiqueta iuNombreRazonSocial;
    private JSeparator iuTercerSeparador;
    private IUTablaVentas iuTablaVentas;
    private IUEtiqueta iuTotalPagar;
    private IUEtiqueta iuEfectivo;
    private IUEtiqueta iuCambio;
    private IUEtiqueta iuTotalImporte;
    private IUEtiqueta iuMontoLiteral;
    private IUEtiqueta iuCodigoControl;
    private IUEtiqueta iuFechaLimiteEmision;
    private IUEtiquetaI iuCodigoQR;
    private IUAreaTexto iuAvisoLey;
    private IUAreaTexto iuDescripcionLey;
    private IUEtiqueta iuResponsable;
    
    public IUPanelFactura(Tienda tienda, Usuario usuario, Limitacion limitacion) {
        super(limitacion);
        this.tienda = tienda;
        this.usuario = usuario;
        actualizarDatos(getLimitacion());
    }
    private void actualizarDatos(Limitacion limite){
        iuNombreEntidad = new IUEtiqueta(tienda.getNombreTienda().toUpperCase(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNombreEntidad.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNombreEntidad.setHorizontalAlignment(SwingConstants.CENTER);
        iuNombreEntidad.setBorder(new LineBorder(Color.BLACK));
        add(iuNombreEntidad);
        
        iuTipoTienda = new IUEtiqueta(tienda.getDescripcionTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(4), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTipoTienda.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuTipoTienda.setHorizontalAlignment(SwingConstants.CENTER);
        iuTipoTienda.setBorder(new LineBorder(Color.BLACK));
        add(iuTipoTienda);
        
        iuDireccion = new IUEtiqueta(tienda.getDireccionTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuDireccion.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        iuDireccion.setBorder(new LineBorder(Color.BLACK));
        add(iuDireccion);
        
        iuTelefono = new IUEtiqueta(tienda.getTelefonosTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTelefono.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        iuTelefono.setBorder(new LineBorder(Color.BLACK));
        add(iuTelefono);
        
        iuCiudadPais = new IUEtiqueta(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(13), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTelefono.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        iuTelefono.setBorder(new LineBorder(Color.BLACK));
        add(iuTelefono);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(17), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(230, 230, 230));
        add(iuPrimerSeparador);
        
        iuNroNit = new IUEtiqueta(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(13), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNroNit.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNroNit.setHorizontalAlignment(SwingConstants.CENTER);
        iuNroNit.setBorder(new LineBorder(Color.BLACK));
        add(iuNroNit);
    }
}
