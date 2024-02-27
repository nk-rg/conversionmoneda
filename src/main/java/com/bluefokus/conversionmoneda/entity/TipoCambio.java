package com.bluefokus.conversionmoneda.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Table("tipo_cambio")
public class TipoCambio {

    @Id
    private Integer idTipoCambio;
//
//    @Column("id_moneda_origen")
//    private Moneda monedaOrigen;
//
//    @Column("id_moneda_destino")
//    private Moneda monedaDestino;

    private BigDecimal valor;

    private LocalDate fecha;
}
