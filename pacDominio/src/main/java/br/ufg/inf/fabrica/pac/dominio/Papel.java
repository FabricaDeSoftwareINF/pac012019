package br.ufg.inf.fabrica.pac.dominio;

/**
 *
 * @author Danillo
 */
public enum Papel {
    GPP ("GPP"), // Gerente de Portifólio
    GPR("GPR"), // Gerente de Projetos
    MEG("MEG"), // Membro de equipe gerencial
    ME("ME");   // Membro de equipe
    
    private String codigo;
    
    Papel (String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
