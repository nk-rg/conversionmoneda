package com.bluefokus.conversionmoneda.repository;

import com.bluefokus.conversionmoneda.entity.Conversion;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ConversionRepository extends ReactiveCrudRepository<Conversion, Integer> {
}
