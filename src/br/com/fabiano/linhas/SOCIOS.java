package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class SOCIOS {
    private String query;
    
        private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro) {
		char virgula = ',';
		char apas = '"';
		
        Integer TIPO_DE_REGISTRO                        = validainteiro.validaInteger(registro.substring(0,1));
		String  INDICADOR_FULL_DIARIO                   = apas + registro.substring(1,2).trim() + apas;
		String  TIPO_DE_ATUALIZAÇÃO                     = apas + registro.substring(2,3).trim() + apas;
		Integer CNPJ                                    = validainteiro.validaInteger (registro.substring(3,17));
		Integer IDENTIFICADOR_DE_SOCIO                  = validainteiro.validaInteger(registro.substring(17,18));
		String  NOME_SOCIO_NO_CASO_PF                   = apas + registro.substring(18,168).trim() + apas;
		String  CNPJ_CPF_DO_SÓCIO                       = apas + registro.substring(168,182).trim() + apas;
		String  CODIGO_QUALIFICACAO_SOCIO               = apas + registro.substring(182,184).trim() + apas;
		Integer PERCENTUAL_CAPITAL_SOCIAL               = validainteiro.validaInteger(registro.substring(184,189));
		Integer DATA_ENTRADA_SOCIEDADE                  = validainteiro.validaInteger( registro.substring(189,197));
		String  CODIGO_PAIS                             = apas + registro.substring(197,200).trim() + apas;
		String  NOME_PAIS_SOCIO                         = apas + registro.substring(200,270).trim() + apas;
		String  CPF_REPRESENTANTE_LEGAL                 = apas + registro.substring(270,281).trim() + apas;
		String  NOME_REPRESENTANTE                      = apas + registro.substring(281,341).trim() + apas;
		String  CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL = apas + registro.substring(341,343).trim() + apas;
		String  FILLER                                  = apas + registro.substring(343,1198).trim() + apas;
		String  FIM_REGISTRO                            = apas + registro.substring(1198,1200).trim() + apas;
	

		
		query = "Insert into TAB_SOCIOS values ("            +  
				TIPO_DE_REGISTRO                        + virgula +
				INDICADOR_FULL_DIARIO                   + virgula + 
				TIPO_DE_ATUALIZAÇÃO                     + virgula +
				CNPJ                                    + virgula +
				IDENTIFICADOR_DE_SOCIO                  + virgula +
				NOME_SOCIO_NO_CASO_PF                   + virgula +
				CNPJ_CPF_DO_SÓCIO                       + virgula +
				CODIGO_QUALIFICACAO_SOCIO               + virgula +
				PERCENTUAL_CAPITAL_SOCIAL               + virgula +
				DATA_ENTRADA_SOCIEDADE                  + virgula +
				CODIGO_PAIS                             + virgula +
				NOME_PAIS_SOCIO                         + virgula +
				CPF_REPRESENTANTE_LEGAL                 + virgula +
				NOME_REPRESENTANTE                      + virgula +
				CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL + virgula +
				FILLER                                  + virgula +
				FIM_REGISTRO                            + 				 ")";
		return query;

	}

}
