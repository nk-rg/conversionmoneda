package com.bluefokus.conversionmoneda.service;

import com.bluefokus.conversionmoneda.entity.TipoCambio;
import com.bluefokus.conversionmoneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;

    public Mono<BigDecimal> getValorTipoCambio(String codMonedaOrigen, String codMonedaDestino, LocalDate fecha) {
        return tipoCambioRepository.findValorTipoCambio(fecha, codMonedaOrigen, codMonedaDestino)
                .single()
                .map(TipoCambio::getValor);
    }
}
