package data;

import java.util.ArrayList;

public  class Usuario {
    protected String nome;
    protected int id;
    protected Departamento departamento;
    private static ArrayList<Usuario> usuarios = new ArrayList<>(); 

    public Usuario (String nome, Departamento departamento, int id) {
        this.nome = nome;
        this.id = id; 
        this.departamento = departamento;
       
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

    public static boolean adicionaUsuario(Usuario user){
       usuarios.add(user);
       return true;
    }

    public static Usuario consultaUsuario(int id){
        for(Usuario user : usuarios){
            if (user.getId() == id) {
                return user;
            }
        }
            return null; 
        }


        public static Usuario consultaUsuarioNome(String nome){
            for(Usuario user : usuarios){
                if (user.getNome().equals(nome)) {
                    return user;
                }
            }
                return null; 
            }

        public static ArrayList<Usuario> getUsuarios(){
            return usuarios;
        }   
    
}