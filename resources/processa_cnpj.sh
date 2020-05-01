#!/bin/bash
arquivo=$1;
pahCNPJ=$2;
DIRLOG="/home/jc/CNPJ/log_parallel";
#
inicio() {
 if [ -d "$$DIRLOG" ]; then
 	rm "$DIRLOG"/log_java_$arquivo;
 	touch "$DIRLOG"/log_java_$arquivo;
 else	
 	mkdir -p "$DIRLOG"
 	touch "$DIRLOG"/log_java_$arquivo;
 fi
 data=`date +"%Y-%m-%d %T"`;
 echo "Inicio processamento do arquivo $arquivo"   >> $DIRLOG/log_java_$arquivo;
 echo "$data"                                      >> $DIRLOG/log_java_$arquivo;
}

fim() {
 data=`date +"%Y-%m-%d %T"`;
 echo "Fim processamento do arquivo $arquivo"      >> $DIRLOG/log_java_$arquivo;
 echo "$data"                                      >> $DIRLOG/log_java_$arquivo;
 exit 0;
} 

processa() {
 java -jar /home/jc/CNPJ/CNPJ_LOAD.jar $arquivo $pahCNPJ >> $DIRLOG/log_java_$arquivo;
 if [ $? -eq 0 ]; then
    echo "Processamento OK: $arquivo"              >> $DIRLOG/lista_cnpj_processado;
 else
    echo "Erro processamento: $arquivo"            >> $DIRLOG/lista_cnpj_processado_erro;
    exit 1;
 fi;
}

# Execução da funçoes
inicio;
processa;
fim;