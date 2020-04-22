CREATE TABLE `CNPJ_JC`.`TAB_HEADER` (
 `TIPO_DO_REGISTRO`             VARCHAR(1),
 `FILLER1`                      VARCHAR(16),
 `NOME_DO_ARQUIVO`              VARCHAR(11),
 `DATA_DE_GRAVAÇÃO`             DECIMAL(8),
 `NUMERO_DA_REMESSA`            DECIMAL(8),
 `FILLER2`                      VARCHAR(1155),
 `FIM_DEREGISTRO`               VARCHAR(1)
);

CREATE TABLE `CNPJ_JC`.`TAB_PRINCIPAL` (
 `TIPO_DE_REGISTRO`             DECIMAL(1),
 `INDICADOR_FULL_DIARIO`        VARCHAR(1),
 `TIPO_ATUALIZACAO`             VARCHAR(1),
 `CNPJ`                         DECIMAL(14),
 `IDENTIFICADORMATRIZ_FILIAL`   DECIMAL(1),
 `RAZÃO_SOCIAL_NOMEEMPRESARIAL` VARCHAR(150),
 `NOME_FANTASIA`                VARCHAR(55),
 `SITUAÇÃOCADASTRAL`            DECIMAL(2),
 `DATA_SITUACAOCADASTRAL`       DECIMAL(8),
 `MOTIVO_SITUAÇÃOCADASTRAL`     DECIMAL(2),
 `NM_CIDADEEXTERIOR`            VARCHAR(55),
 `CO_PAIS`                      VARCHAR(3),
 `NM_PAIS`                      VARCHAR(70),
 `CODIGO_NATUREZAJURIDICA`      DECIMAL(4),
 `DATA_INICIOATIVIDADE`         DECIMAL(8),
 `CNAE_FISCAL`                  DECIMAL(7),
 `DESCRIÇÃO_TIPOLOGRADOURO`     VARCHAR(20),
 `LOGRADOURO`                   VARCHAR(60),
 `NUMERO`                       VARCHAR(6),
 `COMPLEMENTO`                  VARCHAR(156),
 `BAIRRO`                       VARCHAR(50),
 `CEP`                          DECIMAL(8),
 `UF`                           VARCHAR(2),
 `CODIGO_MUNICIPIO`             DECIMAL(4),
 `MUNICIPIO`                    VARCHAR(50),
 `DDD_TELEFONE_1`               VARCHAR(12),
 `DDD_TELEFONE_2`               VARCHAR(12),
 `DDD_FAX`                      VARCHAR(12),
 `CORREIO_ELETRONICO`           VARCHAR(115),
 `QUALIFICAÇÃO_DO_RESPONSÁVEL`  DECIMAL(2),
 `CAPITAL_SOCIAL_DA_EMPRESA`    REAL,
 `PORTE_EMPRESA`                VARCHAR(2),
 `OPÇÃO_PELO_SIMPLES`           VARCHAR(1),
 `DATA_OPCAO_PELO_SIMPLES`      DECIMAL(8),
 `DATA_EXCLUSÃO_DO_SIMPLES`     DECIMAL(8),
 `OPÇÃO_PELO_MEI`               VARCHAR(1),
 `SITUAÇÃO_ESPECIAL`            VARCHAR(23),
 `DATA_SITUAÇÃO_ESPECIAL`       VARCHAR(8),
 `FILLER`                       VARCHAR(243),
 `FIM_DE_REGISTRO`              VARCHAR(1)
); 

CREATE TABLE `CNPJ_JC`.`TAB_SOCIOS` (
 `TIPO_DE_REGISTRO`             DECIMAL(1),
 `INDICADOR_FULL_DIARIO`        VARCHAR(1),
 `TIPO_DE_ATUALIZAÇÃO`          VARCHAR(1),
 `CNPJ`                         REAL,
 `IDENTIFICADOR_DE_SOCIO`       DECIMAL(1),
 `NOME_SOCIO_(NO_CASO_PF)_OU_RAZÃO_SOCIAL_(NOCASO_PJ)` VARCHAR(150),
 `CNPJ/CPF_DO_SÓCIO`            VARCHAR(14),
 `CODIGO_QUALIFICACAO_SOCIO`    VARCHAR(2),
 `PERCENTUAL_CAPITAL_SOCIAL`    DECIMAL(5),
 `DATA_ENTRADA_SOCIEDADE`       DECIMAL(8),
 `CODIGO_PAIS`                  VARCHAR(3),
 `NOME_PAIS_SOCIO`              VARCHAR(70),
 `CPF_REPRESENTANTE_LEGAL`      VARCHAR(11),
 `NOME_REPRESENTANTE`           VARCHAR(60),
 `CODIGO_QUALIFICACAO_REPRESENTANTE_LEGAL` VARCHAR(2),
 `FILLER`                       VARCHAR(855),
 `FIM_REGISTRO`                 VARCHAR(1)
);

CREATE TABLE `CNPJ_JC`.`TAB_CNAE_SECUNDARIAS` (
 `TIPO_DO_REGISTRO`             VARCHAR(1),
 `INDICADOR_FULL_DIARIO`        VARCHAR(1),
 `TIPO_DE_ATUALIZAÇÃO`          VARCHAR(1),
 `CNPJ`                         REAL,
 `CNAE_SECUNDARIA`              DECIMAL(7),
 `FILLER`                       VARCHAR(489),
 `FIM_REGISTRO`                 VARCHAR(1)
);

CREATE TABLE `CNPJ_JC`.`TAB_TRAILLER` (
 `TIPO_DO_REGISTRO`             VARCHAR(1),
 `FILLER1`                      VARCHAR(16),
 `TOTAL_DE_REGISTROS_T1`        DECIMAL(9),
 `TOTAL_DE_REGISTROS_T2`        DECIMAL(9),
 `TOTAL_DE_REGISTROS_T3`        DECIMAL(9),
 `TOTAL_DE_REGISTROS`           DECIMAL(11),
 `FILLER2`                      VARCHAR(1144),
 `FIM_DE_REGISTRO`              VARCHAR(1)
);

ALTER TABLE `CNPJ`.`TAB_HEADER`    SET TABLESPACE cnpj;
ALTER TABLE `CNPJ`.`TAB_PRINCIPAL` SET TABLESPACE cnpj; 
ALTER TABLE `CNPJ`.`TAB_SOCIOS`    SET TABLESPACE cnpj;
ALTER TABLE `CNPJ`.`TAB_CNAE_SECUNDARIAS` SET TABLESPACE cnpj;
ALTER TABLE `CNPJ`.`TAB_TRAILLER`  SET TABLESPACE cnpj;