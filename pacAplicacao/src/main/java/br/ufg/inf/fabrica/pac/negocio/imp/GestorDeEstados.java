package br.ufg.inf.fabrica.pac.negocio.imp;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
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

    public Resposta cadastrar(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            List<String> erros = estado.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.salvar(estado);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta alterar(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            List<String> erros = estado.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.alterar(estado);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta excluir(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não informado");
        }
        try {
            List<String> erros = estado.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.excluir(estado);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta<List<Estado>> listar() {
        try {
            List<Estado> estados = dao.listar();
            return Resposta.novaInstanciaDeSucesso(estados);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta<Estado> buscar(Long id) {
        if (id == 0) {
            return Resposta.novaInstanciaDeInsucesso(
                    "Identificador não informado");
        }
        try {
            Estado estado = dao.buscar(id);
            return Resposta.novaInstanciaDeSucesso(estado);
        } catch (Exception ex) {
            Logger.getLogger(GestorDeEstados.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }
}
