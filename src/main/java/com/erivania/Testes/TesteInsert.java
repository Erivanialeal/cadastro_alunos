package com.erivania.Testes;

import com.model.Aluno;
import com.model.Curso;
import com.model.Matricula;
import com.model.Professor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class TesteInsert {
    public static void main(String[] args) {
        // cria a fabrica de conexão.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");

        // cria o gerenciador de entidades
        EntityManager em = emf.createEntityManager();

        // criar o objeto aluno
        Curso curso = new Curso();
        curso.setNome("Biologia");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Ana");
        aluno1.setEmail("Ana@gmail.com");
        aluno1.setIdade(19);

        Matricula matricula = new Matricula();
        matricula.setDataMatricula(LocalDate.of(2025, 4, 15));

        Professor professor = new Professor();
        professor.setNome("Ednalva");

        aluno1.setCurso(curso);
        curso.getAlunos().add(aluno1);
        matricula.setAluno(aluno1);
        matricula.setCurso(curso);
        professor.getCursos().add(curso);
        curso.getProfessores().add(professor);

        // iniciar a transação
        em.getTransaction().begin();
        // salvar no banco
        em.persist(curso);
        em.persist(aluno1);
        em.persist(matricula);
        em.persist(professor);
        ;
        // confirma
        em.getTransaction().commit();
        // fechar
        em.close();
        // emf.close();

        // System.out.println("Aluno salvo com sucesso.");
    }
}
