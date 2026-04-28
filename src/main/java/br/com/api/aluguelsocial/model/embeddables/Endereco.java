package br.com.api.aluguelsocial.model.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String Bairro;
}
