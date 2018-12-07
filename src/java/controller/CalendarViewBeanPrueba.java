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
@Named(value = "calendarViewPrueba")
@SessionScoped
public class CalendarViewBeanPrueba implements Serializable {

    /**
     * Creates a new instance of CalendarView
     */
     private Date date1_a_buscar;
     private Date date2_a_buscar;
    
    private List<HistoricoCuentaBuses> listaBusesFecha=new ArrayList<>();
    
    @EJB
    private HistoricoCuentaBusesFacade connFacade;

    public Date getDate1_a_buscar() {
        return date1_a_buscar;
    }

    public void setDate1_a_buscar(Date date1_a_buscar) {
        this.date1_a_buscar = date1_a_buscar;
    }

    public Date getDate2_a_buscar() {
        return date2_a_buscar;
    }

    public void setDate2_a_buscar(Date date2_a_buscar) {
        this.date2_a_buscar = date2_a_buscar;
    }

    public List<HistoricoCuentaBuses> getListaBusesFecha() {
        return listaBusesFecha;
    }

    public void setListaBusesFecha(List<HistoricoCuentaBuses> listaBusesFecha) {
        this.listaBusesFecha = listaBusesFecha;
    }
    
    
    
    public CalendarViewBeanPrueba() {
    }
      public void llenarBusesFecha(){
    
    listaBusesFecha=connFacade.consultarBusesFecha2(date1_a_buscar, date2_a_buscar);
    }
    
}
