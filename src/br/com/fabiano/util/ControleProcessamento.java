package br.com.fabiano.util;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fabiano.bd.ConnectionDB;
import br.com.fabiano.bd.ExecSQL;
import br.com.fabiano.bd.SchemaDB;
import br.com.fabiano.common.EnumStatusProcessamento;
import br.com.fabiano.infra.GetProperties;

public class ControleProcessamento extends SchemaDB {

    private boolean isOkPathCNPJ = false;
    private boolean isOKpathDB = false;

    private String pathCNPJ = null;
    private String pathDB = null;
    private String nomeArquivoProcessa = null;
    private Integer registro_processado = 0;

    private ExecSQL execSql = null;
    private Connection conn = null;
    private boolean sqlExecIsOK;
    private String sql = null;
    private File pathcnpj = null;
    private File pathdb = null;

    private StringBuilder sqlControle = new StringBuilder("");
    private boolean verLog = true;

    public ControleProcessamento() {
        super();
        setSql("");
        setSqlExecIsOK(false);

        try {
            setConn(new ConnectionDB().getConnection(verLog, this));
            setExecSql(new ExecSQL());

            setPathCNPJ(GetProperties.path_CNPJ());
            setPathDB(GetProperties.path_DB());

            setPathcnpj(new File(getPathCNPJ()));
            setPathdb(new File(getPathDB()));

            setOkPathCNPJ(pathcnpj.isDirectory());
            setOKpathDB(pathdb.isDirectory());

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("Erro em obter properties ou ExecSQLDB");
        }
    }

    public boolean gravaControle(String arquivo, int registro) throws Exception {
        sqlControle.delete(0, sqlControle.length());

        sqlControle.append("INSERT INTO " + getSchemaDB(arquivo) + ".TAB_CONTROLE ");
        sqlControle.append("(ARQUIVO,REGISTRO_PROCESSADO,STATUS_PORCESSAMENTO)");
        sqlControle.append(" VALUES (");
        sqlControle.append("\'" + arquivo + "\',");
        sqlControle.append(registro + ",");
        sqlControle.append("\'" + EnumStatusProcessamento.PROCESSANDO.toString() + "\'");
        sqlControle.append(") ");
        // equivaltente a if exists
        sqlControle.append("ON CONFLICT (ARQUIVO) ");
        sqlControle.append("DO NOTHING;");

        setSql(sqlControle.toString());
        try {
            setSqlExecIsOK(execSql.execInsert(sql, conn));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sqlExecIsOK;
    }

    public boolean atualizaControle(String arquivo, int registro, EnumStatusProcessamento enumstatus) throws Exception {

        sqlControle.delete(0, sqlControle.length());
        arquivo = new File(arquivo).getName();
        
        sqlControle.append("UPDATE " + getSchemaDB(arquivo) + ".TAB_CONTROLE ");

        switch (enumstatus) {
        case ERRO:
        case PROCESSADO:
            sqlControle.append("SET STATUS_PORCESSAMENTO = ");
            sqlControle.append("\'" + enumstatus.toString() + "\'");
            break;
        case PROCESSANDO:
            sqlControle.append("SET REGISTRO_PROCESSADO = ");
            sqlControle.append(registro);
            break;
        default:
            break;
        }

        sqlControle.append(" WHERE ARQUIVO = ");
        sqlControle.append("\'" + arquivo + "\'");
        sqlControle.append(" ;");
        // Montar String de gravar

        setSql(sqlControle.toString());
        try {
            setSqlExecIsOK(execSql.execInsert(sql, conn));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sqlExecIsOK;
    }

    public int verificaProcessamento(String arquivo) throws Exception {

        boolean verLog = false;
        int registro = 0;
        arquivo = new File(arquivo).getName();

        sqlControle.delete(0, sqlControle.length());
        sqlControle.append("SELECT REGISTRO_PROCESSADO, STATUS_PORCESSAMENTO ");
        sqlControle.append("FROM " + getSchemaDB(arquivo) + ".TAB_CONTROLE ");
        sqlControle.append("WHERE ARQUIVO = ");
        sqlControle.append("\'" + arquivo + "\'");
        sqlControle.append(" ;");

        setSql(sqlControle.toString());
        try {
            // setSqlExecIsOK(execSql.exec(sql, conn));
            List<String> list = execSql.exec(sql, conn, verLog, this);

            if (!(list == null) && list.size() > 0) {
                for (String aString : list) {
                    // System.out.println(aString);

                    registro = Integer.parseInt(aString);
                }

            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return registro;
    }

    public File getPathcnpj() {
        return pathcnpj;
    }

    public void setPathcnpj(File pathcnpj) {
        this.pathcnpj = pathcnpj;
    }

    public File getPathdb() {
        return pathdb;
    }

    public void setPathdb(File pathdb) {
        this.pathdb = pathdb;
    }

    public boolean isOkPathCNPJ() {
        return isOkPathCNPJ;
    }

    public void setOkPathCNPJ(boolean isOkPathCNPJ) {
        this.isOkPathCNPJ = isOkPathCNPJ;
    }

    public boolean isOKpathDB() {
        return isOKpathDB;
    }

    public void setOKpathDB(boolean isOKpathDB) {
        this.isOKpathDB = isOKpathDB;
    }

    public String getPathCNPJ() {
        return pathCNPJ;
    }

    public void setPathCNPJ(String pathCNPJ) {
        this.pathCNPJ = pathCNPJ;
    }

    public String getPathDB() {
        return pathDB;
    }

    public void setPathDB(String pathDB) {
        this.pathDB = pathDB;
    }

    public String getNomeArquivoProcessa() {
        return nomeArquivoProcessa;
    }

    public void setNomeArquivoProcessa(String nomeArquivoProcessa) {
        this.nomeArquivoProcessa = nomeArquivoProcessa;
    }

    public Integer getRegistro_processado() {
        return registro_processado;
    }

    public void setRegistro_processado(Integer registro_processado) {
        this.registro_processado = registro_processado;
    }

    public ExecSQL getExecSql() {
        return execSql;
    }

    public void setExecSql(ExecSQL execSql) {
        this.execSql = execSql;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public boolean isSqlExecIsOK() {
        return sqlExecIsOK;
    }

    public void setSqlExecIsOK(boolean sqlExecIsOK) {
        this.sqlExecIsOK = sqlExecIsOK;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isOKfileSystem() {
        setOkPathCNPJ(pathcnpj.isDirectory());
        setOKpathDB(pathdb.isDirectory());

        return isOKpathDB && isOkPathCNPJ;
    }

    public void finalizaExecPorFalha(int error, String classe) {
        closeConn();
        System.out.println("Classe finalizadora: " + classe);
        System.exit(error);
    }

    public void closeConn() {
        try {
            if (conn != null) {
                if (!conn.isClosed()) {
                    conn.close();
                    System.out.println("Liberando Connection da classe: " + this.getClass());
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Liberação nok Connection da classe: " + this.getClass() + " sqlexception: " + sqle.toString());
        } catch (Exception e) {
            System.out.println("Liberação nok Connection da classe: " + this.getClass() + " exception: " + e.toString());
        }

    }

}
