/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.HistoricoCuentaBuses;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author girlesa.buitrago
 */
@Stateless
public class HistoricoCuentaBusesFacade extends AbstractFacade<HistoricoCuentaBuses> {

    @PersistenceContext(unitName = "Reportes1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoCuentaBusesFacade() {
        super(HistoricoCuentaBuses.class);
    }
    
    public List getBusesFecha(){
       
        Query q;
        q = em.createNativeQuery("SELECT \"ID\", \"RC\", \"Tipologia\", \"Operador\", \"ZONA\", \"Conteo_Buses_Tipologia\", \n" +
"       \"Linea\", \"Ruta_Com\", \"Fecha\", \"Tipo_dia\", \"Mes\", \"Anio\", \"Cuenta\", \n" +
"       \"Suma\"\n" +
"  FROM public.\"Historico_Cuenta_Buses\" WHERE extract(year from \"Fecha\") =extract(year from current_date) and \"Fecha\" between (select max(\"Fecha\")-30 from \"Historico_Cuenta_Buses\" ) and (select max(\"Fecha\") from \"Historico_Cuenta_Buses\")");
        List<Object[]> listado=q.getResultList();
        return listado;    
     
    }
    /*public List getBusesIntervalo(){
       
        Query q;
        Date fechaInicial;
        q = em.createNativeQuery("SELECT  \"RC\", \"Tipologia\", \"Operador\", \"ZONA\",\"Linea\", \"Ruta_Com\", \"Fecha\", \"Tipo_dia\", \"Mes\", \"Anio\", \"Conteo_Buses_Tipologia\" \n" +
                "        FROM public.\"Historico_Cuenta_Buses\"\n" +
                "  WHERE extract(year from \"Fecha\") =extract(year from current_date) and extract(month from \"Fecha\") =extract(month from current_date)-1");
        List<Object[]> listado=q.getResultList();
        return listado;
}*/
    
    public List<HistoricoCuentaBuses> getBusesByString(String cadena){
    
       List<HistoricoCuentaBuses> listBusesStr;
        Query q;
        q=em.createNativeQuery("SELECT * FROM \"Historico_Cuenta_Buses\" where \"Operador\" ilike '%"+cadena+"%' and \"Fecha\" = '2018-10-31'",HistoricoCuentaBuses.class);
        listBusesStr=q.getResultList();
        
        return listBusesStr;
        
    }    
}

    