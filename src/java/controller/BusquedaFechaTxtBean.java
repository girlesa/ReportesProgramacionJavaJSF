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
@Named(value = "busquedaFechaTxtBean")
@SessionScoped
public class BusquedaFechaTxtBean implements Serializable {

   private String fecha1txt="";
   private String fecha2txt="";
   private List <HistoricoCuentaBuses> list_Fecha= new ArrayList<>();
   
   @EJB
   private HistoricoCuentaBusesFacade busesFechaFacade;

    public String getFecha1txt() {
        return fecha1txt;
    }

    public void setFechatxt(String fecha1txt) {
        this.fecha1txt = fecha1txt;
    }

    public String getFecha2txt() {
        return fecha2txt;
    }

    public void setFecha2txt(String fecha2txt) {
        this.fecha2txt = fecha2txt;
    }

    public List<HistoricoCuentaBuses> getList_Fecha() {
        return list_Fecha;
    }

    public void setList_Fecha(List<HistoricoCuentaBuses> list_Fecha) {
        this.list_Fecha = list_Fecha;
    }
    
      
    public BusquedaFechaTxtBean() {
    }
    
    public void llenarListaFecha3(){
    
        list_Fecha=busesFechaFacade.consultarBusesFecha3(fecha1txt, fecha2txt);
        
        
    }
    
}
