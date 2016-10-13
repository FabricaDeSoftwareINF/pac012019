package br.ufg.inf.fabrica.pac.negocio.imp;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.pac.persistencia.DaoEstado;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class GestorDeEstados {

    public boolean cadastrar(Estado estado){
        if(estado==null){
            throw new IllegalArgumentException("Estado não informado");
        }
        DaoEstado dao = new DaoEstado();
        try{
            dao.salvar(estado);
            return true;
        }catch(Exception ex){
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
