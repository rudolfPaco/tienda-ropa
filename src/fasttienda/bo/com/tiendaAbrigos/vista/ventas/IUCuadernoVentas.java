/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.ventas;

import com.aplicacionjava.www.botones.IUBoton;
import com.aplicacionjava.www.calendario.IUCalendarioPantalla;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaR;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.recursos.Fecha;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import fasttienda.bo.com.tiendaAbrigos.modelo.DetalleVenta;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.vista.prendas.IUPanelBotonPrenda;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author rudolf
 */
public class IUCuadernoVentas extends IUPanelBD{

    private CVenta controlVentas;
    
    private IUPanelBD primerPanel;
    private IUPanel panelTitulo;
    private IUEtiqueta iuTitulo;
    private IUEtiqueta iuFecha;
    private IUEtiquetaR iuReloj;
    private IUEtiqueta iuTCantidad;
    private IUEtiqueta iuTDetalle;
    private IUEtiqueta iuTCodigo;
    private IUEtiqueta iuTPrecio;
    private IUEtiqueta iuTImporte;
    private IUEtiqueta iuTVer;
    private IUEtiqueta iuTDevolver;
    private IUEtiqueta iuTModificar;
    private CardLayout administrador;
    private IUPanel panelCuaderno;
    private IUBoton botonArriba;
    private IUBoton botonAbajo;
    private int puntero;
    private IUPanelBD segundoPanel;
    
    private int cantidadHojasCuaderno;
    private ArrayList<IUReglonVenta> listaReglonesVenta;
    
