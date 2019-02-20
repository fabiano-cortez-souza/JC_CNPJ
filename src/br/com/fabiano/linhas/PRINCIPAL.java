package br.com.fabiano.linhas;

import br.com.fabiano.common.ValidaInteger;

public class PRINCIPAL {
    private String  query                        ;
	private Integer TIPO_DE_REGISTRO             ;
    private String  INDICADOR_FULL_DIARIO        ;
    private String  TIPO_ATUALIZACAO             ;
    private Integer CNPJ                         ;
    private Integer IDENTIFICADORMATRIZ_FILIAL   ;
    private String  RAZÃO_SOCIAL_NOMEEMPRESARIAL ;
    private String  NOME_FANTASIA                ;
    private Integer SITUAÇÃOCADASTRAL            ;
    private Integer DATA_SITUACAOCADASTRAL       ;
    private Integer MOTIVO_SITUAÇÃOCADASTRAL     ;
    private String  NM_CIDADEEXTERIOR            ;
    private String  CO_PAIS                      ;
    private String  NM_PAIS                      ;
    private Integer CODIGO_NATUREZAJURIDICA      ;
    private Integer DATA_INICIOATIVIDADE         ;
    private Integer CNAE_FISCAL                  ;
    private String  DESCRIÇÃO_TIPOLOGRADOURO     ;
    private String  LOGRADOURO                   ;
    private String  NUMERO                       ;
    private String  COMPLEMENTO                  ;
    private String  BAIRRO                       ;
    private Integer CEP                          ;
    private String  UF                           ;
    private Integer CODIGO_MUNICIPIO             ;
    private String  MUNICIPIO                    ;
    private String  DDD_TELEFONE_1               ;
    private String  DDD_TELEFONE_2               ;
    private String  DDD_FAX                      ;
    private String  CORREIO_ELETRONICO           ;
    private Integer QUALIFICAÇÃO_DO_RESPONSÁVEL  ;
    private Double  CAPITAL_SOCIAL_DA_EMPRESA    ;
    private String  PORTE_EMPRESA                ;
    private String  OPÇÃO_PELO_SIMPLES           ;
    private Integer DATA_OPCAO_PELO_SIMPLES      ;
    private Integer DATA_EXCLUSÃO_DO_SIMPLES     ;
    private String  OPÇÃO_PELO_MEI               ;
    private String  SITUAÇÃO_ESPECIAL            ;
    private String  DATA_SITUAÇÃO_ESPECIAL       ;
    private String  FILLER                       ;
    private String  FIM_DE_REGISTRO              ;
    
    private ValidaInteger validainteiro = new ValidaInteger();
	
