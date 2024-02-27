package com.bluefokus.conversionmoneda.repository;

import com.bluefokus.conversionmoneda.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
}