    public IUCuadernoVentas(CVenta controlVentas, Limitacion limitacion) {
        super(limitacion);        
        this.controlVentas = controlVentas;
        this.cantidadHojasCuaderno = 0;
        this.listaReglonesVenta = new ArrayList<>();
        this.puntero = 0;
        
        construirPaneles(getLimitacion());
        escucharEvento();
    }
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(4), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(90)));
        primerPanel.setArco(15);
        add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        botonArriba = new IUBoton("▲", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(63), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(15)));
        botonArriba.iuTexto.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(10)));        
        botonArriba.setVisible(false);
        add(botonArriba);
        
        botonAbajo = new IUBoton("▼", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(79), limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(15)));
        botonAbajo.iuTexto.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(10)));
        botonAbajo.setVisible(false);
        add(botonAbajo);
        actualizarCuadernoVentas();
    }    
    private void construirPrimerPanel(Limitacion limite){
        panelTitulo = new IUPanel(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(20)));
        primerPanel.add(panelTitulo);
        construirPanelTitulo(panelTitulo.getLimitacion());
        
        administrador = new CardLayout();
        panelCuaderno = new IUPanel(new Limitacion(0, limite.getPorcentajeAlto(20), limite.getAncho(), limite.getPorcentajeAlto(80)));
        panelCuaderno.setLayout(administrador);
        primerPanel.add(panelCuaderno);        
    }
    private void construirPanelTitulo(Limitacion limite){
        iuTitulo = new IUEtiqueta("Cuaderno de Ventas de Hoy", new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(30)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(20)));
        iuTitulo.setForeground(new Color(120, 0, 0));
        panelTitulo.add(iuTitulo);
        
        iuFecha = new IUEtiqueta("Cochabamba, "+new Fecha().getFecha1(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(30)));
        iuFecha.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(20)));
        panelTitulo.add(iuFecha);
        
        iuReloj = new IUEtiquetaR(new Limitacion(limite.getPorcentajeAncho(71), limite.getPorcentajeAlto(30), limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(35)));
        panelTitulo.add(iuReloj);
        
        iuTCantidad = new IUEtiqueta("CANT", new Limitacion(limite.getPorcentajeAncho(0), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(6), limite.getPorcentajeAlto(20)));
        iuTCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        //iuTCantidad.setBorder(new LineBorder(new Color(180, 0, 0)));
        iuTCantidad.setForeground(new Color(120, 0, 0));
        panelTitulo.add(iuTCantidad);
        
        iuTDetalle = new IUEtiqueta("DETALLE DE PRENDA", new Limitacion(limite.getPorcentajeAncho(6), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(20)));
        iuTDetalle.setHorizontalAlignment(SwingConstants.CENTER);
        iuTDetalle.setForeground(new Color(120, 0, 0));
        //iuTDetalle.setBorder(new LineBorder(new Color(180, 0, 0)));
        panelTitulo.add(iuTDetalle);
        
        iuTCodigo = new IUEtiqueta("CODIGO", new Limitacion(limite.getPorcentajeAncho(56), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(20)));
        iuTCodigo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTCodigo.setForeground(new Color(120, 0, 0));
        //iuTCodigo.setBorder(new LineBorder(new Color(180, 0, 0)));
        panelTitulo.add(iuTCodigo);
        
        iuTPrecio = new IUEtiqueta("PRECIO", new Limitacion(limite.getPorcentajeAncho(66), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(20)));
        iuTPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        iuTPrecio.setForeground(new Color(120, 0, 0));
        //iuTPrecio.setBorder(new LineBorder(new Color(180, 0, 0)));
        panelTitulo.add(iuTPrecio);
        
        iuTImporte = new IUEtiqueta("IMPORTE", new Limitacion(limite.getPorcentajeAncho(76), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(20)));
        iuTImporte.setHorizontalAlignment(SwingConstants.CENTER);
        iuTImporte.setForeground(new Color(120, 0, 0));
        //iuTImporte.setBorder(new LineBorder(new Color(180, 0, 0)));
        panelTitulo.add(iuTImporte);
    }
    private void actualizarCuadernoVentas(){
        ArrayList<DetalleVenta> lista = controlVentas.listarDetallesVentas();
        int numeroElementos = lista.size();
        int limite = 12;
        cantidadHojasCuaderno = Ayuda.getCantidadPaneles(numeroElementos, limite);
        int indice = 0;
        puntero = 1;
        System.out.println("el tam de cantidad es: "+cantidadHojasCuaderno);
        
        if(cantidadHojasCuaderno > 1)
            botonAbajo.setVisible(true);
        else
            botonAbajo.setVisible(false);
        
        this.listaReglonesVenta.clear();
        panelCuaderno.removeAll();
        panelCuaderno.updateUI();
                        
        for (int i = 0; i < cantidadHojasCuaderno; i++) {
            IUPanel panelHojaCuaderno = new IUPanel(new Limitacion(panelCuaderno.getLimitacion().getAncho(), panelCuaderno.getLimitacion().getAlto()));
            panelCuaderno.add(panelHojaCuaderno);
            
            int ancho = panelHojaCuaderno.getLimitacion().getAncho() - 4;
            int alto = panelHojaCuaderno.getLimitacion().getAlto()/13;
            
            for(int j = 0; j < limite; j++){
                if(indice < numeroElementos){
                    DetalleVenta detalleVenta = lista.get(indice);
                    if(detalleVenta != null){
                        IUReglonVenta iuReglon = new IUReglonVenta(new Limitacion(2, j*2 + j + j*alto, ancho, alto), detalleVenta);
                        listaReglonesVenta.add(iuReglon);
                        panelHojaCuaderno.add(iuReglon);
                        /*elemento.addEventoRaton(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                elemento.setColorPanel(new Color(255, 255, 125), Color.WHITE, new Color(221, 221, 0));                            
                                despintarBotonPrenda(elemento);                                
                                mostrarPrenda(detalleVenta);
                                prenda = detalleVenta;
                            }
                        });*/
                    }                    
                }
                indice++;
            }
        }
    }
    private void escucharEvento(){
        botonAbajo.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(puntero < cantidadHojasCuaderno){
                    botonArriba.setVisible(true);
                    administrador.next(panelCuaderno);
                    puntero++;
                }
            }            
        });
        botonArriba.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(puntero > 1){
                    administrador.previous(panelCuaderno);
                    puntero--;
                    if(puntero == 1)
                        botonArriba.setVisible(false);
                }   
            }
        });
    }
}
