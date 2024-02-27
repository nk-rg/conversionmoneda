package com.bluefokus.conversionmoneda.repository;

import com.bluefokus.conversionmoneda.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

    @Query(
    """
     SELECT tc FROM TipoCambio tc
             INNER JOIN tc.monedaOrigen mo
             INNER JOIN tc.monedaDestino md
             WHERE tc.fecha = :fecha AND mo.codigo = :codMonedaOrigen AND md.codigo = :codMonedaDestino
    """)
    TipoCambio getValorTipoCambio(
            @Param("fecha") LocalDate fecha,
            @Param("codMonedaOrigen") String codMonedaOrigen,
            @Param("codMonedaDestino") String codMonedaDestino);
}
