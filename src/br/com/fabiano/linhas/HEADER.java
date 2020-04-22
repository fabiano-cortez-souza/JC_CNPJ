package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;

public class HEADER {
    private StringBuilder query = new StringBuilder("");
    private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro_0) throws IOException {
		/*
		System.out.println(registro_0);
		System.out.println("A " + registro_0.substring(0,3));
		System.out.println("B " + registro_0.substring(4,7));
		System.out.println("C " + registro_0.substring(8,11));
		System.out.println("D " + registro_0.substring(12,15));
		*/
		char virgula = ',';
		
        Properties prop = new GetProperties().getProperties();
        String db = prop.getProperty("dbtipo");
        String aspas = prop.getProperty(db + "_db_aspas");
		
		String TIPO_DO_REGISTRO   = aspas + TrataString.trataAspas(registro_0.substring(0,1)) + aspas;
		String FILLER             = aspas + TrataString.trataAspas(registro_0.substring(1,17)) + aspas;
		String NOME_DO_ARQUIVO    = aspas + TrataString.trataAspas(registro_0.substring(17,28)) + aspas;
		Integer DATA_DE_GRAVACAO  = validainteiro.validaInteger(registro_0.substring(28,36));
		Integer NUMERO_DA_REMESSA = validainteiro.validaInteger(registro_0.substring(36,44));
		String FILLER2            = aspas + TrataString.trataAspas(registro_0.substring(44,1199)) + aspas;
		String FIM_DEREGISTRO     = aspas + TrataString.trataAspas(registro_0.substring(1199,1200)) + aspas;
		
		query.append("Insert into CNPJ.TAB_HEADER values ("); 
		query.append(TIPO_DO_REGISTRO);  query.append( virgula );
		query.append(FILLER);            query.append( virgula );
		query.append(NOME_DO_ARQUIVO);   query.append( virgula );
		query.append(DATA_DE_GRAVACAO);  query.append( virgula );
		query.append(NUMERO_DA_REMESSA); query.append( virgula );
		query.append(FILLER2);           query.append( virgula );
		query.append(FIM_DEREGISTRO);   
		query.append(");");
		return query.toString();

	}

}
