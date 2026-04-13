package com.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Long id;

    private String nomeCurso;

    @ManyToOne
    private Professor Professor;

    @ManyToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    public Curso() {

    }

    public Long getId() {
        return id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Professor getProfessor() {
        return Professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setProfessor(Professor professor) {
        Professor = professor;
    }

}
