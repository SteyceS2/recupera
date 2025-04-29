package com.query.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//Query Methods
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
	List<Aluno> findByEmail(String email);
	List<Aluno> findByRenda(double renda);
	List<Aluno> findByRA(String ra);
	
	
}

	
	
	
	
	
	