package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class PRINCIPAL {
    private String  query                        ;
	
    private ValidaInteger validainteiro = new ValidaInteger();
	
    public String transforma(String registro, int qtde_reg) {
					
    	char virgula = ',';
		char apas = '"';
		
		Integer TIPO_DE_REGISTRO             = (validainteiro.validaInteger(registro.substring(0,1))    );
	    String  INDICADOR_FULL_DIARIO        = (apas + registro.substring(1,2).trim().replaceAll("\"", "") + apas      );
	    String  TIPO_ATUALIZACAO             = (apas + registro.substring(2,3).trim().replaceAll("\"", "") + apas      );
	    Integer CNPJ                         = (validainteiro.validaInteger(registro.substring(3,17))   );
	    Integer IDENTIFICADORMATRIZ_FILIAL   = (validainteiro.validaInteger(registro.substring(17,18))  );
	    String  RAZÃO_SOCIAL_NOMEEMPRESARIAL = (apas + registro.substring(18,168).trim().replaceAll("\"", "") + apas   );
	    String  NOME_FANTASIA                = (apas + registro.substring(168,223).trim().replaceAll("\"", "") + apas  );
	    Integer SITUACAOCADASTRAL            = (validainteiro.validaInteger(registro.substring(223,225)));
	    Integer DATA_SITUACAOCADASTRAL       = (validainteiro.validaInteger(registro.substring(225,233)));
	    Integer MOTIVO_SITUACAOCADASTRAL     = (validainteiro.validaInteger(registro.substring(233,235)));
	    String  NM_CIDADEEXTERIOR            = (apas + registro.substring(235,290).trim().replaceAll("\"", "") + apas  );
	    String  CO_PAIS                      = (apas + registro.substring(290,293).trim().replaceAll("\"", "") + apas  );
	    String  NM_PAIS                      = (apas + registro.substring(293,363).trim().replaceAll("\"", "") + apas  );
	    Integer CODIGO_NATUREZAJURIDICA      = (validainteiro.validaInteger(registro.substring(363,367)));
	    Integer DATA_INICIOATIVIDADE         = (validainteiro.validaInteger(registro.substring(367,375)));
	    Integer CNAE_FISCAL                  = (validainteiro.validaInteger(registro.substring(375,382)));
	    String  DESCRICAO_TIPOLOGRADOURO     = (apas + registro.substring(382,402).trim().replaceAll("\"", "") + apas  );
	    String  LOGRADOURO                   = (apas + registro.substring(402,462).trim().replaceAll("\"", "") + apas  );
	    String  NUMERO                       = (apas + registro.substring(462,468).trim().replaceAll("\"", "") + apas  );
	    String  COMPLEMENTO                  = (apas + registro.substring(468,624).trim().replaceAll("\"", "") + apas  );
	    String  BAIRRO                       = (apas + registro.substring(624,674).trim().replaceAll("\"", "") + apas  );
	    Integer CEP                          = (validainteiro.validaInteger(registro.substring(674,682)));
	    String  UF                           = (apas + registro.substring(682,684).trim().replaceAll("\"", "") + apas  );
	    Integer CODIGO_MUNICIPIO             = (validainteiro.validaInteger(registro.substring(684,688)));
	    String  MUNICIPIO                    = (apas + registro.substring(688,738).trim().replaceAll("\"", "") + apas  );
	    String  DDD_TELEFONE_1               = (apas + registro.substring(738,750).trim().replaceAll("\"", "") + apas  );
	    String  DDD_TELEFONE_2               = (apas + registro.substring(750,762).trim().replaceAll("\"", "") + apas  );
	    String  DDD_FAX                      = (apas + registro.substring(762,774).trim().replaceAll("\"", "") + apas  );
	    String  CORREIO_ELETRONICO           = (apas + registro.substring(774,889).trim().replaceAll("\"", "") + apas  );
	    Integer QUALIFICACAO_DO_RESPONSAVEL  = (validainteiro.validaInteger(registro.substring(889,891)));
	    Double  CAPITAL_SOCIAL_DA_EMPRESA    = (Double.parseDouble(registro.substring(891,905))         );
	    String  PORTE_EMPRESA                = (apas + registro.substring(905,907).trim().replaceAll("\"", "") + apas  );
	    String  OPCAO_PELO_SIMPLES           = (apas + registro.substring(907,908).trim().replaceAll("\"", "") + apas  );
	    Integer DATA_OPCAO_PELO_SIMPLES      = (validainteiro.validaInteger(registro.substring(908,916)));
	    Integer DATA_EXCLUSÃO_DO_SIMPLES     = (validainteiro.validaInteger(registro.substring(916,924)));
	    String  OPCAO_PELO_MEI               = (apas + registro.substring(924,925).trim().replaceAll("\"", "") + apas  );
	    String  SITUACAO_ESPECIAL            = (apas + registro.substring(925,948).trim().replaceAll("\"", "") + apas  );
	    String  DATA_SITUACAO_ESPECIAL       = (apas + registro.substring(948,956).trim().replaceAll("\"", "") + apas  );
	    String  FILLER                       = (apas + registro.substring(956,1199).trim().replaceAll("\"", "") + apas );
	    String  FIM_DE_REGISTRO              = (apas + registro.substring(1199,1200).trim().replaceAll("\"", "") + apas);		
		
	    query = "Insert into TAB_PRINCIPAL values (" + 
				TIPO_DE_REGISTRO             + virgula + 
				INDICADOR_FULL_DIARIO        + virgula + 
				TIPO_ATUALIZACAO             + virgula + 
				CNPJ                         + virgula + 
				IDENTIFICADORMATRIZ_FILIAL   + virgula + 
				RAZÃO_SOCIAL_NOMEEMPRESARIAL + virgula + 
				NOME_FANTASIA                + virgula + 
				SITUACAOCADASTRAL            + virgula + 
				DATA_SITUACAOCADASTRAL       + virgula + 
				MOTIVO_SITUACAOCADASTRAL     + virgula + 
				NM_CIDADEEXTERIOR            + virgula + 
				CO_PAIS                      + virgula + 
				NM_PAIS                      + virgula + 
				CODIGO_NATUREZAJURIDICA      + virgula + 
				DATA_INICIOATIVIDADE         + virgula + 
				CNAE_FISCAL                  + virgula + 
				DESCRICAO_TIPOLOGRADOURO     + virgula + 
				LOGRADOURO                   + virgula + 
				NUMERO                       + virgula + 
				COMPLEMENTO                  + virgula + 
				BAIRRO                       + virgula + 
				CEP                          + virgula + 
				UF                           + virgula + 
				CODIGO_MUNICIPIO             + virgula + 
				MUNICIPIO                    + virgula + 
				DDD_TELEFONE_1               + virgula + 
				DDD_TELEFONE_2               + virgula + 
				DDD_FAX                      + virgula + 
				CORREIO_ELETRONICO           + virgula + 
				QUALIFICACAO_DO_RESPONSAVEL  + virgula + 
				CAPITAL_SOCIAL_DA_EMPRESA    + virgula + 
				PORTE_EMPRESA                + virgula + 
				OPCAO_PELO_SIMPLES           + virgula + 
				DATA_OPCAO_PELO_SIMPLES      + virgula + 
				DATA_EXCLUSÃO_DO_SIMPLES     + virgula + 
				OPCAO_PELO_MEI               + virgula + 
				SITUACAO_ESPECIAL            + virgula + 
				DATA_SITUACAO_ESPECIAL       + virgula + 
				FILLER                       + virgula + 
				FIM_DE_REGISTRO              + 
				")";
	    
		return query;
	}
}
