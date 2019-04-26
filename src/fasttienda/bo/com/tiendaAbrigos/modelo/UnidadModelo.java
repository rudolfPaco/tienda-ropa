/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.modelo;

/**
 *
 * @author neo
 */
public class UnidadModelo {
    private int modeloID;
    private int unidadID;

    public UnidadModelo(int modeloID, int unidadID) {
        this.modeloID = modeloID;
        this.unidadID = unidadID;
    }

    public int getModeloID() {
        return modeloID;
    }
    public void setModeloID(int modeloID) {
        this.modeloID = modeloID;
    }
    public int getUnidadID() {
        return unidadID;
    }
    public void setUnidadID(int unidadID) {
        this.unidadID = unidadID;
    }
    @Override
    public String toString() {
        return "UnidadModelo{" + "modeloID=" + modeloID + ", unidadID=" + unidadID + '}';
    }
    
    
}
