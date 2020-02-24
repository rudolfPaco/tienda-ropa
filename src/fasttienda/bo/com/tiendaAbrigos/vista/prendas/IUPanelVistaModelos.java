/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.prendas;

import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelCTU;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrenda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
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
 * @author rudolf
 */
public class IUPanelVistaModelos extends IUPanel{
    
    private CPrenda controlPrenda;
    
    private IUPanel primerPanel;
    private CardLayout administradorPrendas;
    private IUPanelBD panelMostrarPrenda;    
    private IUEtiquetaI iuImagen;
    private IUEtiquetaI iuCodigo;
    private IUPanelCT iuCategoria;
    private IUPanelCT iuMarca;
    private IUPanelCT iuColor;
    private IUPanelCT iuTalla;
    private IUPanelCTU iuPrecio;
    private IUPanelCTU iuCantidadStock;
    private IUPanelCT iuUbicacion;
    
    private IUEtiqueta botonAtras;
    private IUEtiqueta botonAdelante;
    
    private IUPanel panelContenedoresPrendas;
    private IUPanelBD panelControlPrendas;
    private IUEtiquetaI iconoAtrasModelo;
    private IUEtiqueta indicePanelesModelo;
    private IUEtiquetaI iconoAdelanteModelo;
    
    private IUPanel segundoPanel;
    private IUPanelBD panelBusqueda;
    private IUPanelCT buscarModelo;
    private IUEtiquetaI iconoBuscar;
    private IUEtiquetaI iconoLimpiar;
    private IUEtiqueta tituloModelo;
    private CardLayout administradorModelos;
    private IUPanel panelContenedorModelos;
    private IUPanelBD panelBotonesModelo;
    private IUEtiquetaI iconoAtrasPrendas;
    private IUEtiqueta indicePanelesPrendas;
    private IUEtiquetaI iconoAdelantePrendas;
    
    private int numeroPanelModelo;
    private int cantidadPanelesModelo;
    private Modelo modelo;
    private int numeroPanelPrenda;
    private int cantidadPanelesPrenda; 
    
    private ArrayList<IUPanelBotonModelo> listaModelos;
    private ArrayList<IUPanelBotonPrenda> listaPrendas;
    
