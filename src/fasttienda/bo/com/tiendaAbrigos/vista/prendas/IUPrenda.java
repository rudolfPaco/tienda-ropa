/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.prendas;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelCTU;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrenda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUPrenda extends IUVentanaT{
    
    private IUPrincipal ventanaPrincipal;
    
    private IUPanel primerPanel;
    private IUPanel primerTituloPanel;
    private IUEtiqueta primerEtiquetaTitulo;
    private CardLayout primerAdministradora;
    private IUPanel primerContenedorModelos;
    private IUPanelBD primerControlPaneles;
    private IUEtiquetaI iconoAtrasModelo;
    private IUEtiqueta indicePanelesModelo;
    private IUEtiquetaI iconoAdelanteModelo;
    
    private IUPanel segundoPanel;
    private IUPanel segundoTituloPanel;
    
    private IUEtiqueta segundoEtiquetaTitulo;
    private CardLayout administradorPrendas;
    private IUPanel segundoPanelPrenda;
    private IUPanelBD controlPanelesPrendas;
    private IUEtiquetaI iconoAtrasPrenda;
    private IUEtiqueta indicePanelesPrenda;
    private IUEtiquetaI iconoAdelantePrenda;
    
    private IUPanel tercerPanel;
    private IUPanel tercerTituloPanel;    
    private IUEtiqueta tercerEtiquetaTitulo;
    private IUPanelBD tercerPanelPrenda;
    private IUEtiquetaI imagenPrenda;    
    private IUEtiquetaI codigoImagen;
    private IUEtiqueta codigo;
    private IUPanelCT categoria;
    private IUPanelCT marca;
    private IUPanelCT color;
    private IUPanelCT talla;
    private IUPanelCTU precioOficial;
    private IUPanelCTU cantidadMinima;
    private IUPanelCTU stock;
    private IUPanelCT ubicacion;
    private IUBotonIT botonImprimir;
    
    private IUPanelBD cuartoPanel;
    private IUBotonIT nuevaPrenda;
    private IUBotonIT botonEliminar;
    private IUBotonIT botonModificar;
    private IUBotonIT botonSalir;
    
    private boolean estado;
    private int numeroPanelModelo;
    private int cantidadPanelesModelo;
    private int numeroPanelPrenda;
    private int cantidadPanelesPrenda;
    
    private ArrayList<IUPanelBotonModelo> listaModelos;
    private ArrayList<IUPanelBotonPrenda> listaPrendas;
    private CPrenda controlPrenda;
    private Modelo modelo;
    private Prenda prenda;
    
    public IUPrenda(IUPrincipal ventanaPrincipal, CPrenda controlPrenda, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.ventanaPrincipal = ventanaPrincipal;
        this.controlPrenda = controlPrenda;
        this.estado = false;
        this.listaModelos = new ArrayList<>();
        this.listaPrendas = new ArrayList<>();
        this.numeroPanelModelo = 1;
        this.numeroPanelPrenda = 1;
        this.cantidadPanelesModelo = 0;
        this.modelo = null;
        this.prenda = null;
        
        construirPaneles(panelFondo.getLimitacion());
        setEventos();
        actualizarListaModelos(controlPrenda.listarTodosModelos());
    }
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(90)));
        panelFondo.add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(35), 0, limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(90)));
        panelFondo.add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(55), 0, limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(90)));
        panelFondo.add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
        
        cuartoPanel = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(90), limite.getAncho(), limite.getPorcentajeAlto(10)));
        panelFondo.add(cuartoPanel);
        construirCuartoPanel(cuartoPanel.getLimitacion());
    }
    
    private void construirPrimerPanel(Limitacion limite){
        primerTituloPanel = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));        
        primerPanel.add(primerTituloPanel);
        construirPrimerTituloPanel(primerTituloPanel.getLimitacion());
        
        primerAdministradora = new CardLayout();
        primerContenedorModelos = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(10), limite.getAncho(), limite.getPorcentajeAlto(83)));
        primerContenedorModelos.setLayout(primerAdministradora);
        primerPanel.add(primerContenedorModelos);
        
        primerControlPaneles = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(93), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(7)));
        primerPanel.add(primerControlPaneles);
        construirPrimerControlPaneles(primerControlPaneles.getLimitacion());
    }
    private void construirPrimerTituloPanel(Limitacion limite){
        primerEtiquetaTitulo = new IUEtiqueta("Lista de Modelos Registrados", new Limitacion(0, limite.getPorcentajeAlto(25), limite.getAncho(), limite.getPorcentajeAlto(50)));
        primerEtiquetaTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));
        primerEtiquetaTitulo.setForeground(new Color(120, 0, 0));
        primerEtiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        primerTituloPanel.add(primerEtiquetaTitulo);
    }
    private void construirPrimerControlPaneles(Limitacion limite){
        iconoAtrasModelo = new IUEtiquetaI("src/imagenes/izquierda.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iconoAtrasModelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        primerControlPaneles.add(iconoAtrasModelo);
        
        indicePanelesModelo = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(60)));
        indicePanelesModelo.setHorizontalAlignment(SwingConstants.CENTER);
        indicePanelesModelo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));        
        primerControlPaneles.add(indicePanelesModelo);
        
        iconoAdelanteModelo = new IUEtiquetaI("src/imagenes/derecha.png", new Limitacion(limite.getPorcentajeAncho(91), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iconoAdelanteModelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        primerControlPaneles.add(iconoAdelanteModelo);
    }
    
    private void construirSegundoPanel(Limitacion limite){
        segundoTituloPanel = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        segundoPanel.add(segundoTituloPanel);
        construirSegundoTituloPanel(segundoTituloPanel.getLimitacion());
        
        administradorPrendas = new CardLayout();
        segundoPanelPrenda = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(10), limite.getAncho(), limite.getPorcentajeAlto(83)));
        segundoPanelPrenda.setLayout(administradorPrendas);
        segundoPanel.add(segundoPanelPrenda);
        
        controlPanelesPrendas = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(93), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(7)));
        segundoPanel.add(controlPanelesPrendas);
        construirSegundoControlPaneles(controlPanelesPrendas.getLimitacion());
    }
    private void construirSegundoTituloPanel(Limitacion limite){
        segundoEtiquetaTitulo = new IUEtiqueta("Prendas del Modelo", new Limitacion(0, limite.getPorcentajeAlto(25), limite.getAncho(), limite.getPorcentajeAlto(50)));
        segundoEtiquetaTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));
        segundoEtiquetaTitulo.setForeground(new Color(120, 0, 0));
        segundoEtiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        segundoTituloPanel.add(segundoEtiquetaTitulo);
    }
    private void construirSegundoControlPaneles(Limitacion limite){
        iconoAtrasPrenda = new IUEtiquetaI("src/imagenes/izquierda.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(90)));
        iconoAtrasPrenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAtrasPrenda.setVisible(false);
        controlPanelesPrendas.add(iconoAtrasPrenda);
        
        indicePanelesPrenda = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(60)));
        indicePanelesPrenda.setHorizontalAlignment(SwingConstants.CENTER);
        indicePanelesPrenda.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));        
        controlPanelesPrendas.add(indicePanelesPrenda);
        
        iconoAdelantePrenda = new IUEtiquetaI("src/imagenes/derecha.png", new Limitacion(limite.getPorcentajeAncho(86), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(90)));
        iconoAdelantePrenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAdelantePrenda.setVisible(false);
        controlPanelesPrendas.add(iconoAdelantePrenda);
    }
    
    private void construirTercerPanel(Limitacion limite){
        tercerTituloPanel = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        tercerPanel.add(tercerTituloPanel);
        construirTercerTituloPanel(tercerTituloPanel.getLimitacion());
        
        tercerPanelPrenda = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(10), limite.getAncho(), limite.getPorcentajeAlto(90)));
        tercerPanel.add(tercerPanelPrenda);
        construirTercerPanelPrenda(tercerPanelPrenda.getLimitacion());
    }
    private void construirTercerTituloPanel(Limitacion limite){
        tercerEtiquetaTitulo = new IUEtiqueta("Vista de la Prenda", new Limitacion(0, limite.getPorcentajeAlto(25), limite.getAncho(), limite.getPorcentajeAlto(50)));
        tercerEtiquetaTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));
        tercerEtiquetaTitulo.setForeground(new Color(120, 0, 0));
        tercerEtiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        tercerTituloPanel.add(tercerEtiquetaTitulo);
    }
    private void construirTercerPanelPrenda(Limitacion limite){
        imagenPrenda = new IUEtiquetaI("src/imagenes/agregarImagen.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(70)));
        tercerPanelPrenda.add(imagenPrenda);
        
        codigoImagen = new IUEtiquetaI("src/imagenes/logoVacio.png", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(10)));
        tercerPanelPrenda.add(codigoImagen);
        
        codigo = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(11), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(3)));
        codigo.setHorizontalAlignment(SwingConstants.CENTER);
        //codigo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        tercerPanelPrenda.add(codigo);
        
        categoria = new IUPanelCT("categoria", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(16), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        categoria.iuTexto.setBorder(null);
        categoria.iuTexto.setEditable(false);
        tercerPanelPrenda.add(categoria);
        
        marca = new IUPanelCT("marca", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        marca.iuTexto.setBorder(null);
        marca.iuTexto.setEditable(false);
        tercerPanelPrenda.add(marca);
        
        color = new IUPanelCT("color", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(34), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        color.iuTexto.setBorder(null);
        color.iuTexto.setEditable(false);
        tercerPanelPrenda.add(color);
        
        talla = new IUPanelCT("talla", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(43), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        talla.iuTexto.setBorder(null);
        talla.iuTexto.setEditable(false);
        tercerPanelPrenda.add(talla);
        
        precioOficial = new IUPanelCTU("precio Oficial", "", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(52), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 40);
        precioOficial.iuTexto.setBorder(null);
        precioOficial.iuTexto.setEditable(false);
        tercerPanelPrenda.add(precioOficial);
        
        cantidadMinima = new IUPanelCTU("cant. minima", "", "uddes.", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(61), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 60);
        cantidadMinima.iuTexto.setBorder(null);
        cantidadMinima.iuTexto.setEditable(false);
        tercerPanelPrenda.add(cantidadMinima);
        
        stock = new IUPanelCTU("stock actual", "", "uddes.", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(71), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 50);
        stock.iuTexto.setBorder(null);
        stock.iuTexto.setEditable(false);
        tercerPanelPrenda.add(stock);
        
        ubicacion = new IUPanelCT("ubicacion", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(81), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        ubicacion.iuTexto.setBorder(null);
        ubicacion.iuTexto.setEditable(false);
        tercerPanelPrenda.add(ubicacion);
        
        botonImprimir = new IUBotonIT("imprimir codigo", "src/imagenes/impresoraAzul.png", new Limitacion(limite.getPorcentajeAncho(68), limite.getPorcentajeAlto(78), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)));
        tercerPanelPrenda.add(botonImprimir);
        botonImprimir.setVisible(false);
    }
    
    private void construirCuartoPanel(Limitacion limite){        
        nuevaPrenda = new IUBotonIT("NUEVA PRENDA", "src/imagenes/compras.png", new Limitacion(limite.getPorcentajeAncho(85), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        nuevaPrenda.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        cuartoPanel.add(nuevaPrenda);
        
        botonModificar = new IUBotonIT("MODIFICAR PRENDA", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonModificar.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        cuartoPanel.add(botonModificar);
        
        botonEliminar = new IUBotonIT("ELIMINAR PRENDA", "src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonEliminar.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));
        cuartoPanel.add(botonEliminar);
        
        botonSalir = new IUBotonIT("SALIR CRUD", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonSalir.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        cuartoPanel.add(botonSalir);
    }
    private void setEventos(){        
        
        nuevaPrenda.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                crearNuevaPrenda();
            }
        });   
        botonSalir.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        botonEliminar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eliminarPrenda();
            }
        });
        botonModificar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                modificarPrenda();                    
            }
        });
        iconoAtrasModelo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelModelo > 1){
                    primerAdministradora.previous(primerContenedorModelos);
                    numeroPanelModelo--;
                    indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
                }
            }
        });
        iconoAdelanteModelo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelModelo > 0 && numeroPanelModelo < cantidadPanelesModelo){
                    primerAdministradora.next(primerContenedorModelos);
                    numeroPanelModelo++;
                    indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
                }
            }
        });
        iconoAtrasPrenda.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelPrenda > 1){
                    administradorPrendas.previous(segundoPanelPrenda);
                    numeroPanelPrenda--;
                    indicePanelesPrenda.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
                }
            }
        });
        iconoAdelantePrenda.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelPrenda > 0 && numeroPanelPrenda < cantidadPanelesPrenda){
                    administradorPrendas.next(segundoPanelPrenda);
                    numeroPanelPrenda++;
                    indicePanelesPrenda.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
                }
            }
        });
    }
    private void actualizarListaModelos(ArrayList<Modelo> lista){
        int numeroElementos = lista.size();
        int limite = 4;
        cantidadPanelesModelo = Ayuda.getCantidadPaneles(numeroElementos, limite);
        int indice = 0;
        
        indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
        if(cantidadPanelesModelo < 2){
            iconoAtrasModelo.setVisible(false);
            iconoAdelanteModelo.setVisible(false);
        }else{
            iconoAtrasModelo.setVisible(true);
            iconoAdelanteModelo.setVisible(true);
        }
        
        listaModelos.clear();
        primerContenedorModelos.removeAll();
        primerContenedorModelos.updateUI();
                        
        for (int i = 0; i < cantidadPanelesModelo; i++) {
            IUPanel panelModelos = new IUPanel(new Limitacion(primerContenedorModelos.getLimitacion().getAncho(), primerContenedorModelos.getLimitacion().getAlto()));
            primerContenedorModelos.add(panelModelos);
            
            int ancho = panelModelos.getLimitacion().getAncho() - limite;
            int alto = (panelModelos.getLimitacion().getAlto() - 10)/limite;
            
            for(int j = 0; j < limite; j++){
                if(indice < numeroElementos){
                    IUPanelBotonModelo elemento = new IUPanelBotonModelo(new Limitacion(2, j*2 + j + j*alto, ancho, alto), lista.get(indice));
                    listaModelos.add(elemento);
                    panelModelos.add(elemento);  
                    elemento.addEventoRaton(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            elemento.setColorPanel(new Color(255, 255, 125), Color.WHITE, new Color(221, 221, 0));                            
                            despintarBoton(elemento);
                            modelo = elemento.getModelo();
                            actualizarListaPrendas(modelo);
                            limpiarDatosPrenda();                            
                        }
                    });
                }
                indice++;
            }
        }
    }
    public boolean getEstado(){
        return estado;
    }
    private void despintarBoton(IUPanelBotonModelo boton){
        for (int i = 0; i < listaModelos.size(); i++) {
            if(!boton.equals(listaModelos.get(i)))
                listaModelos.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));
        }
    }
    private void despintarBotonPrenda(IUPanelBotonPrenda boton){
        for (int i = 0; i < listaPrendas.size(); i++) {
            if(!boton.equals(listaPrendas.get(i)))
                listaPrendas.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));
        }
    }
    private void crearNuevaPrenda(){
        if(modelo == null){
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "debe elegir un modelo para crear  una nueva prenda...", "advertencia");
        }else{
            setOpacity(0.5f);
            IUNuevaPrenda iuNuevaPrenda = new IUNuevaPrenda(ventanaPrincipal, modelo, "registrar nueva prenda", new Limitacion(Ayuda.ancho/2, Ayuda.alto - Ayuda.alto/100), 5);
            iuNuevaPrenda.mostrarVentana();            
            if(iuNuevaPrenda.getEstado()){
                if(controlPrenda.guardarNuevaPrenda(iuNuevaPrenda.getPrenda(), modelo, controlPrenda.moduloPrenda.getVentanaPrincipal().getCPrincipal().getTienda().getTiendaID())){
                    if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "EN HORA BUENA... se ha guardado los datos de la prenda y el kardex como INVENTARIO INICIAL correctamente...!", "correcto")){
                        actualizarListaPrendas(modelo);
                        limpiarDatosPrenda();
                    }                    
                }
            }
            setOpacity(1f);
        }        
    }
    private void modificarPrenda(){
        if(prenda == null){
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "debe elegir una prenda del modelo para poder modificar la prenda...", "advertencia");
        }else{
            setOpacity(0.5f);
            IUModificarPrenda iuModificarPrenda = new IUModificarPrenda(ventanaPrincipal, modelo, prenda, "modificar los datos de la prenda", new Limitacion(Ayuda.ancho/2, Ayuda.alto - Ayuda.alto/100), 5);
            iuModificarPrenda.mostrarVentana();            
            if(iuModificarPrenda.getEstado()){
                if(controlPrenda.modificarPrenda(iuModificarPrenda.getPrenda())){
                    if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "EN HORA BUENA... se ha modificado la prenda correctamente...!", "correcto")){
                        actualizarListaPrendas(modelo);
                        limpiarDatosPrenda();
                    }                    
                }else{
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "peligro", "Existe un error al modificar la prenda...!", "error");
                }
            }
            setOpacity(1f);
        }
    }
    private void eliminarPrenda(){
        if(prenda == null){
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "debe elegir una prenda del modelo para poder eliminar la prenda...", "advertencia");
        }else{
            setOpacity(0.5f);
            /*IUModificarPrenda iuModificarPrenda = new IUModificarPrenda(ventanaPrincipal, modelo, prenda, "modificar los datos de la prenda", new Limitacion(Ayuda.ancho/2, Ayuda.alto - Ayuda.alto/100), 5);
            iuModificarPrenda.mostrarVentana();            
            if(iuModificarPrenda.getEstado()){
                if(controlPrenda.modificarPrenda(iuModificarPrenda.getPrenda())){
                    if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "EN HORA BUENA... se ha modificado la prenda correctamente...!", "correcto")){
                        actualizarListaPrendas(modelo);
                        limpiarDatosPrenda();
                    }                    
                }else{
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "peligro", "Existe un error al modificar la prenda...!", "error");
                }
            }*/
            setOpacity(1f);
        }
        /*if(prenda = null){            
            if(prenda.tienePrendasCreadas()){
                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "este modelo: "+modeloID+" tiene al menos una prenda creada en base al modelo\npor esta rezon NO PUEDE SER ELIMINADO", "advertencia");                
            }else{
                if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "peligro", "esta seguro que desea eliminar el modelo: \nID: "+modeloID+"\ncategoria: "+modelo.getCategoria()+"\nmarca: "+modelo.getMarca()+"\ndetalle: "+modelo.getDetalle(), "peligro")){
                    if(modelo.seElimino()){
                        if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "informacion", "en hora buena... se ELIMNO CORRECTAMENTE EL MODELO...!", "correcto")){
                            limpiarCampoDatos();
                            actualizarListaModelos(controlPrenda.listarTodosModelos());
                        }
                    }
                }
            }
        }else{
            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento.... debe seleccionar un modelo por favor...!", "aviso");
        }*/
    }
    private void actualizarListaPrendas(Modelo modelo){
        ArrayList<Prenda> lista = controlPrenda.listarTodasPrendas(modelo);
        int numeroElementos = lista.size();
        int limite = 8;
        cantidadPanelesPrenda = Ayuda.getCantidadPaneles(numeroElementos, limite);
        int indice = 0;
        
        indicePanelesPrenda.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
        if(cantidadPanelesPrenda > 1){
            iconoAtrasPrenda.setVisible(true);
            iconoAdelantePrenda.setVisible(true);
        }else{
            indicePanelesPrenda.setText("");
            iconoAtrasPrenda.setVisible(false);
            iconoAdelantePrenda.setVisible(false);
        }
        
        this.listaPrendas.clear();
        segundoPanelPrenda.removeAll();
        segundoPanelPrenda.updateUI();
                        
        for (int i = 0; i < cantidadPanelesPrenda; i++) {
            IUPanel panelPrenda = new IUPanel(new Limitacion(segundoPanelPrenda.getLimitacion().getAncho(), segundoPanelPrenda.getLimitacion().getAlto()));
            segundoPanelPrenda.add(panelPrenda);
            
            int ancho = panelPrenda.getLimitacion().getAncho() - limite;
            int alto = (panelPrenda.getLimitacion().getAlto() - 10)/limite;
            
            for(int j = 0; j < limite; j++){
                if(indice < numeroElementos){
                    Prenda prendaBoton = lista.get(indice);
                    if(prendaBoton != null){
                        IUPanelBotonPrenda elemento = new IUPanelBotonPrenda(new Limitacion(2, j*2 + j + j*alto, ancho, alto), prendaBoton);
                        listaPrendas.add(elemento);
                        panelPrenda.add(elemento);  
                        elemento.addEventoRaton(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                elemento.setColorPanel(new Color(255, 255, 125), Color.WHITE, new Color(221, 221, 0));                            
                                despintarBotonPrenda(elemento);                                
                                mostrarPrenda(prendaBoton);
                                prenda = prendaBoton;
                            }
                        });
                    }                    
                }
                indice++;
            }
        }
    }
    private void mostrarPrenda(Prenda p){
        imagenPrenda.setUrlImagen(p.getUrlPrenda());
        Ayuda.getCodigoBarra(p.getCodigo(), "src/imagenes/codigoBarra.png", codigoImagen.getLimitacion());
        codigoImagen.setUrlImagen("src/imagenes/codigoBarra.png");
        codigo.setText(p.getCodigo());
        categoria.iuTexto.setText(p.getCategoria());
        marca.iuTexto.setText(p.getMarca());
        color.iuTexto.setText(p.getColor());
        talla.iuTexto.setText(p.getTalla());
        precioOficial.iuTexto.setText(String.valueOf(p.getPrecio()));
        precioOficial.iuTexto.iuUnidad.setText(modelo.getUnidades().get(0).getUnidadMedida());
        cantidadMinima.iuTexto.setText(String.valueOf(p.getCantidadMinima()));
        stock.iuTexto.setText(String.valueOf(p.getCantidadEntrante()));
        ubicacion.iuTexto.setText(p.getUbicacion());        
        botonImprimir.setVisible(true);
        if(p.getCantidadEntrante() < 1)
            stock.iuTexto.setForeground(new Color(120, 0, 0));
        else 
            stock.iuTexto.setForeground(new Color(2, 67, 109));
    }   
    private void limpiarDatosPrenda(){
        prenda = null;
        imagenPrenda.setUrlImagen("src/imagenes/agregarImagen.png");        
        codigoImagen.setUrlImagen("src/imagenes/logoVacio.png");
        codigo.setText("");
        categoria.iuTexto.setText("");
        marca.iuTexto.setText("");
        color.iuTexto.setText("");
        talla.iuTexto.setText("");
        precioOficial.iuTexto.setText("");
        precioOficial.iuTexto.iuUnidad.setText("");
        cantidadMinima.iuTexto.setText("");
        ubicacion.iuTexto.setText("");
        botonImprimir.setVisible(false);
    }
}