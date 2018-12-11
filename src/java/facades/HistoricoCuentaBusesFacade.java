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
    
    
    public List<HistoricoCuentaBuses> getBusesByString(String cadena){
    
       List<HistoricoCuentaBuses> listBusesStr;
        Query q;
      q=em.createNativeQuery("SELECT * FROM \"Historico_Cuenta_Buses\" where \"Operador\" ilike '%"+cadena+"%' and \"Fecha\" = '2018-10-31'",HistoricoCuentaBuses.class);
      // q=em.createNativeQuery( " SELECT * FROM \"Historico_Cuenta_Buses\" where \"Operador\" ilike '%"+cadena+"%' and \"Ruta_Com\" ilike'%"+cadena1+"%'and \"Fecha\" = '2018-10-31'");
        
        
        listBusesStr=q.getResultList();
        
        return listBusesStr;
        
    }    
    public List<HistoricoCuentaBuses> getBusesStr2(String cadena1,String cadena2){
    
    List<HistoricoCuentaBuses> listBusesStr2;
    Query q2;
    q2=em.createNativeQuery("SELECT * FROM \"Historico_Cuenta_Buses\" where \"Operador\" ilike '%"+cadena1+"%' and \"Ruta_Com\" ilike'%"+cadena2+"%'and \"Fecha\" between (select max(\"Fecha\")-30 from \"Historico_Cuenta_Buses\" ) and (select max(\"Fecha\") from \"Historico_Cuenta_Buses\")",HistoricoCuentaBuses.class);
    listBusesStr2=q2.getResultList();
    return listBusesStr2;
    }
    
    public List<HistoricoCuentaBuses> consultarBusesFecha2(Date date1,Date date2){
        
         List<HistoricoCuentaBuses> listBusesFecha;
         Query q3;
         q3=em.createNativeQuery("select * from \"Historico_Cuenta_Buses\" where \"Fecha\" between '"+date1+"' and '"+date2+"'",HistoricoCuentaBuses.class);
         listBusesFecha=q3.getResultList();
         return listBusesFecha;
        
    }
    public List<HistoricoCuentaBuses> consultarBusesFecha3(String fecha1,String fecha2){
        
         List<HistoricoCuentaBuses> listBusesFecha3;
         Query q4;
         q4=em.createNativeQuery("select * from \"Historico_Cuenta_Buses\" where \"Fecha\" between '"+fecha1+"' and '"+fecha2+"'",HistoricoCuentaBuses.class);
         listBusesFecha3=q4.getResultList();
         return listBusesFecha3;
        
    }
}

    