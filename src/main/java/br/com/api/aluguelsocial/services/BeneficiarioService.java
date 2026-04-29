package br.com.api.aluguelsocial.services;

import br.com.api.aluguelsocial.exceptions.ResourceAlreadyExistsException;
import br.com.api.aluguelsocial.exceptions.ResourceNotFoundExeception;
import br.com.api.aluguelsocial.model.dto.BeneficiarioRequestDTO;
import br.com.api.aluguelsocial.model.dto.BeneficiarioResponseDTO;
import br.com.api.aluguelsocial.model.dto.PageResponse;
import br.com.api.aluguelsocial.model.entities.Beneficiario;
import br.com.api.aluguelsocial.model.enums.Status;
import br.com.api.aluguelsocial.repositories.BeneficiarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    @Transactional(readOnly = true)
    public PageResponse<BeneficiarioResponseDTO> listarBeneficiariosPaginados(String nomeCompleto, String cpf, Status status, Pageable pageable) {

        Page<Beneficiario> page;

        if (cpf != null && !cpf.isBlank()) {
            page = beneficiarioRepository.findByCpf(cpf, pageable);
        } else if (nomeCompleto != null && !nomeCompleto.isBlank()) {
            page = beneficiarioRepository.findByNomeContainingIgnoreCase(nomeCompleto, pageable);
        } else if (status != null) {
            page = beneficiarioRepository.findAllByStatus(status, pageable);
        } else {
            page = beneficiarioRepository.findAll(pageable);
        }

        return new PageResponse<>(
                page.getContent().stream().map(BeneficiarioResponseDTO::fromEntity).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Transactional(readOnly = true)
    public BeneficiarioResponseDTO listarBeneficiarioPorId(UUID id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Beneficiário(a) não encontrado."));
        return BeneficiarioResponseDTO.fromEntity(beneficiario);
    }

    @Transactional
    public void cadastrarBeneficiario(BeneficiarioRequestDTO dto) {
        Beneficiario beneficiario = new Beneficiario();

        if (beneficiarioRepository.existsByCpf(dto.cpf())) {
            throw new ResourceAlreadyExistsException("CPF já cadastrado.");
        }

        beneficiario.setNome(dto.nome());
        beneficiario.setCpf(dto.cpf());
        beneficiario.setEndereco(dto.endereco());
        beneficiario.setStatus(dto.status());
        beneficiario.setDataCriacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        beneficiario.setDadosBancarios(dto.dadosBancarios());

        beneficiarioRepository.save(beneficiario);
    }

    @Transactional
    public void atualizarBeneficiario(UUID id, BeneficiarioRequestDTO dto) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Beneficiário(a) não encontrado."));

        if (beneficiarioRepository.existsByCpf(dto.cpf())) {
            throw new ResourceAlreadyExistsException("CPF já cadastrado.");
        }

        beneficiario.setNome(dto.nome());
        beneficiario.setCpf(dto.cpf());
        beneficiario.setEndereco(dto.endereco());
        beneficiario.setDataCriacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        beneficiario.setDadosBancarios(dto.dadosBancarios());

    }

    public void atualizarStatusBeneficiario(UUID id, Status status) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Beneficiario não encontrado."));

        if (beneficiario.getStatus() != Status.ATIVO && status != Status.INATIVO) {
            beneficiario.setStatus(status);
        } else {
            throw new IllegalStateException("Transição inválida");
        }
    }
}

