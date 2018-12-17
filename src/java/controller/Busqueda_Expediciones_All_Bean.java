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
import static java.lang.Integer.getInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "busqueda_Expediciones_All_Bean")
@SessionScoped
public class Busqueda_Expediciones_All_Bean implements Serializable {

    private String txt_operador_a_buscar ="";
    private String txt_RC_a_buscar="";
   private String txt_tipo_evento_a_buscar="";
   private Date date1_a_ingresar;
   private  Date date2_a_ingresar;
   private List<HistoricoCuentaExpediciones> listExped=new ArrayList<>();
   
   @EJB
   private HistoricoCuentaExpedicionesFacade connExpFacade;

    public String getTxt_RC_a_buscar() {
        return txt_RC_a_buscar;
    }

    public void setTxt_RC_a_buscar(String txt_RC_a_buscar) {
        this.txt_RC_a_buscar = txt_RC_a_buscar;
    }

   
    public String getTxt_operador_a_buscar() {
        return txt_operador_a_buscar;
    }

    public void setTxt_operador_a_buscar(String txt_operador_a_buscar) {
        this.txt_operador_a_buscar = txt_operador_a_buscar;
    }

  

    public String getTxt_tipo_evento_a_buscar() {
        return txt_tipo_evento_a_buscar;
    }

    public void setTxt_tipo_evento_a_buscar(String txt_tipo_evento_a_buscar) {
        this.txt_tipo_evento_a_buscar = txt_tipo_evento_a_buscar;
    }

  

    public Date getDate1_a_ingresar() {
        return date1_a_ingresar;
    }

    public void setDate1_a_ingresar(Date date1_a_ingresar) {
        this.date1_a_ingresar = date1_a_ingresar;
    }

    public Date getDate2_a_ingresar() {
        return date2_a_ingresar;
    }

    public void setDate2_a_ingresar(Date date2_a_ingresar) {
        this.date2_a_ingresar = date2_a_ingresar;
    }

    public List<HistoricoCuentaExpediciones> getListExped() {
        return listExped;
    }

    public void setListExped(List<HistoricoCuentaExpediciones> listExped) {
        this.listExped = listExped;
    }
   
    
    
    public Busqueda_Expediciones_All_Bean() {
    }
    
    public void llenarExpediciones_All(){
    
        listExped=connExpFacade.consultarExpedicionesAll(date1_a_ingresar, date2_a_ingresar, txt_operador_a_buscar, txt_RC_a_buscar, txt_tipo_evento_a_buscar);
    
    }
    
}
