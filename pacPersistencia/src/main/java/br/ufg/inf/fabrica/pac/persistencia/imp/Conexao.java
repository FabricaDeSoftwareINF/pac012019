package br.ufg.inf.fabrica.pac.persistencia.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danillo
 */
public class Conexao {

    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/PAC2015?zeroDateTimeBehavior=convertToNull";
        String user = "pac";
        String senha = "pac";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(dbUrl, user, senha);
    }
}
