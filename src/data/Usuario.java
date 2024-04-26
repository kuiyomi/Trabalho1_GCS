package data;

import java.util.ArrayList;

public abstract class Usuario {
    protected String nome;
    protected int id;
    protected Departamento departamento;
    private static ArrayList<Usuario> usuarios; 

    public Usuario (String nome, Departamento departamento, int id) {
        this.nome = nome;
        this.id = id; 
        this.departamento = departamento;
        usuarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getId(){
        return id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public boolean adicionaUsuario(Usuario u){
        if (consultaUsuario(u.getId())!= null ) {
            return false; 
        }
        return usuarios.add(u);
    }

    public Usuario consultaUsuario(int id){
        for(Usuario u : usuarios){
            if (Usuario.getId() == id) {
                return u;
            }
        }
            return null; 
        }
    
    
    public abstract String toString();
        
}