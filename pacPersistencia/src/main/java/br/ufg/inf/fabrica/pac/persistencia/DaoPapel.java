package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.dominio.Papel;
import java.util.List;

/**
 *
 * @author Danillo
 */
public class DaoPapel extends BasicDao {

    @Override
    public Papel buscar(long id) {
        return this.buscar(Papel.class, id);
    }

    public <T> List<T> listar() {
        return super.listar(Papel.class);
    }

    @Override
    public <T> T buscar(String fieldName, Object value) {
        return super.buscar(Papel.class, fieldName, value);
    }

}
