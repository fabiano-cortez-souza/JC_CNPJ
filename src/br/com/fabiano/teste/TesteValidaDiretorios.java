package br.com.fabiano.teste;

import java.io.File;
import java.util.Properties;

import br.com.fabiano.infra.GetProperties;

public class TesteValidaDiretorios {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Properties prop = null;
        
        try {
            prop = new GetProperties().getProperties();
        } catch (Exception e) {
            System.out.println("Erro em obter properties");
        }

        String sPathCNPJ = prop.getProperty("pathCNPJ");
        String sPathDB = prop.getProperty("pathDB");            

         
        File pathcnpj = new File( sPathCNPJ );
        File pathdb   = new File( sPathDB );
        
        boolean dirCNPJ = pathcnpj.isDirectory();
        boolean dirDB   = pathdb.isDirectory();
        
        
        if (dirCNPJ && dirDB) {
            System.out.println("CNPJ: " + pathcnpj);
            System.out.println("DB  : " + pathdb  );
            System.out.println("DIRETÒRIOS CNPJ e DB OK : " + (dirCNPJ && dirDB));
        }

    }

}
