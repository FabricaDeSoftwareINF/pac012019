package br.ufg.inf.fabrica.servicos;

import br.ufg.inf.fabrica.ldapinfautenticador.ILdapAutenticador;
import br.ufg.inf.fabrica.ldapinfautenticador.imp.LdapAutenticador;
import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.imp.GestorDeCredenciais;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import br.ufg.inf.fabrica.servicos.util.UtilsServicos;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Danillo
 */
public class SrvAutenticador {

    public Resposta<Boolean> autenticar(Usuario credencial) {
        try {
            String nomeVariavelAmbiente = "PAC_PROPERTIES";
            String propFileName = UtilsServicos.getVariavelDeAmbiente(nomeVariavelAmbiente);
            Properties prop = new Properties();
            prop.load(new FileReader(propFileName));
            
            ILdapAutenticador autenticador = new LdapAutenticador(prop, 
                    credencial.getLogin(), credencial.getSenha());
            if(autenticador.isCredencialValida()){
                credencial.setId(autenticador.getId());
                credencial.setNome(autenticador.getNome());
                credencial.setEmail(autenticador.getEmail());
                GestorDeCredenciais gestor = new GestorDeCredenciais();
                return Resposta.novaInstanciaDeSucesso(gestor.autenticar(credencial));
            }
        } catch (IOException | NamingException ex) {
            Logger.getLogger(SrvAutenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resposta.novaInstanciaDeSucesso(Boolean.FALSE);
    }

}
