package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @ManyToMany
    private List<Curso> cursos = new ArrayList<>();

    public Professor() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

}
