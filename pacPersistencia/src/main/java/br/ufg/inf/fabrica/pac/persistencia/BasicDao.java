package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.persistencia.imp.Conexao;
import br.ufg.inf.fabrica.pac.persistencia.util.UtilPersistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Danillo
 */
public abstract class BasicDao implements IDao{

    @Override
    public boolean salvar(Object entity) {
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(entity);
            tx.commit();
            return true;
        }catch(Exception ex){
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }
    
    @Override
    public boolean alterar(Object entity) {
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(entity);
            tx.commit();
            return true;
        }catch(Exception ex){
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }

    @Override
    public boolean excluir(Object entity) {
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(entity);
            tx.commit();
            return true;
        }catch(Exception ex){
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }

    public <T> T buscar(Class klass, long id) {
        EntityManager em = Conexao.getEntityManager();
        try{
            return (T) em.find(klass, id);
        }catch(Exception ex){
            UtilPersistencia.registraLogException(ex);
            return null;
        }
    }
    
}
