package com.zara.comercio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase DTO que representa el resultado a devolver de una consulta
 */
@Data
@NoArgsConstructor
public class PriceDto {

    private Long id;

    private Long brandId;

    private Long productId;

    private Long priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal price;

}
