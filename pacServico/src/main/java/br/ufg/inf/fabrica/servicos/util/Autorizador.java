package br.ufg.inf.fabrica.servicos.util;

import br.ufg.inf.fabrica.pac.dominio.Usuario;

/**
 *
 * @author Danillo
 */
public class Autorizador {
    
    public boolean autorizarAcesso(Usuario credencial, String recurso){
        return true;
    }
    
    public boolean autorizarAcesso(Usuario credencial, String recurso, 
            String contexto){
        return true;
    }
    
}
