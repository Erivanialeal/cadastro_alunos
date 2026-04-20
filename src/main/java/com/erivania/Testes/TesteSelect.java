package com.erivania.Testes;

import com.model.Aluno;
import com.model.Professor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteSelect {
    public static void main(String[] args) {
        // criar fabrica de conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        // criar o gerenciador de entidade
        EntityManager em = emf.createEntityManager();

        // tentar
        try {
            var alunos = em.createQuery(
                    "SELECT a FROM Aluno a", Aluno.class).getResultList();
            for (Aluno a : alunos) {
                System.out.println("Nome: " + a.getNome());
                System.out.println("Email: " + a.getId());
                System.out.println("Curso: " + a.getCurso().getNome());
                System.out.println("----------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
