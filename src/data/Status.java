package data;

public enum Status {
    ABERTO("Aberto"), 
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    CONCLUIDO("Concluido");

    private final String status;

    Status(String status){
        this.status= status;
    }

    public String getStatus(){
        return status;
    }
}
