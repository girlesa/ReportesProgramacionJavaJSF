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
@Named(value = "busqueda_Operador_Ruta_Comercial_Bean")
@SessionScoped
public class Busqueda_Operador_Ruta_Comercial_Bean implements Serializable {

    /**
     * Creates a new instance of Busqueda_Operador_Ruta_Comercial
     */
    
    private String txtOperador_a_buscar="";
    private String txtRuta_com_a_buscar="";
    private List<HistoricoCuentaBuses> lista2= new ArrayList<>();
    
    @EJB
    private HistoricoCuentaBusesFacade connFacade2;

    public String getTxtOperador_a_buscar() {
        return txtOperador_a_buscar;
    }

    public void setTxtOperador_a_buscar(String txtOperador_a_buscar) {
        this.txtOperador_a_buscar = txtOperador_a_buscar;
    }

    public String getTxtRuta_com_a_buscar() {
        return txtRuta_com_a_buscar;
    }

    public void setTxtRuta_com_a_buscar(String txtRuta_com_a_buscar) {
        this.txtRuta_com_a_buscar = txtRuta_com_a_buscar;
    }

    public List<HistoricoCuentaBuses> getLista2() {
        return lista2;
    }

    public void setLista2(List<HistoricoCuentaBuses> lista2) {
        this.lista2 = lista2;
    }
    
    public Busqueda_Operador_Ruta_Comercial_Bean() {
    }
    public void llenarBuses2(){
    
    lista2=connFacade2.getBusesStr2(txtOperador_a_buscar, txtRuta_com_a_buscar);
    }
    
}
