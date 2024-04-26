package data;

public class Administrador extends Usuario {

    public Administrador (String nome, int id, Departamento departamento){
        super(nome, id, departamento);
    }

    public String toString(){
        return "Nome: "+this.nome+", Id: "+this.id+", Departamento"+this.departamento+"\n";
    }
    
}