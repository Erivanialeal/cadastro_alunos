package com.erivania.Testes;

import com.model.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteDelete {
    public static void main(String[] args) {
        // criar fabrica de conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        // criar o gerenciador de entidades
        EntityManager em = emf.createEntityManager();

        try {
            Aluno aluno = em.find(Aluno.class, 1L);
            if (aluno != null) {
                // iniciar transação
                em.getTransaction().begin();
                // deletar
                em.remove(aluno);
                // commitar
                em.getTransaction().commit();
                System.out.println("Aluno deletado com sucesso!");

            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }

}
