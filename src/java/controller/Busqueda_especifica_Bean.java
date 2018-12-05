/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoCuentaBuses;
import facades.HistoricoCuentaBusesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "busqueda_especifica_Bean")
@SessionScoped
public class Busqueda_especifica_Bean implements Serializable {

    /**
     * Creates a new instance of Busqueda_especifica_Bean
     */
    
    private String txtBuscar="";
    private List<HistoricoCuentaBuses> listaBuses=new ArrayList<>();
    
    @EJB
    private HistoricoCuentaBusesFacade connFacade;

    public String getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(String txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public List<HistoricoCuentaBuses> getListaBuses() {
        return listaBuses;
    }

    public void setListaBuses(List<HistoricoCuentaBuses> listaBuses) {
        this.listaBuses = listaBuses;
    }

  
        
    
    public Busqueda_especifica_Bean() {
    }
    
    public void llenarTablaEspecifica(){
    
    listaBuses=connFacade.getBusesByString(txtBuscar);
    }
       
    
}
