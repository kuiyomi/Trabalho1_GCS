package data;

public enum Status {
    ABERTO("Aberto"), 
    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private final String status;

    Status(String status){
        this.status= status;
    }

    public String getStatus(){
        return status;
    }
}
