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
import com.aplicacionjava.www.paneles.IUPanelTCB;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUModificarPrenda extends IUVentanaT{
    private IUPrincipal ventanaPrincipal;
    private IUPanelBD primerPanelPrenda;
    private IUEtiqueta primerTitulo;
    
    private IUPanel segundoPanel;
    private IUBotonIT botonModificar;
    private IUBotonIT botonCancelar;
    private IUEtiquetaI imagenPrenda;   
    private IUBotonIT botonEliminar;
    private IUBotonIT botonExaminar;
    
    private IUEtiquetaI codigoImagen;
    private IUPanelCT codigo;
    private IUPanelCT categoria;
    private IUPanelCT marca;
    private IUPanelTCB color;
    private IUPanelTCB talla;
    private IUPanelCTU precioOficial;
    private IUPanelCTU cantidadMinima;
    private IUPanelTCB ubicacion;
    
    private Modelo modelo;
    private Prenda prenda;
    private boolean estado;
      
    public IUModificarPrenda(IUPrincipal ventanaPrincipal, Modelo modelo, Prenda prenda, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.ventanaPrincipal = ventanaPrincipal;
        this.modelo = modelo;
        this.prenda = prenda;
        this.estado = false;
        construirPaneles(panelFondo.getLimitacion());    
        setEventos();
    }
    private void construirPaneles(Limitacion limite){
        primerPanelPrenda = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(90)));
        panelFondo.add(primerPanelPrenda);
        construirPrimerPanelPrenda(primerPanelPrenda.getLimitacion());
        
        segundoPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(91), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(8)));
        panelFondo.add(segundoPanel);        
        construirSegundoPanel(segundoPanel.getLimitacion());
    }
    private void construirPrimerPanelPrenda(Limitacion limite){
        imagenPrenda = new IUEtiquetaI("src/imagenes/agregarImagen.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(70)));
        primerPanelPrenda.add(imagenPrenda);
        imagenPrenda.setUrlImagen(prenda.getUrlPrenda());
        
        botonEliminar = new IUBotonIT("eliminar foto", "src/imagenes/basurero.png", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(73), limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(5)));
        primerPanelPrenda.add(botonEliminar);
        
        botonExaminar = new IUBotonIT("examinar foto", "src/imagenes/buscarCarpeta.png", new Limitacion(limite.getPorcentajeAncho(69), limite.getPorcentajeAlto(73), limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(5)));
        primerPanelPrenda.add(botonExaminar);
        
        codigoImagen = new IUEtiquetaI("src/imagenes/codigobarra.png", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(10)));
        codigoImagen.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(7)));
        primerPanelPrenda.add(codigoImagen);
        
        codigo = new IUPanelCT("codigo unico", prenda.getCodigo(), new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(11), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);        
        codigo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(2)));
        codigo.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        primerPanelPrenda.add(codigo);
        
        categoria = new IUPanelCT("categoria", prenda.getCategoria(), new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(26), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelPrenda.add(categoria);
        
        marca = new IUPanelCT("marca", prenda.getMarca(), new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelPrenda.add(marca);
                
        String[] colores = modelo.getArregloColores();
        color = new IUPanelTCB("color", colores, new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(44), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelPrenda.add(color);
        color.iuTexto.setSelectedItem(prenda.getColor());
        
        String[] tallas = modelo.getArregloTallas();
        talla = new IUPanelTCB("talla", tallas, new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelPrenda.add(talla);
        talla.iuTexto.setSelectedItem(prenda.getTalla());
        
        precioOficial = new IUPanelCTU("precio Oficial", String.valueOf(prenda.getPrecio()), modelo.getUnidades().get(0).getUnidadMedida(), new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(62), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 40);
        precioOficial.iuTexto.setRestriccionNumeroDecimal();
        primerPanelPrenda.add(precioOficial);
        
        cantidadMinima = new IUPanelCTU("cant. minima", String.valueOf(prenda.getCantidadMinima()), modelo.getUnidades().get(1).getUnidadMedida(), new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(71), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 60);
        cantidadMinima.iuTexto.setRestriccionNumeroEnteros();
        primerPanelPrenda.add(cantidadMinima);
        
        String[] ubicaciones = modelo.getUbicaciones();
        ubicacion = new IUPanelTCB("ubicacion", ubicaciones, new Limitacion(limite.getPorcentajeAncho(22), limite.getPorcentajeAlto(81), limite.getPorcentajeAncho(36), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelPrenda.add(ubicacion);
        ubicacion.iuTexto.setSelectedItem(prenda.getUbicacion());
        
        Ayuda.getCodigoBarra(codigo.iuTexto.getText(), "src/imagenes/codigoBarra.png", codigoImagen.getLimitacion());
        codigoImagen.setUrlImagen("src/imagenes/codigoBarra.png");
    }
    private void construirSegundoPanel(Limitacion limite){
        botonModificar = new IUBotonIT("modificar prenda", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(34), limite.getPorcentajeAlto(90)));
        segundoPanel.add(botonModificar);
        
        botonCancelar = new IUBotonIT("salir del formulario", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(34), limite.getPorcentajeAlto(90)));
        segundoPanel.add(botonCancelar);
    }
    private boolean estaValidadoCorrectamente(){
        boolean verificador = false;
        if(!codigo.iuTexto.getText().isEmpty()){
            if(!color.iuTexto.getTexto().isEmpty()){
                if(!talla.iuTexto.getTexto().isEmpty()){
                    if(!precioOficial.iuTexto.getText().isEmpty()){
                        if(!cantidadMinima.iuTexto.getText().isEmpty()){
                            if(!ubicacion.iuTexto.getTexto().isEmpty()){
                                verificador = true;
                            }else
                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo UBICACION...", "advertencia");
                        }else
                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo CANTIDAD MINIMA...", "advertencia");
                    }else
                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo PRECIO OFICIAL...", "advertencia");
                }else
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TALLA...", "advertencia");
            }else
                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo COLOR...", "advertencia");
        }else
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo CODIGO UNICO...", "advertencia");
        return verificador;
    }
    private void setEventos(){
        codigo.iuTexto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(!codigo.iuTexto.getText().isEmpty()){
                    String codigoBarra = codigo.iuTexto.getText();
                    Ayuda.getCodigoBarra(codigoBarra, "src/imagenes/codigoBarra.png", codigoImagen.getLimitacion());
                    codigoImagen.setUrlImagen("src/imagenes/codigoBarra.png");
                }
            }
        });
        botonExaminar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setAlwaysOnTop(false);                
                imagenPrenda.setUrlImagen(Ayuda.examinarArchivo(ventanaPrincipal, "src/imagenes/logo.png"));
                setAlwaysOnTop(true);
            }
        });
        botonEliminar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imagenPrenda.setUrlImagen("src/imagenes/agregarImagen.png");
            }
        });
        botonCancelar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        botonModificar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(estaValidadoCorrectamente()){
                    modificarPrenda();
                }
            }
        });
    }    
    private void modificarPrenda(){
        if(getPrenda().existePrendaDuplicada()){
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "NO PUEDE MODIFICAR ESTA PRENDA.... por que ya existe duplicada en la base de datos.", "Advertencia");
        }else{
            estado = true;
            dispose();
        }        
    }
    public boolean getEstado(){
        return estado;
    }
    public Prenda getPrenda(){
        Prenda p = new Prenda(prenda.getId());
        p.setCodigo(codigo.iuTexto.getText());
        p.setCategoria(categoria.iuTexto.getText());
        p.setMarca(marca.iuTexto.getText());
        p.setColor(color.iuTexto.getTexto());
        p.setTalla(talla.iuTexto.getTexto());
        p.setPrecio(Double.parseDouble(precioOficial.iuTexto.getText()));
        p.setCantidadMinima(Integer.parseInt(cantidadMinima.iuTexto.getText()));
        p.setCantidadEntrante(0);
        p.setUbicacion(ubicacion.iuTexto.getTexto());
        p.setUrlPrenda(imagenPrenda.getUrlImagen());
        p.setIdModelo(prenda.getId());
        
        return p;
    }
}
