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
        String recursoId = "cadastro_estado";
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
    public Resposta<Boolean> excluir(Usuario solicitante, Estado entidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<Boolean> alterar(Usuario solicitante, Estado entidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setLogin("danillo");
        usuario.setSenha("ollinad10");
        
        Estado estado = new Estado();
        estado.setNome("novo");
        estado.setEstadoFinal(true);
        estado.setPermiteDelegacao(true);
        estado.setDescricao("Estado de um pacote sem esforço gasto");
        
        SrvEstado srvEstado = new SrvEstado();
        srvEstado.cadastrar(usuario, estado);
        System.out.println("....ok....");
    }
}
