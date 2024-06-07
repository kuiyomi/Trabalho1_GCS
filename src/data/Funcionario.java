package data;

public class Funcionario extends Usuario {
    public Funcionario(String nome, Departamento departamento, int id) {
        super(nome, departamento, id);
    }

    public String toString() {
        return  "Funcionario"+ "Nome: " + this.nome + ", Id: " + this.id + ", Departamento" + this.departamento.getNome() + "\n";
    }
}