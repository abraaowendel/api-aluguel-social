package br.com.api.aluguelsocial.model.entities;


import br.com.api.aluguelsocial.model.embeddables.DadosBancarios;
import br.com.api.aluguelsocial.model.embeddables.Endereco;
import jakarta.persistence.*;
import lombok.*;

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
    private String cpf;
    private Endereco endereco;
    private DadosBancarios dadosBancarios;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Recibo> recibos;

}
