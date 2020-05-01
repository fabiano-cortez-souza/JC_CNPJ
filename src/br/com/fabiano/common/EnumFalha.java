package br.com.fabiano.common;

public enum EnumFalha {
    
    FalhaFile         (1){
        @Override
        public String getDescription() {
         return "Falha em operações com Arquivo";
        }
       },
    FalhaDB           (2){
        @Override
        public String getDescription() {
         return "Falha em operações no BD";
        }
       },
    FalhaProcessamento(3){
        @Override
        public String getDescription() {
         return "Falha durante processamento";
        }
       };
    
    int level;
    
    EnumFalha(int level){
        this.level = level;  
    }

    public int getIntLevel() {
        return level;
    }
    
    public abstract String getDescription();

}
