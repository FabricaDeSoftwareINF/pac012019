package br.ufg.inf.fabrica.pac.persistencia.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Danillo
 */
public class Conexao {

    private static EntityManagerFactory factory;
    private Conexao() {
        
    }

    public static EntityManager getEntityManager(){
        if(factory==null){
            factory = Persistence.createEntityManagerFactory("PU-PAC");
        }
        return factory.createEntityManager();
    }
}
