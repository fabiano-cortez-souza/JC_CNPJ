package br.com.fabiano.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fabiano.common.EnumFalha;
import br.com.fabiano.util.ControleProcessamento;

public class ExecSQL {

    private boolean status = false;

    /*
     * public ExecSQL(String sqlSentence) throws Exception { return
     * exec(sqlSentence); }
     */

    public boolean testeDB(boolean verLog, ControleProcessamento controleProcessamento) {
        Connection conn;
        try {
            conn = new ConnectionDB().getConnection(verLog, controleProcessamento);
            if (conn != null) {
                setStatus(true);
                if (!conn.isClosed()) {
                    conn.close();
                }
            } else {
                setStatus(false);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public List<String> exec(String query, Connection conn, boolean verLog,ControleProcessamento controleProcessamento) throws Exception {

        String msgException = "";
        boolean finalizaProcessamento = false;
        
        List<String> list = new ArrayList<String>();

        ResultSet rs = null;
        //conn.close();
        
        //conn = new ConnectionDB().getConnection(verLog,controleProcessamento);
        
        if (conn == null) {
            // System.out.println("You made it, take control your database now!");
            // } else {
            System.out.println("Failed to make connection!");
        } else {

            Statement stmt = null;
            // String query = sqlSentence;
            try {

                stmt = (Statement) conn.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    // System.out.println(rs.toString());
                    list.add(rs.getString("REGISTRO_PROCESSADO"));
                    /*
                     * String coffeeName = rs.getString("COF_NAME"); int supplierID =
                     * rs.getInt("SUP_ID"); float price = rs.getFloat("PRICE"); int sales =
                     * rs.getInt("SALES"); int total = rs.getInt("TOTAL");
                     * System.out.println(coffeeName + "\t" + supplierID + "\t" + price + "\t" +
                     * sales + "\t" + total);
                     */
                }
                // setStatus(true);
            } catch (SQLException e) {
                // JDBCTutorialUtilities.printSQLException(e);
                System.out.println(e.getMessage().toString());
                System.out.println(e.getErrorCode());
                System.out.println(e.getSQLState());
                // setStatus(false);
                msgException = msgException + e.toString();
                finalizaProcessamento = true;
                
            } finally {
                if (rs != null) {
                    if (!rs.isClosed()) {
                        rs.close();
                    }
                }
                if (stmt != null) {
                    if (!stmt.isClosed()) {
                        stmt.close();
                    }
                }
                /*
                if (conn != null) {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                }
                */
            }
            if (finalizaProcessamento) {
                System.out.println("Falha processamento ex: " + msgException);
                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaProcessamento.getIntLevel(), this.getClass().getName());
            }

        }
        return list;
    }

    public boolean execInsert(String query, Connection conn) throws Exception {

        if (conn != null) {
            // System.out.println("You made it, take control your database now!");

            Statement stmt = null;
            // String query = sqlSentence;
            try {

                // execute insert SQL stetement
                stmt = (Statement) conn.createStatement();
                stmt.executeUpdate(query);

                setStatus(true);
            } catch (SQLException e) {
                // JDBCTutorialUtilities.printSQLException(e);
                System.out.println(e.getMessage().toString());
                System.out.println(e.getErrorCode());
                System.out.println(e.getSQLState());
                setStatus(false);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } else {
            System.out.println("Failed to make connection!");
            setStatus(false);
        }

        return status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
