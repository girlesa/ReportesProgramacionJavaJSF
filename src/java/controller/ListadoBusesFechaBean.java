/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facades.HistoricoCuentaBusesFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "listadoBusesFechaBean")
@RequestScoped
public class ListadoBusesFechaBean {

    @EJB
    private facades.HistoricoCuentaBusesFacade  busesFacade;
    private List<Object[]> listado;

    public List<Object[]> getListado() {
        return listado;
    }

    public void setListado(List<Object[]> listado) {
        this.listado = listado;
    }
    @PostConstruct
    public void llenarTabla(){
    listado=busesFacade.getBusesFecha();
    }
    
    
    
    /**
     * Creates a new instance of ListadoBusesFechaBean
     */
    public ListadoBusesFechaBean() {
    }
    
    
}
