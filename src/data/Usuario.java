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

    public boolean adicionaUsuario(Usuario user){
        if (consultaUsuario(user.getId())!= null ) {
            return false; 
        }
        return usuarios.add(user);
    }

    public Usuario consultaUsuario(int id){
        for(Usuario user : usuarios){
            if (user.getId() == id) {
                return user;
            }
        }
            return null; 
        }
        
    public abstract String toString();
}