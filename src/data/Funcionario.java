package data;

public class Funcionario extends Usuario {
    public Funcionario (String nome, Departamento departamento) {
        super(nome, TipoUsuario.FUNCIONARIO, departamento);
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    /*
     * Favor implementar a classe "Departamento" e a classe "enum" equivalente aos
     * tipo de departamentos que forem definidos entre o grupo
     */
}