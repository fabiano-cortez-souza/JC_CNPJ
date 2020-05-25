package br.com.fabiano.linhas;

import java.io.IOException;

import br.com.fabiano.bd.SchemaDB;
import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;


public class CNAE_SECUNDARIAS extends SchemaDB {
    private StringBuilder query = new StringBuilder("");
    private ValidaInteger validainteiro = new ValidaInteger();
	public String transforma(String registro, String arquivo) throws IOException {
	    
		char virgula = ',';
    
		String schema = getSchemaDB(arquivo);
		
	    String aspas = GetProperties.db_aspas();
		
        String    TIPO_DO_REGISTRO        =  aspas + TrataString.trataAspas(registro,0,1) + aspas;
		String    INDICADOR_FULL_DIARIO   =  aspas + TrataString.trataAspas(registro,1,2) + aspas;
		String    TIPO_DE_ATUALIZACAO     =  aspas + TrataString.trataAspas(registro,2,3) + aspas;
		Double    CNPJ                    =  Double.parseDouble( TrataString.trataAspas(registro,3,17));
		Integer   CNAE_SECUNDARIA         =  validainteiro.validaInteger(TrataString.trataAspas(registro,17,24));
		String    FILLER                  =  aspas + TrataString.trataAspas(registro,24,513) + aspas;
		String    FIM_REGISTRO            =  aspas + TrataString.trataAspas(registro,513,514) + aspas;
		          arquivo                 =  aspas + arquivo + aspas;
                       
		query.append("Insert into " + schema + ".TAB_CNAE_SECUNDARIAS  values (");  
		query.append(TIPO_DO_REGISTRO);       query.append( virgula );
	    query.append(INDICADOR_FULL_DIARIO);  query.append( virgula );
		query.append(TIPO_DE_ATUALIZACAO);    query.append( virgula );
		query.append(CNPJ);                   query.append( virgula );
		query.append(CNAE_SECUNDARIA);        query.append( virgula );
		query.append(FILLER);                 query.append( virgula );
		query.append(FIM_REGISTRO);           query.append( virgula );;
		query.append(arquivo);
		query.append(")");
		return query.toString();

	}

}
