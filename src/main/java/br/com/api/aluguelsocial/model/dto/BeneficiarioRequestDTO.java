package br.com.api.aluguelsocial.model.dto;

import br.com.api.aluguelsocial.model.embeddables.DadosBancarios;
import br.com.api.aluguelsocial.model.embeddables.Endereco;
import br.com.api.aluguelsocial.model.entities.Recibo;
import br.com.api.aluguelsocial.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BeneficiarioRequestDTO(
        String nome,
        String cpf,
        Endereco endereco,
        Status status,
        DadosBancarios dadosBancarios
) {
}
