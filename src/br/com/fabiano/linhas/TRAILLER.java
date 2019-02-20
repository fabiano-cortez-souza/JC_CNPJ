package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class TRAILLER {
    private String query;
    private ValidaInteger validainteiro = new ValidaInteger();

	public String transforma(String registro_0) {
		char virgula = ',';
		char apas = '"';
		
        String  TIPO_DO_REGISTRO       = apas +registro_0.substring(1,1).trim() + apas;
		String  FILLER1                = apas +registro_0.substring(2,17).trim() + apas;
		Integer TOTAL_DE_REGISTROS_T1  = validainteiro.validaInteger(registro_0.substring(18,26));
		Integer TOTAL_DE_REGISTROS_T2  = validainteiro.validaInteger( registro_0.substring(27,35));
		Integer TOTAL_DE_REGISTROS_T3  = validainteiro.validaInteger(registro_0.substring(36,44));
		Integer TOTAL_DE_REGISTROS     = validainteiro.validaInteger(registro_0.substring(45,55));
		Integer FILLER                 = validainteiro.validaInteger(registro_0.substring(56,1199));
		String  FIM_DE_REGISTRO        = apas +registro_0.substring(1200,1200).trim() + apas;

		query = "Insert into TAB_TRAILLER values (" +  
				TIPO_DO_REGISTRO      + virgula +
				FILLER1               + virgula +
				TOTAL_DE_REGISTROS_T1 + virgula +
				TOTAL_DE_REGISTROS_T2 + virgula +
				TOTAL_DE_REGISTROS_T3 + virgula +
				TOTAL_DE_REGISTROS    + virgula +
				FILLER                + virgula +
				FIM_DE_REGISTRO       +
				 ")";
		return query;

	}

}
