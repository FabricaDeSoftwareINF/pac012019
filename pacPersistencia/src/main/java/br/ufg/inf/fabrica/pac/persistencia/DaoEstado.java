package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import java.util.List;

/**
 *
 * @author Danillo
 */
public class DaoEstado extends BasicDao{

    @Override
    public Estado buscar(long id) {
        return this.buscar(Estado.class, id);
    }

    /**
     * Retorna lista de estados cadastrados
     * @param <T>
     * @param klass
     * @return 
     */
    public <T> List<T> listar(){
        return super.listar(Estado.class);
    }

    @Override
    public <T> T buscar(String fieldName, Object value) {
        return super.buscar(Estado.class, fieldName, value);
    }
    
    
}
