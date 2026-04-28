package br.com.api.aluguelsocial.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Month;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "TB_RECIBOS")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private Month mes;
    private Year ano;

    @ManyToOne
    private Beneficiario beneficiario;


}
