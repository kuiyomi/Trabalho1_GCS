package data;

public abstract class Usuario {
    protected String nome;
    protected int ID;
    protected Departamento departamento;
    private TipoUsuario tipo;

    public Usuario (String nome, TipoUsuario tipo, Departamento departamento) {
        this.nome = nome;
        this.tipo = tipo;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    /*
     * Favor implementar a classe "Departamento" e a classe "enum" equivalente aos
     * tipo de departamentos que forem definidos entre o grupo
     */
}