    public String transforma(String registro, int qtde_reg) {
					
    	char virgula = ',';
		char apas = '"';
		
		setTIPO_DE_REGISTRO             (validainteiro.validaInteger(registro.substring(0,1))            );
		setINDICADOR_FULL_DIARIO        (apas + registro.substring(1,2).trim() + apas      );
		setTIPO_ATUALIZACAO             (apas + registro.substring(2,3).trim() + apas      );
		setCNPJ                         (validainteiro.validaInteger(registro.substring(3,17))           ); 
		setIDENTIFICADORMATRIZ_FILIAL   (validainteiro.validaInteger(registro.substring(17,18))          );
		setRAZÃO_SOCIAL_NOMEEMPRESARIAL (apas + registro.substring(18,168).trim() + apas   );
		setNOME_FANTASIA                (apas + registro.substring(168,223).trim() + apas  );
		setSITUAÇÃOCADASTRAL            (validainteiro.validaInteger(registro.substring(223,225))        );
		setDATA_SITUACAOCADASTRAL       (validainteiro.validaInteger(registro.substring(225,233))        );
		setMOTIVO_SITUAÇÃOCADASTRAL     (validainteiro.validaInteger(registro.substring(233,235))        );
		setNM_CIDADEEXTERIOR            (apas + registro.substring(235,290).trim() + apas  );
		setCO_PAIS                      (apas + registro.substring(290,293).trim() + apas  );                                                                       
		setNM_PAIS                      (apas + registro.substring(293,363).trim() + apas  );
		setCODIGO_NATUREZAJURIDICA      (validainteiro.validaInteger(registro.substring(363,367))        );
		setDATA_INICIOATIVIDADE         (validainteiro.validaInteger(registro.substring(367,375))        );
		setCNAE_FISCAL                  (validainteiro.validaInteger(registro.substring(375,382))        );
		setDESCRIÇÃO_TIPOLOGRADOURO     (apas + registro.substring(382,402).trim() + apas  );
		setLOGRADOURO                   (apas + registro.substring(402,462).trim() + apas  );
		setNUMERO                       (apas + registro.substring(462,468).trim() + apas  );
		setCOMPLEMENTO                  (apas + registro.substring(468,624).trim() + apas  );
		setBAIRRO                       (apas + registro.substring(624,674).trim() + apas  );
		setCEP                          (validainteiro.validaInteger(registro.substring(674,682))        );
		setUF                           (apas + registro.substring(682,684).trim() + apas  );
		setCODIGO_MUNICIPIO             (validainteiro.validaInteger(registro.substring(684,688))        );
		setMUNICIPIO                    (apas + registro.substring(688,738).trim() + apas  );
		setDDD_TELEFONE_1               (apas + registro.substring(738,750).trim() + apas  );
		setDDD_TELEFONE_2               (apas + registro.substring(750,762).trim() + apas  );
		setDDD_FAX                      (apas + registro.substring(762,774).trim() + apas  );
		setCORREIO_ELETRONICO           (apas + registro.substring(774,889).trim() + apas  );
		setQUALIFICAÇÃO_DO_RESPONSÁVEL  (validainteiro.validaInteger(registro.substring(889,891))        );
		setCAPITAL_SOCIAL_DA_EMPRESA    (Double.parseDouble(registro.substring(891,905))   );
		setPORTE_EMPRESA                (apas + registro.substring(905,907).trim() + apas  );
		setOPÇÃO_PELO_SIMPLES           (apas + registro.substring(907,908).trim() + apas  );
		setDATA_OPCAO_PELO_SIMPLES      (validainteiro.validaInteger(registro.substring(908,916))     );
		setDATA_EXCLUSÃO_DO_SIMPLES     (validainteiro.validaInteger(registro.substring(916,924))     );
		setOPÇÃO_PELO_MEI               (apas + registro.substring(924,925).trim() + apas  );
		setSITUAÇÃO_ESPECIAL            (apas + registro.substring(925,948).trim() + apas  );
		setDATA_SITUAÇÃO_ESPECIAL       (apas + registro.substring(948,956).trim() + apas  );
		setFILLER                       (apas + registro.substring(956,1199).trim() + apas );
		setFIM_DE_REGISTRO              (apas + registro.substring(1199,1200).trim() + apas);
		
		setQuery("Insert into TAB_PRINCIPAL values (" + 
				getTIPO_DE_REGISTRO()             + virgula + 
				getINDICADOR_FULL_DIARIO()        + virgula + 
				getTIPO_ATUALIZACAO()             + virgula + 
				getCNPJ()                         + virgula + 
				getIDENTIFICADORMATRIZ_FILIAL()   + virgula + 
				getRAZÃO_SOCIAL_NOMEEMPRESARIAL() + virgula + 
				getNOME_FANTASIA()                + virgula + 
				getSITUAÇÃOCADASTRAL()            + virgula + 
				getDATA_SITUACAOCADASTRAL()       + virgula + 
				getMOTIVO_SITUAÇÃOCADASTRAL()     + virgula + 
				getNM_CIDADEEXTERIOR()            + virgula + 
				getCO_PAIS()                      + virgula + 
				getNM_PAIS()                      + virgula + 
				getCODIGO_NATUREZAJURIDICA()      + virgula + 
				getDATA_INICIOATIVIDADE()         + virgula + 
				getCNAE_FISCAL()                  + virgula + 
				getDESCRIÇÃO_TIPOLOGRADOURO()     + virgula + 
				getLOGRADOURO()                   + virgula + 
				getNUMERO()                       + virgula + 
				getCOMPLEMENTO()                  + virgula + 
				getBAIRRO()                       + virgula + 
				getCEP()                          + virgula + 
				getUF()                           + virgula + 
				getCODIGO_MUNICIPIO()             + virgula + 
				getMUNICIPIO()                    + virgula + 
				getDDD_TELEFONE_1()               + virgula + 
				getDDD_TELEFONE_2()               + virgula + 
				getDDD_FAX()                      + virgula + 
				getCORREIO_ELETRONICO()           + virgula + 
				getQUALIFICAÇÃO_DO_RESPONSÁVEL()  + virgula + 
				getCAPITAL_SOCIAL_DA_EMPRESA()    + virgula + 
				getPORTE_EMPRESA()                + virgula + 
				getOPÇÃO_PELO_SIMPLES()           + virgula + 
				getDATA_OPCAO_PELO_SIMPLES()      + virgula + 
				getDATA_EXCLUSÃO_DO_SIMPLES()     + virgula + 
				getOPÇÃO_PELO_MEI()               + virgula + 
				getSITUAÇÃO_ESPECIAL()            + virgula + 
				getDATA_SITUAÇÃO_ESPECIAL()       + virgula + 
				getFILLER()                       + virgula + 
				getFIM_DE_REGISTRO()              + 
				")");
		return query;

	}
	
