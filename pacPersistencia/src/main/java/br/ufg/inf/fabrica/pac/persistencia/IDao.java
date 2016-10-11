package br.ufg.inf.fabrica.pac.persistencia;

/**
 *
 * @author Danillo
 */
public interface IDao {
    
    public boolean salvar(Object entity);
    
    public boolean excluir(Object entity);
    
    public Object buscar(long id);
}
