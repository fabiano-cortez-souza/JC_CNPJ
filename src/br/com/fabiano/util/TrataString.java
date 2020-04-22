package br.com.fabiano.util;

public final class TrataString {

    public static String trataAspas(String t) {
        String[] words = t.split(" ");
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
                    int count = t.length() - t.replace("\"", "").length();

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
}
