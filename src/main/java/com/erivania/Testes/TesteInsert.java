package com.erivania.Testes;

import com.model.Aluno;

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
        aluno.setCurso("Educação Física");
        aluno.setEmail("Carlos@gmail.com");

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
