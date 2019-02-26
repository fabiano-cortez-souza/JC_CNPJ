package br.com.fabiano.main;

import br.com.fabiano.bd.ExecSQL;
import br.com.fabiano.io.readFile;

public class JC_APP {

	public static void main(String[] args) {
		ExecSQL execSQL = new ExecSQL();
		String arquivo = args[0];
		//System.out.println(args[1]);
		/*
		 * Testa se Banco disponivel
		 */
		if (execSQL.testeDB()){
			/*
			 * Testa se arquivo Existe
			 */
			if ( new readFile().arquivoExiste(arquivo)) {
				try {
					processa(arquivo, execSQL);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("CAGOU: " + e.toString());
				}
				
			} else {
				System.out.println("ERRO: Arquivo nao existe !!! ");
			}
		} else {
			System.out.println("ERRO: Banco não disponivel !!! ");
		}
	}
	
	private static void processa(String arquivo, ExecSQL execSQL) {
		new readFile().processaArquivo(arquivo, execSQL);
	}

}
