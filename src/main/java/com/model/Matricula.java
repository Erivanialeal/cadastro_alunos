package com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Matricula {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Curso curso;

    private LocalDate dataMatricula;

    public Matricula() {

    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

}
