/*
 * Interface que determina os métodos padões de um crud de entidade.
 */
package br.ufg.inf.fabrica.servicos.iservicos;

import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.utils.Resposta;
import java.util.List;

/**
 *
 * @author Danillo
 */
public interface ICrud <T> {
    
    public Resposta<List<T>> consultar(Usuario solicitante);
    
    public Resposta<Boolean> cadastrar(Usuario solicitante, T entidade);
    
    public Resposta<Boolean> excluir(Usuario solicitante, T entidade);
    
    public Resposta<Boolean> alterar(Usuario solicitante, T entidade);
}
