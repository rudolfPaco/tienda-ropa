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
import com.aplicacionjava.www.paneles.IUPanelTA;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrenda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
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
 * @author rudolf
 */
public class IUModelo extends IUVentanaT{
    
    private IUPrincipal ventanaPrincipal;
    private CPrenda controlPrenda;
    
    private IUPanel primerPanel;
    private IUPanel primerTituloPanel;
    private IUEtiqueta primerEtiquetaTitulo;
    private CardLayout primerAdministradora;
    private IUPanel primerContenedorModelos;
    private IUPanelBD primerControlPaneles;
    private IUEtiquetaI iconoAtras;
    private IUEtiqueta indicePaneles;
    private IUEtiquetaI iconoAdelante;
    
    private IUPanel segundoPanel;
    private IUPanel segundoTituloPanel;
    private IUEtiqueta segundoEtiquetaTitulo;
    private IUPanelBD segundoPanelModelo;
    private IUPanelCT categoria;
    private IUPanelCT marca;
    private IUPanelCT detalle;
    private IUPanelCT tipoColor;
    private IUPanelTA colores;
    private IUPanelTA tallas;
    private IUPanelCT tela;
    private IUPanelCT industria;
    private IUPanelCT temporada;
    private IUPanelCT tipoMoneda;
    private IUPanelCT unidadMoneda;
    private IUPanelCTU costo;
    private IUPanelCTU iva;
    private IUPanelCTU costoIva;
    private IUPanelCTU margenUtilidad;
    private IUPanelCTU precioTope;
    private IUPanelCTU precioOficial;
    
    private IUPanel tercerPanel;
    private IUBotonIT nuevoModelo;
    private IUBotonIT botonModificar;
    private IUBotonIT botonEliminar;
    private IUBotonIT botonSalir;
    
    private int modeloID;
    private int numeroPanel;
    private int cantidadPaneles;
    private Modelo modelo;
    
    private ArrayList<IUPanelBotonModelo> listaModelos;
    
