package br.com.api.aluguelsocial.repositories;

import br.com.api.aluguelsocial.model.entities.Beneficiario;
import br.com.api.aluguelsocial.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, UUID> {

    Page<Beneficiario> findByCpf(String cpf, Pageable pageable);

    Page<Beneficiario> findByNomeContainingIgnoreCase(String nomeCompleto, Pageable pageable);

    Page<Beneficiario> findAllByStatus(Status status, Pageable pageable);

    boolean existsByCpf(String cpf);
}
