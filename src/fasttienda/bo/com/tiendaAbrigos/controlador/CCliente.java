/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.dao.ClienteDao;
import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.modelo.Cliente;
import fasttienda.bo.com.tiendaAbrigos.vista.clientes.IUModuloCliente;
import java.util.ArrayList;

/**
 *
 * @author hotel-felipez
 */
public class CCliente {
    
    public IUModuloCliente iuCliente;
    
    public CCliente(){
        iuCliente = null;
    }
    public void controlarIUModuloCliente(IUModuloCliente iuCliente){
        this.iuCliente = iuCliente;        
    }
    public ArrayList<Cliente> getListaClientes(){
        Conexion conexion = new Conexion();
        ClienteDao clienteDao = new ClienteDao(conexion);
        ArrayList<Cliente> lista = clienteDao.getListaClientes();        
        conexion.cerrarConexion();
        return lista;
    }
    public boolean guardarCliente(Cliente cliente){
        boolean verificador = false;
        if(cliente.guardarNuevo()){
            verificador = true;
            Ayuda.mensajeVerificacion(iuCliente.getIUPrincipal(), "aviso", "en buena hora... se guardo el nuevo cliente correctamente...!", "advertencia");
        }
        return verificador;
    }
}
