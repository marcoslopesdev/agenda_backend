
package com.marcos.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcos.agenda.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findAllByNomeClienteContainingIgnoreCase(@Param("nomeCliente") String nomeCliente);

	Optional<Cliente> findByCpf(String cpf);

	boolean existsByCpf(String cpf);

}
