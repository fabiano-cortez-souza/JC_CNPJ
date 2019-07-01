package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class CNAE_SECUNDARIAS {
    private String query;
    private ValidaInteger validainteiro = new ValidaInteger();
	public String transforma(String registro_0) {
		char virgula = ',';
		char apas = '"';
		
        String    TIPO_DO_REGISTRO        =  apas +registro_0.substring(0,1).trim() + apas;
		String    INDICADOR_FULL_DIARIO   =  apas +registro_0.substring(1,2).trim() + apas;
		String    TIPO_DE_ATUALIZACAO     =  apas +registro_0.substring(2,3).trim() + apas;
		Double    CNPJ                    =  Double.parseDouble( registro_0.substring(3,17));
		Integer   CNAE_SECUNDARIA         =  validainteiro.validaInteger(registro_0.substring(17,24));
		String    FILLER                  =  apas +registro_0.substring(24,513).trim() + apas;
		String    FIM_REGISTRO            =  apas +registro_0.substring(513,514).trim() + apas;
                       
		query = "Insert into TAB_CNAE_SECUNDARIAS  values (" +  
				TIPO_DO_REGISTRO       + virgula +
				INDICADOR_FULL_DIARIO  + virgula +
				TIPO_DE_ATUALIZACAO    + virgula +
				CNPJ                   + virgula +
				CNAE_SECUNDARIA        + virgula +
				FILLER                 + virgula +
				FIM_REGISTRO           + 				 ")";
		return query;

	}

}
