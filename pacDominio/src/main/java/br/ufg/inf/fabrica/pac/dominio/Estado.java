package br.ufg.inf.fabrica.pac.dominio;

import br.ufg.inf.fabrica.pac.dominio.utils.UtilsValidacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Danillo
 */
@Entity
public class Estado implements Serializable, Validavel {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private boolean estadoFinal;
    private String descricao;
    private boolean permiteDelegacao;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Papel> papeis = new ArrayList<>();

    public Estado() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPermiteDelegacao() {
        return permiteDelegacao;
    }

    public void setPermiteDelegacao(boolean permiteDelegacao) {
        this.permiteDelegacao = permiteDelegacao;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    @Override
    public List<String> validar() {
        List<String> erros = new ArrayList<>();
        if(UtilsValidacao.isNullOrEmpty(nome)){
            erros.add("Nome não informado");
        }
        return erros;
    }
    
}
