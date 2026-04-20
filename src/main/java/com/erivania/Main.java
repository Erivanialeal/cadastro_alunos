package com.erivania;

import com.erivania.repository.AlunosRepository;
import com.model.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // cria a fabrica de conexão
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        // cria o gerenciador de entidades
        EntityManager em = emf.createEntityManager();

        AlunosRepository repo = new AlunosRepository(em);
        em.getTransaction().begin();

        // repo.buscaTodosOsAlunos();
        System.out.println("BUSCAR POR NOME");
        // Aluno aluno = repo.buscarPorNome("Vitor");

        System.out.println("Buscar por idade");
        // repo.buscarAlunosPorIdade(24);

        System.out.println("Buscar por nome e idade");
        // repo.buscarPorNomeIdade("Vitor", 24);

        System.out.println("Buscar por idade ou curso");
        // repo.buscarAlunoPorIdadeOuCurso(24, "TI");

        em.getTransaction().commit();
        em.clear();
        emf.close();

    }

}