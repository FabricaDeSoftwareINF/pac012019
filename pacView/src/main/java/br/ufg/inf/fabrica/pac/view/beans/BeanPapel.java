package br.ufg.inf.fabrica.pac.view.beans;

import br.ufg.inf.fabrica.pac.dominio.Papel;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import br.ufg.inf.fabrica.servicos.SrvPapel;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Danillo
 */
@Named(value = "beanPapel")
@SessionScoped
public class BeanPapel implements Serializable {

    @Inject
    private BeanAutenticacao beanAutenticacao;

    List<Papel> papeis;

    private Papel papel;

    private final SrvPapel srv;
    
    public BeanPapel(){
        this.srv = new SrvPapel();
    }
    
    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public String listar() {
        if (beanAutenticacao == null
                || beanAutenticacao.getUsuarioAutenticado() == null) {
            return "login";
        } else {
            Resposta<List<Papel>> resposta
                    = srv.listar(beanAutenticacao.getUsuarioAutenticado());
            if (resposta.isSucesso()) {
                papeis = resposta.getChave();
            }
            return "papel/listagem";
        }
    }

    public String prepararCadastro() {
        this.papel = new Papel();
        return "/papel/cadastrar";
    }

    public String cadastrar() {
        Resposta<Boolean> resposta;
        resposta = srv.cadastrar(beanAutenticacao.getUsuarioAutenticado(),
                papel);
        if (resposta.getChave()) {
            return listar();
        } else {
            return "";
        }
    }

    public String visualizar(Papel papel) {
        this.papel = papel;
        return "/papel/visualizar";
    }

    public String prepararAlteracao() {
        return "/papel/cadastrar";
    }

    public String prepararAlteracao(Papel papel) {
        this.papel = papel;
        return "/papel/cadastrar";
    }

    public String alterar() {
        Resposta<Boolean> resposta;
        resposta = srv.alterar(beanAutenticacao.getUsuarioAutenticado(),
                papel);
        if (resposta.getChave()) {
            return "listagem";
        } else {
            return "";
        }
    }

    public String remover() {
        Resposta<Boolean> resposta
                = srv.excluir(beanAutenticacao.getUsuarioAutenticado(), 
                        this.papel);
        if (resposta.getChave()) {
            return "listagem";
        } else {
            return "";
        }
    }
}
