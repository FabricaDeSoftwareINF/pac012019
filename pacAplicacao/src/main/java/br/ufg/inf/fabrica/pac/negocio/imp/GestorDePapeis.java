package br.ufg.inf.fabrica.pac.negocio.imp;

import br.ufg.inf.fabrica.pac.dominio.Papel;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import br.ufg.inf.fabrica.pac.persistencia.DaoPapel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class GestorDePapeis {

    private final DaoPapel dao;

    public GestorDePapeis() {
        this.dao = new DaoPapel();
    }

    public Resposta cadastrar(Papel papel) {
        if (papel == null) {
            return Resposta.novaInstanciaDeInsucesso("Papel não informado");
        }
        try {
            List<String> erros = papel.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.salvar(papel);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDePapeis.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta alterar(Papel papel) {
        if (papel == null) {
            return Resposta.novaInstanciaDeInsucesso("Papel não informado");
        }
        try {
            List<String> erros = papel.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.alterar(papel);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDePapeis.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta excluir(Papel papel) {
        if (papel == null) {
            return Resposta.novaInstanciaDeInsucesso("Papel não informado");
        }
        try {
            List<String> erros = papel.validar();
            if(erros.isEmpty()){
                return Resposta.novaInstanciaDeInsucesso(erros);
            }
            dao.excluir(papel);
            return Resposta.novaInstanciaDeSucesso(Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(GestorDePapeis.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta<List<Papel>> listar() {
        try {
            List<Papel> papeis = dao.listar();
            return Resposta.novaInstanciaDeSucesso(papeis);
        } catch (Exception ex) {
            Logger.getLogger(GestorDePapeis.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }

    public Resposta<Papel> buscar(Long id) {
        if (id == 0) {
            return Resposta.novaInstanciaDeInsucesso(
                    "Identificador não informado");
        }
        try {
            Papel papel = dao.buscar(id);
            return Resposta.novaInstanciaDeSucesso(papel);
        } catch (Exception ex) {
            Logger.getLogger(GestorDePapeis.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Resposta.novaInstanciaDeInsucesso(ex.getMessage());
        }
    }
}