    public IUModelo(IUPrincipal ventanaPrincipal, CPrenda controlPrenda, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.ventanaPrincipal = ventanaPrincipal;
        this.controlPrenda = controlPrenda;
        this.modelo = null;
        this.listaModelos = new ArrayList<>();
        this.numeroPanel = 1;
        this.cantidadPaneles = 0;
        this.modeloID = 0;
        
        construirPaneles(panelFondo.getLimitacion());
        setEventos();
        actualizarListaModelos(controlPrenda.listarTodosModelos());
    }
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(90)));
        panelFondo.add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(35), 0, limite.getPorcentajeAncho(65), limite.getPorcentajeAlto(90)));
        panelFondo.add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(90), limite.getAncho(), limite.getPorcentajeAlto(10)));
        panelFondo.add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
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
        iconoAtras = new IUEtiquetaI("src/imagenes/izquierda.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iconoAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        primerControlPaneles.add(iconoAtras);
        
        indicePaneles = new IUEtiqueta("", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(60)));
        indicePaneles.setHorizontalAlignment(SwingConstants.CENTER);
        indicePaneles.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));        
        primerControlPaneles.add(indicePaneles);
        
        iconoAdelante = new IUEtiquetaI("src/imagenes/derecha.png", new Limitacion(limite.getPorcentajeAncho(91), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(90)));
        iconoAdelante.setCursor(new Cursor(Cursor.HAND_CURSOR));
        primerControlPaneles.add(iconoAdelante);
    }
    
    private void construirSegundoPanel(Limitacion limite){
        segundoTituloPanel = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        segundoPanel.add(segundoTituloPanel);
        construirSegundoTituloPanel(segundoTituloPanel.getLimitacion());
        
        segundoPanelModelo = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(10), limite.getAncho(), limite.getPorcentajeAlto(90)));
        segundoPanel.add(segundoPanelModelo);
        construirSegundoPanelModelo(segundoPanelModelo.getLimitacion());
    }
    private void construirSegundoTituloPanel(Limitacion limite){
        segundoEtiquetaTitulo = new IUEtiqueta("Modelo Registrado", new Limitacion(0, limite.getPorcentajeAlto(25), limite.getAncho(), limite.getPorcentajeAlto(50)));
        segundoEtiquetaTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(40)));
        segundoEtiquetaTitulo.setForeground(new Color(120, 0, 0));
        segundoEtiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        segundoTituloPanel.add(segundoEtiquetaTitulo);
    }
    private void construirSegundoPanelModelo(Limitacion limite){
        categoria = new IUPanelCT("categoria de modelo", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        categoria.iuTexto.setEditable(false);
        segundoPanelModelo.add(categoria);
        
        marca = new IUPanelCT("marca del modelo", "", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        marca.iuTexto.setEditable(false);
        segundoPanelModelo.add(marca);
        
        detalle = new IUPanelCT("detalle del modelo", "", new Limitacion(limite.getPorcentajeAncho(4), limite.getPorcentajeAlto(14), limite.getPorcentajeAncho(92), limite.getPorcentajeAlto(7)), 40, 60);
        detalle.iuTexto.setEditable(false);
        segundoPanelModelo.add(detalle);
        
        tipoColor = new IUPanelCT("tipo de colores", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        tipoColor.iuTexto.setEditable(false);
        segundoPanelModelo.add(tipoColor);
        
        colores = new IUPanelTA("colores (rojo, azul-verde, negro)", "", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(14)), 21, 79);
        colores.iuAreaTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(7)/3));
        colores.iuAreaTexto.setEditable(false);
        segundoPanelModelo.add(colores);
        
        tallas = new IUPanelTA("tallas (XL, 185/12-XL, 45)", "", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(14)), 21, 79);
        tallas.iuAreaTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(7)/3));
        tallas.iuAreaTexto.setEditable(false);
        segundoPanelModelo.add(tallas);
        
        tela = new IUPanelCT("nombre de tela", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(39), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        tela.iuTexto.setEditable(false);
        segundoPanelModelo.add(tela);
        
        industria = new IUPanelCT("origen de industria", "", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(39), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        industria.iuTexto.setEditable(false);
        segundoPanelModelo.add(industria);
        
        temporada = new IUPanelCT("temporada del modelo", "", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(39), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        temporada.iuTexto.setEditable(false);
        segundoPanelModelo.add(temporada);
        
        tipoMoneda = new IUPanelCT("tipo de monedas", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        tipoMoneda.iuTexto.setEditable(false);
        segundoPanelModelo.add(tipoMoneda);
        
        unidadMoneda = new IUPanelCT("U/M", "", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(7)), 40, 60);
        unidadMoneda.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        unidadMoneda.iuTexto.setEditable(false);
        segundoPanelModelo.add(unidadMoneda);
        
        costo = new IUPanelCTU("costo unitario", "", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        costo.iuTexto.setPosicionHorizontalUnidad("izquierda");
        costo.iuTexto.setEditable(false);
        segundoPanelModelo.add(costo);
        
        iva = new IUPanelCTU("I.V.A.", String.valueOf(Ayuda.getDatoDouble("IVA", "select IVA from impuesto")), "%", new Limitacion(limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 50);        
        iva.iuTexto.setPosicionHorizontalUnidad("izquierda");
        iva.iuTexto.setEditable(false);
        segundoPanelModelo.add(iva);
        
        costoIva = new IUPanelCTU("costo I.V.A.", "", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        costoIva.iuTexto.setPosicionHorizontalUnidad("izquierda");
        costoIva.iuTexto.setEditable(false);
        segundoPanelModelo.add(costoIva);
        
        margenUtilidad = new IUPanelCTU("margen de utilidad", "", "%", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        margenUtilidad.iuTexto.setPosicionHorizontalUnidad("izquierda");
        margenUtilidad.iuTexto.setEditable(false);
        segundoPanelModelo.add(margenUtilidad);
        
        precioTope = new IUPanelCTU("precio tope", "", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        precioTope.iuTexto.setPosicionHorizontalUnidad("izquierda");
        precioTope.iuTexto.setEditable(false);
        segundoPanelModelo.add(precioTope);
        
        precioOficial = new IUPanelCTU("precio oficial", "", "", new Limitacion(limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 50);
        precioOficial.iuTexto.setPosicionHorizontalUnidad("izquierda");
        precioOficial.iuTexto.setEditable(false);
        segundoPanelModelo.add(precioOficial);
    }
    
    private void construirTercerPanel(Limitacion limite){
        nuevoModelo = new IUBotonIT("NUEVO MODELO", "src/imagenes/compras.png", new Limitacion(limite.getPorcentajeAncho(85), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        nuevoModelo.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        tercerPanel.add(nuevoModelo);
        
        botonModificar = new IUBotonIT("MODIFICAR MODELO", "src/imagenes/editar.png", new Limitacion(limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonModificar.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        tercerPanel.add(botonModificar);
        
        botonEliminar = new IUBotonIT("ELIMINAR MODELO", "src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonEliminar.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        tercerPanel.add(botonEliminar);
        
        botonSalir = new IUBotonIT("SALIR CRUD", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(20), limite.getPorcentajeAncho(14), limite.getPorcentajeAlto(60)));
        botonSalir.iuTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        tercerPanel.add(botonSalir);
    }
    private void setEventos(){
        nuevoModelo.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                crearNuevoModelo();
            }
        });   
        botonModificar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                modificarModelo();
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
                eliminarModelo();
            }
        });
        iconoAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanel > 1){
                    primerAdministradora.previous(primerContenedorModelos);
                    numeroPanel--;
                    indicePaneles.setText(numeroPanel+"/"+cantidadPaneles);
                }
            }
        });
        iconoAdelante.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(numeroPanel > 0 && numeroPanel < cantidadPaneles){
                    primerAdministradora.next(primerContenedorModelos);
                    numeroPanel++;
                    indicePaneles.setText(numeroPanel+"/"+cantidadPaneles);
                }
            }
        });
    }
    private void setDatosModelo(Modelo modelo){
        this.modelo = modelo;
        modeloID = modelo.getModeloID();
        categoria.iuTexto.setText(modelo.getCategoria());
        marca.iuTexto.setText(modelo.getMarca());
        detalle.iuTexto.setText(modelo.getDetalle());
        tipoColor.iuTexto.setText(modelo.getTipoColor());
        colores.iuAreaTexto.setText(modelo.getColores());
        tallas.iuAreaTexto.setText(modelo.getTallas());
        tela.iuTexto.setText(modelo.getTela());
        industria.iuTexto.setText(modelo.getIndustria());
        temporada.iuTexto.setText(modelo.getTemporada());
        tipoMoneda.iuTexto.setText(modelo.getUnidades().get(0).getNombreUnidad());
        unidadMoneda.iuTexto.setText(modelo.getUnidades().get(0).getUnidadMedida());
        costo.iuTexto.setText(String.valueOf(modelo.getCostoUnitario()));
        costo.iuTexto.iuUnidad.setText(modelo.getUnidades().get(0).getUnidadMedida());
        iva.iuTexto.setText(String.valueOf(modelo.getImpuesto().getIva()));
        costoIva.iuTexto.setText(String.valueOf(modelo.getCostoUnitarioIva()));
        costoIva.iuTexto.iuUnidad.setText(modelo.getUnidades().get(0).getUnidadMedida());
        margenUtilidad.iuTexto.setText(String.valueOf(modelo.getMargenUtilidad()));
        precioTope.iuTexto.setText(String.valueOf(modelo.getPrecioTope()));
        precioTope.iuTexto.iuUnidad.setText(modelo.getUnidades().get(0).getUnidadMedida());
        precioOficial.iuTexto.setText(String.valueOf(modelo.getPrecioOficial()));
        precioOficial.iuTexto.iuUnidad.setText(modelo.getUnidades().get(0).getUnidadMedida());
    }
    private void actualizarListaModelos(ArrayList<Modelo> lista){
        int numeroElementos = lista.size();
        int limite = 4;
        cantidadPaneles = Ayuda.getCantidadPaneles(numeroElementos, limite);
        int indice = 0;        
        
        if(cantidadPaneles < 2){
            iconoAtras.setVisible(false);
            iconoAdelante.setVisible(false);
            indicePaneles.setText("");
        }else{
            iconoAtras.setVisible(true);
            iconoAdelante.setVisible(true);
            indicePaneles.setText(numeroPanel+"/"+cantidadPaneles);
        }
        
        listaModelos.clear();
        primerContenedorModelos.removeAll();
        primerContenedorModelos.updateUI();
                        
        for (int i = 0; i < cantidadPaneles; i++) {
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
                            setDatosModelo(elemento.getModelo());
                        }
                    });
                }
                indice++;
            }
        }
    }
    private void crearNuevoModelo(){
        setOpacity(0.5f);
        IUNuevoModelo iuNuevoModelo = new IUNuevoModelo(ventanaPrincipal, "registrar nuevo modelo", new Limitacion(Ayuda.ancho/2, Ayuda.alto - Ayuda.alto/100), 5);
        iuNuevoModelo.mostrarVentana();            
        if(iuNuevoModelo.getEstado()){
            if(controlPrenda.seGuardoNuevoModelo(iuNuevoModelo.getModelo())){
                if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "EN HORA BUENA... se ha guardado los datos del NUEVO MODELO correctamente...!", "correcto")){
                    limpiarCampoDatos();
                    actualizarListaModelos(controlPrenda.listarTodosModelos());
                }                    
            }else{
                Ayuda.mensajeVerificacion(ventanaPrincipal, "error", "ERROR, NO se pudo guardar la prenda... existe un error", "error");
            }
        }
        setOpacity(1f);
    }
    private void modificarModelo(){
        setOpacity(0.5f);
        if(modeloID != 0){
            IUModificarModelo iuModificarModelo = new IUModificarModelo(ventanaPrincipal, "modificar datos del modelo", new Limitacion(Ayuda.ancho/2, Ayuda.alto - Ayuda.alto/100), 5);
            iuModificarModelo.setModelo(modelo);
            iuModificarModelo.mostrarVentana();
            if(iuModificarModelo.getEstado()){
                if(controlPrenda.seModificoModelo(iuModificarModelo.getModelo())){
                    if(Ayuda.mensajeVerificacion(ventanaPrincipal, this, "correcto", "EN HORA BUENA... se ha MODIFICADO los datos del MODELO correctamente...!", "correcto")){
                        limpiarCampoDatos();
                        actualizarListaModelos(controlPrenda.listarTodosModelos());
                    }
                }
            }
        }else{
            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento.... debe seleccionar un modelo por favor...!", "aviso");
        }
        setOpacity(1f);
    }
    private void eliminarModelo(){
        setOpacity(0.5f);
        if(modeloID != 0){
            if(modelo.tienePrendasCreadas()){
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
        }
        setOpacity(1f);
    }
    
    private void limpiarCampoDatos(){
        modeloID = 0;
        categoria.iuTexto.setText("");
        marca.iuTexto.setText("");
        detalle.iuTexto.setText("");
        tipoColor.iuTexto.setText("");
        colores.iuAreaTexto.setText("");
        tallas.iuAreaTexto.setText("");
        tela.iuTexto.setText("");
        industria.iuTexto.setText("");
        temporada.iuTexto.setText("");
        tipoMoneda.iuTexto.setText("");
        unidadMoneda.iuTexto.setText("");
        costo.iuTexto.setText("");
        costo.iuTexto.iuUnidad.setText("");
        costoIva.iuTexto.setText("");
        costoIva.iuTexto.iuUnidad.setText("");
        margenUtilidad.iuTexto.setText("");
        precioTope.iuTexto.setText("");
        precioTope.iuTexto.iuUnidad.setText("");
        precioOficial.iuTexto.setText("");
        precioOficial.iuTexto.iuUnidad.setText("");        
        despintarBoton(null);
    }
    private void despintarBoton(IUPanelBotonModelo boton){
        if(boton != null){
            for (int i = 0; i < listaModelos.size(); i++) {
                if(!boton.equals(listaModelos.get(i)))
                    listaModelos.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));
            }
        }else{
            for (int i = 0; i < listaModelos.size(); i++) {
                listaModelos.get(i).setColorPanel(new Color(242, 238, 236), new Color(250, 250, 250), new Color(170, 170, 170));                    
            }
        }
    }
}