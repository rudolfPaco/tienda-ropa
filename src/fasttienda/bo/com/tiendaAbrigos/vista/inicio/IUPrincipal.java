/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.inicio;

import com.aplicacionjava.www.botones.IUBotonToggle;
import com.aplicacionjava.www.etiquetas.IUEtiqueta;
import com.aplicacionjava.www.etiquetas.IUEtiquetaI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaP;
import fasttienda.bo.com.tiendaAbrigos.controlador.CModuloUsuarios;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrenda;
import fasttienda.bo.com.tiendaAbrigos.controlador.CPrincipal;
import fasttienda.bo.com.tiendaAbrigos.controlador.CVenta;
import fasttienda.bo.com.tiendaAbrigos.modelo.Caja;
import fasttienda.bo.com.tiendaAbrigos.modelo.Registro;
import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import fasttienda.bo.com.tiendaAbrigos.vista.prendas.IUModuloPrendas;
import fasttienda.bo.com.tiendaAbrigos.vista.usuarios.IUModuloUsuarios;
import fasttienda.bo.com.tiendaAbrigos.vista.ventas.IUModuloVentas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUPrincipal extends IUVentanaP{
    
    private CPrincipal controlPrincipal;
    
    private IUEtiquetaI iuLogo;
    public ArrayList<IUBotonToggle> botones;
    private IUPanelBD panelUsuario;
    private IUEtiquetaI iuIconoUsuario;
    private IUEtiqueta iuTituloUsuario;
    private IUPanelCT iuNombreUsuario;
    private IUPanelCT iuCargoUsuario;
    private IUPanel panelLateral;
    
    private CardLayout administrador;    
    private IUPanel panelPrincipal;
    public IUPanelBD panelConfiguracion;
    public IUPanelBD panelCaja;
    public IUPanelBD panelClientes;
    public IUModuloVentas panelVentas;
    public IUModuloPrendas panelPrendas;
    public IUPanelBD panelProveedores;
    public IUPanelBD panelCompras;
    public IUPanelBD panelReportes;
    
    public CModuloUsuarios controlModuloUsuarios;
    public IUModuloUsuarios moduloUsuarios;
    public IUPanelBD panelKardex;
    
    public IUPrincipal(CPrincipal controlPrincipal, String titulo) {
        super(titulo);
        this.controlPrincipal = controlPrincipal;
        
        construirPaneles(panelFondo.getLimitacion());
        setEventos();
    }
    private void construirPaneles(Limitacion limite){
        panelLateral = new IUPanel(new Limitacion(limite.getPorcentajeAncho(15), limite.getAlto()));
        panelFondo.add(panelLateral);
        construirPanelLateral(panelLateral.getLimitacion());
        
        administrador = new CardLayout();        
        panelPrincipal = new IUPanel(new Limitacion(limite.getPorcentajeAncho(15), 0, limite.getPorcentajeAncho(85), limite.getAlto()));
        panelPrincipal.setLayout(administrador);
        panelFondo.add(panelPrincipal);
        construirPanelAdministrador(panelPrincipal.getLimitacion());
    }
    private void construirPanelLateral(Limitacion limite){
        iuLogo = new IUEtiquetaI("", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(13)));        
        panelLateral.add(iuLogo);
        
        botones = new ArrayList<>();        
        int y = 15;
        String[] nombres = {"configuracion","caja","clientes","ventas","prendas","proveedores","compras","reportes","usuarios","inventario"};
        String[] iconos = {"icono.png","cajero.png","clientes.png","ventas.png","producto.png","proveedores.png","comprar.png","reportes.png","usuarios.png","inventario.png"};
        for (int i = 0; i < 10; i++) {
            IUBotonToggle boton = new IUBotonToggle(nombres[i], "src/imagenes/"+iconos[i], new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(y + i*6), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(4)), false);
            botones.add(boton);
            panelLateral.add(boton);
        }
        botones.get(1).setPresionado(true);
                        
        panelUsuario = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(75), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(24)));        
        panelLateral.add(panelUsuario);
        construirPanelUsuario(panelUsuario.getLimitacion());
    }
    private void construirPanelUsuario(Limitacion limite){
        iuTituloUsuario = new IUEtiqueta("inicio de sesion", new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(10)));
        iuTituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        iuTituloUsuario.setForeground(new Color(120, 0, 0));
        iuTituloUsuario.setFont(new Font("Verdana", Font.BOLD, limite.getPorcentajeAlto(7)));
        panelUsuario.add(iuTituloUsuario);

        iuIconoUsuario = new IUEtiquetaI("", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(15), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(30)));
        panelUsuario.add(iuIconoUsuario);
        
        iuNombreUsuario = new IUPanelCT("nombre de usuario", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(53), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(20)), 40, 60);
        iuNombreUsuario.iuTexto.setEditable(false);
        panelUsuario.add(iuNombreUsuario);
        
        iuCargoUsuario = new IUPanelCT("cargo de usuario", "", new Limitacion(limite.getPorcentajeAncho(2), limite.getPorcentajeAlto(75), limite.getPorcentajeAncho(96), limite.getPorcentajeAlto(20)), 40, 60);
        iuCargoUsuario.iuTexto.setEditable(false);
        panelUsuario.add(iuCargoUsuario);
        
    }
    private void construirPanelAdministrador(Limitacion limite){        
        panelConfiguracion = new IUPanelBD(limite);
        panelPrincipal.add(panelConfiguracion);
                
        panelCaja = new IUPanelBD(limite);
        panelPrincipal.add(panelCaja);
        
        panelClientes = new IUPanelBD(limite);
        panelPrincipal.add(panelClientes);
        
        CVenta controlVentas = new CVenta();
        panelVentas = new IUModuloVentas(controlVentas, this, new Limitacion(limite.getAncho(), limite.getAlto()));
        panelPrincipal.add(panelVentas);        
        
        CPrenda controlPrendas = new CPrenda();
        panelPrendas = new IUModuloPrendas(controlPrendas, this, new Limitacion(limite.getAncho(), limite.getAlto()));
        controlPrendas.controlarIUModuloPrendas(panelPrendas);        
        panelPrincipal.add(panelPrendas);
        
        panelProveedores = new IUPanelBD(limite);
        panelPrincipal.add(panelProveedores);
        
        panelCompras = new IUPanelBD(limite);
        panelPrincipal.add(panelCompras);
        
        panelReportes = new IUPanelBD(limite);
        panelPrincipal.add(panelReportes);
        
        controlModuloUsuarios = new CModuloUsuarios();
        moduloUsuarios = new IUModuloUsuarios(controlModuloUsuarios, new Limitacion(limite.getAncho(), limite.getAlto()));
        controlModuloUsuarios.controlarModuloUsuarios(moduloUsuarios);
        panelPrincipal.add(moduloUsuarios);
        
        panelKardex = new IUPanelBD(limite);
        panelPrincipal.add(panelKardex);
    }
    private void seleccionarBoton(int indice){
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setPresionado(false);            
        }
        botones.get(indice).setPresionado(true);
    }
    private void setEventos(){
        
        botones.get(0).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {                
                seleccionarBoton(0);                
                administrador.first(panelPrincipal);
            }
        });
        botones.get(1).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(1);                
                administrador.first(panelPrincipal);
                administrador.next(panelPrincipal);
            }
        });
        botones.get(2).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(2);
                administrador.first(panelPrincipal);
                administrador.next(panelPrincipal);
                administrador.next(panelPrincipal);
            }
        });
        botones.get(3).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(3);
                administrador.first(panelPrincipal);
                administrador.next(panelPrincipal);
                administrador.next(panelPrincipal);
                administrador.next(panelPrincipal);
            }
        });
        
        botones.get(4).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(4);
                administrador.last(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);                
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
            }
        });
        botones.get(5).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(5);
                administrador.last(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
            }
        });
        botones.get(6).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(6);
                administrador.last(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
            }
        });
        botones.get(7).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(7);
                administrador.last(panelPrincipal);
                administrador.previous(panelPrincipal);
                administrador.previous(panelPrincipal);
            }
        });        
        botones.get(8).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(8);
                administrador.last(panelPrincipal);                
                administrador.previous(panelPrincipal);
            }
        });
        
        botones.get(9).addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seleccionarBoton(9);
                administrador.last(panelPrincipal);                
            }
        });
    }    
    public void cargarDatosSistema(){
        Usuario usuario = controlPrincipal.getUsuario();
        Tienda tienda = controlPrincipal.getTienda();
        ArrayList<Registro> listaResponsables = controlPrincipal.getListaRegistros();
        Caja caja = controlPrincipal.getCaja();
        
        iuLogo.setUrlImagen(controlPrincipal.getTienda().getUrlLogo());
        iuIconoUsuario.setUrlImagen(controlPrincipal.getUsuario().getEmpleado().getPersona().getUrlFoto());
        iuNombreUsuario.iuTexto.setText(usuario.getEmpleado().getPersona().getNombres()+" "+usuario.getEmpleado().getPersona().getApellidos());
        iuCargoUsuario.iuTexto.setText(usuario.getEmpleado().getCargoEmpleado());
        moduloUsuarios.agregarUsuarioActual(usuario);
    }
    public CPrincipal getCPrincipal(){
        return controlPrincipal;
    }
}