/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controller.AbstractFacade;
import entities.HistoricoCuentaExpediciones;
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
public class HistoricoCuentaExpedicionesFacade extends AbstractFacade<HistoricoCuentaExpediciones> {

    @PersistenceContext(unitName = "Reportes1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoCuentaExpedicionesFacade() {
        super(HistoricoCuentaExpediciones.class);
    }
    
    public List ObtenerExpedicionesMes(){
        
    Query q =em.createNativeQuery("SELECT \"Linea\", \"Tipo_Evento\", \"Cuenta_expediciones\", \"Tipologia\", \"Operador\", \"RC\", \"Fecha\", \"Mes\", \"Tipo_dia\", \"Dia_Cal\"\n" +
"  FROM public.\"Historico_Cuenta_Expediciones\"\n" +
"   WHERE extract(year from \"Fecha\") =extract(year from current_date) and \"Fecha\" between (select max(\"Fecha\")-30 from \"Historico_Cuenta_Expediciones\" ) and (select max(\"Fecha\") from \"Historico_Cuenta_Expediciones\")--- (max(\"Fecha\")-1 and ('2018-10-31'))\n" +
"");
    
    
    List<Object[]> listExp=q.getResultList();
    return listExp;
    
    }
    
}
