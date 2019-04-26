/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.inicio;

import com.aplicacionjava.www.botones.IUBoton;
import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.calendario.IUCalendario;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelCTU;
import com.aplicacionjava.www.paneles.IUPanelTCB;
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.FastTienda;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CRegistroPrincipal;
import fasttienda.bo.com.tiendaAbrigos.modelo.Empleado;
import fasttienda.bo.com.tiendaAbrigos.modelo.Persona;
import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author rudolf
 */
public class IURegistroPrincipal extends IUVentanaT{
    
    private JFrame ventanaPrincipal;
    private CRegistroPrincipal controlRegistroPrincipal;
    private String tipoPanel;
    private Tienda tienda;
    private Usuario usuario;
    
    private CardLayout administrador;
    private IUPanelBD panelAdministrador;
    
    private IUPanelBD panelTienda;
    private IUEtiqueta tituloTienda;
    private IUPanelCT nombreTienda;
    private IUPanelCT descripcionTienda;
    private IUPanelCT direccionTienda;
    private IUPanelCT telefonosTienda;
    private IUPanelCT ciudadTienda;
    private IUPanelCT paisTienda;
    private IUPanelTCB monedaOficial;
    private IUPanelCT unidadMoneda;
    private IUPanelCTU tipoCambio;
    private IUEtiqueta etiquetaLogo;
    private IUEtiquetaI logo;
    private IUBotonIT botonExaminar;
    private IUBotonIT botonEliminar;
    
    private IUPanelBD panelUsuario;
    private IUEtiqueta tituloUsuario;
    private IUEtiquetaI imagenUsuario;
    private IUBotonIT botonExaminarFoto;
    private IUBotonIT botonEliminarFoto;
    private IUPanelCT panelNombreUsuario;
    private IUPanelCT panelApellidoUsuario;
    private IUPanelCT panelCarnetIdentidadUsuario;
    private IUPanelCT panelDireccionUsuario;
    private IUPanelCT panelTelefonosUsuario;
    private IUPanelCT panelEmailUsuario;
    private IUPanelCT panelCargoUsuario;
    private IUPanelCT panelFechaContratacion;
    private IUBotonIT botonMostrarCalendario;
    
    private IUPanelCT panelUsernameUsuario;
    private IUPanelCT panelPasswordUsuario;
    
    private IUPanel panelBotones;
    private IUBotonIT botonValidacion;
    private IUBotonIT botonAtras;
    private IUBotonIT botonSiguiente;
    private IUBotonIT botonSalir;
    private IUBotonIT botonFinalizar;
    
    public IURegistroPrincipal(JFrame ventanaPrincipal, CRegistroPrincipal controlRegistroPrincipal, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);        
        this.ventanaPrincipal = ventanaPrincipal;
        this.controlRegistroPrincipal = controlRegistroPrincipal;
        this.tipoPanel = "TIENDA";
        this.tienda = null;
        this.usuario = null;
        
