#!/bin/bash
qtde_arquivo_proc=$1;
pahCNPJ="/home/jc-pc/CNPJ/ARQUIVOS";
retorno=0;
	
inicio() {
 # Arquivos de work/log
    cd ~/CNPJ;
 pathRaiz=`pwd`; 

 LOG_PARALLEL="${pathRaiz}/log_exec";
 LISTA_CNPJ="${pathRaiz}/lista_cnpj";
 PARALLEL_CNPJ_LOG="${pathRaiz}/parallel_cnpj_log";
 DIRLOG="${pathRaiz}/log_parallel";
 # Remoção dos arquivos de work/log
 rm -f $LOG_PARALLEL $LISTA_CNPJ $PARALLEL_CNPJ_LOG $DIRLOG/lista_cnpj_processado*;
 
 # criação dos arquivos de work/log
 touch $LOG_PARALLEL $LISTA_CNPJ $PARALLEL_CNPJ_LOG;

 data=`date +"%Y-%m-%d %T"`;
 echo "Inicio processamento do arquivo." >> $LOG_PARALLEL;
 echo "$data"                            >> $LOG_PARALLEL;
 
 # Listagem dos arquivos
 # Camuinho dos arquivos CNPJ
 cd $pahCNPJ;
 MASCARA_ARQUIVO="K3241.K03200DV.D90607.L000??";
 
 #cd $path_arquivos
 ls -1f $MASCARA_ARQUIVO > $LISTA_CNPJ;
 if [ $? -eq 0 ]; then
   echo "Listagem OK de arquivos"        >> $LOG_PARALLEL;
 else
   echo "Falha na listagem de arquivos"  >> $LOG_PARALLEL;
   rm $log_parallel $lista_cnpj $parallel_cnpj_log;
   exit 1; 
 fi
}

fim() {
 data=`date +"%Y-%m-%d %T"`;
 echo "Fim processamento do arquivo."    >> $LOG_PARALLEL;
 echo "$data"                            >> $LOG_PARALLEL;
 exit $1;
} 

processa_parallel() {
 cat $LISTA_CNPJ | parallel --joblog $PARALLEL_CNPJ_LOG -j$qtde_arquivo_proc 'sh ~/CNPJ/processa_cnpj.sh {}';
 retorno=$?              
 case $retorno in 
 0)	 echo "Parallel OK $retorno."     >> $LOG_PARALLEL ;;
 1)  echo "Parallel NOK $retorno."    >> $LOG_PARALLEL ;;
 13) echo "Parallel NOK $retorno."    >> $LOG_PARALLEL ;;
 20) echo "Parallel NOK $retorno."    >> $LOG_PARALLEL ;;
 *)  echo "Parallel NOK $retorno."    >> $LOG_PARALLEL ;;
 esac
}

# Execução da funçoes
inicio;
processa_parallel;
fim $retorno;
