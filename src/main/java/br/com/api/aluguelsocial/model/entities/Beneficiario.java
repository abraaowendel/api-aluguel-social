package br.com.api.aluguelsocial.model.entities;


import br.com.api.aluguelsocial.model.embeddables.DadosBancarios;
import br.com.api.aluguelsocial.model.embeddables.Endereco;
import br.com.api.aluguelsocial.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_BENEFICIARIOS")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String dataCriacao;
    @NotNull
    private DadosBancarios dadosBancarios;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Recibo> recibos;

}
