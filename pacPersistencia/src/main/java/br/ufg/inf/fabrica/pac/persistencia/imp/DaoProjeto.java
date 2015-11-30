package br.ufg.inf.fabrica.pac.persistencia.imp;

import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.persistencia.IDaoProjeto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class DaoProjeto implements IDaoProjeto{

    @Override
    public Projeto salvar(Projeto entity) {
        entity.setDataInicio(null);
        entity.setDataTermino(null);
        entity.setDescricao(null);
        entity.setId(0);
        entity.setNome(null);
        entity.setPatrocinador(null);
        entity.setStakeholders(null);
        
        String sqlUpdate = "update PROJETO set DATAINICIO=?, DATATERMINO=?, DESCRICAO=?, NOME=?, PATROCINADOR=?, STAKEHOLDERS=? where ID=?";
        String sqlInsert = "insert into PROJETO (DATAINICIO, DATATERMINO, DESCRICAO, NOME, PATROCINADOR, STAKEHOLDERS) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst;
            if(entity.getId()==0){
                pst = Conexao.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            } else {
                pst = Conexao.getConnection().prepareStatement(sqlUpdate);
                pst.setLong(7, entity.getId());
            }
            pst.setDate(1, convertUtilDateToSqlDate(entity.getDataInicio()));
            pst.setDate(2, convertUtilDateToSqlDate(entity.getDataTermino()));
            pst.setString(3, entity.getDescricao());
            pst.setString(4, entity.getNome());
            pst.setString(5, entity.getPatrocinador());
            pst.setString(6, entity.getStakeholders());
            
            
            pst.execute();
            if(entity.getId()==0){
                ResultSet keys = pst.getGeneratedKeys();
                if(keys.next()){
                    entity.setId(keys.getInt(1));
                }
            }
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Projeto excluir(Projeto entity) {
        String sql = "delete from PROJETO where id=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, entity.getId());
            pst.execute();
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Projeto buscar(long id) {
        String sql = "select e.* from PROJETO where id=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            Projeto projeto = null;
            if (rs.next()){
                projeto = new Projeto();
                projeto.setId(rs.getLong("id"));
                projeto.setDataInicio(convertSqlDateToUtilDate(rs.getDate("dataInicio")));
                projeto.setDataTermino(convertSqlDateToUtilDate(rs.getDate("dataTermino")));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setNome(rs.getString("nome"));
                projeto.setPatrocinador(rs.getString("patrocinador"));
                projeto.setStakeholders(rs.getString("stakeholders"));
            }
            return projeto;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Date convertUtilDateToSqlDate(java.util.Date date){
        return new Date(date.getTime());
    }
    
    private java.util.Date convertSqlDateToUtilDate(Date date){
        return new java.util.Date(date.getTime());
    }
}
