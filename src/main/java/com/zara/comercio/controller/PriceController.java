package com.zara.comercio.controller;

import com.zara.comercio.dto.PriceDto;
import com.zara.comercio.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Clase que contiene el endpoint al cual se realizan la consultas
 * sobre la tabla PRICES
 */
@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Método para realizar una consulta por parámetros
     * @param applicationDate Fecha de aplicación
     * @param productId Id del producto
     * @param brandId Id de la cadena
     * @return ResponseEntity<PriceDto> PriceDTO que se ajusta a los parámetros especificados
     */
    @GetMapping("/search")
    public ResponseEntity<PriceDto> searchPrice(
            @RequestParam LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId
            ) {

        return new ResponseEntity<>(priceService
                .getByApplicationDateProductIdAndBrandId(applicationDate, productId, brandId)
                , HttpStatus.OK);
    }
}
