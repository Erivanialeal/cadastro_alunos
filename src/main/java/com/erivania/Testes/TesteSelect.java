package com.erivania.Testes;

import com.model.Aluno;

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
            // buscar
            Aluno aluno = em.find(Aluno.class, 1L);

            if (aluno != null) {
                System.out.println("Aluno encontrado");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Curso: " + aluno.getCurso());
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }

    }

}
