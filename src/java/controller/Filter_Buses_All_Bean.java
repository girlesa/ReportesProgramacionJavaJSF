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
@Named(value = "filter_Buses_All_Bean")
@SessionScoped
public class Filter_Buses_All_Bean implements Serializable {

  private Date date1;
   private Date date2;
   private String txt_Operador_a_buscar;
  private String txt_Ruta_a_Buscar;
  private String txt__Linea_a_Buscar;
  
 private List<HistoricoCuentaBuses> listFilterBuses=new ArrayList<>();
 
 @EJB
 private HistoricoCuentaBusesFacade connBusesFacadeAll;
 
   
   
    
    public Filter_Buses_All_Bean() {
    }
    
}
