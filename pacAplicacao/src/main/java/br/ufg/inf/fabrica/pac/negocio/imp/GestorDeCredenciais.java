package br.ufg.inf.fabrica.pac.negocio.imp;

import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.persistencia.DaoUsuario;

/**
 *
 * @author Danillo
 */
public class GestorDeCredenciais {
    
    public boolean autenticar(Usuario credencial){
        DaoUsuario dao = new DaoUsuario();
        Usuario credencialRegistrada = dao.buscar(credencial.getId());
        if(credencialRegistrada!=null){
            return credencialRegistrada.isAtivo();
        } else {
            credencial.setAtivo(true);
            dao.salvar(credencial);
            return true;
        }
    }
}
