package com.bluefokus.conversionmoneda.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("moneda")
public class Moneda {
    @Id
    private Long idMoneda;
    private String codigo;
    private String nombre;
    private String simbolo;
}
