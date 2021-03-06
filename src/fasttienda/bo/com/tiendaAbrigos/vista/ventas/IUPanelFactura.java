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
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Hora;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Dosificacion;
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
    private Dosificacion dosificacion;
    
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
    private IUEtiqueta iuTotalPagarE;
    private IUEtiqueta iuEfectivo;
    private IUEtiqueta iuEfectivoE;
    private IUEtiqueta iuCambio;
    private IUEtiqueta iuCambioE;
    private IUEtiqueta iuTotalImporte;
    private IUEtiqueta iuTotalImporteE;
    private JSeparator iuQuintoSeperador;
    private IUEtiqueta iuMontoLiteral;
    private IUEtiqueta iuCodigoControl;
    private IUEtiqueta iuFechaLimiteEmision;
    private IUEtiquetaI iuCodigoQR;
    private IUAreaTexto iuAvisoLey;
    private IUAreaTexto iuDescripcionLey;
    private IUEtiqueta iuResponsable;
    
    public IUPanelFactura(Tienda tienda, Usuario usuario, Dosificacion dosificacion, Limitacion limitacion) {
        super(limitacion);
        this.tienda = tienda;
        this.usuario = usuario;
        this.dosificacion = dosificacion;
        actualizarDatos(getLimitacion());
        limpiarCamposDatos();
    }
    private void actualizarDatos(Limitacion limite){
        iuNombreEntidad = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNombreEntidad.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNombreEntidad.setHorizontalAlignment(SwingConstants.CENTER);
        //iuNombreEntidad.setBorder(new LineBorder(Color.BLACK));
        add(iuNombreEntidad);
        
        iuTipoTienda = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(3), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuTipoTienda.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTipoTienda.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTipoTienda.setBorder(new LineBorder(Color.BLACK));
        add(iuTipoTienda);
        
        iuDireccion = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuDireccion.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        //iuDireccion.setBorder(new LineBorder(Color.BLACK));
        add(iuDireccion);
        
        iuTelefono = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuTelefono.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTelefono.setBorder(new LineBorder(Color.BLACK));
        add(iuTelefono);
        
        iuCiudadPais = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuCiudadPais.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCiudadPais.setHorizontalAlignment(SwingConstants.CENTER);
        //iuCiudadPais.setBorder(new LineBorder(Color.BLACK));
        add(iuCiudadPais);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(210, 210, 210));
        add(iuPrimerSeparador);
        
        iuTitulo = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, 20));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTitulo.setBorder(new LineBorder(Color.yellow));
        iuTitulo.setForeground(new Color(120, 0, 0));
        add(iuTitulo);
        
        iuSegundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuSegundoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuSegundoSeparador.setForeground(new Color(210, 210, 210));
        add(iuSegundoSeparador);
        
        iuNroNit = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroNit.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroNit.setHorizontalAlignment(SwingConstants.CENTER);
        //iuNroNit.setBorder(new LineBorder(Color.BLACK));
        add(iuNroNit);
        
        iuNroFactura = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroFactura.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroFactura.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroFactura);
        
        iuNroAutorizacion = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroAutorizacion.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroAutorizacion.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroAutorizacion);
        
        iuTercerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuTercerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(22), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuTercerSeparador.setForeground(new Color(210, 210, 210));
        add(iuTercerSeparador);
        
        iuActividadEconomica = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuActividadEconomica.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuActividadEconomica.setHorizontalAlignment(SwingConstants.LEFT);
        add(iuActividadEconomica);
        
        iuFecha = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(2)));
        iuFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuFecha.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuFecha);
        
        iuHora = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(2)));
        iuHora.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuHora.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuHora);
        
        iuCuartoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuCuartoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(27), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuCuartoSeparador.setForeground(new Color(210, 210, 210));
        add(iuCuartoSeparador);
        
        iuNitCi = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(28), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNitCi.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNitCi.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNitCi);
        
        iuNombreRazonSocial = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNombreRazonSocial.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNombreRazonSocial.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNombreRazonSocial);
        
        iuTablaVentas = new IUTablaVentas(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(33), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(10)));
        iuTablaVentas.tabla.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTablaVentas.setFuenteCabecera(new Font("Verdana", Font.PLAIN, 13));
        add(iuTablaVentas.tabla.deslizador);
        
        iuTotalPagar = new IUEtiqueta("Total a Pagar:", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuTotalPagar.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);        
        add(iuTotalPagar);
        
        iuTotalPagarE = new IUEtiqueta("0.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuTotalPagarE.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTotalPagarE.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuTotalPagarE);
        
        iuEfectivo = new IUEtiqueta("Efectivo:", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuEfectivo.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuEfectivo.setHorizontalAlignment(SwingConstants.RIGHT);        
        add(iuEfectivo);
        
        iuEfectivoE = new IUEtiqueta("0.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuEfectivoE.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuEfectivoE.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuEfectivoE);
        
        iuCambio = new IUEtiqueta("Cambio:", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuCambio.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCambio.setHorizontalAlignment(SwingConstants.RIGHT);        
        add(iuCambio);
        
        iuCambioE = new IUEtiqueta("0.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuCambioE.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCambioE.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuCambioE);
        
        iuTotalImporte = new IUEtiqueta("Total Importe:", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuTotalImporte.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTotalImporte.setHorizontalAlignment(SwingConstants.RIGHT);        
        add(iuTotalImporte);
        
        iuTotalImporteE = new IUEtiqueta("0.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuTotalImporteE.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTotalImporteE.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuTotalImporteE);
        
        iuQuintoSeperador = new JSeparator(SwingConstants.HORIZONTAL);
        iuQuintoSeperador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuQuintoSeperador.setForeground(new Color(210, 210, 210));
        add(iuQuintoSeperador);
        
        iuMontoLiteral = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(54), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuMontoLiteral.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuMontoLiteral.setHorizontalAlignment(SwingConstants.LEFT);
        add(iuMontoLiteral);
        
        iuResponsable = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(56), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuResponsable.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuResponsable.setHorizontalAlignment(SwingConstants.LEFT);
        add(iuResponsable);
        
        iuCodigoControl = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(58), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuCodigoControl.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCodigoControl.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuCodigoControl);
        
        iuFechaLimiteEmision = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(60), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuFechaLimiteEmision.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuFechaLimiteEmision.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuFechaLimiteEmision);
        
        iuCodigoQR = new IUEtiquetaI("src/imagenes/codigoqr.png", new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(63), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(16)));
        //iuCodigoQR.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(iuCodigoQR);
        
        iuAvisoLey = new IUAreaTexto("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)));
        iuAvisoLey.setBorder(null);
        iuAvisoLey.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuAvisoLey.setFocusable(false);
        iuAvisoLey.setEditable(false);
        add(iuAvisoLey);
        
        iuDescripcionLey = new IUAreaTexto("", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(86), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)));
        iuDescripcionLey.setBorder(null);
        iuDescripcionLey.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuDescripcionLey.setFocusable(false);
        iuDescripcionLey.setEditable(false);
        add(iuDescripcionLey);
    }
    public void llenarDatosFactura(){
        iuNombreEntidad.setText(tienda.getNombreTienda().toUpperCase());
        iuTipoTienda.setText(tienda.getDescripcionTienda());
        iuDireccion.setText(tienda.getDireccionTienda());
        iuTelefono.setText(tienda.getTelefonosTienda());
        iuCiudadPais.setText(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda());
        iuTitulo.setText("FACTURA");
        iuNroNit.setText("nit contribuyente: "+dosificacion.getNitContribuyente());
        iuNroFactura.setText("nro factura: "+dosificacion.getNroFactura());
        iuNroAutorizacion.setText("nro autorizacion: "+dosificacion.getNroAutorizacion());        
        iuActividadEconomica.setText("actividad economica: "+dosificacion.getActividadEconomica().toUpperCase());
        iuFecha.setText("fecha: "+new Fecha().getFecha3());
        iuHora.setText("hora: "+new Hora().getHora()+" "+new Hora().getFormato());
        iuNitCi.setText("nombre: ");
        iuNombreRazonSocial.setText("nit: ");        
        iuTotalPagarE.setText("0.0");
        iuEfectivoE.setText("0.0");
        iuCambioE.setText("0.0");
        iuTotalImporteE.setText("0.0");
        iuMontoLiteral.setText("son: ");
        iuCodigoControl.setText("codigo de control: ");
        iuFechaLimiteEmision.setText("fecha limite emision: "+dosificacion.getFechaLimiteEmision());
        iuAvisoLey.setText(dosificacion.getDescripcionLey());
        iuDescripcionLey.setText(dosificacion.getAvisoLey());
        iuResponsable.setText("usuario:  "+usuario.getEmpleado().getPersona().getNombres()+" "+usuario.getEmpleado().getPersona().getApellidos());        
    }
    public void llenarDatosRecibo(){
        iuNombreEntidad.setText(tienda.getNombreTienda().toUpperCase());
        iuTipoTienda.setText(tienda.getDescripcionTienda());
        iuDireccion.setText(tienda.getDireccionTienda());
        iuTelefono.setText(tienda.getTelefonosTienda());
        iuCiudadPais.setText(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda());
        iuTitulo.setText("RECIBO");
        iuNroNit.setText("");
        iuNroFactura.setText("");
        iuNroAutorizacion.setText("");
        iuActividadEconomica.setText("actividad economica: "+dosificacion.getActividadEconomica().toUpperCase());
        iuFecha.setText("fecha: "+new Fecha().getFecha3());
        iuHora.setText("hora: "+new Hora().getHora()+" "+new Hora().getFormato());
        iuNitCi.setText("nombre: ");
        iuNombreRazonSocial.setText("");
        iuTotalPagarE.setText("0.0");
        iuEfectivoE.setText("0.0");
        iuCambioE.setText("0.0");
        iuTotalImporteE.setText("0.0");
        iuMontoLiteral.setText("son: ");
        iuCodigoControl.setText("");
        iuFechaLimiteEmision.setText("");
        iuAvisoLey.setText("");
        iuDescripcionLey.setText("");
        iuResponsable.setText("usuario:  "+usuario.getEmpleado().getPersona().getNombres()+" "+usuario.getEmpleado().getPersona().getApellidos());
    }
    
    public void limpiarCamposDatos(){
        iuNombreEntidad.setText("");
        iuTipoTienda.setText("");
        iuDireccion.setText("");
        iuTelefono.setText("");
        iuCiudadPais.setText("");
        iuTitulo.setText("");
        iuNroNit.setText("");
        iuNroFactura.setText("");
        iuNroAutorizacion.setText("");
        iuActividadEconomica.setText("");
        iuFecha.setText("");
        iuHora.setText("");
        iuNitCi.setText("");
        iuNombreRazonSocial.setText("");
        iuTablaVentas.limpiarTabla();
        iuTotalPagarE.setText("");
        iuEfectivoE.setText("");
        iuCambioE.setText("");
        iuTotalImporteE.setText("");
        iuMontoLiteral.setText("");
        iuCodigoControl.setText("");
        iuFechaLimiteEmision.setText("");
        iuAvisoLey.setText("");
        iuDescripcionLey.setText("");
        iuResponsable.setText("");
    }
}