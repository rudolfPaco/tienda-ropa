/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.controlador;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.UsuarioDao;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import fasttienda.bo.com.tiendaAbrigos.vista.logueo.IULogueo;

/**
 *
 * @author rudolf
 */
public class CLogueo {
    
    private IULogueo iuLogueo;
    
    public CLogueo(){
        iuLogueo = null;
    }
    public void controlarIULogueo(IULogueo iuLogueo){
        this.iuLogueo = iuLogueo;
    }
    public boolean esCorrectoLogueo(){
        boolean verificador = false;
        String username = iuLogueo.iuUsername.getTexto();
        String password = iuLogueo.iuPassword.getTexto();
        
        Conexion conexion = new Conexion();
        UsuarioDao usuarioDao = new UsuarioDao(conexion);
        Usuario usuario = usuarioDao.obtenerUsuario(username, password);
        if(usuario != null){
            iuLogueo.setUsuario(usuario);
            verificador = true;
        }
        conexion.cerrarConexion();
        
        return verificador;
    }
}
