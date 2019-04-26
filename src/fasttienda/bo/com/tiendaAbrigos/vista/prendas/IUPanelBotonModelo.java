/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.prendas;

import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelTT;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author rudolf
 */
public class IUPanelBotonModelo extends IUPanelBD{
    
    private IUEtiqueta iuTitulo;
    private IUPanelTT iuCategoria;
    private IUPanelTT iuMarca;
    private IUPanelTT iuDetalle;
    private IUPanelTT iuTipoColor;
    private IUPanelTT iuTela;
    private IUPanelTT iuIndustria;
    private IUPanelTT iuTemporada;
    private IUPanelTT iuColores;
    private IUPanelTT iuTallas;
    private IUPanelTT iuPrecioOficial;
    
    private Modelo modelo;
    
    public IUPanelBotonModelo(Limitacion limitacion, Modelo modelo) {
        super(limitacion);
        this.modelo = modelo;
        construirPanelBotonModelo(getLimitacion());
    }
    private void construirPanelBotonModelo(Limitacion limite){
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        iuTitulo = new IUEtiqueta("modelo ID: "+modelo.getModeloID(), new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(10)));
        iuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        iuTitulo.setForeground(new Color(120, 0, 0));
        iuTitulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuTitulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(iuTitulo);
        
        iuCategoria = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(12)), "Cat.:", modelo.getCategoria().toUpperCase(), 20, 80);
        iuCategoria.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuCategoria.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuCategoria);
        
        iuMarca = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(12)), "Marca:", modelo.getMarca().toUpperCase(), 30, 70);
        iuMarca.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuMarca.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuMarca);
        
        iuDetalle = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(22), limite.getAncho(), limite.getPorcentajeAlto(12)), "Detalle:", modelo.getDetalle(), 15, 85);
        iuDetalle.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuDetalle.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuDetalle);
        
        iuTela = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(34), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(12)), "Tela:", modelo.getTela(), 30, 70);
        iuTela.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuTela.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuTela);
        
        iuIndustria = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(34), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(12)), "Industria:", modelo.getIndustria(), 45, 55);
        iuIndustria.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuIndustria.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuIndustria);
        
        iuTipoColor = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(12)), "Tipo:", modelo.getTipoColor(), 30, 70);
        iuTipoColor.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuTipoColor.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuTipoColor);
        
        iuTemporada = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(58), limite.getAncho(), limite.getPorcentajeAlto(12)), "Temporada:", "primavera", 30, 70);
        iuTemporada.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuTemporada.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuTemporada);
        
        iuColores = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(70), limite.getAncho(), limite.getPorcentajeAlto(12)), "Colores:", modelo.getColores(), 15, 85);
        iuColores.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuColores.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuColores);
        
        iuTallas = new IUPanelTT(new Limitacion(0, limite.getPorcentajeAlto(84), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(12)), "Tallas:", modelo.getTallas(), 20, 80);
        iuTallas.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuTallas.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuTallas);
        
        iuPrecioOficial = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(84), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(12)), "Precio:"+" ("+modelo.getUnidades().get(0).getUnidadMedida()+")", String.valueOf(modelo.getPrecioOficial()), 70, 30);
        iuPrecioOficial.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(9)));
        iuPrecioOficial.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(iuPrecioOficial);
    }
    public void addEventoRaton(MouseAdapter evento){
        addMouseListener(evento);
        iuTitulo.addMouseListener(evento);
        iuCategoria.addEventoRaton(evento);
        iuMarca.addEventoRaton(evento);
        iuDetalle.addEventoRaton(evento);
        iuTela.addEventoRaton(evento);
        iuIndustria.addEventoRaton(evento);
        iuTipoColor.addEventoRaton(evento);
        iuTemporada.addEventoRaton(evento);
        iuColores.addEventoRaton(evento);
        iuTallas.addEventoRaton(evento);
        iuPrecioOficial.addEventoRaton(evento);
    }
    public Modelo getModelo(){
        return modelo;
    }
    public void pintarBoton(){
        setColorPanel(Color.orange, Color.YELLOW, Color.orange);
    }
}
