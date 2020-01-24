/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBotonTI;
import com.aplicacionjava.www.calendario.IUCalendario;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelTA;
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaM;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import static fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda.alto;
import static fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda.ancho;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IUPanelDosificacion extends IUPanelBD{

    private CVenta controlVentas;    
    private IUPrincipal ventanaPrincipal;
    
    private IUPanelBD primerPanel;
    private IUEtiqueta iuTituloDosificacion;
    private JSeparator iuPrimerSeparador;
    private IUPanelCT iuNitContribuyente;
    private IUPanelCT iuNombreRazonSocial;
    private IUPanelCT iuNroTramite;
    private JSeparator iuSegundoSeparador;
    private IUPanelCT iuLlaveDosificacion;
    private IUPanelCT iuNroAutorizacion;
    private IUPanelCT iuCantidad;
    private IUPanelCT iuRangoDesde;
    private IUPanelCT iuRangoHasta;
    private IUPanelCT iuFechaLimiteEmision;
    private IUBotonTI botonFecha;
    private IUPanelTA iuAvisoLey;
    
    private IUPanel segundoPanel;
    private IUBotonTI botonImprimerDosificacion;    
    
    private IUBotonTI botonModificarDosificacion;
    private IUBotonTI botonGuardarDosificacion;
    
    public IUPanelDosificacion(CVenta controlVentas, IUPrincipal ventanaPrincipal, Limitacion limitacion) {
        super(limitacion);
        this.controlVentas = controlVentas;
        this.ventanaPrincipal = ventanaPrincipal;
        construirPaneles(getLimitacion());
        habilitarCamposDatos(true);
        escucharEvento();
    }
    private void construirPaneles(Limitacion limite){
        
        primerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(98)));
        primerPanel.setArco(20);
        add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(85), 0, limite.getPorcentajeAncho(15), limite.getAlto()));
        add(segundoPanel);
        construirTercerPanel(segundoPanel.getLimitacion());
    }
    private void construirPrimerPanel(Limitacion limite){
        iuTituloDosificacion = new IUEtiqueta("Dosificacion Facturas", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(7)));
        iuTituloDosificacion.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(4)));
        iuTituloDosificacion.setHorizontalAlignment(SwingConstants.CENTER);
        iuTituloDosificacion.setForeground(new Color(120, 0, 0));
        primerPanel.add(iuTituloDosificacion);
        
        iuPrimerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuPrimerSeparador.setBounds(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(7), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(1));
        iuPrimerSeparador.setForeground(new Color(120, 0, 0));
        iuPrimerSeparador.setFocusable(false);
        primerPanel.add(iuPrimerSeparador);
        
        iuNitContribuyente = new IUPanelCT("nit contribuyente", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(6)), 40, 60);
        iuNitContribuyente.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNitContribuyente.iuTexto.setFocusable(false);
        iuNitContribuyente.iuTexto.setEditable(false);
        primerPanel.add(iuNitContribuyente);
        
        iuNombreRazonSocial = new IUPanelCT("nombre / razon social", "", new Limitacion(limite.getPorcentajeAncho(42), limite.getPorcentajeAlto(9), limite.getPorcentajeAncho(56), limite.getPorcentajeAlto(6)), 40, 60);
        iuNombreRazonSocial.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNombreRazonSocial.iuTexto.setFocusable(false);
        iuNombreRazonSocial.iuTexto.setEditable(false);
        primerPanel.add(iuNombreRazonSocial);
        
        iuNroTramite = new IUPanelCT("nro de tramite", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(6)), 40, 60);
        iuNroTramite.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNroTramite.iuTexto.setFocusable(false);
        iuNroTramite.iuTexto.setEditable(false);
        primerPanel.add(iuNroTramite);
        
        iuSegundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
        iuSegundoSeparador.setBounds(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(27), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(1));
        iuSegundoSeparador.setForeground(new Color(220, 220, 220));
        iuSegundoSeparador.setFocusable(false);
        primerPanel.add(iuSegundoSeparador);
        
        iuLlaveDosificacion = new IUPanelCT("llave dosificacion", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)), 40, 60);
        iuLlaveDosificacion.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuLlaveDosificacion.iuTexto.setFocusable(false);
        iuLlaveDosificacion.iuTexto.setEditable(false);
        primerPanel.add(iuLlaveDosificacion);
        
        iuNroAutorizacion = new IUPanelCT("nro autorizacion", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(37), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(6)), 40, 60);
        iuNroAutorizacion.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNroAutorizacion.iuTexto.setFocusable(false);
        iuNroAutorizacion.iuTexto.setEditable(false);
        primerPanel.add(iuNroAutorizacion);
        
        iuCantidad = new IUPanelCT("cantidad", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(37), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(6)), 40, 60);
        iuCantidad.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuCantidad.iuTexto.setFocusable(false);
        iuCantidad.iuTexto.setEditable(false);
        primerPanel.add(iuCantidad);
        
        iuRangoDesde = new IUPanelCT("rango desde", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(6)), 40, 60);
        iuRangoDesde.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuRangoDesde.iuTexto.setFocusable(false);
        iuRangoDesde.iuTexto.setEditable(false);
        primerPanel.add(iuRangoDesde);
        
        iuRangoHasta = new IUPanelCT("rango hasta", "", new Limitacion(limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(6)), 40, 60);
        iuRangoHasta.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuRangoHasta.iuTexto.setFocusable(false);
        iuRangoHasta.iuTexto.setEditable(false);
        primerPanel.add(iuRangoHasta);
        
        iuFechaLimiteEmision = new IUPanelCT("fecha limite emision", "", new Limitacion(limite.getPorcentajeAncho(54), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(6)), 40, 60);
        iuFechaLimiteEmision.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuFechaLimiteEmision.iuTexto.setFocusable(false);
        iuFechaLimiteEmision.iuTexto.setEditable(false);
        primerPanel.add(iuFechaLimiteEmision);
        
        botonFecha = new IUBotonTI("", "src/imagenes/fecha.png", new Limitacion(limite.getPorcentajeAncho(84), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(6)), 90, 90, 0);
        primerPanel.add(botonFecha);
        
        iuAvisoLey = new IUPanelTA("aviso de ley", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(51), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(15)), 15, 85);        
        iuAvisoLey.iuAreaTexto.setFocusable(false);
        iuAvisoLey.iuAreaTexto.setEditable(false);
        primerPanel.add(iuAvisoLey);
    }
    private void construirTercerPanel(Limitacion limite){
        botonImprimerDosificacion = new IUBotonTI("imprimir", "src/imagenes/impresoraAzul.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        segundoPanel.add(botonImprimerDosificacion);
        botonImprimerDosificacion.setVisible(false);
        
        botonModificarDosificacion = new IUBotonTI("modificar", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 60, 70, 15);
        segundoPanel.add(botonModificarDosificacion);
        botonModificarDosificacion.setVisible(false);
        
        botonGuardarDosificacion = new IUBotonTI("guardar", "src/imagenes/guardar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        segundoPanel.add(botonGuardarDosificacion);
    }
    private void habilitarCamposDatos(boolean bandera){
        iuNitContribuyente.iuTexto.setEditable(bandera);
        iuNitContribuyente.iuTexto.setFocusable(bandera);
        iuNombreRazonSocial.iuTexto.setEditable(bandera);
        iuNombreRazonSocial.iuTexto.setFocusable(bandera);
        iuNroTramite.iuTexto.setEditable(bandera);
        iuNroTramite.iuTexto.setFocusable(bandera);
        iuLlaveDosificacion.iuTexto.setEditable(bandera);
        iuLlaveDosificacion.iuTexto.setFocusable(bandera);
        iuNroAutorizacion.iuTexto.setEditable(bandera);
        iuNroAutorizacion.iuTexto.setFocusable(bandera);
        iuCantidad.iuTexto.setEditable(bandera);
        iuCantidad.iuTexto.setFocusable(bandera);
        iuRangoDesde.iuTexto.setEditable(bandera);
        iuRangoDesde.iuTexto.setFocusable(bandera);
        iuRangoHasta.iuTexto.setEditable(bandera);
        iuRangoHasta.iuTexto.setFocusable(bandera);        
        iuAvisoLey.iuAreaTexto.setEditable(bandera);
        iuAvisoLey.iuAreaTexto.setFocusable(bandera);
    }
    private boolean estaCamposValidados(){
        boolean verificador = false;
        if(!iuNitContribuyente.iuTexto.getText().isEmpty()){
            if(!iuNombreRazonSocial.iuTexto.getText().isEmpty()){
                if(!iuNroTramite.iuTexto.getText().isEmpty()){
                    if(!iuLlaveDosificacion.iuTexto.getText().isEmpty()){
                        if(!iuNroAutorizacion.iuTexto.getText().isEmpty()){
                            if(!iuCantidad.iuTexto.getText().isEmpty()){
                                if(!iuRangoDesde.iuTexto.getText().isEmpty()){
                                    if(!iuRangoHasta.iuTexto.getText().isEmpty()){
                                        if(!iuAvisoLey.iuAreaTexto.getText().isEmpty()){
                                            verificador = true;
                                        }else{
                                            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo AVISO LEY", "advertencia");
                                        }
                                    }else{
                                        Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo RANGO HASTA", "advertencia");
                                    }
                                }else{
                                    Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo RANGO DESDE", "advertencia");
                                }
                            }else{
                                Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo CANTIDAD ", "advertencia");
                            }
                        }else{
                            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo NRO AUTORIZACION ", "advertencia");
                        }
                    }else{
                        Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo LLAVE DOSIFICACION ", "advertencia");
                    }
                }else{
                    Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo NRO TRAMITE ", "advertencia");
                }
            }else{
                Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo NNOMBRE RAZON SOCIAL ", "advertencia");
            }
        }else{
            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo NIT CONTRIBUYENTE ", "advertencia");
        }
        return verificador;
    }
    private void escucharEvento(){
        botonGuardarDosificacion.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(estaCamposValidados()){
                    habilitarCamposDatos(false);
                    
                }                
            }
        });
        botonFecha.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                IUCalendario iuCalendario = new IUCalendario(ventanaPrincipal, "Fecha Limite de Emision", new Fecha(), new Limitacion(Ayuda.ancho/2, Ayuda.alto/2));
                iuCalendario.mostrarVentana();
                if(iuCalendario.getEstado()){
                    Fecha fecha = iuCalendario.getFecha();
                    iuFechaLimiteEmision.iuTexto.setText(fecha.getFecha());                    
                }
            }            
        });
    }
}
