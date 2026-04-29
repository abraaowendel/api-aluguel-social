package br.com.api.aluguelsocial.model.dto;

import br.com.api.aluguelsocial.model.embeddables.DadosBancarios;
import br.com.api.aluguelsocial.model.embeddables.Endereco;
import br.com.api.aluguelsocial.model.entities.Beneficiario;
import br.com.api.aluguelsocial.model.entities.Recibo;
import br.com.api.aluguelsocial.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BeneficiarioResponseDTO(
        UUID id,
        @NotBlank(message = "Campo Nome não pode ser vazio.")
        String nome,
        @CPF
        @NotBlank(message = "Campo Nome não pode ser vazio.")
        String cpf,
        @NotNull(message = "Campo Endereço não pode ser nulo.")
        Endereco endereco,
        @NotNull(message = "Campo Status não pode ser nulo.")
        Status status,
        String dataCriacao,
        @NotNull(message = "Campo Dados bancários não pode ser nulo.")
        DadosBancarios dadosBancarios,
        List<Recibo>recibos
) {

    public static BeneficiarioResponseDTO fromEntity(Beneficiario beneficiario) {
        return new BeneficiarioResponseDTO(
                beneficiario.getId(),
                beneficiario.getNome(),
                beneficiario.getCpf(),
                beneficiario.getEndereco(),
                beneficiario.getStatus(),
                beneficiario.getDataCriacao(),
                beneficiario.getDadosBancarios(),
                beneficiario.getRecibos()
        );
    }
}
