package com.bluefokus.conversionmoneda.repository;

import com.bluefokus.conversionmoneda.entity.TipoCambio;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface TipoCambioRepository extends ReactiveCrudRepository<TipoCambio, Integer> {

    @Query("SELECT t.* FROM tipo_cambio t JOIN moneda mo ON mo.id_moneda = t.id_moneda_origen JOIN moneda md ON md.id_moneda = t.id_moneda_destino WHERE t.fecha = $1 AND mo.codigo = $2 AND md.codigo = $3")
    Flux<TipoCambio> findValorTipoCambio(LocalDate fecha, String codMonedaOrigen, String codMonedaDestino);
}
