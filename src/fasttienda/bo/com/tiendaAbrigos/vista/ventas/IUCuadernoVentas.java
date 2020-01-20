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
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import fasttienda.bo.com.tiendaAbrigos.vista.prendas.IUPanelBotonPrenda;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IUCuadernoVentas extends IUPanelBD{

    private CVenta controlVentas;
    
    private IUPanelBD primerPanel;
    private IUPanelBD panelTitulo;
    private IUEtiqueta iuTitulo;
    private IUEtiqueta iuFecha;
    private IUEtiquetaR iuReloj;
    private IUPanelBD panelCuaderno;
    private IUBoton botonArriba;
    private IUBoton botonAbajo;
    private IUPanelBD segundoPanel;
    
    public IUCuadernoVentas(CVenta controlVentas, Limitacion limitacion) {
        super(limitacion);
        this.controlVentas = controlVentas;
        setBorder(null);
        setColorPanel(Color.LIGHT_GRAY, Color.WHITE, Color.WHITE);
        construirPaneles(getLimitacion());
    }
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(8), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(90)));
        add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        botonArriba = new IUBoton("▲", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(18)));
        botonArriba.iuTexto.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        add(botonArriba);
        
        botonAbajo = new IUBoton("▼", new Limitacion(limite.getPorcentajeAncho(79), limite.getPorcentajeAlto(70), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(18)));
        botonAbajo.iuTexto.setFont(new Font("Arial", Font.PLAIN, limite.getPorcentajeAlto(15)));        
        add(botonAbajo);
    }    
    private void construirPrimerPanel(Limitacion limite){
        panelTitulo = new IUPanelBD(new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(20)));
        primerPanel.add(panelTitulo);
        construirPanelTitulo(panelTitulo.getLimitacion());
        
        panelCuaderno = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(20), limite.getAncho(), limite.getPorcentajeAlto(80)));
        primerPanel.add(panelCuaderno);
        actualizarCuadernoVentas();
    }
    private void construirPanelTitulo(Limitacion limite){
        iuTitulo = new IUEtiqueta("Cuaderno de Ventas de Hoy", new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(50)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(20)));
        iuTitulo.setForeground(new Color(180, 0, 0));
        panelTitulo.add(iuTitulo);
        
        iuFecha = new IUEtiqueta("Cochabamba, "+new Fecha().getFecha1(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(50)));
        iuFecha.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(20)));
        panelTitulo.add(iuFecha);
        
        iuReloj = new IUEtiquetaR(new Limitacion(limite.getPorcentajeAncho(71), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(28), limite.getPorcentajeAlto(35)));
        panelTitulo.add(iuReloj);
    }
    private void actualizarCuadernoVentas(){
        /*ArrayList<Prenda> lista = controlVentas.listarTodasPrendas(modelo);
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
        }*/
    }
}
