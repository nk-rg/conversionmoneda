package com.bluefokus.conversionmoneda.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoCambio;

    @ManyToOne
    @JoinColumn(name = "id_moneda_origen")
    private Moneda monedaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_moneda_destino")
    private Moneda monedaDestino;

    private BigDecimal valor;

    private LocalDate fecha;
}
