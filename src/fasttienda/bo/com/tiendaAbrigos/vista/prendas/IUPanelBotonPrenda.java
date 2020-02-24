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
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author hotel-felipez
 */
public class IUPanelBotonPrenda extends IUPanelBD{
    
    private IUEtiqueta categoria;
    private IUPanelTT stock;
    private IUEtiqueta marcaTalla;
    private IUPanelTT color;
    private IUPanelTT precio;
    
    private Prenda prenda;
    
    public IUPanelBotonPrenda(Limitacion limitacion, Prenda prenda) {
        super(limitacion);
        this.prenda = prenda;
        construirPanel(getLimitacion());
    }
    private void construirPanel(Limitacion limite){
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        categoria = new IUEtiqueta(prenda.getCategoria().toUpperCase(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(20)));
        categoria.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));
        categoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        categoria.setHorizontalAlignment(SwingConstants.CENTER);
        add(categoria);
        
        stock = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(71), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(29), limite.getPorcentajeAlto(20)), "stock", String.valueOf(prenda.getCantidadEntrante()), 50, 50);
        stock.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)), new Font("Verdana", Font.BOLD, limite.getPorcentajeAlto(22)));
        stock.iuTexto.setForeground(new Color(180, 0, 0));
        stock.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        stock.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(stock);
        if(prenda.getCantidadEntrante() < 1)
            stock.iuTexto.setForeground(new Color(120, 120, 120));
        
        marcaTalla = new IUEtiqueta(prenda.getMarca().toUpperCase()+" - "+prenda.getTalla(), new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(35), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(30)));
        marcaTalla.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(27)));
        marcaTalla.setCursor(new Cursor(Cursor.HAND_CURSOR));
        marcaTalla.setHorizontalAlignment(SwingConstants.CENTER);
        add(marcaTalla);
        
        color = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(20)), "color: ", prenda.getColor(), 20, 80);
        color.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));
        color.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        //color.setBorder(new LineBorder(Color.yellow));
        add(color);
        
        precio = new IUPanelTT(new Limitacion(limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(80), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(20)), "precio: ", String.valueOf(prenda.getPrecio()), 50, 50);
        precio.setFuente(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)), new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(15)));
        precio.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        precio.setCursorMano(new Cursor(Cursor.HAND_CURSOR));
        add(precio);
    }
    public void cambiarColorMarcaTalla(Color color){
        marcaTalla.setForeground(color);        
    }
    public void addEventoRaton(MouseAdapter evento){
        addMouseListener(evento);
        categoria.addMouseListener(evento);
        precio.addEventoRaton(evento);
        marcaTalla.addMouseListener(evento);
        stock.addEventoRaton(evento);
        color.addEventoRaton(evento);
    }
}
