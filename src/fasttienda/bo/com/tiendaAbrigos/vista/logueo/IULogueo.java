/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.logueo;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.campos.IUAreaTexto;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelPT;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.controlador.CLogueo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author rudolf
 */
public class IULogueo extends IUVentanaT{
    
    private IUPanel primerPanel;
    private IUEtiquetaI imagenLogueo;
    private IUAreaTexto iuMensaje;
    
    private IUPanelBD segundoPanel;
    public IUPanelCT iuUsername;
    public IUPanelPT iuPassword;
    
    private IUPanel tercerPanel;
    private IUBotonIT botonIniciar;
    
    private CLogueo controlLogueo;
    private Usuario usuario;
    private boolean estado;
    
    public IULogueo(JFrame ventanaPrincipal, CLogueo controlLogueo, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.controlLogueo = controlLogueo;
        this.usuario = null;
        this.estado = false;
        
        construirPaneles(panelFondo.getLimitacion());
        setEventos();
    }   
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(30)));
        panelFondo.add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanelBD(new Limitacion(0, limite.getPorcentajeAlto(35), limite.getAncho(), limite.getPorcentajeAlto(50)));
        segundoPanel.setArco(1);
        panelFondo.add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(85), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(15)));
        panelFondo.add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
    }
    private void construirPrimerPanel(Limitacion limite){
        imagenLogueo = new IUEtiquetaI("src/imagenes/logearse.png", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(98)));
        primerPanel.add(imagenLogueo);
        
        iuMensaje = new IUAreaTexto("lo siento...! el nombre de usuario o password es INCORRECTO.", new Limitacion(limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(70), limite.getPorcentajeAncho(53), limite.getPorcentajeAlto(24)));
        iuMensaje.setBorder(null);
        iuMensaje.setForeground(new Color(100, 0, 0));
        primerPanel.add(iuMensaje);
        iuMensaje.setVisible(false);
    }
    private void construirSegundoPanel(Limitacion limite){
        iuUsername = new IUPanelCT("username", "rudolf", new Limitacion(limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(20)), 40, 60);
        segundoPanel.add(iuUsername);
        
        iuPassword = new IUPanelPT("password", "rudolf", new Limitacion(limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(55), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(20)), 40, 60);
        segundoPanel.add(iuPassword);
    }
    private void construirTercerPanel(Limitacion limite){
        botonIniciar = new IUBotonIT("iniciar sesion", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(25), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(50)));
        tercerPanel.add(botonIniciar);
    }
    private void setEventos(){
        iuUsername.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(iuMensaje.isVisible()){
                        iuMensaje.setVisible(false);
                        imagenLogueo.setUrlImagen("src/imagenes/logearse.png");
                    }
                }
            }
        });
        iuPassword.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(estaValidado()){
                        if(controlLogueo.esCorrectoLogueo()){
                            estado = true;
                            dispose();
                        }else
                            mostrarErrorLogueo();
                    }else
                        transferFocus();
                }
            }
        });
        botonIniciar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {                
                if(estaValidado()){
                    if(controlLogueo.esCorrectoLogueo()){
                        estado = true;
                        dispose();
                    }else
                        mostrarErrorLogueo();
                }
            }
        });
    }
    private boolean estaValidado(){
        boolean verificador = false;        
        if(!iuUsername.getTexto().isEmpty() && !iuPassword.getTexto().isEmpty())
            verificador = true;        
        return verificador;
    }
    private void mostrarErrorLogueo(){
        iuUsername.iuTexto.setText("");
        iuPassword.iuTexto.setText("");
        iuMensaje.setVisible(true);
        imagenLogueo.setUrlImagen("src/imagenes/peligro.png");
    }
    public boolean getEstado(){
        return estado;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return usuario;
    }
}