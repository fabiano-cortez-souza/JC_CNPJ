package br.com.fabiano.teste;

import java.io.File;

import br.com.fabiano.infra.GetProperties;

public class TesteValidaDiretorios {

    public static void main(String[] args) {
        
        String sPathCNPJ = GetProperties.path_CNPJ();
        String sPathDB = GetProperties.path_DB();            
         
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
