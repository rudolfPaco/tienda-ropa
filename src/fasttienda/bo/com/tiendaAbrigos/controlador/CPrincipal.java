/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaM;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Caja;
import fasttienda.bo.com.tiendaAbrigos.modelo.Registro;
import fasttienda.bo.com.tiendaAbrigos.modelo.Tienda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import fasttienda.bo.com.tiendaAbrigos.vista.logueo.IULogueo;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IURegistroPrincipal;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class CPrincipal {
    private Tienda tienda;
    private Usuario usuario;
    private Caja caja;
    private ArrayList<Registro> listaRegistros;
    private IUPrincipal iuPrincipal;
    
    
    public CPrincipal() { 
        tienda = null;
        usuario = null;
        caja = null;
        listaRegistros = new ArrayList<>();
        iuPrincipal = new IUPrincipal(this, "crear sistema de inventario desde cero");        
    }
    public void algoritmoInicioPrincipal(){
        //consulta si ya existe un usuario logueado anteriormente.
        //si existe, obtiene al usuario anterior y recupera todas las funciones respectivas.
        //caso contrario se loguea un nuevo usuario.
        //en cualquiera de los casos, se debe agregar el usuario encontrado al sistema.
        
        if(existeTienda()){      
            if(logueadoEsCorrecto()){
                switch(tienda.getEstadoTienda()){
                    case "ABIERTO":
                        //pregunta si el usuario logueado es el mismo usuario que esta a cargo o activo en la tienda
                        //SI. entrar al sistema y recuperar los datos vinculados al usuario a cargo.
                        //NO. el sistema bloquear al usuario logueado... y cerrar sistema.
                        if(esCorrectoSesionEmpleadoActivo())
                            if(seRecuperoCajaInicial())
                                iniciarSistema();
                        else
                            Ayuda.mensajeVerificacion(iuPrincipal, "peligro", "lo siento... pero no puede ingresar al sistema. por que usted no inicio sesion en el sistema correctamente.", "advertencia");
                    break;
                        
                    case "CERRADO":
                        if(seCreoNuevaCaja())
                            if(seCreoNuevoResponsable("inicio apertura"))
                                if(setEstadoTienda("ABIERTO"))
                                    iniciarSistema();
                                
                    break;
                }
            }else
                iuPrincipal.salirSistema();
        }else{            
            crearDatosPrincipales();
        }                
    }    
    private void iniciarSistema(){
        switch(usuario.getEmpleado().getCargoEmpleado()){
            case "administrador":
                iuPrincipal.cargarDatosSistema();
                iuPrincipal.mostrarVentana();
            break;
            
        }
    }
    private boolean existeTienda(){
        boolean verificador = false;
        tienda = Tienda.getTiendaExistente();
        if(tienda != null)
            verificador = true;
        return verificador;
    }
    
    private void crearDatosPrincipales(){
        
        IUVentanaM iuMensaje = new IUVentanaM(iuPrincipal, new Limitacion(Ayuda.ancho/2, Ayuda.alto/2), "informacion", "Hola... en hora buena... para iniciar el sistema de inventarios, debe crear una nueva tienda. despues es necesario crear un nuevo usuario administrador. \nmuchas gracias.", "informacion", 10);
        iuMensaje.mostrarVentana();        
        if(iuMensaje.getEstado()){
            CRegistroPrincipal controlRegistroPrincipal = new CRegistroPrincipal();
            
            IURegistroPrincipal iuRegistro = new IURegistroPrincipal(iuPrincipal, controlRegistroPrincipal, "ventana principal para el registro de datos", new Limitacion(Ayuda.ancho/2, Ayuda.alto), 4);
            controlRegistroPrincipal.controlarRegistroPrincipal(iuRegistro);
            
            iuRegistro.mostrarVentana();
        }        
    }
    private boolean logueadoEsCorrecto(){
        boolean verificador = false;
        CLogueo controlLogueo = new CLogueo();
        
        IULogueo iuLogueo = new IULogueo(iuPrincipal, controlLogueo, "loguearse", new Limitacion(Ayuda.ancho/3, Ayuda.alto - Ayuda.alto/5), 10);
        controlLogueo.controlarIULogueo(iuLogueo);
        iuLogueo.mostrarVentana();
        
        if(iuLogueo.getEstado()){
            verificador = true;
            usuario = iuLogueo.getUsuario();
        }            
                
        return verificador;
    }
    private boolean seRecuperoCajaInicial(){
        boolean verificador = false;        
        if(caja.recuperarDatos())
            verificador = true;
        return verificador;
    }
    private boolean seCreoNuevaCaja(){
        boolean verificador = false;
        
        caja = new Caja(0);
        if(caja.seCreoCajaNueva(tienda.getTiendaID())){
            verificador = true;
        }
        return verificador;
    }
    private boolean seCreoNuevoResponsable(String tipo){
        boolean verificador = false;
        switch(tipo){
            case "inicio apertura":
                Registro responsable = new Registro(0);
                if(responsable.seCreoNuevoRegistro(usuario.getEmpleadoID(), caja.getCajaID(), tipo)){
                    listaRegistros.add(responsable);
                    verificador = true;
                }
            break;
            case "arqueo caja":
            break;
            case "cierre apertura":
            break;
        }
        return verificador;
    }    
    private boolean setEstadoTienda(String estado){
        boolean verificador = false;
        tienda.setEstadoTienda(estado);
        if(tienda.modificarDatos())
            verificador = true;
        return verificador;
    }
    private void listarRegistros(){
        Registro registro = new Registro(0);
        if(registro.seCargoDatosRegistroActivo()){
            caja = new Caja(registro.getCajaID());
            listaRegistros = registro.getListaRegistros(registro.getCajaID());
        }        
    }
    private boolean esCorrectoSesionEmpleadoActivo(){
        boolean verificador = false;
        listarRegistros();
        
        for (int i = 0; i < listaRegistros.size(); i++) {
            Registro registro = listaRegistros.get(i);
            if(registro.getEstado().equalsIgnoreCase("activo")){
                if(registro.getEmpleadoID() == usuario.getEmpleadoID()){
                    verificador = true;
                }
            }
        }
        return verificador;
    }
    
    public Tienda getTienda() {
        if(tienda == null)
            tienda = Tienda.getTiendaExistente();
        return tienda;
    }
    public Usuario getUsuario() {        
        return usuario;
    }
    public Caja getCaja() {
        return caja;
    }
    public ArrayList<Registro> getListaRegistros() {
        return listaRegistros;
    }
}