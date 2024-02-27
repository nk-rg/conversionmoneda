package com.bluefokus.conversionmoneda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ConversionRequest (
        BigDecimal monto,
        String codigoMonedaOrigen,
        String codigoMonedaDestino,
        LocalDate fechaTipoCambio
){}
