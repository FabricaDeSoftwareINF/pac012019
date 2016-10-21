package br.ufg.inf.fabrica.pac.view.beans;

import br.ufg.inf.fabrica.pac.dominio.Estado;
import br.ufg.inf.fabrica.servicos.SrvEstado;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Danillo
 */
@Named(value = "beanEstado")
@SessionScoped
public class BeanEstado implements Serializable {

    @Inject
    private BeanAutenticacao beanAutenticacao;

    List<Estado> estados;

    private Estado estado;

    private final SrvEstado srv;
    
    public BeanEstado(){
        this.srv = new SrvEstado();
    }
    
    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String listar() {
        if (beanAutenticacao == null
                || beanAutenticacao.getUsuarioAutenticado() == null) {
            return "login";
        } else {
            Resposta<List<Estado>> resposta
                    = srv.listar(beanAutenticacao.getUsuarioAutenticado());
            if (resposta.isSucesso()) {
                estados = resposta.getChave();
            }
            return "estado/listagem";
        }
    }

    public String prepararCadastro() {
        this.estado = new Estado();
        estado.setEstadoFinal(true);
        return "/estado/cadastrar";
    }

    public String cadastrar() {
        Resposta<Boolean> resposta;
        resposta = srv.cadastrar(beanAutenticacao.getUsuarioAutenticado(),
                estado);
        if (resposta.getChave()) {
            return listar();
        } else {
            return "";
        }
    }

    public String visualizar(Estado estado) {
        this.estado = estado;
        return "/estado/visualizar";
    }

    public String prepararAlteracao() {
        return "/estado/cadastrar";
    }

    public String prepararAlteracao(Estado estado) {
        this.estado = estado;
        return "/estado/cadastrar";
    }

    public String alterar() {
        Resposta<Boolean> resposta;
        resposta = srv.alterar(beanAutenticacao.getUsuarioAutenticado(),
                estado);
        if (resposta.getChave()) {
            return "listagem";
        } else {
            return "";
        }
    }

    public String remover() {
        Resposta<Boolean> resposta
                = srv.excluir(beanAutenticacao.getUsuarioAutenticado(), 
                        this.estado);
        if (resposta.getChave()) {
            return "listagem";
        } else {
            return "";
        }
    }
}
