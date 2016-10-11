package br.ufg.inf.fabrica.pac.dominio;

import br.ufg.inf.fabrica.pac.dominio.utils.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author danilloguimaraes
 */
@Entity
public class Usuario implements Validavel, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private boolean ativo;

    @Transient
    private String login;
    @Transient
    private String senha;
    @Transient
    private String nome;
    @Transient
    private String email;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean value) {
        this.ativo = value;
    }

    @Override
    public List<String> validar() {
        List<String> inconsistencias = new ArrayList<>();
        if(Utils.stringVaziaOuNula(login)){
            inconsistencias.add("Login não informado");
        }
        return inconsistencias;
    }
}
