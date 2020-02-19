/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.clientes;

import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.tablas.IUTabla;
import com.aplicacionjava.www.tablas.ModeloTabla;
import fasttienda.bo.com.tiendaAbrigos.modelo.Cliente;
import fasttienda.bo.com.tiendaAbrigos.modelo.Prenda;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hotel-felipez
 */
public class IUTablaClientes extends ModeloTabla<Cliente>{
    public IUTabla tabla;   
    private final String[] nombreCabecera = {"Nª","Nombre Clientes","Nit","nombre/razon social", "telefonos"};
    private final ArrayList<Cliente> lista = new ArrayList<>();
    private final Class[] columnas = {Integer.class, String.class, String.class, String.class, String.class};
    private final int[] porcentajes = {5, 30, 20, 30, 15};
    private final Limitacion limitacion;
    
    
    public IUTablaClientes(Limitacion limitacion) {
        this.limitacion = limitacion;
        
        construirTabla();
        setEventos();
    }
    private void construirTabla(){
        setModelo(nombreCabecera, columnas, lista);
        
        tabla = new IUTabla(this, limitacion);
        tabla.agregarAnchoColumnas(porcentajes);
        tabla.setColumnaRender(0);
        tabla.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
        tabla.setPosicionTextoHorizontal(2, SwingConstants.CENTER);
        tabla.setPosicionTextoHorizontal(3, SwingConstants.LEFT);        
        
        //tabla.setRowHeight(limitacion.getPorcentajeAlto(15));
        /*for (int i = 0; i < tipoColumnas.length - 1; i++) {
            tabla.setDefaultRenderer(tipoColumnas[i], new IURenderProductoMinibar(this));            
        }
        tabla.agregarCellRender(1, new IURenderProductoMinibar(new Limitacion(limitacion.getPorcentajeAncho(30) - 1, limitacion.getPorcentajeAlto(15) - 1)));        */
    }
    public void setFuenteCabecera(Font fuente){
        JTableHeader th = tabla.getTableHeader();
        th.setFont(fuente);
    }
    private void setEventos(){
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                                
                if (row > -1) {
                    
                }
            }
        });
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 ;
            case 1:
                return lista.get(rowIndex).getNombreCliente();
            case 2:
                return lista.get(rowIndex).getNitCi();
            case 3:
                return lista.get(rowIndex).getRazonSocial();
            case 4:
                return lista.get(rowIndex).getTelefonoCliente()+ " " +lista.get(rowIndex).getTelefonoCelular();
            default:
                return null;
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {     
            default:
                return false;
        }
    }
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        /*if(rowIndex < lista.size()){            
        }
        if((Producto)lista.get(rowIndex) != null){                
            switch (columnIndex) {
                case 3:
                    lista.get(rowIndex).setEstado((String) value);
                    fireTableCellUpdated(rowIndex, columnIndex);
                default:                
            }
        }*/
    }    
}
