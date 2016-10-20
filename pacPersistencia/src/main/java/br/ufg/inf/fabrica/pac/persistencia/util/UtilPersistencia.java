package br.ufg.inf.fabrica.pac.persistencia.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Danillo
 */
public class UtilPersistencia {

    private UtilPersistencia() {

    }

    public static void registraLogException(Exception ex){
        Logger.getLogger(UtilPersistencia.class.getName()).
                    log(Level.INFO, ex.getMessage());
    }
    
    public static <T> T getSingleResult(Query q){
        try{
        return (T) q.getSingleResult();
        }catch(Exception ex){
            Logger.getLogger(UtilPersistencia.class.getName()).log(Level.SEVERE, 
                    null, ex);
            return null;
        }
    }

    public static void fecharEntityManager(EntityManager em){
        if(em!=null && em.isOpen()){
            em.close();
        }
    }
}
