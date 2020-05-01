package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;

public class HEADER {
    private StringBuilder query = new StringBuilder("");
    private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro, String arquivo) throws IOException {
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
		
		String  TIPO_DO_REGISTRO   = aspas + TrataString.trataAspas(registro,0,1)   + aspas;
		String  FILLER             = aspas + TrataString.trataAspas(registro,1,17)  + aspas;
		String  NOME_DO_ARQUIVO    = aspas + TrataString.trataAspas(registro,17,28) + aspas;
		Integer DATA_DE_GRAVACAO   = validainteiro.validaInteger(TrataString.trataAspas(registro,28,36));
		Integer NUMERO_DA_REMESSA  = validainteiro.validaInteger(TrataString.trataAspas(registro,36,44));
		String  FILLER2            = aspas + TrataString.trataAspas(registro,44,1199) + aspas;
		String  FIM_DEREGISTRO     = aspas + TrataString.trataAspas(registro,1199,1200) + aspas;
		        arquivo            =  aspas + arquivo + aspas;
		
		query.append("Insert into CNPJ.TAB_HEADER values ("); 
		query.append(TIPO_DO_REGISTRO);  query.append( virgula );
		query.append(FILLER);            query.append( virgula );
		query.append(NOME_DO_ARQUIVO);   query.append( virgula );
		query.append(DATA_DE_GRAVACAO);  query.append( virgula );
		query.append(NUMERO_DA_REMESSA); query.append( virgula );
		query.append(FILLER2);           query.append( virgula );
		query.append(FIM_DEREGISTRO);    query.append( virgula );
		query.append(arquivo);
		query.append(");");
		return query.toString();

	}

}
