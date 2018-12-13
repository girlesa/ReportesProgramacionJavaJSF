/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoSumKMS;
import facades.HistoricoSumKMSFacade;
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
@Named(value = "kmsCalendarBean")
@SessionScoped
public class KmsCalendarBean implements Serializable {

   private Date date1;
   private Date date2;
  
   private List<HistoricoSumKMS>listKms=new ArrayList<>();
  @EJB
   private HistoricoSumKMSFacade connKmsFacade;

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

    public List<HistoricoSumKMS> getListKms() {
        return listKms;
    }

    public void setListKms(List<HistoricoSumKMS> listKms) {
        this.listKms = listKms;
    }
    
    
    public KmsCalendarBean() {
    }
    
    public void llenarListaKms(){
        
        listKms=connKmsFacade.consultarKmsFecha(date1, date2);
    }
    
}
