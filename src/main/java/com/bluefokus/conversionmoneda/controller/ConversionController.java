package com.bluefokus.conversionmoneda.controller;


import com.bluefokus.conversionmoneda.dto.ConversionRequest;
import com.bluefokus.conversionmoneda.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/conversion")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @PostMapping
    public Mono<ResponseEntity<?>> insert(@RequestBody ConversionRequest request) {
        return conversionService.insert(request)
                .map(idConversion -> {
                    URI uri = UriComponentsBuilder
                            .fromPath("/api/v1/conversion/{id}")
                            .buildAndExpand(idConversion)
                            .toUri();
                    return ResponseEntity.created(uri).build();
                });
    }

    @PutMapping("/{idConversion}")
    public Mono<ResponseEntity<?>> update(@PathVariable Integer idConversion, @RequestBody ConversionRequest request) {
        return conversionService.update(idConversion, request)
                .thenReturn(ResponseEntity.ok().build());
    }
}
