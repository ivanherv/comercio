package com.zara.comercio.service;

import com.zara.comercio.dto.PriceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz de servicio para la tabla PRICES
 */
@Service
public interface PriceService {

    PriceDto getByApplicationDateProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId);
}
