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
        
        iuTelefono = new IUEtiqueta(tienda.getTelefonosTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuTelefono.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTelefono.setBorder(new LineBorder(Color.BLACK));
        add(iuTelefono);
        
        iuCiudadPais = new IUEtiqueta(tienda.getCiudadTienda()+" - "+tienda.getPaisTienda(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuCiudadPais.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCiudadPais.setHorizontalAlignment(SwingConstants.CENTER);
        //iuCiudadPais.setBorder(new LineBorder(Color.BLACK));
        add(iuCiudadPais);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(210, 210, 210));
        add(iuPrimerSeparador);
        
        iuTitulo = new IUEtiqueta("FACTURA", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(3)));
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, 20));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTitulo.setBorder(new LineBorder(Color.yellow));
        iuTitulo.setForeground(new Color(120, 0, 0));
        add(iuTitulo);
        
        iuSegundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuSegundoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuSegundoSeparador.setForeground(new Color(210, 210, 210));
        add(iuSegundoSeparador);
        
        iuNroNit = new IUEtiqueta("NIT CONTRIBUYENTE: 5233631019", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroNit.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroNit.setHorizontalAlignment(SwingConstants.CENTER);
        //iuNroNit.setBorder(new LineBorder(Color.BLACK));
        add(iuNroNit);
        
        iuNroFactura = new IUEtiqueta("NRO FACTURA: 10212444", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroFactura.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroFactura.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroFactura);
        
        iuNroAutorizacion = new IUEtiqueta("NRO AUTORIZACION: 100002784", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNroAutorizacion.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNroAutorizacion.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNroAutorizacion);
        
        iuTercerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuTercerSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(22), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuTercerSeparador.setForeground(new Color(210, 210, 210));
        add(iuTercerSeparador);
        
        iuActividadEconomica = new IUEtiqueta("ACTIVIDAD ECONOMICA: tienda comercial", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuActividadEconomica.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuActividadEconomica.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuActividadEconomica);
        
        iuFecha = new IUEtiqueta("Fecha: 20-10-2020", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(2)));
        iuFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuFecha.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuFecha);
        
        iuHora = new IUEtiqueta("Hora: 20:20:33", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(49), limite.getPorcentajeAlto(2)));
        iuHora.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuHora.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuHora);
        
        iuCuartoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuCuartoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(27), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuCuartoSeparador.setForeground(new Color(210, 210, 210));
        add(iuCuartoSeparador);
        
        iuNitCi = new IUEtiqueta("NIT: 5233631019", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(28), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuNitCi.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuNitCi.setHorizontalAlignment(SwingConstants.CENTER);        
        add(iuNitCi);
        
        iuNombreRazonSocial = new IUEtiqueta("NOMBRE: Felipez", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
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
        
        iuTotalPagarE = new IUEtiqueta("120.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuTotalPagarE.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuTotalPagarE.setHorizontalAlignment(SwingConstants.RIGHT);
        add(iuTotalPagarE);
        
        iuEfectivo = new IUEtiqueta("Efectivo:", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
        iuEfectivo.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuEfectivo.setHorizontalAlignment(SwingConstants.RIGHT);        
        add(iuEfectivo);
        
        iuEfectivoE = new IUEtiqueta("120.0", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(48), limite.getPorcentajeAlto(2)));
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
        
        iuMontoLiteral = new IUEtiqueta("Son: docientos cincuenta y cinco 00/100", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(54), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuMontoLiteral.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuMontoLiteral.setHorizontalAlignment(SwingConstants.LEFT);
        add(iuMontoLiteral);
        
        iuResponsable = new IUEtiqueta("Responsable: Juana de arco", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(56), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuResponsable.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuResponsable.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuResponsable);
        
        iuCodigoControl = new IUEtiqueta("codigo de control: CD-A1-DD-1D-DW-4A", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(58), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuCodigoControl.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuCodigoControl.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuCodigoControl);
        
        iuFechaLimiteEmision = new IUEtiqueta("fecha limite de emision: 17-02-2020", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(60), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(2)));
        iuFechaLimiteEmision.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuFechaLimiteEmision.setHorizontalAlignment(SwingConstants.CENTER);
        add(iuFechaLimiteEmision);
        
        iuCodigoQR = new IUEtiquetaI("src/imagenes/codigoqr.png", new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(63), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(16)));
        iuCodigoQR.setBorder(new LineBorder(Color.yellow));
        add(iuCodigoQR);
        
        iuAvisoLey = new IUAreaTexto("''ESTA FACTURA CONTRIBUYE AL DESARROLLO DEL PAIS , ELS USO ILICITO DE ESTA SERA SANCIONADO DE ACUERDO A LEY''", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)));
        iuAvisoLey.setBorder(new LineBorder(Color.LIGHT_GRAY));
        iuAvisoLey.setFont(new Font("Verdana", Font.PLAIN, 12));
        iuAvisoLey.setFocusable(false);
        iuAvisoLey.setEditable(false);
        add(iuAvisoLey);
        
        iuDescripcionLey = new IUAreaTexto("Ley Nº 453: El proveedor de servicios debe habilitar medios e instrumentos para efectua consultas y reclamaciones.", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(86), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)));
        iuDescripcionLey.setBorder(new LineBorder(Color.LIGHT_GRAY));
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
        iuNroNit.setText(dosificacion.getNitContribuyente());
        iuNroFactura.setText(dosificacion.getNroFactura());
        iuNroAutorizacion.setText(dosificacion.getNroAutorizacion());        }
        /*iuActividadEconomica.setText(dosificacion.get);
        iuFecha;
        iuHora;
        iuNitCi;
        iuNombreRazonSocial;
        iuCuartoSeparador;
        iuTablaVentas;
        iuTotalPagar;
        iuTotalPagarE;
        iuEfectivo;
        iuEfectivoE;
        iuCambio;
        iuCambioE;
        iuTotalImporte;
        iuTotalImporteE;
        iuQuintoSeperador;
        iuMontoLiteral;
        iuCodigoControl;
        iuFechaLimiteEmision;
        iuCodigoQR;
        iuAvisoLey;
        iuDescripcionLey;
        iuResponsable;
    }
    public void llenarDatosRecibo(){
        iuNombreEntidad;
        iuTipoTienda;
        iuDireccion;
        iuTelefono;
        iuCiudadPais;
        iuTitulo;
        iuPrimerSeparador;
        iuNroNit;
        iuNroFactura;
        iuNroAutorizacion;
        iuSegundoSeparador;
        iuTercerSeparador;
        iuActividadEconomica;
        iuFecha;
        iuHora;
        iuNitCi;
        iuNombreRazonSocial;
        iuCuartoSeparador;
        iuTablaVentas;
        iuTotalPagar;
        iuTotalPagarE;
        iuEfectivo;
        iuEfectivoE;
        iuCambio;
        iuCambioE;
        iuTotalImporte;
        iuTotalImporteE;
        iuQuintoSeperador;
        iuMontoLiteral;
        iuCodigoControl;
        iuFechaLimiteEmision;
        iuCodigoQR;
        iuAvisoLey;
        iuDescripcionLey;
        iuResponsable;
    }
    public void limpiarCamposDatos(){
        iuNombreEntidad;
        iuTipoTienda;
        iuDireccion;
        iuTelefono;
        iuCiudadPais;
        iuTitulo;
        iuPrimerSeparador;
        iuNroNit;
        iuNroFactura;
        iuNroAutorizacion;
        iuSegundoSeparador;
        iuTercerSeparador;
        iuActividadEconomica;
        iuFecha;
        iuHora;
        iuNitCi;
        iuNombreRazonSocial;
        iuCuartoSeparador;
        iuTablaVentas;
        iuTotalPagar;
        iuTotalPagarE;
        iuEfectivo;
        iuEfectivoE;
        iuCambio;
        iuCambioE;
        iuTotalImporte;
        iuTotalImporteE;
        iuQuintoSeperador;
        iuMontoLiteral;
        iuCodigoControl;
        iuFechaLimiteEmision;
        iuCodigoQR;
        iuAvisoLey;
        iuDescripcionLey;
        iuResponsable;
    }*/
}