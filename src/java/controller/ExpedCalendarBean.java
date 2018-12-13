/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoCuentaExpediciones;
import facades.HistoricoCuentaExpedicionesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.ejb.EJB;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "expedCalendarBean")
@SessionScoped
public class ExpedCalendarBean implements Serializable {

   private Date date1;
    private Date date2;
    private List<HistoricoCuentaExpediciones> listExpedFecha=new ArrayList<>();
    
   // @EJB
     private HistoricoCuentaExpedicionesFacade connExpedFacade;
    
     public List<HistoricoCuentaExpediciones> getListExpedFecha() {
        return listExpedFecha;
    }

    public void setListExpedFecha(List<HistoricoCuentaExpediciones> listExpedFecha) {
        this.listExpedFecha = listExpedFecha;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
    
    public ExpedCalendarBean() {
    }
    
    public void llenarExpedFecha(){
    
    listExpedFecha=connExpedFacade.consultarExpedFecha(date1, date2);
    }
}