    public IUPanelVistaModelos(CPrenda controlPrenda, Limitacion limitacion) {
        super(limitacion);
        this.controlPrenda = controlPrenda;
        this.listaModelos = new ArrayList<>();
        this.listaPrendas = new ArrayList<>();
        this.numeroPanelModelo = 1;
        this.numeroPanelPrenda = 1;
        this.cantidadPanelesModelo = 0;
        this.cantidadPanelesPrenda = 0;
        this.modelo = null;
        
        construirPaneles(getLimitacion());
        actualizarListaModelos(controlPrenda.listarTodosModelos());
        setEventos();
    }    
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(65), limite.getAlto()));
        add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(65), 0, limite.getPorcentajeAncho(35), limite.getAlto()));
        add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
    }    
    private void construirPrimerPanel(Limitacion limite){
        botonAtras = new IUEtiqueta("◄", new Limitacion(limite.getPorcentajeAncho(4), limite.getPorcentajeAlto(68)));
        botonAtras.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(4)));
        botonAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //primerPanel.add(botonAtras);
        
        
        panelMostrarPrenda = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(4), 0, limite.getPorcentajeAncho(92), limite.getPorcentajeAlto(68)));        
        primerPanel.add(panelMostrarPrenda);
        construirPanelAdministradorPrendas(panelMostrarPrenda.getLimitacion());
        
        botonAdelante = new IUEtiqueta("►", new Limitacion(limite.getPorcentajeAncho(96), 0, limite.getPorcentajeAncho(4), limite.getPorcentajeAlto(68)));
        botonAdelante.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(4)));
        botonAdelante.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //primerPanel.add(botonAdelante);
        
        administradorPrendas = new CardLayout();
        panelContenedoresPrendas = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(68), limite.getAncho(), limite.getPorcentajeAlto(25)));
        panelContenedoresPrendas.setLayout(administradorPrendas);
        primerPanel.add(panelContenedoresPrendas);
        
        panelControlPrendas = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(93), limite.getAncho(), limite.getPorcentajeAlto(7)));
        primerPanel.add(panelControlPrendas);
        construirControlPrendas(panelControlPrendas.getLimitacion());
    }
    private void construirPanelAdministradorPrendas(Limitacion limite){
        iuImagen = new IUEtiquetaI("src/imagenes/agregarImagen.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(98)));
        panelMostrarPrenda.add(iuImagen);
        
        iuCodigo = new IUEtiquetaI("", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(15)));        
        panelMostrarPrenda.add(iuCodigo);
        
        iuCategoria = new IUPanelCT("categoria", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(17), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(10)), 40, 60);
        iuCategoria.iuTexto.setEditable(false);
        iuCategoria.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuCategoria);
        
        iuMarca = new IUPanelCT("marca", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(28), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(10)), 40, 60);
        iuMarca.iuTexto.setEditable(false);
        iuMarca.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuMarca);
        
        iuColor = new IUPanelCT("color", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(39), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(10)), 40, 60);
        iuColor.iuTexto.setEditable(false);
        iuColor.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuColor);
        
        iuTalla = new IUPanelCT("talla", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(10)), 40, 60);
        iuTalla.iuTexto.setEditable(false);
        iuTalla.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuTalla);
        
        iuPrecio = new IUPanelCTU("precio", "", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(61), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(10)), 40, 60, 50);
        iuPrecio.iuTexto.setEditable(false);
        iuPrecio.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuPrecio);
        
        iuCantidadStock = new IUPanelCTU("stock actual", "", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(72), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(10)), 40, 60, 50);
        iuCantidadStock.iuTexto.setEditable(false);
        iuCantidadStock.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuCantidadStock);
        
        iuUbicacion = new IUPanelCT("ubicacion", "", new Limitacion(limite.getPorcentajeAncho(62), limite.getPorcentajeAlto(83), limite.getPorcentajeAncho(38), limite.getPorcentajeAlto(10)), 40, 60);
        iuUbicacion.iuTexto.setEditable(false);
        iuUbicacion.iuTexto.setFocusable(false);
        panelMostrarPrenda.add(iuUbicacion);
    }
    private void construirControlPrendas(Limitacion limite){
        iconoAtrasPrendas = new IUEtiquetaI("src/imagenes/izquierda.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(90)));
        iconoAtrasPrendas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAtrasPrendas.setVisible(false);
        panelControlPrendas.add(iconoAtrasPrendas);
        
        indicePanelesPrendas = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(60)));
        indicePanelesPrendas.setHorizontalAlignment(SwingConstants.CENTER);
        indicePanelesPrendas.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));        
        panelControlPrendas.add(indicePanelesPrendas);
        
        iconoAdelantePrendas = new IUEtiquetaI("src/imagenes/derecha.png", new Limitacion(limite.getPorcentajeAncho(94), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(90)));
        iconoAdelantePrendas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAdelantePrendas.setVisible(false);
        panelControlPrendas.add(iconoAdelantePrendas);
    }
    private void construirSegundoPanel(Limitacion limite){
        panelBusqueda = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(8)));
        segundoPanel.add(panelBusqueda);
        construirPanelBusqueda(panelBusqueda.getLimitacion());
        
        tituloModelo = new IUEtiqueta("MODELOS ENCONTRADOS", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(4)));
        tituloModelo.setHorizontalAlignment(SwingConstants.CENTER);
        tituloModelo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(3)));
        segundoPanel.add(tituloModelo);
        
        administradorModelos = new CardLayout();
        panelContenedorModelos = new IUPanel(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(14), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(79)));
        panelContenedorModelos.setLayout(administradorModelos);
        segundoPanel.add(panelContenedorModelos);
        
        panelBotonesModelo = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(93), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(7)));
        segundoPanel.add(panelBotonesModelo);
        construirPanelBotonesModelo(panelBotonesModelo.getLimitacion());
    }
    public void actualizarListaModelos(ArrayList<Modelo> lista){
        int numeroElementos = lista.size();
        int limite = 4;
        cantidadPanelesModelo = Ayuda.getCantidadPaneles(numeroElementos, limite);
        int indice = 0;        
        if(cantidadPanelesModelo < 2){
            iconoAtrasModelo.setVisible(false);
            iconoAdelanteModelo.setVisible(false);
            indicePanelesModelo.setText("");
        }else{
            iconoAtrasModelo.setVisible(true);
            iconoAdelanteModelo.setVisible(true);
            indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
        }
        
        listaModelos.clear();    
        panelContenedorModelos.removeAll();
        panelContenedorModelos.updateUI();
        
        for (int i = 0; i < cantidadPanelesModelo; i++) {
            IUPanel panelModelos = new IUPanel(new Limitacion(panelContenedorModelos.getLimitacion().getAncho(), panelContenedorModelos.getLimitacion().getAlto()));
            panelContenedorModelos.add(panelModelos);
            
            int ancho = panelModelos.getLimitacion().getAncho() - limite;
            int alto = (panelModelos.getLimitacion().getAlto() - 10)/limite;
            
            for(int j = 0; j < limite; j++){
                if(indice < numeroElementos){
                    Modelo modelo = lista.get(indice);
                    IUPanelBotonModelo elemento = new IUPanelBotonModelo(new Limitacion(2, j*2 + j + j*alto, ancho, alto), modelo);
                    listaModelos.add(elemento);
                    panelModelos.add(elemento);
                    elemento.addEventoRaton(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {                            
                            elemento.setColorPanel(new Color(255, 255, 125), Color.WHITE, new Color(221, 221, 0));
                            despintarBoton(elemento);
                            actualizarListaPrendas(modelo);     
                            limpiarDatosPrenda();
                        }
                    });
                }
                indice++;
            }
        }        
    }
    private void actualizarListaPrendas(Modelo modeloPrenda){
        this.listaPrendas.clear();
        panelContenedoresPrendas.removeAll();
        panelContenedoresPrendas.updateUI();
        
        ArrayList<Prenda> lista = controlPrenda.listarTodasPrendas(modeloPrenda);
        int numeroElementos = lista.size();
        int limite = 9;
        
        int numeroColumnas = 3;
        int numeroFilas = 3;
        cantidadPanelesPrenda = Ayuda.getCantidadPaneles(numeroElementos, limite);        
        int indice = 0;
        
        indicePanelesPrendas.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
        if(cantidadPanelesPrenda > 1){
            iconoAtrasPrendas.setVisible(true);
            iconoAdelantePrendas.setVisible(true);
        }else{
            indicePanelesPrendas.setText("");
            iconoAtrasPrendas.setVisible(false);
            iconoAdelantePrendas.setVisible(false);
        }
                        
        for (int i = 0; i < cantidadPanelesPrenda; i++) {
            IUPanel panelPrenda = new IUPanel(new Limitacion(panelContenedoresPrendas.getLimitacion().getAncho(), panelContenedoresPrendas.getLimitacion().getAlto()));
            panelContenedoresPrendas.add(panelPrenda);
            
            int ancho = (panelPrenda.getLimitacion().getAncho() - (numeroColumnas*2 + 2))/numeroColumnas;
            int alto = (panelPrenda.getLimitacion().getAlto() - numeroFilas*2)/numeroFilas;
            
            for(int filas = 0; filas < numeroFilas; filas++){
                for (int columnas = 0; columnas < numeroColumnas; columnas++) {
                    if(indice < numeroElementos){
                        Prenda prendaBoton = lista.get(indice);
                        if(prendaBoton != null){

                            IUPanelBotonPrenda elemento = new IUPanelBotonPrenda(new Limitacion(columnas*2 + 2 + columnas*ancho, filas*2 + 2 + filas*alto, ancho, alto), prendaBoton);
                            listaPrendas.add(elemento);
                            panelPrenda.add(elemento);  
                            elemento.addEventoRaton(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {
                                    elemento.setColorPanel(new Color(255, 255, 125), Color.WHITE, new Color(221, 221, 0));                                    
                                    elemento.cambiarColorMarcaTalla(new Color(120, 0, 0));
                                    despintarBotonPrenda(elemento);                                    
                                    mostrarPrenda(prendaBoton);
                                }
                            });
                            indice++;
                        }                    
                    }                    
                }                
            }
        }
    }
    private void construirPanelBusqueda(Limitacion limite){
        buscarModelo = new IUPanelCT("buscar modelo por su caracteristica", "", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(70)), 40, 60);
        buscarModelo.iuTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        buscarModelo.iuTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
        panelBusqueda.add(buscarModelo);
        
        iconoBuscar = new IUEtiquetaI("src/imagenes/buscar.png", new Limitacion(limite.getPorcentajeAncho(72), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(70)));
        iconoBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelBusqueda.add(iconoBuscar);
        
        iconoLimpiar = new IUEtiquetaI("src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(84), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(70)));
        iconoLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelBusqueda.add(iconoLimpiar);
    }
    private void construirPanelBotonesModelo(Limitacion limite){
        iconoAtrasModelo = new IUEtiquetaI("src/imagenes/izquierda.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(90)));
        iconoAtrasModelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAtrasModelo.setVisible(false);        
        panelBotonesModelo.add(iconoAtrasModelo);
        
        indicePanelesModelo = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(60)));
        indicePanelesModelo.setHorizontalAlignment(SwingConstants.CENTER);
        indicePanelesModelo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));        
        panelBotonesModelo.add(indicePanelesModelo);
        
        iconoAdelanteModelo = new IUEtiquetaI("src/imagenes/derecha.png", new Limitacion(limite.getPorcentajeAncho(89), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(90)));
        iconoAdelanteModelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconoAdelanteModelo.setVisible(false);
        panelBotonesModelo.add(iconoAdelanteModelo);
    }
    private void setEventos(){
        iconoAtrasModelo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelModelo > 1){
                    administradorModelos.previous(panelContenedorModelos);
                    numeroPanelModelo--;
                    indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
                }
            }
        });
        iconoAdelanteModelo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelModelo > 0 && numeroPanelModelo < cantidadPanelesModelo){
                    administradorModelos.next(panelContenedorModelos);
                    numeroPanelModelo++;
                    indicePanelesModelo.setText(numeroPanelModelo+"/"+cantidadPanelesModelo);
                }
            }
        });
        
        iconoAtrasPrendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelPrenda > 1){
                    administradorPrendas.previous(panelContenedoresPrendas);
                    numeroPanelPrenda--;
                    indicePanelesPrendas.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
                }
            }
        });
        iconoAdelantePrendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanelPrenda > 0 && numeroPanelPrenda < cantidadPanelesPrenda){
                    administradorPrendas.next(panelContenedoresPrendas);
                    numeroPanelPrenda++;
                    indicePanelesPrendas.setText(numeroPanelPrenda+"/"+cantidadPanelesPrenda);
                }
            }
        });
    }
    private void despintarBoton(IUPanelBotonModelo boton){
        for (int i = 0; i < listaModelos.size(); i++) {
            if(!boton.equals(listaModelos.get(i)))
                listaModelos.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));
        }
    }
    private void despintarBotonPrenda(IUPanelBotonPrenda boton){
        for (int i = 0; i < listaPrendas.size(); i++) {
            if(!boton.equals(listaPrendas.get(i))){
                listaPrendas.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));
                listaPrendas.get(i).cambiarColorMarcaTalla(new Color(2, 67, 109));                
            }                
        }
    }
    
    private void mostrarPrenda(Prenda prenda){
        iuImagen.setUrlImagen(prenda.getUrlPrenda());
        Ayuda.getCodigoBarra(prenda.getCodigo(), "src/imagenes/codigoBarra.png", iuCodigo.getLimitacion());
        iuCodigo.setUrlImagen("src/imagenes/codigoBarra.png");
        iuCategoria.setTexto(prenda.getCategoria());
        iuMarca.iuTexto.setText(prenda.getMarca());
        iuColor.iuTexto.setText(prenda.getColor());
        iuTalla.iuTexto.setText(prenda.getTalla());
        iuPrecio.iuTexto.setText(String.valueOf(prenda.getPrecio()));
        iuPrecio.iuTexto.iuUnidad.setText("BOB.-");
        iuCantidadStock.iuTexto.setText(String.valueOf(prenda.getCantidadEntrante()));        
        iuCantidadStock.iuTexto.iuUnidad.setText("udds.");
        iuUbicacion.iuTexto.setText(prenda.getUbicacion());
    }
    private void limpiarDatosPrenda(){
        iuImagen.setUrlImagen("src/imagenes/agregarImagen.png");        
        iuCodigo.setUrlImagen("");
        iuCategoria.setTexto("");
        iuMarca.iuTexto.setText("");
        iuColor.iuTexto.setText("");
        iuTalla.iuTexto.setText("");
        iuPrecio.iuTexto.setText("");
        iuPrecio.iuTexto.iuUnidad.setText("");        
        iuCantidadStock.iuTexto.setText("");
        iuCantidadStock.iuTexto.iuUnidad.setText("");
        iuUbicacion.iuTexto.setText("");
    }
}
