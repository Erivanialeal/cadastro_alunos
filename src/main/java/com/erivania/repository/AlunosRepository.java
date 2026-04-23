package com.erivania.repository;

import java.util.List;

import com.model.Aluno;
import com.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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

    public Long contarQuantosAlunosExistem() {
        return em.createQuery("SELECT COUNT(a) FROM Aluno a", Long.class)
                .getSingleResult();
    }

    public List<Object[]> contarAlunosPorCurso() {
        return em.createQuery("SELECT a.curso.nome, COUNT(a)" +
                "FROM Aluno a" +
                "GROUP BY a.curso.nome", Object[].class)
                .getResultList();
    }

    public List<Aluno> buscarAlunosComSeusCursos(String nome) {
        return em.createQuery("SELECT a FROM Aluno a JOIN FETCH a.curso c" +
                " WHERE c.nome = :nome", Aluno.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Aluno> buscarAlunosPorCursoEspecifico(Long idCurso) {
        return em.createQuery("SELECT a FROM Aluno a JOIN FETCH a.curso c" +
                " WHERE c.id = :idCurso", Aluno.class)
                .setParameter("idCurso", idCurso)
                .getResultList();
    }

    public List<Curso> buscarCursosComSeusAlunos(String Alunonome) {
        return em.createQuery("SELECT DISTINCT c FROM Curso c JOIN FETCH c.alunos a" +
                "WHERE a.nome = :nome", Curso.class)
                .setParameter("nome", Alunonome)
                .getResultList();
    }

    public List<Aluno> buscarAlunoDeUmCursoComNomeEspecifico(String nomeCurso) {
        return em.createQuery("SELECT a FROM Aluno a" +
                "JOIN a.curso c" +
                "WHERE c.nome = :nomeCurso", Aluno.class)
                .setParameter("nomeCurso", nomeCurso)
                .getResultList();
    }

    public List<Curso> BuscarCursosDeProfessoresEspecíficos(String nomeProfessor) {
        return em.createQuery("SELECT c FROM Curso c" +
                "JOIN c.professores p " +
                "WHERE p.nome = :nomeProfessor", Curso.class)
                .setParameter("nomeProfessor", nomeProfessor)
                .getResultList();
    }

    @Transactional
    public int atualizarEmailDeAluno(Long id, String email) {
        return em.createQuery("UPDATE Aluno a SET a.email = :email WHERE a.id = :id")
                .setParameter("email", email)
                .setParameter("id", id)
                .executeUpdate();
    }

    public int atualizarCursoDeUmAluno(Long nomeAluno, String novoCurso) {
        return em.createQuery("UPDATE Curso c SET c.nome = : novoCurso" +
                "WHERE c.id = (SELECT a.curso.id FROM Aluno a WHERE a.nome = :nomeAluno")
                .setParameter("idAluno", nomeAluno)
                .setParameter("novoCurso", novoCurso)
                .executeUpdate();

    }

}
