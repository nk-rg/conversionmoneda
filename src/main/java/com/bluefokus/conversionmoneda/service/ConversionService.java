package com.bluefokus.conversionmoneda.service;

import com.bluefokus.conversionmoneda.dto.ConversionRequest;
import com.bluefokus.conversionmoneda.entity.Conversion;
import com.bluefokus.conversionmoneda.repository.ConversionRepository;
import com.bluefokus.conversionmoneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final TipoCambioRepository tipoCambioRepository;
    private final ConversionRepository conversionRepository;

    public Mono<Integer> insert(ConversionRequest request) {
        return tipoCambioRepository.findValorTipoCambio(
                request.fechaTipoCambio(),
                request.codigoMonedaOrigen(),
                request.codigoMonedaDestino()
        ).flatMap(tipoCambio -> {
            BigDecimal montoConvertido = request.monto().multiply(tipoCambio.getValor());
            return  conversionRepository.save(Conversion.builder()
                    .montoOrigen(request.monto())
                    .montoConvertido(montoConvertido)
                    .idTipoCambio(tipoCambio.getIdTipoCambio())
                    .build());
        }).single().map(Conversion::getIdConversion);
    }

    public Mono<Conversion> update(Integer idConversion, ConversionRequest request) {
    return tipoCambioRepository.findValorTipoCambio(
                request.fechaTipoCambio(),
                request.codigoMonedaOrigen(),
                request.codigoMonedaDestino()
        ).flatMap(tipoCambio -> {
            BigDecimal montoConvertido = request.monto().multiply(tipoCambio.getValor());
            return conversionRepository.save(Conversion.builder()
                    .idConversion(idConversion)
                    .montoOrigen(request.monto())
                    .montoConvertido(montoConvertido)
                    .idTipoCambio(tipoCambio.getIdTipoCambio())
                    .build());
        }).single();
    }
}
