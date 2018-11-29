/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facades.HistoricoCuentaExpedicionesFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "listadoExpedicionesPeriodo")
@RequestScoped
public class ListadoExpedicionesPeriodoBean {

    /**
     * Creates a new instance of ListadoExpedicionesPeriodo
     */
    @EJB
    private HistoricoCuentaExpedicionesFacade expedFacade;
    private List<Object[]> listExp;

    public List<Object[]> getListExp() {
        return listExp;
    }

    public void setListExp(List<Object[]> listExp) {
        this.listExp = listExp;
    }
    
    public ListadoExpedicionesPeriodoBean() {
        
    }
    @PostConstruct
    public void llenarTabla(){
    
    listExp=expedFacade.ObtenerExpedicionesMes();
    }
    
}