    public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getTIPO_DE_REGISTRO() {
		return TIPO_DE_REGISTRO;
	}

	public void setTIPO_DE_REGISTRO(Integer tIPO_DE_REGISTRO) {
		TIPO_DE_REGISTRO = tIPO_DE_REGISTRO;
	}

	public String getINDICADOR_FULL_DIARIO() {
		return INDICADOR_FULL_DIARIO;
	}

	public void setINDICADOR_FULL_DIARIO(String iNDICADOR_FULL_DIARIO) {
		INDICADOR_FULL_DIARIO = iNDICADOR_FULL_DIARIO;
	}

	public String getTIPO_ATUALIZACAO() {
		return TIPO_ATUALIZACAO;
	}

	public void setTIPO_ATUALIZACAO(String tIPO_ATUALIZACAO) {
		TIPO_ATUALIZACAO = tIPO_ATUALIZACAO;
	}

	public Integer getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {
		CNPJ = cNPJ;
	}

	public Integer getIDENTIFICADORMATRIZ_FILIAL() {
		return IDENTIFICADORMATRIZ_FILIAL;
	}

	public void setIDENTIFICADORMATRIZ_FILIAL(Integer iDENTIFICADORMATRIZ_FILIAL) {
		IDENTIFICADORMATRIZ_FILIAL = iDENTIFICADORMATRIZ_FILIAL;
	}

	public String getRAZÃO_SOCIAL_NOMEEMPRESARIAL() {
		return RAZÃO_SOCIAL_NOMEEMPRESARIAL;
	}

	public void setRAZÃO_SOCIAL_NOMEEMPRESARIAL(String rAZÃO_SOCIAL_NOMEEMPRESARIAL) {
		RAZÃO_SOCIAL_NOMEEMPRESARIAL = rAZÃO_SOCIAL_NOMEEMPRESARIAL;
	}

	public String getNOME_FANTASIA() {
		return NOME_FANTASIA;
	}

	public void setNOME_FANTASIA(String nOME_FANTASIA) {
		NOME_FANTASIA = nOME_FANTASIA;
	}

	public Integer getSITUAÇÃOCADASTRAL() {
		return SITUAÇÃOCADASTRAL;
	}

	public void setSITUAÇÃOCADASTRAL(Integer sITUAÇÃOCADASTRAL) {
		SITUAÇÃOCADASTRAL = sITUAÇÃOCADASTRAL;
	}

	public Integer getDATA_SITUACAOCADASTRAL() {
		return DATA_SITUACAOCADASTRAL;
	}

