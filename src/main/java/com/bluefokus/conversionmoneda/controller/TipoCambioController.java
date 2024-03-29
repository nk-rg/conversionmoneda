package com.bluefokus.conversionmoneda.controller;

import com.bluefokus.conversionmoneda.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/tipo-cambio")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    @GetMapping
    public Mono<ResponseEntity<?>> search(
            @RequestParam String codMonedaOrigen,
            @RequestParam String codMonedaDestino,
            @RequestParam LocalDate fecha) {
        return tipoCambioService.getValorTipoCambio(codMonedaOrigen, codMonedaDestino, fecha)
                .map(ResponseEntity::ok);
    }

}
