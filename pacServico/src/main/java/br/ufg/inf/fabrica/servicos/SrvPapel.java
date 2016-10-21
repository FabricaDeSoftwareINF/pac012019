package br.ufg.inf.fabrica.servicos;

import br.ufg.inf.fabrica.pac.dominio.Papel;
import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.imp.GestorDePapeis;
import br.ufg.inf.fabrica.servicos.iservicos.ICrud;
import br.ufg.inf.fabrica.servicos.util.Autorizador;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import java.util.List;

/**
 *
 * @author Danillo
 */
public class SrvPapel implements ICrud<Papel> {

    private final GestorDePapeis gestor;

    public SrvPapel() {
        this.gestor = new GestorDePapeis();
    }

    @Override
    public Resposta<List<Papel>> consultar(Usuario solicitante) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<Boolean> cadastrar(Usuario solicitante, Papel papel) {
        String recursoId = "cadastrar_papel";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            return gestor.cadastrar(papel);
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    @Override
    public Resposta<Boolean> excluir(Usuario solicitante, Papel papel) {
        String recursoId = "excluir_papel";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            return gestor.excluir(papel);
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    @Override
    public Resposta<Boolean> alterar(Usuario solicitante, Papel papel) {
        String recursoId = "alterar_papel";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            return gestor.alterar(papel);
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    public Resposta<Papel> buscar(Usuario solicitante, Long id) {
        String recursoId = "buscar_papel";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            return gestor.buscar(id);
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

    public Resposta<List<Papel>> listar(Usuario solicitante) {
        String recursoId = "listar_papel";
        if (solicitante == null) {
            return Resposta.novaInstanciaDeInsucesso("Informe solicitante");
        }
        Autorizador autorizador = new Autorizador();
        if (autorizador.autorizarAcesso(solicitante, recursoId)) {
            return gestor.listar();
        } else {
            return Resposta.novaInstanciaDeInsucesso("Recurso não autorizado");
        }
    }

}
