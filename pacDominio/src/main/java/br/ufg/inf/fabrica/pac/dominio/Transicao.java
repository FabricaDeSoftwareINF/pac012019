package br.ufg.inf.fabrica.pac.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Danillo
 */
@Entity
public class Transicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;
    private String regra;
    private long idEstadoOrigem;
    private long idEstadoDestino;

    @ManyToOne
    private Estado estadoOrigem;
    @ManyToOne
    private Estado estadoDestino;

    public Transicao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }

    public long getIdEstadoOrigem() {
        return idEstadoOrigem;
    }

    public void setIdEstadoOrigem(long idEstadoOrigem) {
        this.idEstadoOrigem = idEstadoOrigem;
    }

    public long getIdEstadoDestino() {
        return idEstadoDestino;
    }

    public void setIdEstadoDestino(long idEstadoDestino) {
        this.idEstadoDestino = idEstadoDestino;
    }

    public Estado getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(Estado estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public Estado getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(Estado estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

}