	public void setDATA_SITUACAOCADASTRAL(Integer dATA_SITUACAOCADASTRAL) {
		DATA_SITUACAOCADASTRAL = dATA_SITUACAOCADASTRAL;
	}

	public Integer getMOTIVO_SITUAÇÃOCADASTRAL() {
		return MOTIVO_SITUAÇÃOCADASTRAL;
	}

	public void setMOTIVO_SITUAÇÃOCADASTRAL(Integer mOTIVO_SITUAÇÃOCADASTRAL) {
		MOTIVO_SITUAÇÃOCADASTRAL = mOTIVO_SITUAÇÃOCADASTRAL;
	}

	public String getNM_CIDADEEXTERIOR() {
		return NM_CIDADEEXTERIOR;
	}

	public void setNM_CIDADEEXTERIOR(String nM_CIDADEEXTERIOR) {
		NM_CIDADEEXTERIOR = nM_CIDADEEXTERIOR;
	}

	public String getCO_PAIS() {
		return CO_PAIS;
	}

	public void setCO_PAIS(String cO_PAIS) {
		CO_PAIS = cO_PAIS;
	}

	public String getNM_PAIS() {
		return NM_PAIS;
	}

	public void setNM_PAIS(String nM_PAIS) {
		NM_PAIS = nM_PAIS;
	}

	public Integer getCODIGO_NATUREZAJURIDICA() {
		return CODIGO_NATUREZAJURIDICA;
	}

	public void setCODIGO_NATUREZAJURIDICA(Integer cODIGO_NATUREZAJURIDICA) {
		CODIGO_NATUREZAJURIDICA = cODIGO_NATUREZAJURIDICA;
	}

	public Integer getDATA_INICIOATIVIDADE() {
		return DATA_INICIOATIVIDADE;
	}

	public void setDATA_INICIOATIVIDADE(Integer dATA_INICIOATIVIDADE) {
		DATA_INICIOATIVIDADE = dATA_INICIOATIVIDADE;
	}

	public Integer getCNAE_FISCAL() {
		return CNAE_FISCAL;
	}

	public void setCNAE_FISCAL(Integer cNAE_FISCAL) {
		CNAE_FISCAL = cNAE_FISCAL;
	}

	public String getDESCRIÇÃO_TIPOLOGRADOURO() {
		return DESCRIÇÃO_TIPOLOGRADOURO;
	}

	public void setDESCRIÇÃO_TIPOLOGRADOURO(String dESCRIÇÃO_TIPOLOGRADOURO) {
		DESCRIÇÃO_TIPOLOGRADOURO = dESCRIÇÃO_TIPOLOGRADOURO;
	}

	public String getLOGRADOURO() {
		return LOGRADOURO;
	}

	public void setLOGRADOURO(String lOGRADOURO) {
		LOGRADOURO = lOGRADOURO;
	}

	public String getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public Integer getCEP() {
		return CEP;
	}

