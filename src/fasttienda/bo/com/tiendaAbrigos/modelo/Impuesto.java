/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

/**
 *
 * @author rudolf
 */
public class Impuesto {
    private int impuestoID;
    private double iva;
    private double it;

    public Impuesto(int impuestoID) {
        this.impuestoID = impuestoID;
    }
    public int getImpuestoID() {
        return impuestoID;
    }
    public void setImpuestoID(int impuestoID) {
        this.impuestoID = impuestoID;
    }
    public double getIva() {
        return iva;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public double getIt() {
        return it;
    }
    public void setIt(double it) {
        this.it = it;
    }
    @Override
    public String toString() {
        return "Impuesto{" + "impuestoID=" + impuestoID + ", iva=" + iva + ", it=" + it + '}';
    }
    
}
