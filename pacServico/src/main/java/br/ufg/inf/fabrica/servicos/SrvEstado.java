package br.ufg.inf.fabrica.servicos;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.imp.GestorDeEstados;
import br.ufg.inf.fabrica.servicos.iservicos.ICrud;
import br.ufg.inf.fabrica.servicos.util.Autorizador;
import br.ufg.inf.fabrica.servicos.util.Resposta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class SrvEstado implements ICrud<Estado> {

    @Override
    public Resposta<List<Estado>> consultar(Usuario solicitante) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<Boolean> cadastrar(Usuario solicitante, Estado estado) {
        String recursoId = "cadastrar_estado";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            GestorDeEstados gestor = new GestorDeEstados();
            try {
                gestor.cadastrar(estado);
                return Resposta.novaInstanciaDeSucesso(true);
            } catch (Exception ex) {
                Logger.getLogger(SrvEstado.class.getName()).
                        log(Level.SEVERE, null, ex);
                return Resposta.novaInstanciaDeSucesso(
                        "Falha ao cadastrar novo estado");
            }
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    @Override
    public Resposta<Boolean> excluir(Usuario solicitante, Estado estado) {
        String recursoId = "excluir_estado";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            GestorDeEstados gestor = new GestorDeEstados();
            try {
                gestor.excluir(estado);
                return Resposta.novaInstanciaDeSucesso(true);
            } catch (Exception ex) {
                Logger.getLogger(SrvEstado.class.getName()).
                        log(Level.SEVERE, null, ex);
                return Resposta.novaInstanciaDeSucesso(
                        "Falha ao excluir estado");
            }
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    @Override
    public Resposta<Boolean> alterar(Usuario solicitante, Estado estado) {
        String recursoId = "alterar_estado";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            GestorDeEstados gestor = new GestorDeEstados();
            try {
                gestor.alterar(estado);
                return Resposta.novaInstanciaDeSucesso(true);
            } catch (Exception ex) {
                Logger.getLogger(SrvEstado.class.getName()).
                        log(Level.SEVERE, null, ex);
                return Resposta.novaInstanciaDeSucesso(
                        "Falha ao alterar estado");
            }
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    public Resposta<Estado> buscar(Usuario solicitante, Long id){
        String recursoId = "buscar_estado";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            GestorDeEstados gestor = new GestorDeEstados();
            try {
                Estado estado = gestor.buscar(id);
                return Resposta.novaInstanciaDeSucesso(estado);
            } catch (Exception ex) {
                Logger.getLogger(SrvEstado.class.getName()).
                        log(Level.SEVERE, null, ex);
                return Resposta.novaInstanciaDeSucesso(
                        "Falha ao alterar estado");
            }
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }
}
