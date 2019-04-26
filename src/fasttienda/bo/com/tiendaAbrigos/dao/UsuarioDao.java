/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.modelo.Empleado;
import fasttienda.bo.com.tiendaAbrigos.modelo.Persona;
import fasttienda.bo.com.tiendaAbrigos.modelo.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rudolf
 */
public class UsuarioDao {
    private final Conexion conexion;

    public UsuarioDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public Usuario obtenerUsuario(String username, String password){
        Usuario usuario = null;
        try {
            String sql = "select * from usuario where username = ? and password = md5(?) limit 1";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("UsuarioID"));                
                usuario.setUsername(rs.getString("Username"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setEmpleadoID(rs.getInt("EmpleadoID"));
                usuario.setPersonaID(rs.getInt("PersonaID"));
                usuario.setEmpleado(obtenerEmpleado(usuario.getEmpleadoID()));                
            }
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Empleado obtenerEmpleado(int empleadoID){
        Empleado empleado = null;
        try {
            String sql = "select * from empleado where EmpleadoID = "+empleadoID+"";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                empleado = new Empleado(rs.getInt("EmpleadoID"));
                empleado.setCargoEmpleado(rs.getString("CargoEmpleado"));
                empleado.setFechaContratacion(rs.getString("FechaContratacion"));
                empleado.setEstado(rs.getString("Estado"));
                empleado.setPersonaID(rs.getInt("PersonaID"));                
                empleado.setPersona(obtenerPersona(empleado.getEmpleadoID()));
            }
            return empleado;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Persona obtenerPersona(int personaID){
        Persona persona = null;
        try {
            String sql = "select * from persona where PersonaID = "+personaID+"";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                persona = new Persona(rs.getInt("PersonaID"));
                persona.setNombres(rs.getString("Nombres"));
                persona.setApellidos(rs.getString("Apellidos"));
                persona.setCarnetIdentidad(rs.getString("CarnetIdentidad"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setTelefonos(rs.getString("Telefonos"));
                persona.setEmail(rs.getString("Email"));
                persona.setUrlFoto(rs.getString("UrlFoto"));                
            }
            return persona;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*public Usuario buscarUsuario(int idUsuario){
        Usuario usuario = getUsuario("select * from usuario where id = "+idUsuario);
        return usuario;
    }
    public Usuario buscarUsuario(String nombreUsuario){
        Usuario usuario = getUsuario("select * from usuario where nombreUsuario = '"+nombreUsuario+"'");
        return usuario;
    }    
    public ArrayList<Usuario> getListaUsuarios(String sql){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            Usuario usuario = null;
            while (rs.next()) {
                usuario = buscarUsuario(rs.getInt("id"));
                lista.add(usuario);
            }
            return lista;

        } catch (SQLException e) {            
            System.out.println("Error UsuarioDao.getListaUsuarios: " + e.getMessage());
            return lista;
        }        
    }*/
    public boolean seGuardoPersonaCorrectamente(Persona p){
        boolean verificador = false;
        String sql = "insert into persona values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);                                    
            File file = new File(p.getUrlFoto());
            FileInputStream archivo = new FileInputStream(file);

            ps.setInt(1, p.getPersonaID());
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getApellidos());
            ps.setString(4, p.getCarnetIdentidad());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefonos());
            ps.setString(7, p.getEmail());
            ps.setString(8, p.getUrlFoto());
            ps.setBinaryStream(9, archivo, file.length());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.seGuardoPersonaCorrectamente(): "+e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificador;
    }
    public boolean seGuardoEmpleadoCorrectamente(Empleado empleado){
        boolean verificador = false;
        String sql = "insert into empleado values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            
                        
            ps.setInt(1, empleado.getEmpleadoID());
            ps.setString(2, empleado.getCargoEmpleado());
            ps.setString(3, empleado.getFechaContratacion());
            ps.setString(4, empleado.getEstado());
            ps.setInt(5, empleado.getPersonaID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.seGuardoEmpleadoCorrectamente(): "+e.getMessage());
        }
        return verificador;
    }
    public boolean seGuardoUsuarioCorrectamente(Usuario usuario){
        boolean verificador = false;
        String sql = "insert into usuario values(?, ?, md5(?), ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            
                        
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getEmpleadoID());
            ps.setInt(5, usuario.getPersonaID());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.seGuardoUsuarioCorrectamente(): "+e.getMessage());
        }
        return verificador;
    }
    /*
    public boolean seModificoUsuarioCorrectamente(Usuario t){
        boolean verificador = false;
        String sql = "UPDATE usuario SET nombreUsuario=?, cargoUsuario=?, username=?, password=?, email=?, urlFoto=?, foto=?, estado=? WHERE `id`='"+t.getId()+"';";        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            File file = new File(t.getUrlFoto());
            FileInputStream archivo = new FileInputStream(file);
            
            ps.setString(1, t.getNombreUsuario());
            ps.setString(2, t.getCargoUsuario());
            ps.setString(3, t.getUsername());
            ps.setString(4, t.getPassword());
            ps.setString(5, t.getEmail());
            ps.setString(6, t.getUrlFoto());
            ps.setBinaryStream(7, archivo, file.length());
            ps.setString(8, t.getEstado());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error UsuarioDao.seModificoUsuarioCorrectamente(): "+e.getMessage());
        }
        return verificador;
    }
    /*public RegistroUsuarios getRegistroUsuarios(int caja_id, int usuario_id){
        RegistroUsuarios registro = null;
        try {
            String sql = "select * from registrousuarios where caja_id = "+caja_id+" and usuario_id = "+usuario_id+" and  fecha = '"+new Fecha().fecha()+"';";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                registro = new RegistroUsuarios(rs.getInt("id"));
                registro.setFecha(rs.getString("fecha"));
                registro.setNombreUsuario(rs.getString("nombreUsuario"));
                registro.setCargoUsuario(rs.getString("cargoUsuario"));
                registro.setTotalGastos(rs.getDouble("totalGastos"));
                registro.setTotalVentas(rs.getDouble("totalVentas"));
                registro.setCaja_id(rs.getInt("caja_id"));                
                registro.setUsuario_id(rs.getInt("usuario_id"));
            }
            return registro;

        } catch (SQLException e) {            
            System.out.println("Error UsuarioDao.getRegistroUsuarios: " + e.getMessage());
            return registro;
        }        
    }
    
    public ArrayList<RegistroUsuarios> getListaRegistroUsuarios(String sql){
        ArrayList<RegistroUsuarios> listaRegistros = new ArrayList<>();
        try {            
            System.out.println(sql);
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            RegistroUsuarios registro = null;
            while (rs.next()) {
                registro = new RegistroUsuarios(rs.getInt("id"));
                registro.setFecha(rs.getString("fecha"));
                registro.setNombreUsuario(rs.getString("nombreUsuario"));
                registro.setCargoUsuario(rs.getString("cargoUsuario"));
                registro.setTotalGastos(rs.getDouble("totalGastos"));
                registro.setTotalVentas(rs.getDouble("totalVentas"));
                registro.setCaja_id(rs.getInt("caja_id"));                
                registro.setUsuario_id(rs.getInt("usuario_id"));                
                registro.setListaActividades(getActividadUsuario(rs.getInt("id"), rs.getInt("caja_id"), rs.getInt("usuario_id")));
                
                listaRegistros.add(registro);
            }
        } catch (SQLException e) {            
            System.out.println("Error UsuarioDao.getListaUsuarios: " + e.getMessage());            
        }
        return listaRegistros;
    }
    public ArrayList<ActividadesUsuario> getActividadUsuario(int registroUsuarios_id, int caja_id, int usuario_id){
        ArrayList<ActividadesUsuario> listaActividades = new ArrayList<>();
        try {
            String sql = "select * from actividadesusuario where registroUsuarios_id = "+registroUsuarios_id+" and caja_id = "+caja_id+" and usuario_id = "+usuario_id+" order by id desc;";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            ActividadesUsuario actividad = null;
            while (rs.next()) {
                actividad = new ActividadesUsuario(rs.getInt("id"));
                actividad.setHora(rs.getString("hora"));
                actividad.setActividad(rs.getString("actividad"));
                actividad.setObservacion(rs.getString("observacion"));
                actividad.setRegistroUsuarios_id(registroUsuarios_id);
                actividad.setLibroVentasDiarias_id(caja_id);
                actividad.setUsuario_id(usuario_id);
                
                listaActividades.add(actividad);
            }
        } catch (SQLException e) {            
            System.out.println("Error UsuarioDao.getActividadUsuario: " + e.getMessage());            
        }
        return listaActividades;
    }
    public boolean insertRegistroUsuarios(RegistroUsuarios registro){
        boolean verificador = false;
        try {
            String sql = "insert into registroUsuarios values ( ?, ?, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, registro.getId());
            ps.setString(2, registro.getFecha());
            ps.setString(3, registro.getNombreUsuario());
            ps.setString(4, registro.getCargoUsuario());
            ps.setDouble(5, registro.getTotalGastos());
            ps.setDouble(6, registro.getTotalVentas());
            ps.setInt(7, registro.getCaja_id());
            ps.setInt(8, registro.getUsuario_id());
            
            ps.executeUpdate();
            verificador = true;

        } catch (SQLException e) {
            System.out.println("Error TiendaDao.insertRegistroUsuarios: " + e.getMessage());            
        }
        return verificador;
    }
    public boolean modifyUsuario(Usuario u){
        boolean verificador = false;
        FileInputStream flujoEntrada = null;
        String sql = "UPDATE `libreriafelipez`.`usuario` SET `nombre`=?, `email`=?, `username`=?, `password`=?, `cargo`=?, `estado`=?, `urlFoto`=?, `foto`=? WHERE `id`="+u.getId()+";";
        System.out.println(sql);
        System.out.println(u.toString());
        try {
            if(!u.getUrlFoto().isEmpty())
                flujoEntrada = new FileInputStream(new File(u.getUrlFoto()));
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getCargoUsuario());
            ps.setString(6, u.getEstado());
            ps.setString(7, u.getUrlFoto());
            if(!u.getUrlFoto().isEmpty())
                ps.setBinaryStream(8, flujoEntrada, new File(u.getUrlFoto()).length());
            else
                ps.setBinaryStream(8, null, 0);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.modifyUsuario: "+e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificador;
    }
    public boolean insertUsuario(Usuario usuario){
        boolean verificador = false;
        FileInputStream flujoEntrada = null;
        try {
            String sql = "insert into usuario values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";            
            if(!usuario.getUrlFoto().isEmpty() && usuario.getUrlFoto() != null)
                flujoEntrada = new FileInputStream(new File(usuario.getUrlFoto()));
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getUsername());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, usuario.getCargoUsuario());
            ps.setString(7, usuario.getEstado());
            ps.setString(8, usuario.getUrlFoto());
            
            if(!usuario.getUrlFoto().isEmpty() && usuario.getUrlFoto() != null)
                ps.setBinaryStream(9, flujoEntrada, new File(usuario.getUrlFoto()).length());
            else
                ps.setBinaryStream(9, null, 0);
            
            ps.executeUpdate();
            verificador = true;

        } catch (SQLException e) {
            System.out.println("Error TiendaDao.insertUsuario: " + e.getMessage());            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificador;
    }
    public boolean insertActividadUsuario(ActividadesUsuario actividad){
        boolean verificador = false;
        try {
            String sql = "insert into actividadesUsuario values ( ?, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, actividad.getId());
            ps.setString(2, actividad.getHora());
            ps.setString(3, actividad.getActividad());
            ps.setString(4, actividad.getObservacion());
            ps.setInt(5, actividad.getRegistroUsuarios_id());
            ps.setInt(6, actividad.getLibroVentasDiarias_id());
            ps.setInt(7, actividad.getUsuario_id());
            
            ps.executeUpdate();
            verificador = true;

        } catch (SQLException e) {
            System.out.println("Error TiendaDao.insertActividadUsuario: " + e.getMessage());            
        }
        return verificador;
    }

    public void descargarFotosUsuarios(){
        try {
            String sql = "select * from usuario";
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            
                while (rs.next()) {                
                    if(!rs.getString("urlFoto").isEmpty()){
                        File archivo = new File(rs.getString("urlFoto"));
                        Blob campo = rs.getBlob("foto");
                        InputStream flujoDatos = campo.getBinaryStream();
                        try (BufferedInputStream entrada = new BufferedInputStream(flujoDatos); BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(archivo))) {
                            byte[] bytes = new byte[8096];
                            int len = 0;

                            while ( (len = entrada.read( bytes ))> 0 ){
                                salida.write( bytes, 0, len );
                            }

                            salida.flush();
                        } catch (IOException ex) {
                            System.out.println("error...! descargarFotosUsuarios: "+ex.getMessage());
                        }
                    }                    
                }            
        } catch (SQLException e) {
            System.out.println("Error HabitacionDao.descargarFotosUsuarios: " + e.getMessage());
        }
    }*/
}
