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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "busqueda_Buses_Fecha_Bean")
@SessionScoped
public class Busqueda_Buses_Fecha_Bean implements Serializable {

    /**
     * Creates a new instance of Busqueda_Buses_Fecha
     */
     private Date date1_Buscar;
    private Date datea2_a_buscar;
    private List<HistoricoCuentaBuses> listaFecha= new ArrayList<>();
            
    
     @EJB
    private HistoricoCuentaBusesFacade connFacade;

    public Date getFecha1_Buscar() {
        return date1_Buscar;
    }

    public void setFecha1_Buscar(String fecha1_Buscar) {
        this.date1_Buscar = date1_Buscar;
    }

    public Date getFecha2_a_buscar() {
        return datea2_a_buscar;
    }

    public void setFecha2_a_buscar(String fecha2_a_buscar) {
        this.datea2_a_buscar = datea2_a_buscar;
    }

    public List<HistoricoCuentaBuses> getListaFecha() {
        return listaFecha;
    }

    public void setListaFecha(List<HistoricoCuentaBuses> listaFecha) {
        this.listaFecha = listaFecha;
    }
    public Busqueda_Buses_Fecha_Bean() {
    }
    public void llenarBusesFecha(){
        listaFecha=connFacade.consultarBusesFecha2(date1_Buscar, datea2_a_buscar);
        
    
    }
   
 
    
}
