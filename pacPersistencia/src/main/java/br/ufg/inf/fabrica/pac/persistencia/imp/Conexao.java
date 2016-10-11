package br.ufg.inf.fabrica.pac.persistencia.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Danillo
 */
public class Conexao {

    private static final EntityManagerFactory factory = Persistence.
            createEntityManagerFactory("PU-PAC");
    private Conexao() {

    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
