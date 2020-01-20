/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionjava.www.etiquetas;

import com.aplicacionjava.www.recursos.Documento;
import com.aplicacionjava.www.recursos.Limitacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IUEtiquetaI extends JLabel{
    private String urlImagen;
    private Limitacion limitacion;
    private Documento documento;
        
    /**
     * Interfaz de Usuario Etiqueta Imagen, hereda atributos y metodos del componente JLabel.
     * @param urlImagen direccion de la imagen guardad en el disco.
     * @param limitacion determina la posicion y el tamaño del componente.
     */
    public IUEtiquetaI(String urlImagen, Limitacion limitacion){
        this.urlImagen = urlImagen;
        this.limitacion = limitacion;
        this.documento = null;
        construirEtiqueta();        
    }
    private void construirEtiqueta(){
        setOpaque(false);
        setToolTipText("");
        setBounds(limitacion.getX(), limitacion.getY(), limitacion.getAncho(), limitacion.getAlto());
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFocusable(false);
        construirImagen();
    }
    private void construirImagen(){
        if(!urlImagen.isEmpty()){
            if (getClass().getResource(urlImagen) != null) {
                setIcon(new ImageIcon(new ImageIcon(getClass().getResource(urlImagen)).getImage().getScaledInstance(limitacion.getAncho(), limitacion.getAlto(), Image.SCALE_DEFAULT)));
            } else {
                setIcon(new ImageIcon(new ImageIcon(urlImagen).getImage().getScaledInstance(limitacion.getAncho(), limitacion.getAlto(), Image.SCALE_DEFAULT)));
            }
        }
    }

    public Limitacion getLimitacion(){
        return limitacion;
    }
    public void setLimitacion(Limitacion limitacion){
        this.limitacion = limitacion;
        construirEtiqueta();
    }
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
        construirImagen();
    }
    public String getUrlImagen(){
        return urlImagen;
    }
    public Documento getDocumento() {
        return documento;
    }
    public void setDocumento(Documento documento) {
        this.documento = documento;
        setUrlImagen(documento.getUrl());
    }
}