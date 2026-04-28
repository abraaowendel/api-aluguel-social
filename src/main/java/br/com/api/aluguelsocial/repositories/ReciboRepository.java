package br.com.api.aluguelsocial.repositories;

import br.com.api.aluguelsocial.model.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReciboRepository extends JpaRepository<Beneficiario, UUID> {

}
