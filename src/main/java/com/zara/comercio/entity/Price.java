package com.zara.comercio.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase entidad que representa la tabla PRICES con sus mismos atributos
 */
@Entity
@Data
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "PRICE_LIST")
    private Long priceList;

}
