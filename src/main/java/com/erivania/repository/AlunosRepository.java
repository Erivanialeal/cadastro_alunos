package com.erivania.repository;

import java.util.List;

import com.model.Aluno;
import com.model.Curso;

import jakarta.persistence.EntityManager;

public class AlunosRepository {

    private EntityManager em;

    public AlunosRepository(EntityManager em) {
        this.em = em;
    }

    // buscar todos os alunos
    public List<Aluno> buscaTodosOsAlunos() {

        List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();

        for (Aluno a : alunos) {
            System.out.println(a.getNome());
        }
        return alunos;

    }

    public Aluno buscarPorNome(String nome) {
        return em.createQuery("SELECT a FROM Aluno a WHERE a.nome = :nome", Aluno.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    // buscar aluno por idade
    public Aluno buscarAlunosPorIdade(Integer idade) {
        return em.createQuery("SELECT a FROM Aluno a WHERE a.idade = :idade", Aluno.class)
                .setParameter("idade", idade)
                .getSingleResult();
    }

    // buscar por nome (Like)
    public Aluno buscarPorEmail(String email) {
        return em.createQuery("SELECT a FROM Aluno a WHERE a.email LIKE :email", Aluno.class)
                .setParameter("email", "%" + email + "%")
                .getSingleResult();
    }

    public List<Aluno> buscarPorNomeIdade(String nome, Integer idade) {
        return em.createQuery(
                "SELECT a FROM Aluno a WHERE a.nome LIKE :nome AND a.idade = :idade", Aluno.class)
                .setParameter("nome", "%" + nome + "%")
                .setParameter("idade", idade)
                .getResultList();

    }

    public List<Aluno> buscarAlunoPorIdadeOuCurso(Integer idade, String nomeCurso) {

        return em
                .createQuery("SELECT a FROM Aluno a WHERE a.idade = :idade OR a.curso.nome LIKE :nomeCurso",
                        Aluno.class)
                .setParameter("idade", idade)
                .setParameter("nomeCurso", "%" + nomeCurso + "%")
                .getResultList();
    }

    public List<Aluno> buscarNomeCujoTenhaTexo(String nome) {
        return em.createQuery("SELECT a FROM Aluno a WHERE a.nome LIKE :nome", Aluno.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
}
