package br.com.fabiano.common;

public class ValidaInteger {
	public Integer validaInteger(String numero) {
		Integer retorno = null;
		try {
			if (numero.trim() == "") {
				retorno = 0;
		     } else {
			   retorno = Integer.parseInt(numero);
		     }  
		} catch (NumberFormatException e) {
			retorno = 0;			
		}
		return retorno;
	}
}
