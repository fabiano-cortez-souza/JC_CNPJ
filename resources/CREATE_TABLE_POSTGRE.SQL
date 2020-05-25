--
-- Os comandos devem ser executado em um client Postgres
--

--==================================================================
-- Create Schemas
--==================================================================

DO $$
DECLARE
  command_Drop text;
  command_Create text;
BEGIN 
  FOR counter IN 1..20 LOOP
    if (counter < 10) then
      command_Drop := 'DROP schema if exists "CNPJ_0' ;
      command_Create := 'CREATE schema "CNPJ_0' ;
    else
      command_Drop := 'DROP schema if exists "CNPJ_' ;
      command_Create := 'CREATE schema "CNPJ_' ;
    end if;
    command_Drop := command_Drop || counter || '" CASCADE;';
    command_Create := command_Create || counter || '" AUTHORIZATION postgres ;';
    RAISE NOTICE 'Command_Drop: %', command_Drop;
    RAISE NOTICE 'Command_Create: %', command_Create;
	--RAISE NOTICE 'Counter: %', counter;
    execute command_Drop;	
    execute command_Create;
  END LOOP;
END; $$ LANGUAGE plpgsql;

--==================================================================
-- Create TableSpace
--==================================================================
-- sudo chown postgres:postgres /DB/tablespace
CREATE TABLESPACE TBS_CNPJ OWNER postgres LOCATION '/DB/tablespace';

--==================================================================
-- Create Tables
--==================================================================
DO $$
DECLARE
  command_sql text;
  numero text;
