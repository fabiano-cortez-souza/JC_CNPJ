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
        
		Integer TIPO_DE_REGISTRO             = (validainteiro.validaInteger(segregaString(registro,0,1))    );
	    String  INDICADOR_FULL_DIARIO        = (aspas + TrataString.trataAspas(segregaString(registro,1,2))     + aspas );
	    String  TIPO_ATUALIZACAO             = (aspas + TrataString.trataAspas(segregaString(registro,2,3))     + aspas );
	    Integer CNPJ                         = (validainteiro.validaInteger(segregaString(registro,3,17))   );
	    Integer IDENTIFICADORMATRIZ_FILIAL   = (validainteiro.validaInteger(segregaString(registro,17,18))  );
	    String  RAZÃO_SOCIAL_NOMEEMPRESARIAL = (aspas + TrataString.trataAspas(segregaString(registro,18,168))  + aspas );
	    String  NOME_FANTASIA                = (aspas + TrataString.trataAspas(segregaString(registro,168,223)) + aspas );
	    Integer SITUACAOCADASTRAL            = (validainteiro.validaInteger(segregaString(registro,223,225)));
	    Integer DATA_SITUACAOCADASTRAL       = (validainteiro.validaInteger(segregaString(registro,225,233)));
	    Integer MOTIVO_SITUACAOCADASTRAL     = (validainteiro.validaInteger(segregaString(registro,233,235)));
	    String  NM_CIDADEEXTERIOR            = (aspas + TrataString.trataAspas(segregaString(registro,235,290)) + aspas );
	    String  CO_PAIS                      = (aspas + TrataString.trataAspas(segregaString(registro,290,293)) + aspas );
	    String  NM_PAIS                      = (aspas + TrataString.trataAspas(segregaString(registro,293,363)) + aspas );
	    Integer CODIGO_NATUREZAJURIDICA      = (validainteiro.validaInteger(segregaString(registro,363,367)));
	    Integer DATA_INICIOATIVIDADE         = (validainteiro.validaInteger(segregaString(registro,367,375)));
	    Integer CNAE_FISCAL                  = (validainteiro.validaInteger(segregaString(registro,375,382)));
	    String  DESCRICAO_TIPOLOGRADOURO     = (aspas + TrataString.trataAspas(segregaString(registro,382,402)) + aspas );
	    String  LOGRADOURO                   = (aspas + TrataString.trataAspas(segregaString(registro,402,462)) + aspas );
	    String  NUMERO                       = (aspas + TrataString.trataAspas(segregaString(registro,462,468)) + aspas );
	    String  COMPLEMENTO                  = (aspas + TrataString.trataAspas(segregaString(registro,468,624)) + aspas );
	    String  BAIRRO                       = (aspas + TrataString.trataAspas(segregaString(registro,624,674)) + aspas );
	    Integer CEP                          = (validainteiro.validaInteger(segregaString(registro,674,682)));
	    String  UF                           = (aspas + TrataString.trataAspas(segregaString(registro,682,684)) + aspas );
	    Integer CODIGO_MUNICIPIO             = (validainteiro.validaInteger(segregaString(registro,684,688)));
	    String  MUNICIPIO                    = (aspas + TrataString.trataAspas(segregaString(registro,688,738)) + aspas );
	    String  DDD_TELEFONE_1               = (aspas + TrataString.trataAspas(segregaString(registro,738,750)) + aspas );
	    String  DDD_TELEFONE_2               = (aspas + TrataString.trataAspas(segregaString(registro,750,762)) + aspas );
	    String  DDD_FAX                      = (aspas + TrataString.trataAspas(segregaString(registro,762,774)) + aspas );
	    String  CORREIO_ELETRONICO           = (aspas + TrataString.trataAspas(segregaString(registro,774,889)) + aspas );
	    Integer QUALIFICACAO_DO_RESPONSAVEL  = (validainteiro.validaInteger(segregaString(registro,889,891)));
	    Double  CAPITAL_SOCIAL_DA_EMPRESA    = (Double.parseDouble(segregaString(registro,891,905))         );
	    String  PORTE_EMPRESA                = (aspas + TrataString.trataAspas(segregaString(registro,905,907)) + aspas );
	    String  OPCAO_PELO_SIMPLES           = (aspas + TrataString.trataAspas(segregaString(registro,907,908)) + aspas );
	    Integer DATA_OPCAO_PELO_SIMPLES      = (validainteiro.validaInteger(segregaString(registro,908,916)));
	    Integer DATA_EXCLUSÃO_DO_SIMPLES     = (validainteiro.validaInteger(segregaString(registro,916,924)));
	    String  OPCAO_PELO_MEI               = (aspas + TrataString.trataAspas(segregaString(registro,924,925)) + aspas );
	    String  SITUACAO_ESPECIAL            = (aspas + TrataString.trataAspas(segregaString(registro,925,948)) + aspas );
	    String  DATA_SITUACAO_ESPECIAL       = (aspas + TrataString.trataAspas(segregaString(registro,948,956)) + aspas );
	    String  FILLER                       = (aspas + TrataString.trataAspas(segregaString(registro,956,1199)) + aspas);
	    String  FIM_DE_REGISTRO              = (aspas + TrataString.trataAspas(segregaString(registro,1199,1200)) + aspas);		
	    
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
	    
		return query.toString();
	}
    
    private String segregaString(String registro, int posINI, int posFIM) {
        
        StringBuilder retorno = new StringBuilder("");
        
        try {
            retorno.append(registro.substring(posINI,posFIM));
        } catch (StringIndexOutOfBoundsException estiob) { 
            // TODO: handle exception
            retorno.append("E");
        } catch (Exception e) {
        }
        return retorno.toString();
    }
}
