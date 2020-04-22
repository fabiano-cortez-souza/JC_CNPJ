package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;

public class SOCIOS {
    private StringBuilder query = new StringBuilder("");
    
        private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro) throws IOException {
		char virgula = ',';
		
        Properties prop = new GetProperties().getProperties();
        String db = prop.getProperty("dbtipo");
        String aspas = prop.getProperty(db + "_db_aspas");
		
        Integer TIPO_DE_REGISTRO                        = validainteiro.validaInteger(registro.substring(0,1));
		String  INDICADOR_FULL_DIARIO                   = aspas + TrataString.trataAspas(registro.substring(1,2)) + aspas;
		String  TIPO_DE_ATUALIZACAO                     = aspas + TrataString.trataAspas(registro.substring(2,3)) + aspas;
		Integer CNPJ                                    = validainteiro.validaInteger (registro.substring(3,17));
		Integer IDENTIFICADOR_DE_SOCIO                  = validainteiro.validaInteger(registro.substring(17,18));
		String  NOME_SOCIO_NO_CASO_PF                   = aspas + TrataString.trataAspas(registro.substring(18,168))  + aspas;
		String  CNPJ_CPF_DO_SOCIO                       = aspas + TrataString.trataAspas(registro.substring(168,182)) + aspas;
		String  CODIGO_QUALIFICACAO_SOCIO               = aspas + TrataString.trataAspas(registro.substring(182,184)) + aspas;
		Integer PERCENTUAL_CAPITAL_SOCIAL               = validainteiro.validaInteger(registro.substring(184,189));
		Integer DATA_ENTRADA_SOCIEDADE                  = validainteiro.validaInteger( registro.substring(189,197));
		String  CODIGO_PAIS                             = aspas + TrataString.trataAspas(registro.substring(197,200)) + aspas;
		String  NOME_PAIS_SOCIO                         = aspas + TrataString.trataAspas(registro.substring(200,270)) + aspas;
		String  CPF_REPRESENTANTE_LEGAL                 = aspas + TrataString.trataAspas(registro.substring(270,281)) + aspas;
		String  NOME_REPRESENTANTE                      = aspas + TrataString.trataAspas(registro.substring(281,341)) + aspas;
		String  CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL = aspas + TrataString.trataAspas(registro.substring(341,343)) + aspas;
		String  FILLER                                  = aspas + TrataString.trataAspas(registro.substring(343,1198)) + aspas;
		String  FIM_REGISTRO                            = aspas + TrataString.trataAspas(registro.substring(1198,1200)) + aspas;
			
		query.append("Insert into CNPJ.TAB_SOCIOS values (");  
		query.append(TIPO_DE_REGISTRO);                        query.append( virgula );
		query.append(INDICADOR_FULL_DIARIO);                   query.append( virgula ); 
		query.append(TIPO_DE_ATUALIZACAO);                     query.append( virgula );
		query.append(CNPJ);                                    query.append( virgula );
		query.append(IDENTIFICADOR_DE_SOCIO);                  query.append( virgula );
		query.append(NOME_SOCIO_NO_CASO_PF);                   query.append( virgula );
		query.append(CNPJ_CPF_DO_SOCIO);                       query.append( virgula );
		query.append(CODIGO_QUALIFICACAO_SOCIO);               query.append( virgula );
		query.append(PERCENTUAL_CAPITAL_SOCIAL);               query.append( virgula );
		query.append(DATA_ENTRADA_SOCIEDADE);                  query.append( virgula );
		query.append(CODIGO_PAIS);                             query.append( virgula );
		query.append(NOME_PAIS_SOCIO);                         query.append( virgula );
        query.append(CPF_REPRESENTANTE_LEGAL);                 query.append( virgula );
	    query.append(NOME_REPRESENTANTE);                      query.append( virgula );
	    query.append(CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL); query.append( virgula );
        query.append(FILLER);                                  query.append( virgula );
        query.append(FIM_REGISTRO);                            
        query.append(")");
		return query.toString();

	}

}
