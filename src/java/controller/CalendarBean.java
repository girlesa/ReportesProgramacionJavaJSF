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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "calendarBean")
@SessionScoped
public class CalendarBean implements Serializable {

    private Date date1;
    private Date date2;
    private String date3="";
    
    
    
     private List<HistoricoCuentaBuses> listBusesFecha=new ArrayList<>();
    
    @EJB
    private HistoricoCuentaBusesFacade connFacade;
     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      // SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
  
 
    public Date getDate1() {
        return date1;
    }

    public List<HistoricoCuentaBuses> getListBusesFecha() {
        return listBusesFecha;
    }

    public void setListBusesFecha(List<HistoricoCuentaBuses> listBusesFecha) {
        this.listBusesFecha = listBusesFecha;
    }
 
    public void setDate1(Date date1) {
        this.date1 = date1;
       // this.date1=new SimpleDateFormat("dd/MM/yyyy").format(getDate1()) ;      
       // this.date1 = new Date();
        
       
    }
     public String getDate3() {
        return date3;
    }
    public String setDate3() {
        
        this.date3 = date1.toString();
         //this.date3=transformarFecha(date1);
         return date3;
    }
    public Date getDate2() {
        return date2;
    }
 
    public void setDate2(Date date2) {
        this.date2 = date2;
    }
  public void llenarBusesFecha(){
    
    listBusesFecha=connFacade.consultarBusesFecha2(date1, date2);
    }
   
    public CalendarBean() {
        
        
    }
   
    public void imprimeData(){
   System.out.println(date1);
   System.out.println(date2);
   System.out.println(date3);
   
    }
    
    public Date convertirFecha(String date3) throws ParseException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = formatter.parse(date3);

        return fecha1;
    }
    
    
    
    
    
    
}
