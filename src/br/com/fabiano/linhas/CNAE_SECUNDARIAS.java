package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;


public class CNAE_SECUNDARIAS {
    private StringBuilder query = new StringBuilder("");
    private ValidaInteger validainteiro = new ValidaInteger();
	public String transforma(String registro_0) throws IOException {
		char virgula = ',';
    
		Properties prop = new GetProperties().getProperties();
		String db = prop.getProperty("dbtipo");
	    String aspas = prop.getProperty(db + "_db_aspas");
		
        String    TIPO_DO_REGISTRO        =  aspas + TrataString.trataAspas(registro_0.substring(0,1)) + aspas;
		String    INDICADOR_FULL_DIARIO   =  aspas + TrataString.trataAspas(registro_0.substring(1,2)) + aspas;
		String    TIPO_DE_ATUALIZACAO     =  aspas + TrataString.trataAspas(registro_0.substring(2,3)) + aspas;
		Double    CNPJ                    =  Double.parseDouble( registro_0.substring(3,17));
		Integer   CNAE_SECUNDARIA         =  validainteiro.validaInteger(registro_0.substring(17,24));
		String    FILLER                  =  aspas + TrataString.trataAspas(registro_0.substring(24,513)) + aspas;
		String    FIM_REGISTRO            =  aspas + TrataString.trataAspas(registro_0.substring(513,514)) + aspas;
                       
		query.append("Insert into CNPJ.TAB_CNAE_SECUNDARIAS  values (");  
		query.append(TIPO_DO_REGISTRO);       query.append( virgula );
	    query.append(INDICADOR_FULL_DIARIO);  query.append( virgula );
		query.append(TIPO_DE_ATUALIZACAO);    query.append( virgula );
		query.append(CNPJ);                   query.append( virgula );
		query.append(CNAE_SECUNDARIA);        query.append( virgula );
		query.append(FILLER);                 query.append( virgula );
		query.append(FIM_REGISTRO); 			
		query.append(")");
		return query.toString();

	}

}
