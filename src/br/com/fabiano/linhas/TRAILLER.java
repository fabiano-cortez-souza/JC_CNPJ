package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;

public class TRAILLER {
    private StringBuilder query = new StringBuilder("");
    private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro_0) throws IOException {
		char virgula = ',';
		
        Properties prop = new GetProperties().getProperties();
        String db = prop.getProperty("dbtipo");
        String aspas = prop.getProperty(db + "_db_aspas");
		
        String  TIPO_DO_REGISTRO       = aspas + TrataString.trataAspas(registro_0.substring(1,1)) + aspas;
		String  FILLER1                = aspas + TrataString.trataAspas(registro_0.substring(2,17)) + aspas;
		Integer TOTAL_DE_REGISTROS_T1  = validainteiro.validaInteger(registro_0.substring(18,26));
		Integer TOTAL_DE_REGISTROS_T2  = validainteiro.validaInteger( registro_0.substring(27,35));
		Integer TOTAL_DE_REGISTROS_T3  = validainteiro.validaInteger(registro_0.substring(36,44));
		Integer TOTAL_DE_REGISTROS     = validainteiro.validaInteger(registro_0.substring(45,55));
		Integer FILLER                 = validainteiro.validaInteger(registro_0.substring(56,1199));
		String  FIM_DE_REGISTRO        = aspas + TrataString.trataAspas(registro_0.substring(1200,1200)) + aspas;

		query.append("Insert into CNPJ.TAB_TRAILLER values (");  
		query.append(TIPO_DO_REGISTRO);      query.append( virgula );
		query.append(FILLER1);               query.append( virgula );
		query.append(TOTAL_DE_REGISTROS_T1); query.append( virgula );
        query.append(TOTAL_DE_REGISTROS_T2); query.append( virgula );
        query.append(TOTAL_DE_REGISTROS_T3); query.append( virgula );
        query.append(TOTAL_DE_REGISTROS);    query.append( virgula );
        query.append(FILLER);                query.append( virgula );
        query.append(FIM_DE_REGISTRO);
        query.append(")");

        return query.toString();
	}

}
