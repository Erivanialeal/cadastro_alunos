package com.erivania.Testes;

import com.model.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteUpdate {
    public static void main(String[] args) {

        // criar fabricar de conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");

        // criar o gerenciador de entidades
        EntityManager em = emf.createEntityManager();

        try {
            // buscar
            Aluno aluno = em.find(Aluno.class, 1L);
            if (aluno != null) {
                System.out.println("Atualizar dados do aluno.");
                aluno.setNome("Eduarda");
                aluno.setEmail("Eduarda@gmail.com");

                // iniciar transação
                em.getTransaction().begin();
                // salvar no banco
                em.persist(aluno);
                // comitra
                em.getTransaction().commit();

            } else {
                System.out.println("Erro ao atualizar");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                em.close();
        }
    }

}
