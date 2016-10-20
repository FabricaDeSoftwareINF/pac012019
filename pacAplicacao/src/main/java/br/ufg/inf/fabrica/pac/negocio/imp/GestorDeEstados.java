package br.ufg.inf.fabrica.pac.negocio.imp;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.pac.persistencia.DaoEstado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class GestorDeEstados {

    private final DaoEstado dao;

    public GestorDeEstados() {
        this.dao = new DaoEstado();
    }

    public boolean cadastrar(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            dao.salvar(estado);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            dao.alterar(estado);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean excluir(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            dao.excluir(estado);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Estado> listar() {
        try {
            return dao.listar();
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Estado buscar(Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Identificador não informado");
        }
        try {
            return dao.buscar(id);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
