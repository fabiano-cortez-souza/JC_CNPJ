package br.com.fabiano.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import br.com.fabiano.common.EnumFalha;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.main.JC_APP;
import br.com.fabiano.util.ControleProcessamento;

public class ConnectionDB {

    public Connection getConnection(boolean verlog,ControleProcessamento  controleProcessamento) throws Exception {
        Connection connection = null;

        String db = GetProperties.db();
        String driver = GetProperties.db_driver();
        String connString = GetProperties.db_conn();
        String user = GetProperties.db_user();
        String password = GetProperties.db_pass();

        if (verlog) {
            System.out.println("-------- " + db + " JDBC Connection Testing ------");
        }

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connString, user, password);
            if (verlog) {
                System.out.println(db + " JDBC Driver Registered!");
            }
        } catch (PSQLException psqle) {
            System.out.println("FATAL: password authentication failed for user " + user + " ex:" + psqle);
            controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaDB.getIntLevel(), this.getClass().getName() );
        } catch (SQLException sqle) {
            System.out.println("Connection Failed! Check output console - ex: " + sqle.toString());
            controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaDB.getIntLevel(), this.getClass().getName() );
        } catch (ClassNotFoundException cnfe) {
            controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(), this.getClass().getName() );
            System.out.println("Where is your " + db + " JDBC Driver? - ex: " + cnfe.toString());
        } catch (Exception e) {
            controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaProcessamento.getIntLevel(), this.getClass().getName() );
            System.out.println("Another erro in " + db + " JDBC Driver? - ex: " + e.toString());
        }

        return connection;
    }
}
