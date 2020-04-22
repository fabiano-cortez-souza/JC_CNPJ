package br.com.fabiano.linhas;

import java.io.IOException;
import java.util.Properties;

import br.com.fabiano.common.ValidaInteger;
import br.com.fabiano.infra.GetProperties;
import br.com.fabiano.util.TrataString;

public class PRINCIPAL {
    private StringBuilder query = new StringBuilder("");                    ;
	
    private ValidaInteger validainteiro = new ValidaInteger();
	
    public String transforma(String registro, int qtde_reg) throws IOException {
					
    	char virgula = ',';
    	
        Properties prop = new GetProperties().getProperties();
        String db = prop.getProperty("dbtipo");
        String aspas = prop.getProperty(db + "_db_aspas");
        
		Integer TIPO_DE_REGISTRO             = (validainteiro.validaInteger(registro.substring(0,1))    );
	    String  INDICADOR_FULL_DIARIO        = (aspas + TrataString.trataAspas(registro.substring(1,2))     + aspas );
	    String  TIPO_ATUALIZACAO             = (aspas + TrataString.trataAspas(registro.substring(2,3))     + aspas );
	    Integer CNPJ                         = (validainteiro.validaInteger(registro.substring(3,17))   );
	    Integer IDENTIFICADORMATRIZ_FILIAL   = (validainteiro.validaInteger(registro.substring(17,18))  );
	    String  RAZÃO_SOCIAL_NOMEEMPRESARIAL = (aspas + TrataString.trataAspas(registro.substring(18,168))  + aspas );
	    String  NOME_FANTASIA                = (aspas + TrataString.trataAspas(registro.substring(168,223)) + aspas );
	    Integer SITUACAOCADASTRAL            = (validainteiro.validaInteger(registro.substring(223,225)));
	    Integer DATA_SITUACAOCADASTRAL       = (validainteiro.validaInteger(registro.substring(225,233)));
	    Integer MOTIVO_SITUACAOCADASTRAL     = (validainteiro.validaInteger(registro.substring(233,235)));
	    String  NM_CIDADEEXTERIOR            = (aspas + TrataString.trataAspas(registro.substring(235,290)) + aspas );
	    String  CO_PAIS                      = (aspas + TrataString.trataAspas(registro.substring(290,293)) + aspas );
	    String  NM_PAIS                      = (aspas + TrataString.trataAspas(registro.substring(293,363)) + aspas );
	    Integer CODIGO_NATUREZAJURIDICA      = (validainteiro.validaInteger(registro.substring(363,367)));
	    Integer DATA_INICIOATIVIDADE         = (validainteiro.validaInteger(registro.substring(367,375)));
	    Integer CNAE_FISCAL                  = (validainteiro.validaInteger(registro.substring(375,382)));
	    String  DESCRICAO_TIPOLOGRADOURO     = (aspas + TrataString.trataAspas(registro.substring(382,402)) + aspas );
	    String  LOGRADOURO                   = (aspas + TrataString.trataAspas(registro.substring(402,462)) + aspas );
	    String  NUMERO                       = (aspas + TrataString.trataAspas(registro.substring(462,468)) + aspas );
	    String  COMPLEMENTO                  = (aspas + TrataString.trataAspas(registro.substring(468,624)) + aspas );
	    String  BAIRRO                       = (aspas + TrataString.trataAspas(registro.substring(624,674)) + aspas );
	    Integer CEP                          = (validainteiro.validaInteger(registro.substring(674,682)));
	    String  UF                           = (aspas + TrataString.trataAspas(registro.substring(682,684)) + aspas );
	    Integer CODIGO_MUNICIPIO             = (validainteiro.validaInteger(registro.substring(684,688)));
	    String  MUNICIPIO                    = (aspas + TrataString.trataAspas(registro.substring(688,738)) + aspas );
	    String  DDD_TELEFONE_1               = (aspas + TrataString.trataAspas(registro.substring(738,750)) + aspas );
	    String  DDD_TELEFONE_2               = (aspas + TrataString.trataAspas(registro.substring(750,762)) + aspas );
	    String  DDD_FAX                      = (aspas + TrataString.trataAspas(registro.substring(762,774)) + aspas );
	    String  CORREIO_ELETRONICO           = (aspas + TrataString.trataAspas(registro.substring(774,889)) + aspas );
	    Integer QUALIFICACAO_DO_RESPONSAVEL  = (validainteiro.validaInteger(registro.substring(889,891)));
	    Double  CAPITAL_SOCIAL_DA_EMPRESA    = (Double.parseDouble(registro.substring(891,905))         );
	    String  PORTE_EMPRESA                = (aspas + TrataString.trataAspas(registro.substring(905,907)) + aspas );
	    String  OPCAO_PELO_SIMPLES           = (aspas + TrataString.trataAspas(registro.substring(907,908)) + aspas );
	    Integer DATA_OPCAO_PELO_SIMPLES      = (validainteiro.validaInteger(registro.substring(908,916)));
	    Integer DATA_EXCLUSÃO_DO_SIMPLES     = (validainteiro.validaInteger(registro.substring(916,924)));
	    String  OPCAO_PELO_MEI               = (aspas + TrataString.trataAspas(registro.substring(924,925)) + aspas );
	    String  SITUACAO_ESPECIAL            = (aspas + TrataString.trataAspas(registro.substring(925,948)) + aspas );
	    String  DATA_SITUACAO_ESPECIAL       = (aspas + TrataString.trataAspas(registro.substring(948,956)) + aspas );
	    String  FILLER                       = (aspas + TrataString.trataAspas(registro.substring(956,1199)) + aspas);
	    String  FIM_DE_REGISTRO              = (aspas + TrataString.trataAspas(registro.substring(1199,1200)) + aspas);		
	    
	    query.append("Insert into CNPJ.TAB_PRINCIPAL values ("); 
	    query.append(TIPO_DE_REGISTRO);             query.append( virgula ); 
	    query.append(INDICADOR_FULL_DIARIO);        query.append( virgula ); 
	    query.append(TIPO_ATUALIZACAO);             query.append( virgula );
	    query.append(CNPJ);                         query.append( virgula );
	    query.append(IDENTIFICADORMATRIZ_FILIAL);   query.append( virgula );
	    query.append(RAZÃO_SOCIAL_NOMEEMPRESARIAL); query.append( virgula );
	    query.append(NOME_FANTASIA);                query.append( virgula );
	    query.append(SITUACAOCADASTRAL);            query.append( virgula );
	    query.append(DATA_SITUACAOCADASTRAL);       query.append( virgula );
	    query.append(MOTIVO_SITUACAOCADASTRAL);     query.append( virgula );
	    query.append(NM_CIDADEEXTERIOR);            query.append( virgula );
	    query.append(CO_PAIS);                      query.append( virgula );
	    query.append(NM_PAIS);                      query.append( virgula );
	    query.append(CODIGO_NATUREZAJURIDICA);      query.append( virgula );
	    query.append(DATA_INICIOATIVIDADE);         query.append( virgula );
	    query.append(CNAE_FISCAL);                  query.append( virgula );
	    query.append(DESCRICAO_TIPOLOGRADOURO);     query.append( virgula );
	    query.append(LOGRADOURO);                   query.append( virgula );
	    query.append(NUMERO);                       query.append( virgula );
	    query.append(COMPLEMENTO);                  query.append( virgula );
	    query.append(BAIRRO);                       query.append( virgula );
	    query.append(CEP);                          query.append( virgula );
	    query.append(UF);                           query.append( virgula );
	    query.append(CODIGO_MUNICIPIO);             query.append( virgula );
	    query.append(MUNICIPIO);                    query.append( virgula );
	    query.append(DDD_TELEFONE_1);               query.append( virgula );
	    query.append(DDD_TELEFONE_2);               query.append( virgula );
	    query.append(DDD_FAX);                      query.append( virgula );
	    query.append(CORREIO_ELETRONICO);           query.append( virgula );
	    query.append(QUALIFICACAO_DO_RESPONSAVEL);  query.append( virgula );
	    query.append(CAPITAL_SOCIAL_DA_EMPRESA);    query.append( virgula );
	    query.append(PORTE_EMPRESA);                query.append( virgula );
	    query.append(OPCAO_PELO_SIMPLES);           query.append( virgula );
	    query.append(DATA_OPCAO_PELO_SIMPLES);      query.append( virgula );
	    query.append(DATA_EXCLUSÃO_DO_SIMPLES);     query.append( virgula );
	    query.append(OPCAO_PELO_MEI);               query.append( virgula );
	    query.append(SITUACAO_ESPECIAL);            query.append( virgula );
	    query.append(DATA_SITUACAO_ESPECIAL);       query.append( virgula );
	    query.append(FILLER);                       query.append( virgula );
	    query.append(FIM_DE_REGISTRO);
	    query.append(")");

	    /*
        if (registro.substring(168,223).trim().contains("\'")) {
            System.out.println(registro.substring(168,223));
            System.out.println("WARN: " + query.toString());
        }
        
        /*
        if (registro.substring(168,223).trim().contains("PEDO COMERCIO E REPRESENTACOES LTDA")) {
            System.out.println(registro.substring(168,223));
            System.out.println("ERRO OOOO: " + query.toString());
        }
        */
	    
		return query.toString();
	}    
}
