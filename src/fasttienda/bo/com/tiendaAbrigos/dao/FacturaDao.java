/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.dao;

import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;

/**
 *
 * @author hotel-felipez
 */
public class FacturaDao {
    private Conexion conexion;

    public FacturaDao(Conexion conexion) {
        this.conexion = conexion;
    }
    public int getLastIdFactura(){
        int idLast = Ayuda.getDatoInt("FacturaID", "select FacturaID from Factura order by FacturaID desc limit 1");        
        return idLast;
    }
}
