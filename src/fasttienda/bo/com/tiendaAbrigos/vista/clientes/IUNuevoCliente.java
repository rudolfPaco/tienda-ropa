/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.clientes;

import com.aplicacionjava.www.botones.IUBotonTI;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Cliente;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author neo
 */
public class IUNuevoCliente extends IUVentanaT{
    
    
    private IUPrincipal ventanaPrincipal;
    private IUPanelBD primerPanel;
    private IUPanelCT iuNombreRazonSocial;
    private IUPanelCT iuNitCi;
    private IUPanelBD segundoPanel;
    private IUPanelCT iuNombre;
    private IUPanelCT iuDireccion;
    private IUPanelCT iuTelefonoCelular;
    private IUPanelCT iuTelefonoFijo;
    private IUPanelCT iuAntecedentes;
    private IUPanel tercerPanel;
    private IUBotonTI botonSalir;
    private IUBotonTI botonGuardar;
    private boolean estado;
        
    public IUNuevoCliente(IUPrincipal ventanaPrincipal, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.ventanaPrincipal = ventanaPrincipal;
        this.estado = false;
        construirPaneles(panelFondo.getLimitacion());
        escucharEvento();
    }
    private void construirPaneles(Limitacion limite){
        primerPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(3), limite.getPorcentajeAlto(3), limite.getPorcentajeAncho(94), limite.getPorcentajeAlto(15)));
        panelFondo.add(primerPanel);
        construirPrimerPanel(primerPanel.getLimitacion());
        
        segundoPanel = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(3), limite.getPorcentajeAlto(21), limite.getPorcentajeAncho(94), limite.getPorcentajeAlto(60)));
        panelFondo.add(segundoPanel);
        construirSegundoPanel(segundoPanel.getLimitacion());
        
        tercerPanel = new IUPanel(new Limitacion(limite.getPorcentajeAncho(3), limite.getPorcentajeAlto(82), limite.getPorcentajeAncho(94), limite.getPorcentajeAlto(16)));
        panelFondo.add(tercerPanel);
        construirTercerPanel(tercerPanel.getLimitacion());
    }
    private void construirPrimerPanel(Limitacion limite){
        iuNombreRazonSocial = new IUPanelCT("Nombre/Razon Social", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(70), limite.getPorcentajeAlto(40)), 40, 60);
        primerPanel.add(iuNombreRazonSocial);
        
        iuNitCi = new IUPanelCT("Nit", "", new Limitacion(limite.getPorcentajeAncho(6), limite.getPorcentajeAlto(50), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(40)), 40, 60);
        iuNitCi.iuTexto.setRestriccionNumeroEnteros();
        primerPanel.add(iuNitCi);
    }
    private void construirSegundoPanel(Limitacion limite){
        iuNombre = new IUPanelCT("Nombre Completo", "Rudolf Felipez Mancilla", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(10)), 40, 60);
        iuNombre.iuTexto.setRestriccionLetras();
        segundoPanel.add(iuNombre);
        
        iuDireccion = new IUPanelCT("Direccion", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(18), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(10)), 40, 60);
        segundoPanel.add(iuDireccion);
        
        iuTelefonoCelular = new IUPanelCT("Telefono Celular", "", new Limitacion(limite.getPorcentajeAncho(6), limite.getPorcentajeAlto(33), limite.getPorcentajeAncho(35), limite.getPorcentajeAlto(10)), 40, 60);
        segundoPanel.add(iuTelefonoCelular);
        
        iuTelefonoFijo = new IUPanelCT("Telefono Fijo", "", new Limitacion(limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(33), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(10)), 40, 60);
        segundoPanel.add(iuTelefonoFijo);
        
        iuAntecedentes = new IUPanelCT("Antecedentes", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(90), limite.getPorcentajeAlto(10)), 40, 60);
        segundoPanel.add(iuAntecedentes);
    }
    private void construirTercerPanel(Limitacion limite){
        botonSalir = new IUBotonTI("salir", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(90)), 70, 70, 20);
        tercerPanel.add(botonSalir);
        
        botonGuardar = new IUBotonTI("guardar", "src/imagenes/guardar.png", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(90)), 70, 70, 20);
        tercerPanel.add(botonGuardar);
    }
    private void escucharEvento(){
        botonGuardar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(seValidoCamposDatos()){
                    estado = true;
                    dispose();
                }
            }
        });
    }    
    private boolean seValidoCamposDatos(){
        boolean verificador = false;
        if(!iuNombreRazonSocial.iuTexto.getText().isEmpty())
            if(!iuNitCi.iuTexto.getText().isEmpty())
                if(Ayuda.getDatoInt("ClienteID", "select ClienteID from cliente where RazonSocial = "+iuNombreRazonSocial.iuTexto.getText()+" and NitCi = "+iuNitCi.iuTexto.getText()) == 0)
                    verificador = true;                                    
                else{
                    Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento... pero el Nombre/Razon Social o el Nit... YA EXISTEN.... intente con otro dato.", "advertencia");                    
                }
            else
                Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento... pero no puede estar vacio el campo de datos NIT.. ", "advertencia");
        else
            Ayuda.mensajeVerificacion(ventanaPrincipal, "aviso", "lo siento... pero no puede estar vacio el campo de datos NOMBRE/RAZON SOCIAL.. ", "advertencia");
        return verificador;
    }
    public boolean getEstado(){
        return estado;
    }
    public Cliente getCliente(){
        Cliente cliente = new Cliente(0);
        cliente.setRazonSocial(iuNombreRazonSocial.iuTexto.getText());
        cliente.setNitCi(iuNitCi.iuTexto.getText());
        cliente.setNombreCliente(iuNombre.iuTexto.getText());
        cliente.setDireccionCliente(iuDireccion.iuTexto.getText());
        cliente.setTelefonoCelular(iuTelefonoCelular.iuTexto.getText());
        cliente.setTelefonoFijo(iuTelefonoFijo.iuTexto.getText());
        cliente.setAntecedentesCliente(iuAntecedentes.iuTexto.getText());
        return cliente;
    }
}
