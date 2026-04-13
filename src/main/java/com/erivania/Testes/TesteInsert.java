package com.erivania.Testes;

import com.model.Aluno;
import com.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteInsert {
    public static void main(String[] args) {
        // cria a fabrica de conexão.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");

        // cria o gerenciador de entidades
        EntityManager em = emf.createEntityManager();

        // criar o objeto aluno
        Aluno aluno = new Aluno();
        aluno.setNome("Carlos");
        Curso curso = new Curso();
        curso.setNomeCurso("Educação Física");
        aluno.setCurso(curso);
        aluno.setEmail("Carlos@gmail.com");
        aluno.setIdade(24);

        // iniciar a transação
        em.getTransaction().begin();
        // salvar no banco
        em.persist(aluno);
        // confirma
        em.getTransaction().commit();
        // fechar
        em.close();
        // emf.close();

        // System.out.println("Aluno salvo com sucesso.");
    }
}
