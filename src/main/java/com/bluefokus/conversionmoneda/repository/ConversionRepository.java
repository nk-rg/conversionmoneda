package com.bluefokus.conversionmoneda.repository;

import com.bluefokus.conversionmoneda.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<Conversion, Integer> {
}
