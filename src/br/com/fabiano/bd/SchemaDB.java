package br.com.fabiano.bd;

public class SchemaDB {
    public final String getSchemaDB(String file) {
        //System.out.println("Arquivo: " + file + "Final: " + file.substring(26, 28));
        return "\"CNPJ_" + file.substring(26, 28) + "\"";
    }
}
