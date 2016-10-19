package br.ufg.inf.fabrica.pac.persistencia;

/**
 *
 * @author Danillo
 */
public interface IDao {
    
    public boolean salvar(Object entity);
    
    public boolean alterar(Object entity);
    
    public boolean excluir(Object entity);
    
    public <T> T buscar(long id);
    
    public <T> T buscar (String fieldName, Object value);
}
