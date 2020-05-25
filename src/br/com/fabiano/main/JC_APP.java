package br.com.fabiano.main;

import java.io.File;

import br.com.fabiano.bd.ExecSQL;
import br.com.fabiano.common.EnumFalha;
import br.com.fabiano.common.EnumStatusProcessamento;
import br.com.fabiano.io.readFile;
import br.com.fabiano.util.ControleProcessamento;

public class JC_APP {

    static ControleProcessamento controleProcessamento = new ControleProcessamento();

    public static void main(String[] args) {
        String arquivo = "";
        
        if (controleProcessamento.isOKfileSystem()) {
            ExecSQL execSQL = new ExecSQL();
            arquivo = arquivo + args[0];
            boolean verLog = true;

            // System.out.println(args[1]);
            /*
             * Testa se Banco disponivel
             */

            if (execSQL.testeDB(verLog, controleProcessamento)) {
                System.out.println("Conectou no Banco com sucesso!!!");
                /*
                 * Testa se arquivo Existe
                 */
                if (new readFile().arquivoExiste(arquivo)) {
                    try {
                        if (controleProcessamento.gravaControle(new File(arquivo).getName().toString(), 0)) {
                            processa(arquivo, execSQL, controleProcessamento);
                        }
                    } catch (Exception e) {
                        System.out.println("CAGOU: " + e.toString());
                        atualizaControle(arquivo, EnumStatusProcessamento.ERRO);
                        controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaProcessamento.getIntLevel(),
                                JC_APP.class.getName());
                    }
                } else {
                    System.out.println("ERRO: Arquivo nao existe !!! ");
                    controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaFile.getIntLevel(),
                            JC_APP.class.getName());
                }
            } else {
                System.out.println("ERRO: Banco não disponivel !!! ");
                controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaDB.getIntLevel(), JC_APP.class.getName());
            }
        
        atualizaControle(arquivo, EnumStatusProcessamento.PROCESSADO);
        }
        if (controleProcessamento.isOkPathCNPJ() == false) {
           System.out.println("ERRO: Arquivos não disponivel !!! ");
        }else if (controleProcessamento.isOKpathDB() == false) {
            System.out.println("ERRO: Banco não disponivel !!! ");
        }
        controleProcessamento.finalizaExecPorFalha(EnumFalha.FalhaProcessamento.getIntLevel(), JC_APP.class.getName());

    }

    private static void processa(String arquivo, ExecSQL execSQL, ControleProcessamento controleProcessamento) {
        new readFile().processaArquivo(arquivo, execSQL, controleProcessamento);
    }

    private static void atualizaControle(String arquivo, EnumStatusProcessamento enumprocess) {
        try {
            controleProcessamento.atualizaControle(arquivo, 0, enumprocess);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("ERRO: Gravação de controle falho !!! " + e1.toString());
        }
    }

    protected void finalize() {
        controleProcessamento.closeConn();
        System.gc();
        System.out.println("object is garbage collected " + getClass());
    }
}