BEGIN 
 --command_sql := 'CREATE TABLESPACE TBS_CNPJ OWNER postgres LOCATION ';
 --command_sql := command_sql || CHR(39) ;
 --command_sql := command_sql || CHR(47) || 'DB' || CHR(47) || 'tablespace'; 
 --command_sql := command_sql || CHR(39) || ';';
 --execute command_sql;

 FOR counter IN 1..20 LOOP
   if (counter < 10) then
     numero := '0' || counter;
   else
     numero := counter;
   end if;
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_HEADER;'; execute command_sql; 
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_PRINCIPAL;'; execute command_sql;
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_SOCIOS;'; execute command_sql;
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_CNAE_SECUNDARIAS;'; execute command_sql;
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_TRAILLER;'; execute command_sql;
   command_sql := 'DROP TABLE IF EXISTS "CNPJ_' || numero || '".TAB_CONTROLE;'; execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_CONTROLE (';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30) NOT NULL,';
   command_sql := command_sql || ' REGISTRO_PROCESSADO          DECIMAL(10) NOT NULL,';
   command_sql := command_sql || ' STATUS_PORCESSAMENTO         VARCHAR(15) NOT NULL,';
   command_sql := command_sql || 'CONSTRAINT TAB_CONTROLE_PKEY PRIMARY KEY (ARQUIVO)' ;
   command_sql := command_sql || ' );';
   execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_HEADER (';
   command_sql := command_sql || ' TIPO_DO_REGISTRO             VARCHAR(1),';
   command_sql := command_sql || ' FILLER1                      VARCHAR(16),';
   command_sql := command_sql || ' NOME_DO_ARQUIVO              VARCHAR(11),';
   command_sql := command_sql || ' DATA_DE_GRAVACAO             DECIMAL(8),';
   command_sql := command_sql || ' NUMERO_DA_REMESSA            DECIMAL(8),';
   command_sql := command_sql || ' FILLER2                      VARCHAR(1155),';
   command_sql := command_sql || ' FIM_DEREGISTRO               VARCHAR(1),';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30)';
   command_sql := command_sql || ');';
   execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_PRINCIPAL (';
   command_sql := command_sql || ' TIPO_DE_REGISTRO             DECIMAL(1),';
   command_sql := command_sql || ' INDICADOR_FULL_DIARIO        VARCHAR(1),';
   command_sql := command_sql || ' TIPO_ATUALIZACAO             VARCHAR(1),';
   command_sql := command_sql || ' CNPJ                         DECIMAL(14),';
   command_sql := command_sql || ' IDENTIFICADORMATRIZ_FILIAL   DECIMAL(1),';
   command_sql := command_sql || ' RAZAO_SOCIAL_NOMEEMPRESARIAL VARCHAR(150),';
   command_sql := command_sql || ' NOME_FANTASIA                VARCHAR(55),';
   command_sql := command_sql || ' SITUACAOCADASTRAL            DECIMAL(2),';
   command_sql := command_sql || ' DATA_SITUACAOCADASTRAL       DECIMAL(8),';
   command_sql := command_sql || ' MOTIVO_SITUACAOCADASTRAL     DECIMAL(2),';
   command_sql := command_sql || ' NM_CIDADEEXTERIOR            VARCHAR(55),';
   command_sql := command_sql || ' CO_PAIS                      VARCHAR(3),';
   command_sql := command_sql || ' NM_PAIS                      VARCHAR(70),';
   command_sql := command_sql || ' CODIGO_NATUREZAJURIDICA      DECIMAL(4),';
   command_sql := command_sql || ' DATA_INICIOATIVIDADE         DECIMAL(8),';
   command_sql := command_sql || ' CNAE_FISCAL                  DECIMAL(7),';
   command_sql := command_sql || ' DESCRICAO_TIPOLOGRADOURO     VARCHAR(20),';
   command_sql := command_sql || ' LOGRADOURO                   VARCHAR(60),';
   command_sql := command_sql || ' NUMERO                       VARCHAR(6),';
   command_sql := command_sql || ' COMPLEMENTO                  VARCHAR(156),';
   command_sql := command_sql || ' BAIRRO                       VARCHAR(50),';
   command_sql := command_sql || ' CEP                          DECIMAL(8),';
   command_sql := command_sql || ' UF                           VARCHAR(2),';
   command_sql := command_sql || ' CODIGO_MUNICIPIO             DECIMAL(4),';
   command_sql := command_sql || ' MUNICIPIO                    VARCHAR(50),';
   command_sql := command_sql || ' DDD_TELEFONE_1               VARCHAR(12),';
   command_sql := command_sql || ' DDD_TELEFONE_2               VARCHAR(12),';
   command_sql := command_sql || ' DDD_FAX                      VARCHAR(12),';
   command_sql := command_sql || ' CORREIO_ELETRONICO           VARCHAR(115),';
   command_sql := command_sql || ' QUALIFICACAO_DO_RESPONSÁVEL  DECIMAL(2),';
   command_sql := command_sql || ' CAPITAL_SOCIAL_DA_EMPRESA    REAL,';
   command_sql := command_sql || ' PORTE_EMPRESA                VARCHAR(2),';
   command_sql := command_sql || ' OPCAO_PELO_SIMPLES           VARCHAR(1),';
   command_sql := command_sql || ' DATA_OPCAO_PELO_SIMPLES      DECIMAL(8),';
   command_sql := command_sql || ' DATA_EXCLUSAO_DO_SIMPLES     DECIMAL(8),';
   command_sql := command_sql || ' OPCAO_PELO_MEI               VARCHAR(1),';
   command_sql := command_sql || ' SITUACAO_ESPECIAL            VARCHAR(23),';
   command_sql := command_sql || ' DATA_SITUACAO_ESPECIAL       VARCHAR(8),';
   command_sql := command_sql || ' FILLER                       VARCHAR(243),';
   command_sql := command_sql || ' FIM_DE_REGISTRO              VARCHAR(1),';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30)';
   command_sql := command_sql || ');';
   execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_SOCIOS (';
   command_sql := command_sql || ' TIPO_DE_REGISTRO             DECIMAL(1),';
   command_sql := command_sql || ' INDICADOR_FULL_DIARIO        VARCHAR(1),';
   command_sql := command_sql || ' TIPO_DE_ATUALIZACAO          VARCHAR(1),';
   command_sql := command_sql || ' CNPJ                         REAL,';
   command_sql := command_sql || ' IDENTIFICADOR_DE_SOCIO       DECIMAL(1),';
   command_sql := command_sql || ' NOME_SOCIO_NO_CASO_PF_OU_RAZAO_SOCIAL_NOCASO_PJ VARCHAR(150),';
   command_sql := command_sql || ' CNPJ_CPF_DO_SOCIO            VARCHAR(14),';
   command_sql := command_sql || ' CODIGO_QUALIFICACAO_SOCIO    VARCHAR(2),';
   command_sql := command_sql || ' PERCENTUAL_CAPITAL_SOCIAL    DECIMAL(5),';
   command_sql := command_sql || ' DATA_ENTRADA_SOCIEDADE       DECIMAL(8),';
   command_sql := command_sql || ' CODIGO_PAIS                  VARCHAR(3),';
   command_sql := command_sql || ' NOME_PAIS_SOCIO              VARCHAR(70),';
   command_sql := command_sql || ' CPF_REPRESENTANTE_LEGAL      VARCHAR(11),';
   command_sql := command_sql || ' NOME_REPRESENTANTE           VARCHAR(60),';
   command_sql := command_sql || ' CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL VARCHAR(2),';
   command_sql := command_sql || ' FILLER                       VARCHAR(855),';
   command_sql := command_sql || ' FIM_REGISTRO                 VARCHAR(1),';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30)';
   command_sql := command_sql || ');';
   execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_CNAE_SECUNDARIAS (';
   command_sql := command_sql || ' TIPO_DO_REGISTRO             VARCHAR(1),';
   command_sql := command_sql || ' INDICADOR_FULL_DIARIO        VARCHAR(1),';
   command_sql := command_sql || ' TIPO_DE_ATUALIZACAO          VARCHAR(1),';
   command_sql := command_sql || ' CNPJ                         REAL,';
   command_sql := command_sql || ' CNAE_SECUNDARIA              DECIMAL(7),';
   command_sql := command_sql || ' FILLER                       VARCHAR(489),';--#sudo chown postgres:postgres /DB/tablespace
   command_sql := command_sql || ' FIM_REGISTRO                 VARCHAR(1),';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30)';
   command_sql := command_sql || ');';
   execute command_sql;

   command_sql :=                'CREATE TABLE "CNPJ_' || numero || '".TAB_TRAILLER (';
   command_sql := command_sql || ' TIPO_DO_REGISTRO             VARCHAR(1),';
   command_sql := command_sql || ' FILLER1                      VARCHAR(16),';
   command_sql := command_sql || ' TOTAL_DE_REGISTROS_T1        DECIMAL(9),';
   command_sql := command_sql || ' TOTAL_DE_REGISTROS_T2        DECIMAL(9),';
   command_sql := command_sql || ' TOTAL_DE_REGISTROS_T3        DECIMAL(9),';
   command_sql := command_sql || ' TOTAL_DE_REGISTROS           DECIMAL(11),';
   command_sql := command_sql || ' FILLER2                      VARCHAR(1144),';
   command_sql := command_sql || ' FIM_DE_REGISTRO              VARCHAR(1),';
   command_sql := command_sql || ' ARQUIVO                      VARCHAR(30)';
   command_sql := command_sql || ');';
   execute command_sql;

   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_HEADER    SET TABLESPACE TBS_CNPJ;'; execute command_sql;
   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_PRINCIPAL SET TABLESPACE TBS_CNPJ;'; execute command_sql;
   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_SOCIOS    SET TABLESPACE TBS_CNPJ;'; execute command_sql;
   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_CNAE_SECUNDARIAS SET TABLESPACE TBS_CNPJ;'; execute command_sql;
   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_TRAILLER  SET TABLESPACE TBS_CNPJ;'; execute command_sql;
   command_sql := 'ALTER TABLE "CNPJ_' || numero || '".TAB_CONTROLE  SET TABLESPACE TBS_CNPJ;'; execute command_sql;

 END LOOP;
END; $$ LANGUAGE plpgsql;






