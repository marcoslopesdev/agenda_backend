package com.marcos.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcos.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	List<Contato> findByClienteId(Long clienteId);
}