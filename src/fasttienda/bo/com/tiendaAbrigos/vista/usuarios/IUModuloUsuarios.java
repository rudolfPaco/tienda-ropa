/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.usuarios;

import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.recursos.Limitacion;
import fasttienda.bo.com.tiendaAbrigos.controlador.CModuloUsuarios;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author rudolf
 */
public class IUModuloUsuarios extends IUPanel{
    
    private CModuloUsuarios controlModuloUsuarios;
    
    private IUPanelBD panelUsuario;
    private IUPanelCD panelDatos;
    private IUEtiqueta titulo;
    private IUEtiquetaI imagen;
    private IUPanelCT nombreCompleto;
    private IUPanelCT carnetIdentidad;    
    private IUPanelCT telefonos;
    private IUPanelCT email;
    private IUPanelCT direccion;
    
    private IUPanelCT username;
    private IUPanelCT cargo;
    
    private IUPanelBD panelContenedorUsuarios;
    
    public IUModuloUsuarios(CModuloUsuarios controlModuloUsuarios, Limitacion limitacion) {
        super(limitacion);
        this.controlModuloUsuarios = controlModuloUsuarios;
        construirPaneles();
    }
    private void construirPaneles(){
        panelUsuario = new IUPanelBD(new Limitacion(limitacion.getPorcentajeAncho(1), limitacion.getPorcentajeAlto(1), limitacion.getPorcentajeAncho(28), limitacion.getPorcentajeAlto(98)));
        add(panelUsuario);  
        construirPanelUsuario(panelUsuario.getLimitacion());
        
        panelContenedorUsuarios = new IUPanelBD(new Limitacion(limitacion.getPorcentajeAncho(29), limitacion.getPorcentajeAlto(1), limitacion.getPorcentajeAncho(70), limitacion.getPorcentajeAlto(98)));
        add(panelContenedorUsuarios);
    }
    private void construirPanelUsuario(Limitacion limite){
        titulo = new IUEtiqueta("Usuario Actual", new Limitacion(limite.getAncho(), limite.getPorcentajeAlto(5)));
        titulo.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(4)));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelUsuario.add(titulo);
        
        imagen = new IUEtiquetaI("src/imagenes/user.png", new Limitacion(limite.getPorcentajeAncho(25), limite.getPorcentajeAlto(8), limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(27)));
        imagen.setBorder(new LineBorder(new Color(120, 120, 120)));        
        panelUsuario.add(imagen);
        
        nombreCompleto = new IUPanelCT("nombre completo", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(40), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(5)), 40, 60);
        nombreCompleto.iuTexto.setEditable(false);
        panelUsuario.add(nombreCompleto);
        
        carnetIdentidad = new IUPanelCT("carnet identidad", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(46), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(5)), 40, 60);
        carnetIdentidad.iuTexto.setEditable(false);
        panelUsuario.add(carnetIdentidad);
        
        telefonos = new IUPanelCT("telefonos", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(54), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(5)), 40, 60);
        telefonos.iuTexto.setEditable(false);
        panelUsuario.add(telefonos);
        
        email = new IUPanelCT("email", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(61), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(5)), 40, 60);
        email.iuTexto.setEditable(false);
        panelUsuario.add(email);
        
        direccion = new IUPanelCT("direccion", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(68), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(5)), 40, 60);
        direccion.iuTexto.setEditable(false);
        panelUsuario.add(direccion);
        
        username = new IUPanelCT("usuario", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(84), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(5)), 40, 60);
        username.iuTexto.setEditable(false);
        panelUsuario.add(username);
        
        cargo = new IUPanelCT("cargo", "", new Limitacion(limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(91), limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(5)), 40, 60);
        cargo.iuTexto.setEditable(false);
        panelUsuario.add(cargo);
    }
    public void agregarUsuarioActual(Usuario usuario){
        imagen.setUrlImagen(usuario.getEmpleado().getPersona().getUrlFoto());
        nombreCompleto.iuTexto.setText(usuario.getEmpleado().getPersona().getNombres()+" "+usuario.getEmpleado().getPersona().getApellidos());
        carnetIdentidad.iuTexto.setText(usuario.getEmpleado().getPersona().getCarnetIdentidad());
        telefonos.iuTexto.setText(usuario.getEmpleado().getPersona().getTelefonos());
        email.iuTexto.setText(usuario.getEmpleado().getPersona().getEmail());
        direccion.iuTexto.setText(usuario.getEmpleado().getPersona().getDireccion());
        username.iuTexto.setText(usuario.getUsername());
        cargo.iuTexto.setText(usuario.getEmpleado().getCargoEmpleado());
    }
    
}
