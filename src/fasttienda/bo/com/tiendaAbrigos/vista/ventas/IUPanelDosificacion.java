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
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import fasttienda.bo.com.tiendaAbrigos.modelo.Dosificacion;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.Color;
import java.awt.Font;
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
    private IUPanelCT iuNroFactura;
    private JSeparator iuSegundoSeparador;
    private IUPanelCT iuLlaveDosificacion;
    private IUPanelCT iuNroAutorizacion;
    private IUPanelCT iuCantidad;
    private IUPanelCT iuRangoDesde;
    private IUPanelCT iuRangoHasta;
    private IUPanelCT iuFechaLimiteEmision;
    private IUBotonTI botonFecha;
    private IUPanelCT iuActividadEconomica;
    private IUPanelTA iuAvisoLey;
    
    private IUPanel segundoPanel;
    private IUBotonTI botonImprimerDosificacion;    
    
    private IUBotonTI botonModificarDosificacion;
    private IUBotonTI botonGuardarDosificacion;
    private IUBotonTI botonEditarDosificacion;
    
    private Dosificacion dosificacion;
    
    public IUPanelDosificacion(CVenta controlVentas, IUPrincipal ventanaPrincipal, Limitacion limitacion) {
        super(limitacion);
        this.controlVentas = controlVentas;
        this.ventanaPrincipal = ventanaPrincipal;
        this.dosificacion = null;
        
        init();        
    }
    private void init(){
        construirPaneles(getLimitacion());
        escucharEvento();
        if(controlVentas.exiteDosificacion()){
            this.dosificacion = controlVentas.getDosificacion();
            
            botonGuardarDosificacion.setVisible(false);
            botonImprimerDosificacion.setVisible(true);
            botonModificarDosificacion.setVisible(true);
            
            agregarDatosDosificacion();
            habilitarCamposDatos(false);
            
        }else{
            botonGuardarDosificacion.setVisible(true);
            botonImprimerDosificacion.setVisible(false);
            botonModificarDosificacion.setVisible(false);
            
            habilitarCamposDatos(true);
        }
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
        
        iuNroFactura = new IUPanelCT("nro de factura", "", new Limitacion(limite.getPorcentajeAncho(42), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(6)), 40, 60);
        iuNroFactura.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuNroFactura.iuTexto.setFocusable(false);
        iuNroFactura.iuTexto.setEditable(false);
        primerPanel.add(iuNroFactura);
        
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
        iuCantidad.iuTexto.setRestriccionNumeroEnteros();
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
        
        iuActividadEconomica = new IUPanelCT("actividad economica", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(51), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(6)), 40, 60);
        iuActividadEconomica.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        iuActividadEconomica.iuTexto.setFocusable(false);
        iuActividadEconomica.iuTexto.setEditable(false);
        primerPanel.add(iuActividadEconomica);
        
        iuAvisoLey = new IUPanelTA("aviso de ley", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(58), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(15)), 15, 85);        
        iuAvisoLey.iuAreaTexto.setFocusable(false);
        iuAvisoLey.iuAreaTexto.setEditable(false);
        primerPanel.add(iuAvisoLey);
    }
    private void construirTercerPanel(Limitacion limite){
        botonImprimerDosificacion = new IUBotonTI("imprimir", "src/imagenes/impresoraAzul.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(2), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        segundoPanel.add(botonImprimerDosificacion);
        
        botonModificarDosificacion = new IUBotonTI("modificar", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 60, 70, 15);
        segundoPanel.add(botonModificarDosificacion);
        
        botonGuardarDosificacion = new IUBotonTI("guardar", "src/imagenes/guardar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        segundoPanel.add(botonGuardarDosificacion);
        
        botonEditarDosificacion = new IUBotonTI("editar datos", "src/imagenes/guardar.png", new Limitacion(limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(15)), 70, 80, 15);
        segundoPanel.add(botonEditarDosificacion);        
        botonEditarDosificacion.setVisible(false);
    }
    private void habilitarCamposDatos(boolean bandera){        
        iuNitContribuyente.iuTexto.setEditable(bandera);
        iuNitContribuyente.iuTexto.setFocusable(bandera);
        iuNombreRazonSocial.iuTexto.setEditable(bandera);
        iuNombreRazonSocial.iuTexto.setFocusable(bandera);
        iuNroTramite.iuTexto.setEditable(bandera);
        iuNroTramite.iuTexto.setFocusable(bandera);
        iuNroFactura.iuTexto.setEditable(bandera);
        iuNroFactura.iuTexto.setFocusable(bandera);
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
        iuActividadEconomica.iuTexto.setEditable(bandera);
        iuActividadEconomica.iuTexto.setFocusable(bandera);
        iuAvisoLey.iuAreaTexto.setEditable(bandera);
        iuAvisoLey.iuAreaTexto.setFocusable(bandera);
    }
    private boolean estaCamposValidados(){
        boolean verificador = false;
        if(!iuNitContribuyente.iuTexto.getText().isEmpty()){
            if(!iuNombreRazonSocial.iuTexto.getText().isEmpty()){
                if(!iuNroTramite.iuTexto.getText().isEmpty()){
                    if(!iuNroFactura.iuTexto.getText().isEmpty()){
                        if(!iuLlaveDosificacion.iuTexto.getText().isEmpty()){
                            if(!iuNroAutorizacion.iuTexto.getText().isEmpty()){
                                if(!iuCantidad.iuTexto.getText().isEmpty()){
                                    if(!iuRangoDesde.iuTexto.getText().isEmpty()){
                                        if(!iuRangoHasta.iuTexto.getText().isEmpty()){
                                            if(!iuActividadEconomica.iuTexto.getText().isEmpty()){
                                                if(!iuAvisoLey.iuAreaTexto.getText().isEmpty()){
                                                    verificador = true;
                                                }else{
                                                    Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo AVISO LEY", "advertencia");
                                                }
                                            }else{
                                                Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo ACTIVIDAD ECONOMICA", "advertencia");
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
                        Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento pero no puede estar vacio el campo NRO FACTURA ", "advertencia");
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
                    if(Ayuda.mensajeVerificacion(ventanaPrincipal, "peligro", "esta seguro que desea guardar los nuevos datos de la DOSIFICACION...?", "advertencia")){
                        guardarDosificacion();
                    }
                }
            }
        });
        botonModificarDosificacion.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if(Ayuda.mensajeVerificacion(ventanaPrincipal, "peligro", "...esta seguro que desea modificar los datos de la DOSIFICACION...?", "advertencia")){
                    modificarDosificacion();
                }
            }
        });
        botonEditarDosificacion.addEventoRaton(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if(estaCamposValidados()){
                    editarDosificacion();
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
    private void guardarDosificacion(){
        llenarDatosDosificacion();
        if(controlVentas.guardarNuevaDosificacion(dosificacion)){
            habilitarCamposDatos(false);
            botonGuardarDosificacion.setVisible(false);
            botonImprimerDosificacion.setVisible(true);
            botonModificarDosificacion.setVisible(true);
        }
    }
    private void modificarDosificacion(){
        habilitarCamposDatos(true);
        botonEditarDosificacion.setVisible(true);
        botonGuardarDosificacion.setVisible(false);
        botonModificarDosificacion.setVisible(false);
        botonImprimerDosificacion.setVisible(false);
    }
    private void editarDosificacion(){
        llenarDatosDosificacion();        
        if(controlVentas.editarDatosDosificacion(dosificacion)){
            habilitarCamposDatos(false);
            botonEditarDosificacion.setVisible(false);
            botonImprimerDosificacion.setVisible(true);
            botonModificarDosificacion.setVisible(true);
            Ayuda.mensajeVerificacion(ventanaPrincipal, "correcto", "los datos se modificaron EXITOSAMENTE...!", "confirmado");
        }
    }
    private void agregarDatosDosificacion(){
        iuNitContribuyente.iuTexto.setText(dosificacion.getNitContribuyente());
        iuNombreRazonSocial.iuTexto.setText(dosificacion.getNombreApellidoRazonSocial());
        iuNroTramite.iuTexto.setText(dosificacion.getNroTramiteDosificacion());
        iuNroFactura.iuTexto.setText(dosificacion.getNroFactura());
        iuLlaveDosificacion.iuTexto.setText(dosificacion.getLlaveDosificacion());
        iuNroAutorizacion.iuTexto.setText(dosificacion.getNroAutorizacion());
        iuCantidad.iuTexto.setText(String.valueOf(dosificacion.getCantidad()));
        iuRangoDesde.iuTexto.setText(dosificacion.getRangoDesde());
        iuRangoHasta.iuTexto.setText(dosificacion.getRangoHasta());
        iuFechaLimiteEmision.iuTexto.setText(dosificacion.getFechaLimiteEmision());
        iuActividadEconomica.iuTexto.setText(dosificacion.getActividadEconomica());
        iuAvisoLey.iuAreaTexto.setText(dosificacion.getAvisoLey());        
    }
    private void llenarDatosDosificacion(){
        if(dosificacion == null)
            dosificacion = new Dosificacion(0);
                
        dosificacion.setNitContribuyente(iuNitContribuyente.iuTexto.getText());
        dosificacion.setNombreApellidoRazonSocial(iuNombreRazonSocial.iuTexto.getText());
        dosificacion.setNroTramiteDosificacion(iuNroTramite.iuTexto.getText());
        dosificacion.setNroFactura(iuNroFactura.iuTexto.getText());
        dosificacion.setLlaveDosificacion(iuLlaveDosificacion.iuTexto.getText());
        dosificacion.setNroAutorizacion(iuNroAutorizacion.iuTexto.getText());
        dosificacion.setCantidad(Integer.parseInt(iuCantidad.iuTexto.getText()));
        dosificacion.setRangoDesde(iuRangoDesde.iuTexto.getText());
        dosificacion.setRangoHasta(iuRangoHasta.iuTexto.getText());
        dosificacion.setFechaLimiteEmision(iuFechaLimiteEmision.iuTexto.getText());
        dosificacion.setActividadEconomica(iuActividadEconomica.getTexto());
        dosificacion.setAvisoLey(iuAvisoLey.iuAreaTexto.getText());
        dosificacion.setIdTienda(controlVentas.getTienda().getTiendaID());
        dosificacion.setTienda(controlVentas.getTienda());
    }
}