package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class HEADER {
    private String query;
    private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro_0) {
		/*
		System.out.println(registro_0);
		System.out.println("A " + registro_0.substring(0,3));
		System.out.println("B " + registro_0.substring(4,7));
		System.out.println("C " + registro_0.substring(8,11));
		System.out.println("D " + registro_0.substring(12,15));
		*/
		char virgula = ',';
		char apas = '"';
		
		String TIPO_DO_REGISTRO   = apas + registro_0.substring(0,1).trim() + apas;
		String FILLER             = apas + registro_0.substring(1,17).trim() + apas;
		String NOME_DO_ARQUIVO    = apas + registro_0.substring(17,28).trim() + apas;
		Integer DATA_DE_GRAVACAO  = validainteiro.validaInteger(registro_0.substring(28,36));
		Integer NUMERO_DA_REMESSA = validainteiro.validaInteger(registro_0.substring(36,44));
		String FILLER2            = apas + registro_0.substring(44,1199).trim() + apas;
		String FIM_DEREGISTRO     = apas + registro_0.substring(1199,1200).trim() + apas;
		
		query = "Insert into TAB_HEADER values (" + 
		         TIPO_DO_REGISTRO  + virgula +
				 FILLER            + virgula +
				 NOME_DO_ARQUIVO   + virgula +
				 DATA_DE_GRAVACAO  + virgula +
				 NUMERO_DA_REMESSA + virgula +
				 FILLER2           + virgula +
				 FIM_DEREGISTRO    +  ");";
		return query;

	}

}
