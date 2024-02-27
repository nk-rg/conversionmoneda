package com.bluefokus.conversionmoneda.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConversion;

    private BigDecimal montoOrigen;

    private BigDecimal montoConvertido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cambio")
    private TipoCambio tipoCambio;
}
