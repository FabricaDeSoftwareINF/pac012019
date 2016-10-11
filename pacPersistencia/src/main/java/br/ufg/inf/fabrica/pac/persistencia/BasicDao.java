package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.persistencia.imp.Conexao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Danillo
 */
public class BasicDao implements IDao{

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
            return false;
        }
    }

    @Override
    public Object buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
