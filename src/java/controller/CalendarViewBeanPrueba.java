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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
     private boolean fechaInicialFinalMayoraHoy;
    private boolean fechaInicialyFinMayor30Dias;
    public static final int NEGATIVO_TREINTA = -30;
    private Date date1_a_buscar;
     private Date date2_a_buscar;
    
    private List<HistoricoCuentaBuses> listBusesFecha=new ArrayList<>();
    
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

    public List<HistoricoCuentaBuses> getListBusesFecha() {
        return listBusesFecha;
    }

    public void setListaBusesFecha(List<HistoricoCuentaBuses> listaBusesFecha) {
        this.listBusesFecha = listaBusesFecha;
    }
    
    public void validarFechas() throws Exception {
        fechaInicialFinalMayoraHoy = false;
        fechaInicialyFinMayor30Dias = false;
        if (this.date1_a_buscar != null && this.date2_a_buscar != null) {
            if (isMayorFechaHoy(this.date1_a_buscar)
                    || isMayorFechaHoy(this.date2_a_buscar)) {
                fechaInicialFinalMayoraHoy = true;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Fecha Inicio o Fecha Fin es mayor a la fecha de hoy"));
            }
            if (isMayor30Dias(this.date1_a_buscar, this.date2_a_buscar)) {
                fechaInicialyFinMayor30Dias = true;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Fecha es mayor a 30 dias."));
            }
        }
    }
    
    /**
     * Descripci&oacute;n de la regla: Si la fecha inicial o la fecha final es
     * mayor a la fecha acutal. la validaci&oacute termina como incorrecta
     *
     * @param fecha La fecha inicial de consulta o la fecha final de consulta .
     * @throws Exception Si las fechas violan la regla de negocio.
     */
    public Boolean isMayorFechaHoy(Date fecha) throws Exception {
        Date hoy = new Date();
        Boolean resultado = false;

        if (fecha != null && fecha.after(hoy)) {
            resultado = true;
        }

        return resultado;
    }
    
    /**
     * Descripci&oacute;n de la regla: Si la fecha final es mayor a 30
     * d&iacute;as de la fecha inicial la validaci&oacute termina como
     * incorrecta
     *
     * @param fechaInicial La fecha inicial de consulta.
     * @param fechaFinal final de consulta.
     * @throws Exception Si las fechas violan la regla de negocio.
     */
    public Boolean isMayor30Dias(Date fechaInicial, Date fechaFinal) throws Exception {
        Date fhFinal = fechaFinal;
        Boolean resultado = false;
        if (fechaInicial != null && fhFinal != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(fhFinal);
            c.add(Calendar.DATE, NEGATIVO_TREINTA);
            fhFinal = c.getTime();
            if (fechaInicial.getTime() < fhFinal.getTime()) {
                resultado = true;
            }
        }
        return resultado;
    }
    public CalendarViewBeanPrueba() {
    }
      public void llenarBusesFecha(){
    
    listBusesFecha=connFacade.consultarBusesFecha2(date1_a_buscar, date2_a_buscar);
    }
    
}
