package com.bluefokus.conversionmoneda.service;

import com.bluefokus.conversionmoneda.TipoCambioNotFoundException;
import com.bluefokus.conversionmoneda.dto.ConversionRequest;
import com.bluefokus.conversionmoneda.entity.Conversion;
import com.bluefokus.conversionmoneda.entity.TipoCambio;
import com.bluefokus.conversionmoneda.repository.ConversionRepository;
import com.bluefokus.conversionmoneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final TipoCambioRepository tipoCambioRepository;
    private final ConversionRepository conversionRepository;

    public Integer insert(ConversionRequest request) {
        TipoCambio tipoCambio = Optional.ofNullable(tipoCambioRepository.getValorTipoCambio(
                request.fechaTipoCambio(),
                request.codigoMonedaOrigen(),
                request.codigoMonedaDestino()
        )).orElseThrow(() -> new TipoCambioNotFoundException("Tipo de cambio no existe"));

        BigDecimal montoConvertido = request.monto().multiply(tipoCambio.getValor());

        Conversion conversion = conversionRepository.save(Conversion.builder()
                        .montoOrigen(request.monto())
                        .montoConvertido(montoConvertido)
                        .tipoCambio(tipoCambio)
                .build());
        return conversion.getIdConversion();
    }

    public void update(Integer idConversion, ConversionRequest request) {
        TipoCambio tipoCambio = Optional.ofNullable(tipoCambioRepository.getValorTipoCambio(
                request.fechaTipoCambio(),
                request.codigoMonedaOrigen(),
                request.codigoMonedaDestino()
        )).orElseThrow(() -> new TipoCambioNotFoundException("Tipo de cambio no existe"));

        BigDecimal montoConvertido = request.monto().multiply(tipoCambio.getValor());

        conversionRepository.save(Conversion.builder()
                .idConversion(idConversion)
                .montoOrigen(request.monto())
                .montoConvertido(montoConvertido)
                .tipoCambio(tipoCambio)
                .build());
    }
}
