package com.threadbasic.thread_fila_pilha;

public class ObjetoFilaThread {

    private String nome;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
 
    @Override
    public int hashCode() {
        return super.hashCode();
    }
     
}