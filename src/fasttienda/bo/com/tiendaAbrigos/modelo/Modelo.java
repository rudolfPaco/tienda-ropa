/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

import fasttienda.bo.com.tiendaAbrigos.dao.Conexion;
import fasttienda.bo.com.tiendaAbrigos.dao.ModeloDao;
import fasttienda.bo.com.tiendaAbrigos.dao.UnidadDao;
import java.util.ArrayList;

/**
 *
 * @author rudolf
 */
public class Modelo {
    private int modeloID;
    private String categoria;
    private String marca;
    private String detalle;
    private String tipoColor;
    private String colores;
    private String tallas;
    private String tela;
    private String industria;
    private String temporada;
    private Double costoUnitario;
    private Double costoUnitarioIva;
    private Double margenUtilidad;
    private Double precioTope;
    private Double precioOficial;
    private int impuestoID;
    private Impuesto impuesto;
    private ArrayList<Unidad> unidades;
        
    public Modelo(int modeloID) {
        this.modeloID = modeloID;
        this.impuesto = null;        
        this.impuestoID = 0;
        this.unidades = new ArrayList<>();
    }

    public int getModeloID() {
        return modeloID;
    }
    public void setModeloID(int modeloID) {
        this.modeloID = modeloID;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public String getTipoColor() {
        return tipoColor;
    }
    public void setTipoColor(String tipoColor) {
        this.tipoColor = tipoColor;
    }
    public String getColores() {
        return colores;
    }
    public void setColores(String colores) {
        this.colores = colores;
    }
    public String getTallas() {
        return tallas;
    }
    public void setTallas(String tallas) {
        this.tallas = tallas;
    }
    public String getTela() {
        return tela;
    }
    public void setTela(String tela) {
        this.tela = tela;
    }
    public String getIndustria() {
        return industria;
    }
    public void setIndustria(String industria) {
        this.industria = industria;
    }
    public String getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    public Double getCostoUnitario() {
        return costoUnitario;
    }
    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    public Double getCostoUnitarioIva() {
        return costoUnitarioIva;
    }
    public void setCostoUnitarioIva(Double costoUnitarioIva) {
        this.costoUnitarioIva = costoUnitarioIva;
    }
    public Double getMargenUtilidad() {
        return margenUtilidad;
    }
    public void setMargenUtilidad(Double margenUtilidad) {
        this.margenUtilidad = margenUtilidad;
    }
    public Double getPrecioTope() {
        return precioTope;
    }
    public void setPrecioTope(Double precioTope) {
        this.precioTope = precioTope;
    }
    public Double getPrecioOficial() {
        return precioOficial;
    }
    public void setPrecioOficial(Double precioOficial) {
        this.precioOficial = precioOficial;
    }
    public int getImpuestoID() {
        return impuestoID;
    }
    public void setImpuestoID(int impuestoID) {
        this.impuestoID = impuestoID;
    }    
    public Impuesto getImpuesto() {     
        return impuesto;
    }
    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
    public int getLastID(){
        Conexion conexion = new Conexion();
        return conexion.getDato("modeloID", "select modeloID from modelo order by modeloID desc limit 1");
    }
    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }
    public void setUnidades(ArrayList<Unidad> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Modelo{" + "modeloID=" + modeloID + ", categoria=" + categoria + ", marca=" + marca + ", detalle=" + detalle + ", tipoColor=" + tipoColor + ", colores=" + colores + ", tallas=" + tallas + ", tela=" + tela + ", industria=" + industria + ", temporada=" + temporada + ", costoUnitario=" + costoUnitario + ", costoUnitarioIva=" + costoUnitarioIva + ", margenUtilidad=" + margenUtilidad + ", precioTope=" + precioTope + ", precioOficial=" + precioOficial + ", impuestoID=" + impuestoID + ", impuesto=" + impuesto + ", unidades=" + unidades + '}';
    }
    
    public void generarImpuesto(){
        if(impuesto == null){
            Conexion conexion = new Conexion();
            ModeloDao modeloDao = new ModeloDao(conexion);
            if(impuestoID == 0)
                this.impuesto = modeloDao.getImpuesto(1);
            else
                this.impuesto = modeloDao.getImpuesto(impuestoID);
            conexion.cerrarConexion();
        }
    }
    public boolean seGuardo(){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        ModeloDao modeloDao = new ModeloDao(conexion);
        UnidadDao unidadDao = new UnidadDao(conexion);
        
        if(modeloDao.seGuardoModelo(this))
            if(unidadDao.seGuardUnidadModelo(new UnidadModelo(getLastID(), unidades.get(0).getUnidadID())) && unidadDao.seGuardUnidadModelo(new UnidadModelo(getLastID(), unidades.get(1).getUnidadID())))
                verificador = true;
        
        conexion.cerrarConexion();
        return verificador;
    }
    public String[] getArregloColores(){
        String[] arregloColores = colores.split(",");
        return arregloColores;
    }
    public String[] getArregloTallas(){
        String[] arregloTallas = tallas.split(",");
        return arregloTallas;
    }
    public String getCodigoBarraPrenda(){
        String codigo = "";
        Conexion conexion = new Conexion();
        int id = conexion.getDato("ModeloID", "select ModeloID from prenda order by ModeloID desc limit 1");
        id++;
        codigo = String.valueOf(id);
        conexion.cerrarConexion();
        return codigo;
    }
    public String[] getUbicaciones(){
        String[] ubicaciones = {};
        Conexion conexion = new Conexion();
        ArrayList<String> lista = conexion.getColumnaTabla("ubicacion", "select distinct ubicacion from prenda");
        if(!lista.isEmpty()){
            ubicaciones = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                String lugar = lista.get(i);
                ubicaciones[i] = lugar;
            }
        }        
        conexion.cerrarConexion();
        return ubicaciones;
    }
}