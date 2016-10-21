
import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.pac.dominio.Papel;
import br.ufg.inf.fabrica.pac.persistencia.imp.Conexao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danillo
 */
public class Main {
    public static void main(String[] args) {
        Estado novo = new Estado();
        novo.setNome("Nome");
        novo.setDescricao("estado novo");
        
        Papel gerente = new Papel();
        gerente.setNome("Gerente");
        
        novo.getPapeis().add(gerente);
        
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(gerente);
        em.persist(novo);
        tx.commit();
        
        System.out.println("ok");
    }
}
