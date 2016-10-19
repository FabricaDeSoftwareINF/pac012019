package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.dominio.Usuario;

/**
 *
 * @author Danillo
 */
public class DaoUsuario extends BasicDao{

    @Override
    public <T> T buscar(long id) {
        return buscar(Usuario.class, id);
    }

    @Override
    public <T> T buscar(String fieldName, Object value) {
        return super.buscar(Usuario.class, fieldName, value);
    }
    
}
