package data;

public class Administrador extends Usuario {
    private Departamento departamento;

    public Administrador (String nome, Departamento departamento){
        super(nome, TipoUsuario.ADMINISTRADOR, departamento);
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    /*
     * Favor implementar a classe "Departamento" e a classe "enum" equivalente aos
     * tipo de departamentos que forem definidos entre o grupo
     */
}