package br.ufg.inf.fabrica.pac.dominio;

import br.ufg.inf.fabrica.pac.dominio.utils.UtilsValidacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author danilloguimaraes
 */
@Entity
public class Projeto implements Validavel, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    private String patrocinador;
    private String stakeholders;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(String stakeholders) {
        this.stakeholders = stakeholders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isValido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> validar() {
        List<String> inconsistencias = new ArrayList<>();
        if(UtilsValidacao.isNullOrEmpty(nome)){
            inconsistencias.add("Nome não informado");
        }
        if(UtilsValidacao.isNullOrEmpty(descricao)){
            inconsistencias.add("Descrição não informada");
        }
        if (dataInicio == null) {
            inconsistencias.add("Data de inicio não informada");
        }
        if (dataTermino == null) {
            inconsistencias.add("Data de término não informada");
        }
        if(UtilsValidacao.isNullOrEmpty(patrocinador)){
            inconsistencias.add("Patrocinador não informado");
        }
        if(UtilsValidacao.isNullOrEmpty(stakeholders)){
            inconsistencias.add("Stakeholder não informado");
        }
        if (dataInicio!=null && dataInicio.after(dataInicio)) {
            inconsistencias.add("Data de inicio após data de término");
        }
        return inconsistencias;
    }
}
