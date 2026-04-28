package br.com.api.aluguelsocial.model.embeddables;

import jakarta.persistence.Embeddable;

@Embeddable
public class DadosBancarios {

    private String banco;
    private String agencia;
    private String conta;

}
