package br.com.fabiano.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.fabiano.bd.ConnectionDB;
import br.com.fabiano.bd.ExecSQL;
import br.com.fabiano.common.EnumFalha;
import br.com.fabiano.common.EnumStatusProcessamento;
import br.com.fabiano.linhas.CNAE_SECUNDARIAS;
import br.com.fabiano.linhas.HEADER;
import br.com.fabiano.linhas.PRINCIPAL;
import br.com.fabiano.linhas.SOCIOS;
import br.com.fabiano.linhas.TRAILLER;
import br.com.fabiano.util.ControleProcessamento;

public class readFile {

    boolean status;

    StringBuilder msgError = new StringBuilder("");
    
    public boolean arquivoExiste(String arquivo) {
        File arquivoProcessar = new File(arquivo);
        setStatus(arquivoProcessar.exists());
        return status;
    }

    public boolean processaArquivo(String arquivo, ExecSQL execSQL, ControleProcessamento controleProcessamento) {
        Connection conn = null;
        boolean verLog = true;

        try {
            conn = new ConnectionDB().getConnection(verLog,controleProcessamento);
            BufferedReader br = null;
            FileReader fr = null;
            String nomeArquivo = null;
            
            int count = 0;
            int conntDB = 0;
            try {

                // br = new BufferedReader(new FileReader(FILENAME));
                fr = new FileReader(arquivo);
                br = new BufferedReader(fr);
                nomeArquivo = new File(arquivo).getName();

                String sCurrentLine;

                /*
                 * Coração do programa
                 */
                while ((sCurrentLine = br.readLine()) != null) {

                    try {
                        count = count + 1;
                        conntDB = controleProcessamento.verificaProcessamento(arquivo);

                        if (count > conntDB) {

                            // Montar retorno do ponto de controle

                            String query = null;
                            Integer tipo = Integer.parseInt(sCurrentLine.toString().substring(0, 1));

                            switch (tipo.intValue()) {
                            case 0:
                                query = new HEADER().transforma(sCurrentLine, nomeArquivo);
                                break;
                            case 1:
                                query = new PRINCIPAL().transforma(sCurrentLine,nomeArquivo ,count);
                                break;
                            case 2:
                                query = new SOCIOS().transforma(sCurrentLine,nomeArquivo);
                                break;
                            case 6:
                                query = new CNAE_SECUNDARIAS().transforma(sCurrentLine,nomeArquivo);
                                break;
                            case 9:
                                query = new TRAILLER().transforma(sCurrentLine, nomeArquivo);
                                break;
                            default:
                                break;
                            }

                            // TODO Auto-generated method stub
                            try {
                                if (controleProcessamento.isOKfileSystem()) {
                                    boolean execQueryok = execSQL.execInsert(query, conn);
                                    if (execQueryok) {
                                        System.out.println("LINHA.: " + count + " TIPO.: " + tipo.intValue());
                                        controleProcessamento.atualizaControle(arquivo, count,
                                                EnumStatusProcessamento.PROCESSANDO);
                                    } else {
                                        msgError.append("Comando SQL : Execução NOK = ");
                                        msgError.append(query);
                                        ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                                        controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaDB.getIntLevel(),
                                                readFile.class.getName());
                                    }
                                } else {
                                    msgError.append("DB   Diretório não disponivel = ");
                                    msgError.append(controleProcessamento.getPathDB());
                                    msgError.append(" : Status = ");
                                    msgError.append(controleProcessamento.isOKpathDB());
                                    msgError.append("\n CNPJ Diretório não disponivel = ");
                                    msgError.append(controleProcessamento.getPathCNPJ());
                                    msgError.append(" : Status = ");
                                    msgError.append(controleProcessamento.isOkPathCNPJ());
                                    ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                                    controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(),
                                            readFile.class.getName());
                                }
                            } catch (SQLException se) {
                                msgError.append("Merda no SQL Insert: ");
                                msgError.append(se.toString());
                                ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaDB.getIntLevel(),
                                        readFile.class.getName());
                            } catch (IOException ioe) {
                                msgError.append("Merda de IO antes do Insert: ");
                                msgError.append(ioe.toString());
                                ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(),
                                        readFile.class.getName());
                            } catch (Exception e) {
                                msgError.append("Merda antes do Insert: ");
                                msgError.append(e.toString());
                                ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaProcessamento.getIntLevel(),
                                        readFile.class.getName());
                            }
                        }
                    } catch (Exception e) {
                        msgError.append("Merda na Transformação: ");
                        msgError.append(e.toString());
                        ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                        controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(),
                                readFile.class.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                msgError.append("Merda Connection Banco : ");
                msgError.append(e.toString());
                ErrorLOG(msgError.toString(), arquivo, controleProcessamento);
                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(), readFile.class.getName());
            } finally {
                try {
                    if (br != null)
                        br.close();
                    if (fr != null)
                        fr.close();
                    if (conn != null) {
                        try {
                            if (!conn.isClosed()) {
                                conn.close();
                            }
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void ErrorLOG(String msg, String arquivo, ControleProcessamento controleProcessamento) {

        try {
            controleProcessamento.atualizaControle(arquivo, 0, EnumStatusProcessamento.ERRO);
            System.out.println(msg);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro LOG msg: " + msg + " exception: " + e);
        } finally {
            msgError.delete(0, msgError.length());
        }

    }

    protected void finalize() {
        System.gc();
        System.out.println("object is garbage collected " + getClass());
    }
}
