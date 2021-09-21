package br.com.devmedia.util;

public class ErrorUtil {

	public static String getMensagemErro(Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		
		String retorno = e.getMessage();
		
		return retorno;
	}
}
