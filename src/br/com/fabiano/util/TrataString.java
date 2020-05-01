package br.com.fabiano.util;

public final class TrataString {

    public static String trataAspas(String t, int posINI, int posFIM) {
        
        String nova = segregaString(t,posINI,posFIM);
        
        String[] words = nova.split(" ");
        StringBuilder retorno = new StringBuilder("");

        try {
            for (String word : words) {
                if ( (word.indexOf("\"") == -1) 
                  && (word.indexOf("'")  == -1)
                  && (! word.equals(""))    
                   ) {
                    retorno.append(word).append(" ");
                    continue;
                }

                if ((word.indexOf("'") > -1)) {
                    word = word.replace("'", " ");
                } else if ((word.indexOf("\"") > -1)) {
                    int count = nova.length() - nova.replace("\"", "").length();

                    if (count == 2) {
                        word = word.replaceFirst("\"", "{");
                        word = word.replaceFirst("\"", "}");
                    }
                }
                retorno.append(word).append(" ");
            }  
        } catch (StringIndexOutOfBoundsException estiob) {
            System.out.println(estiob.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno.toString().trim();
    }
    
    private static String segregaString(String registro, int posINI, int posFIM) {
        
        StringBuilder retorno = new StringBuilder("");
        
        try {
            retorno.append(registro.substring(posINI,posFIM));
        } catch (StringIndexOutOfBoundsException estiob) { 
            // TODO: handle exception
            retorno.append("E");
            System.out.println("Registro com campos fora de posição: " + registro);
        } catch (Exception e) {
        }
        return retorno.toString();
    }

}
