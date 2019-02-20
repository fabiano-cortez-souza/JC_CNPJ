package br.com.fabiano.common;

public class ValidaInteger {
	public Integer validaInteger(String numero) {
		Integer retorno = null;
		try {
			retorno = Integer.parseInt(numero);	
		} catch (NumberFormatException e) {
			if (numero.trim() == "") {
				retorno = 0;
		     }
		}
		return retorno;
	}
}
