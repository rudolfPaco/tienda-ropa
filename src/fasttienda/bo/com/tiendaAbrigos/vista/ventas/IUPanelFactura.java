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
    private JSeparator iuTercerSeparador;
    private IUEtiqueta iuActividadEconomica;
    private IUEtiqueta iuFecha;
    private IUEtiqueta iuHora;
    private IUEtiqueta iuNitCi;
    private IUEtiqueta iuNombreRazonSocial;
    private JSeparator iuCuartoSeparador;
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
        //iuNombreEntidad.setBorder(new LineBorder(Color.BLACK));
        add(iuNombreEntidad);
        
        iuTipoTienda = new IUEtiqueta(tienda.getDescripcionTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(4), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTipoTienda.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuTipoTienda.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTipoTienda.setBorder(new LineBorder(Color.BLACK));
        add(iuTipoTienda);
        
        iuDireccion = new IUEtiqueta(tienda.getDireccionTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuDireccion.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        //iuDireccion.setBorder(new LineBorder(Color.BLACK));
        add(iuDireccion);
        
        iuTelefono = new IUEtiqueta(tienda.getTelefonosTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTelefono.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTelefono.setBorder(new LineBorder(Color.BLACK));
        add(iuTelefono);
        
        iuCiudadPais = new IUEtiqueta(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(13), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuCiudadPais.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuCiudadPais.setHorizontalAlignment(SwingConstants.CENTER);
        //iuCiudadPais.setBorder(new LineBorder(Color.BLACK));
        add(iuCiudadPais);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(17), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(210, 210, 210));
        add(iuPrimerSeparador);
        
        iuTitulo = new IUEtiqueta("FACTURA", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(4)));
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(3)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setForeground(new Color(120, 0, 0));
        add(iuTitulo);
        
        iuSegundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuSegundoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuSegundoSeparador.setForeground(new Color(210, 210, 210));
        add(iuSegundoSeparador);
        
        iuNroNit = new IUEtiqueta("NIT CONTRIBUYENTE: 5233631019", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(24), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNroNit.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNroNit.setHorizontalAlignment(SwingConstants.CENTER);
        //iuNroNit.setBorder(new LineBorder(Color.BLACK));
        add(iuNroNit);
        
        iuNroFactura = new IUEtiqueta("NRO FACTURA: 10212444", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(27), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNroFactura.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNroFactura.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroFactura);
        
        iuNroAutorizacion = new IUEtiqueta("NRO AUTORIZACION: 100002784", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNroAutorizacion.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNroAutorizacion.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroAutorizacion);
        
        iuTercerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuTercerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(33), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuTercerSeparador.setForeground(new Color(210, 210, 210));
        add(iuTercerSeparador);
        
        iuActividadEconomica = new IUEtiqueta("ACTIVIDAD ECONOMICA: tienda comercial", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(34), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuActividadEconomica.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuActividadEconomica.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuActividadEconomica);
        
        iuFecha = new IUEtiqueta("Fecha: 20-10-2020", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(37), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(3)));
        iuFecha.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuFecha.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuFecha);
        
        iuHora = new IUEtiqueta("Hora: 20:20:33", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(37), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(3)));
        iuHora.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuHora.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuHora);
        
        iuCuartoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuCuartoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(40), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuCuartoSeparador.setForeground(new Color(210, 210, 210));
        add(iuCuartoSeparador);
        
        iuNitCi = new IUEtiqueta("NIT: 5233631019", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(41), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNitCi.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNitCi.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNitCi);
        
        iuNombreRazonSocial = new IUEtiqueta("NOMBRE: Felipez", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuNombreRazonSocial.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        iuNombreRazonSocial.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNombreRazonSocial);
        
        
    }
}
