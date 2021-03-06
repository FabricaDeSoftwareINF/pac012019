package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.persistencia.imp.Conexao;
import br.ufg.inf.fabrica.pac.persistencia.util.UtilPersistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Danillo
 */
public abstract class BasicDao implements IDao {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean salvar(Object entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            return true;
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }

    @Override
    public boolean alterar(Object entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
            return true;
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }

    @Override
    public boolean excluir(Object entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(entity);
            tx.commit();
            return true;
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return false;
        }
    }

    public <T> T buscar(Class klass, long id) {
        UtilPersistencia.fecharEntityManager(this.em);
        em = Conexao.getEntityManager();
        try {
            return (T) em.find(klass, id);
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return null;
        }
    }

    public <T> T buscar(Class klass, String fieldName, Object value) {
        UtilPersistencia.fecharEntityManager(this.em);
        em = Conexao.getEntityManager();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select e from ").append(klass.getSimpleName()).
                    append(" e where ").append(fieldName);
            if (value instanceof String) {
                sb.append(" like '").append(value.toString()).append("'");
            } else {
                sb.append("=").append(value.toString());
            }
            Query q = em.createQuery(sb.toString());
            return (T) UtilPersistencia.getSingleResult(q);
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return null;
        }
    }

    public <T> List<T> listar(Class klass) {
        UtilPersistencia.fecharEntityManager(this.em);
        this.em = Conexao.getEntityManager();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select e from ").
                    append(klass.getSimpleName()).append(" e");
            return (List<T>) (T) em.createQuery(sql.toString()).getResultList();
        } catch (Exception ex) {
            UtilPersistencia.registraLogException(ex);
            return null;
        }
    }
}
