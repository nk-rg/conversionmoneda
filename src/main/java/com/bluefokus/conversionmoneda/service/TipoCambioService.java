package com.bluefokus.conversionmoneda.service;

import com.bluefokus.conversionmoneda.repository.MonedaRepository;
import com.bluefokus.conversionmoneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;
    private final MonedaRepository monedaRepository;
    public BigDecimal getValorTipoCambio(String codMonedaOrigen, String codMonedaDestino, LocalDate fecha) {
        return tipoCambioRepository.getValorTipoCambio(fecha, codMonedaOrigen, codMonedaDestino).getValor();
    }
}
