package data;

public enum TipoUsuario {
    FUNCIONARIO("Funcionário"),
    ADMINISTRADOR("Administrador");
    /*
     * Favor verificar se as designições do "enum" estão condizentes 
     * com o que é descrito no enunciado do trabalho
     */

    private final String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}