package data;

public class Administrador extends Usuario {

    public Administrador (String nome, Departamento departamento, int id){
        super(nome, departamento, id);
    }

    public String toString(){
        return "Administrador" + "Nome: "+this.nome+", Id: "+this.id+", Departamento"+this.departamento.getNome()+"\n";
    }
}