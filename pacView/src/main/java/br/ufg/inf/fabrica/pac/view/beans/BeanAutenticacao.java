package br.ufg.inf.fabrica.pac.view.beans;

import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.servicos.SrvAutenticador;
import br.ufg.inf.fabrica.servicos.util.Resposta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Danillo
 */
@Named(value = "beanAutenticacao")
@SessionScoped
public class BeanAutenticacao implements Serializable {

    private Usuario usuarioInformado;
    
    private Usuario usuarioAutenticado;
    
    /**
     * Creates a new instance of BeanAutenticacao
     */
    public BeanAutenticacao() {
        this.usuarioInformado = new Usuario(); 
        this.usuarioInformado.setLogin("danillo");
        this.usuarioInformado.setSenha("senha");
    }

    public Usuario getUsuarioInformado() {
        if(usuarioInformado==null){
            this.usuarioInformado = new Usuario();
        }
        return usuarioInformado;
    }

    public void setUsuarioInformado(Usuario usuarioInformado) {
        this.usuarioInformado = usuarioInformado;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String prepararAutenticacao(){
        this.usuarioInformado = new Usuario();
        return "login";
    }
    
    public String autenticar(){
        SrvAutenticador srv = new SrvAutenticador();
        Resposta<Boolean> resposta = srv.autenticar(usuarioInformado);
        if(resposta.getChave()){
            this.usuarioAutenticado = usuarioInformado;
            return "index";
        } else {
            return "#";
        }
    }
    
    public String sair(){
        this.usuarioAutenticado = null;
        this.usuarioInformado = null;
        return "index";
    }
}
