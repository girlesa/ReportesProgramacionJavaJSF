/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controller.AbstractFacade;
import entities.HistoricoSumKMS;
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
public class HistoricoSumKMSFacade extends AbstractFacade<HistoricoSumKMS> {

    @PersistenceContext(unitName = "Reportes1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoSumKMSFacade() {
        super(HistoricoSumKMS.class);
    }
    public List obtenerKilometrosMes(){
        HistoricoSumKMSFacade kmsFacade;
        List<Object[]> listKms;
        Query q=em.createNativeQuery("SELECT \"Cuadro\", \"Linea\", \"Tipo_Evento\", kms, \"Tipologia\", \"Operador\", \"RC\", \"Fecha\", \"Tipo_dia\"\n" +
                                    "  FROM public.\"Historico_Sum_KMS\" \n" +
                                    "  WHERE \"Fecha\" between (select Max(\"Fecha\")-8 from \"Historico_Sum_KMS\" ) and  current_date ");
       listKms=q.getResultList();
        return  listKms;
    }
    
}