        construirPaneles(panelFondo.getLimitacion());
        setEventos();
    }
    private void construirPaneles(Limitacion limite){
        administrador = new CardLayout();
        panelAdministrador = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(85)));
        panelAdministrador.setLayout(administrador);
        panelFondo.add(panelAdministrador);
        construirPanelAdministrador(panelAdministrador.getLimitacion());
        
        panelBotones = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(90), limite.getAncho(), limite.getPorcentajeAlto(10)));
        panelBotones.setBackground(Color.WHITE);
        panelFondo.add(panelBotones);
        construirPanelBotones(panelBotones.getLimitacion());
    }
    private void construirPanelAdministrador(Limitacion limite){
        panelTienda = new IUPanelBD(new Limitacion(limite.getAncho(), limite.getAlto()));
        panelTienda.setColorPanel(Color.WHITE, Color.WHITE, Color.lightGray);
        panelAdministrador.add(panelTienda);
        construirPanelTienda(panelTienda.getLimitacion());
        
        panelUsuario = new IUPanelBD(new Limitacion(limite.getAncho(), limite.getAlto()));
        panelUsuario.setColorPanel(Color.WHITE, Color.WHITE, Color.lightGray);
        panelAdministrador.add(panelUsuario);
        construirPanelUsuario(panelUsuario.getLimitacion());
    }
    private void construirPanelTienda(Limitacion limite){
        
        tituloTienda = new IUEtiqueta("Registro de Datos de la TIENDA", new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        tituloTienda.setFont(new Font("Verdana", Font.PLAIN, 25));
        tituloTienda.setForeground(new Color(120, 0, 0));
        tituloTienda.setHorizontalAlignment(SwingConstants.CENTER);
        panelTienda.add(tituloTienda);
        
        nombreTienda = new IUPanelCT("nombre tienda (*)", "Abrigos Felipez", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(12), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(7)), 40, 60);
        //nombreTienda.iuTexto.setRestriccionLetras();
        panelTienda.add(nombreTienda);
        
        descripcionTienda = new IUPanelCT("descripcion tienda (*)", "ofrece a su distinguida clientela una variedad de abrigos para hombres", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(7)), 40, 60);
        panelTienda.add(descripcionTienda);
        
        direccionTienda = new IUPanelCT("direccion (*)", "pasaje aldunate entre Av. 25 de mayo y San martin", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(28), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(7)), 40, 60);
        panelTienda.add(direccionTienda);
        
        telefonosTienda = new IUPanelCT("telefonos (*)", "4502543 - 60710395", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(36), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(7)), 40, 60);        
        panelTienda.add(telefonosTienda);
        
        ciudadTienda = new IUPanelCT("ciudad (*)", "Cochabamba", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(7)), 40, 60);
        panelTienda.add(ciudadTienda);
        
        paisTienda = new IUPanelCT("pais (*)", "Bolivia", new Limitacion(limite.getPorcentajeAncho(43), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(7)), 40, 60);
        panelTienda.add(paisTienda);

        String[] monedas = Ayuda.getMonedaOficial();
        monedaOficial = new IUPanelTCB("moneda oficial (*)", monedas, new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(52), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        monedaOficial.iuTexto.setResctriccionLetras();
        panelTienda.add(monedaOficial);        
        
        unidadMoneda = new IUPanelCT("u/m (*)", "", new Limitacion(limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(52), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        unidadMoneda.iuTexto.setEditable(false);
        unidadMoneda.iuTexto.setFocusable(false);
        panelTienda.add(unidadMoneda);
        
        tipoCambio = new IUPanelCTU("cambio de Dolar (*)", "6.9", "", new Limitacion(limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(52), limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(7)), 40, 60, 40);
        tipoCambio.iuTexto.setRestriccionNumeroDecimal();
        panelTienda.add(tipoCambio);
        
        monedaOficial.iuTexto.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = monedaOficial.iuTexto.getTexto();
                switch(item){
                    case "Bolivianos":
                        unidadMoneda.iuTexto.setText("BOB.-");
                        tipoCambio.iuTexto.iuUnidad.setText("BOB");
                    break;
                    case "Dolares":
                        unidadMoneda.iuTexto.setText("$US.-");
                        tipoCambio.iuTexto.iuUnidad.setText("$US");
                    break;
                }
            }
        });
        
        etiquetaLogo = new IUEtiqueta("logo de la tienda", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(65), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(4)));
        etiquetaLogo.setForeground(new Color(120, 120, 120));
        panelTienda.add(etiquetaLogo);
        
        logo = new IUEtiquetaI("src/imagenes/logo.png", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(69), 230, 112));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setText("230 x 112 (pixeles)");
        logo.setFont(new Font("Verdana", Font.PLAIN, 20));
        panelTienda.add(logo);
        
        botonExaminar = new IUBotonIT("examinar", "src/imagenes/buscarCarpeta.png", new Limitacion(limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(4)));
        panelTienda.add(botonExaminar);
        botonExaminar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setAlwaysOnTop(false);                
                logo.setUrlImagen(Ayuda.examinarArchivo(ventanaPrincipal, "src/imagenes/logo.png"));
                setAlwaysOnTop(true);
            }
        });
        
        botonEliminar = new IUBotonIT("eliminar", "src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(58), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(4)));
        panelTienda.add(botonEliminar);
        botonEliminar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                logo.setUrlImagen("src/imagenes/logo.png");
            }
        });
    }
    private void construirPanelUsuario(Limitacion limite){
        tituloUsuario = new IUEtiqueta("Registro de Datos USUARIO ADMINISTRADOR", new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        tituloUsuario.setFont(new Font("Verdana", Font.PLAIN, 25));
        tituloUsuario.setForeground(new Color(120, 0, 0));
        tituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        panelUsuario.add(tituloUsuario);
        
        imagenUsuario = new IUEtiquetaI("src/imagenes/user.png", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(23)));
        imagenUsuario.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelUsuario.add(imagenUsuario);
        
        botonExaminarFoto = new IUBotonIT("examinar", "src/imagenes/buscarCarpeta.png", new Limitacion(limite.getPorcentajeAncho(24), limite.getPorcentajeAlto(29), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(4)));
        panelUsuario.add(botonExaminarFoto);
        botonExaminarFoto.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setAlwaysOnTop(false);                
                imagenUsuario.setUrlImagen(Ayuda.examinarArchivo(ventanaPrincipal, "src/imagenes/user.png"));                                
                setAlwaysOnTop(true);
            }
        });
        
        botonEliminarFoto = new IUBotonIT("eliminar", "src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(46), limite.getPorcentajeAlto(29), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(4)));
        panelUsuario.add(botonEliminarFoto);
        botonEliminarFoto.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imagenUsuario.setUrlImagen("src/imagenes/user.png");
            }
        });
        
        panelNombreUsuario = new IUPanelCT("nombres (*)", "rudolf", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(38), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelNombreUsuario);
        
        panelApellidoUsuario = new IUPanelCT("apellidos (*)", "felipez mancilla", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(38), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelApellidoUsuario);
        
        panelCarnetIdentidadUsuario = new IUPanelCT("carnet identidad (*)", "5233631 cbba", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelCarnetIdentidadUsuario);
        
        panelDireccionUsuario = new IUPanelCT("direccion de usuario ", "Av. Blanco Galindo km 7 B. florida norte", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(54), limite.getPorcentajeAncho(95), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelDireccionUsuario);
        
        panelTelefonosUsuario = new IUPanelCT("telefonos del usuario ", "60710395", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(62), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelTelefonosUsuario);
        
        panelEmailUsuario = new IUPanelCT("email del usuario", "rudolf.flodur@gmail.com", new Limitacion(limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(62), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelEmailUsuario);
        
        panelCargoUsuario = new IUPanelCT("cargo empleado (*)", "administrador", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(70), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelCargoUsuario);
        
        panelFechaContratacion = new IUPanelCT("fecha contratacion", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(70), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelFechaContratacion);
        
        botonMostrarCalendario = new IUBotonIT("", "src/imagenes/fecha.png", new Limitacion(limite.getPorcentajeAncho(85), limite.getPorcentajeAlto(70), limite.getPorcentajeAncho(7), limite.getPorcentajeAlto(7)));
        panelUsuario.add(botonMostrarCalendario);
        botonMostrarCalendario.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setAlwaysOnTop(false);       
                setOpacity(0.5f);
                IUCalendario iuCalendario = new IUCalendario(ventanaPrincipal, "ingresar fecha de contratacion", new Fecha(), new Limitacion(Ayuda.ancho/2, Ayuda.alto/2));
                iuCalendario.mostrarVentana();
                if(iuCalendario.getEstado()){
                    Fecha fecha = iuCalendario.getFecha();
                    panelFechaContratacion.iuTexto.setText(fecha.getFecha());
                }
                setOpacity(1f);
                setAlwaysOnTop(true);
            }
        });
        
        panelUsernameUsuario = new IUPanelCT("username (*)", "rudolf", new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(82), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelUsernameUsuario);
        
        panelPasswordUsuario = new IUPanelCT("password (*)", "rudolf", new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(90), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        panelUsuario.add(panelPasswordUsuario);
    }
    private void construirPanelBotones(Limitacion limite){
        botonSalir = new IUBotonIT("salir", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(40)));
        panelBotones.add(botonSalir);
        
        botonAtras = new IUBotonIT("atras", "src/imagenes/atras.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(40)));
        panelBotones.add(botonAtras);
        botonAtras.setVisible(false);
        
        botonValidacion = new IUBotonIT("validar", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(40)));
        panelBotones.add(botonValidacion);
        
        botonSiguiente = new IUBotonIT("siguiente", "src/imagenes/siguiente.png", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(40)));
        panelBotones.add(botonSiguiente);
        botonSiguiente.setVisible(false);
        
        botonFinalizar = new IUBotonIT("finalizar", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(40)));
        panelBotones.add(botonFinalizar);
        botonFinalizar.setVisible(false);
    }
    private void setEventos(){        
        botonSalir.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        botonSiguiente.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.next(panelAdministrador);
                botonSiguiente.setVisible(false);
                botonAtras.setVisible(true);
                botonValidacion.setVisible(true);
                tipoPanel = "USUARIO";
            }
        });
        botonAtras.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                administrador.previous(panelAdministrador);
                botonSiguiente.setVisible(false);
                botonAtras.setVisible(false);
                botonValidacion.setVisible(false);
                botonValidacion.setVisible(true);
                tipoPanel = "TIENDA";
            }
        });
        botonValidacion.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switch(tipoPanel){
                    case "TIENDA":
                        if(estaCorrectoDatosTienda()){                    
                            botonValidacion.setVisible(false);
                            botonSiguiente.setVisible(true);                    
                            llenarDatosTienda();
                        }
                    break;
                    case "USUARIO":
                        if(estaCorrectoDatosUsuario()){
                            botonValidacion.setVisible(false);
                            botonSiguiente.setVisible(false);
                            botonFinalizar.setVisible(true);
                            llenarDatosUsuario();
                        }
                    break;
                }                                
            }
        });
        botonFinalizar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {                
                if(controlRegistroPrincipal.seGuardaronDatosPrincipales(tienda, usuario)){
                    dispose();
                    FastTienda.main(null);
                }
            }
        });
    }    
    private boolean estaCorrectoDatosTienda(){
        boolean verificador = false;
        if(!nombreTienda.iuTexto.getText().isEmpty()){
            if(!descripcionTienda.iuTexto.getText().isEmpty()){
                if(!direccionTienda.iuTexto.getText().isEmpty()){
                    if(!telefonosTienda.iuTexto.getText().isEmpty()){
                        if(!ciudadTienda.iuTexto.getText().isEmpty()){
                            if(!paisTienda.iuTexto.getText().isEmpty()){
                                if(!monedaOficial.iuTexto.getSelectedItem().toString().isEmpty()){
                                    if(!unidadMoneda.iuTexto.getText().isEmpty()){
                                        if(!tipoCambio.iuTexto.getText().isEmpty()){
                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "en hora buena... los datos de la nueva tienda son correctos...\na continuacion presione el boton siguiente.", "confirmacion");
                                            verificador = true;
                                        }else            
                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo TIPO CAMBIO", "advertencia");
                                    }else            
                                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo UNIDAD MONEDAD (U/M)", "advertencia");
                                }else            
                                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo MONEDA OFICIAL", "advertencia");
                            }else            
                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo PAIS TIENDA", "advertencia");
                        }else            
                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo CIUDAD TIENDA", "advertencia");
                    }else
                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo TELEFONOS TIENDA", "advertencia");
                }else
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo DIRECCION TIENDA", "advertencia");
            }else
                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo DESCRIPCION TIENDA", "advertencia");
        }else
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo de NOMBRE TIENDA", "advertencia");
        
        return verificador;
    }
    private boolean estaCorrectoDatosUsuario(){
        boolean verificador = false;
        if(!panelNombreUsuario.iuTexto.getText().isEmpty()){            
            if(!panelApellidoUsuario.iuTexto.getText().isEmpty()){                
                if(!panelCarnetIdentidadUsuario.iuTexto.getText().isEmpty()){                    
                    if(!panelCargoUsuario.iuTexto.getText().isEmpty()){                        
                        if(!panelUsernameUsuario.iuTexto.getText().isEmpty()){                                
                            if(!panelPasswordUsuario.iuTexto.getText().isEmpty()){                                    
                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "en hora buena... los datos del nuevo usuario administrador son correctos...\na continuacion presione el boton finalizar.", "confirmacion");
                                verificador = true;
                            }else            
                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo PASSWORD", "advertencia");
                        }else            
                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo USERNAME", "advertencia");                        
                    }else
                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo CARGO USUARIO", "advertencia");
                }else
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo CARNET IDENTIDAD", "advertencia");
            }else
                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo APELLIDO USUARIO", "advertencia");
        }else
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento pero no puede estar vacio, el campo de NOMBRE USUARIO", "advertencia");
        
        return verificador;
    }
    private void llenarDatosTienda(){
        tienda = new Tienda(0);
        tienda.setNombreTienda(nombreTienda.iuTexto.getText());
        tienda.setDescripcionTienda(descripcionTienda.iuTexto.getText());
        tienda.setDireccionTienda(direccionTienda.iuTexto.getText());
        tienda.setTelefonosTienda(telefonosTienda.iuTexto.getText());
        tienda.setCiudadTienda(ciudadTienda.iuTexto.getText());
        tienda.setPaisTienda(paisTienda.iuTexto.getText());
        tienda.setCambioDolar(Double.parseDouble(tipoCambio.iuTexto.getText()));        
        tienda.setEstadoTienda("CERRADO");        
        tienda.setUrlLogo(logo.getUrlImagen());
    }
    private void llenarDatosUsuario(){
        Persona persona = new Persona(0);
        persona.setNombres(panelNombreUsuario.iuTexto.getText());
        persona.setApellidos(panelApellidoUsuario.iuTexto.getText());
        persona.setCarnetIdentidad(panelCarnetIdentidadUsuario.iuTexto.getText());
        persona.setDireccion(panelDireccionUsuario.iuTexto.getText());
        persona.setTelefonos(panelTelefonosUsuario.iuTexto.getText());
        persona.setEmail(panelEmailUsuario.iuTexto.getText());
        persona.setUrlFoto(imagenUsuario.getUrlImagen());
        
        Empleado empleado = new Empleado(0);
        empleado.setCargoEmpleado(panelCargoUsuario.iuTexto.getText());
        empleado.setFechaContratacion(panelFechaContratacion.iuTexto.getText());
        empleado.setEstado("activo");
        empleado.setPersonaID(0);
        empleado.setPersona(persona);
        
        usuario = new Usuario(0);        
        usuario.setUsername(panelUsernameUsuario.iuTexto.getText());
        usuario.setPassword(panelPasswordUsuario.iuTexto.getText());
        usuario.setEmpleadoID(0);        
        usuario.setPersonaID(0);
        usuario.setEmpleado(empleado);
        
    }
}
