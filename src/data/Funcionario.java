package data;

public class Funcionario extends Usuario {
    public Funcionario (String nome, int id, Departamento departamento) {
        super(nome, id, departamento);
    }

public String toString(){
    return "Nome: "+this.nome+", Id: "+this.id+", Departamento"+this.departamento+"\n";
}
    
}