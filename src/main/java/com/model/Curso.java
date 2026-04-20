package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "cursos")
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos = new ArrayList<>();

    public Curso() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setNome(String nomeCurso) {
        this.nome = nomeCurso;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

}
