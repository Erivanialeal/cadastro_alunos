package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Aluno {

    // chave primaria
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String email;

    private String curso;

    public Aluno() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
