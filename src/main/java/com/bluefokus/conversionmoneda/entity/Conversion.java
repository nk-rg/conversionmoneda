package com.bluefokus.conversionmoneda.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@Table("conversion")
public class Conversion {

    @Id
    private Integer idConversion;

    private BigDecimal montoOrigen;

    private BigDecimal montoConvertido;

    private Integer idTipoCambio;
}
