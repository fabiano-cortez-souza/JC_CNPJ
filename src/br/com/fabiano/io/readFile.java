package br.com.fabiano.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.fabiano.bd.ConnectionDB;
import br.com.fabiano.bd.ExecSQL;
import br.com.fabiano.linhas.CNAE_SECUNDARIAS;
import br.com.fabiano.linhas.HEADER;
import br.com.fabiano.linhas.PRINCIPAL;
import br.com.fabiano.linhas.SOCIOS;
import br.com.fabiano.linhas.TRAILLER;

public class readFile {

	boolean status;

	public boolean arquivoExiste(String arquivo) {

		File arquivoProcessar = new File(arquivo);

		setStatus(arquivoProcessar.exists());

		return status;
	}

	public boolean processaArquivo(String arquivo, ExecSQL execSQL) {
		Connection conn = null;

		try {
			conn = new ConnectionDB().getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = null;
		FileReader fr = null;

		int count = 0;
		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);

			String sCurrentLine;

			/*
			 * Coração do programa
			 */
			while ((sCurrentLine = br.readLine()) != null) {

			    try {
	                count = count + 1;
	                // System.out.println(sCurrentLine.substring(0,1));

	                String query = null;
	                Integer tipo = Integer.parseInt(sCurrentLine.toString().substring(0, 1));

	                switch (tipo.intValue()) {
	                case 0:
	                    query = new HEADER().transforma(sCurrentLine);
	                    break;
	                case 1:
	                    query = new PRINCIPAL().transforma(sCurrentLine, count);
	                    break;
	                case 2:
	                    query = new SOCIOS().transforma(sCurrentLine);
	                    break;
	                case 6:
	                    query = new CNAE_SECUNDARIAS().transforma(sCurrentLine);
	                    break;
	                case 9:
	                    query = new TRAILLER().transforma(sCurrentLine);
	                    break;
	                default:
	                    break;
	                }

	                // TODO Auto-generated method stub
	                try {
	                    boolean ok = execSQL.execInsert(query, conn);
	                    if (ok) {
	                        // System.out.println("Comando SQL : Execução OK");
	                        System.out.println("LINHA.: " + count + " TIPO.: " + tipo.intValue());

	                    } else {
	                        System.out.println("Comando SQL : Execução NOK = " + query);
	                    }
	                } catch (Exception e) {
	                    // TODO Auto-generated catch block
	                  System.out.println("Merda no Insert: " + e.toString());
	                }
                    
                } catch (Exception e) {
                    System.out.println("Merda na Transformação: " + e.toString());
                }
			}

		} catch (IOException e) {

			e.printStackTrace();

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

		return false;

	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
