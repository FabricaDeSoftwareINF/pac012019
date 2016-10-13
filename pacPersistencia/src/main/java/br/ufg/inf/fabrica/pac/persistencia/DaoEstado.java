package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.dominio.Estado;

/**
 *
 * @author Danillo
 */
public class DaoEstado extends BasicDao{

    @Override
    public Estado buscar(long id) {
        return this.buscar(Estado.class, id);
    }

}