	public void setCEP(Integer cEP) {
		CEP = cEP;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Integer getCODIGO_MUNICIPIO() {
		return CODIGO_MUNICIPIO;
	}

	public void setCODIGO_MUNICIPIO(Integer cODIGO_MUNICIPIO) {
		CODIGO_MUNICIPIO = cODIGO_MUNICIPIO;
	}

	public String getMUNICIPIO() {
		return MUNICIPIO;
	}

	public void setMUNICIPIO(String mUNICIPIO) {
		MUNICIPIO = mUNICIPIO;
	}

	public String getDDD_TELEFONE_1() {
		return DDD_TELEFONE_1;
	}

	public void setDDD_TELEFONE_1(String dDD_TELEFONE_1) {
		DDD_TELEFONE_1 = dDD_TELEFONE_1;
	}

	public String getDDD_TELEFONE_2() {
		return DDD_TELEFONE_2;
	}

	public void setDDD_TELEFONE_2(String dDD_TELEFONE_2) {
		DDD_TELEFONE_2 = dDD_TELEFONE_2;
	}

	public String getDDD_FAX() {
		return DDD_FAX;
	}

	public void setDDD_FAX(String dDD_FAX) {
		DDD_FAX = dDD_FAX;
	}

	public String getCORREIO_ELETRONICO() {
		return CORREIO_ELETRONICO;
	}

	public void setCORREIO_ELETRONICO(String cORREIO_ELETRONICO) {
		CORREIO_ELETRONICO = cORREIO_ELETRONICO;
	}

	public Integer getQUALIFICAÇÃO_DO_RESPONSÁVEL() {
		return QUALIFICAÇÃO_DO_RESPONSÁVEL;
	}

	public void setQUALIFICAÇÃO_DO_RESPONSÁVEL(Integer qUALIFICAÇÃO_DO_RESPONSÁVEL) {
		QUALIFICAÇÃO_DO_RESPONSÁVEL = qUALIFICAÇÃO_DO_RESPONSÁVEL;
	}

	public Double getCAPITAL_SOCIAL_DA_EMPRESA() {
		return CAPITAL_SOCIAL_DA_EMPRESA;
	}

	public void setCAPITAL_SOCIAL_DA_EMPRESA(Double cAPITAL_SOCIAL_DA_EMPRESA) {
		CAPITAL_SOCIAL_DA_EMPRESA = cAPITAL_SOCIAL_DA_EMPRESA;
	}

	public String getPORTE_EMPRESA() {
		return PORTE_EMPRESA;
	}

	public void setPORTE_EMPRESA(String pORTE_EMPRESA) {
		PORTE_EMPRESA = pORTE_EMPRESA;
	}

	public String getOPÇÃO_PELO_SIMPLES() {
		return OPÇÃO_PELO_SIMPLES;
	}

	public void setOPÇÃO_PELO_SIMPLES(String oPÇÃO_PELO_SIMPLES) {
		OPÇÃO_PELO_SIMPLES = oPÇÃO_PELO_SIMPLES;
	}

	public Integer getDATA_OPCAO_PELO_SIMPLES() {
		return DATA_OPCAO_PELO_SIMPLES;
	}

	public void setDATA_OPCAO_PELO_SIMPLES(Integer dATA_OPCAO_PELO_SIMPLES) {
		DATA_OPCAO_PELO_SIMPLES = dATA_OPCAO_PELO_SIMPLES;
	}

	public Integer getDATA_EXCLUSÃO_DO_SIMPLES() {
		return DATA_EXCLUSÃO_DO_SIMPLES;
	}

	public void setDATA_EXCLUSÃO_DO_SIMPLES(Integer dATA_EXCLUSÃO_DO_SIMPLES) {
		DATA_EXCLUSÃO_DO_SIMPLES = dATA_EXCLUSÃO_DO_SIMPLES;
	}

	public String getOPÇÃO_PELO_MEI() {
		return OPÇÃO_PELO_MEI;
	}

	public void setOPÇÃO_PELO_MEI(String oPÇÃO_PELO_MEI) {
		OPÇÃO_PELO_MEI = oPÇÃO_PELO_MEI;
	}

	public String getSITUAÇÃO_ESPECIAL() {
		return SITUAÇÃO_ESPECIAL;
	}

	public void setSITUAÇÃO_ESPECIAL(String sITUAÇÃO_ESPECIAL) {
		SITUAÇÃO_ESPECIAL = sITUAÇÃO_ESPECIAL;
	}

	public String getDATA_SITUAÇÃO_ESPECIAL() {
		return DATA_SITUAÇÃO_ESPECIAL;
	}

	public void setDATA_SITUAÇÃO_ESPECIAL(String dATA_SITUAÇÃO_ESPECIAL) {
		DATA_SITUAÇÃO_ESPECIAL = dATA_SITUAÇÃO_ESPECIAL;
	}

	public String getFILLER() {
		return FILLER;
	}

	public void setFILLER(String fILLER) {
		FILLER = fILLER;
	}

	public String getFIM_DE_REGISTRO() {
		return FIM_DE_REGISTRO;
	}

	public void setFIM_DE_REGISTRO(String fIM_DE_REGISTRO) {
		FIM_DE_REGISTRO = fIM_DE_REGISTRO;
	}
}
