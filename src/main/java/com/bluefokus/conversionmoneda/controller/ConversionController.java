package com.bluefokus.conversionmoneda.controller;


import com.bluefokus.conversionmoneda.dto.ConversionRequest;
import com.bluefokus.conversionmoneda.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/conversion")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ConversionRequest request) {
        Integer idConversion = conversionService.insert(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(idConversion)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idConversion}")
    public ResponseEntity<?> update(@PathVariable Integer idConversion, @RequestBody ConversionRequest request) {
        conversionService.update(idConversion, request);
        return ResponseEntity.ok().build();
    }
}
