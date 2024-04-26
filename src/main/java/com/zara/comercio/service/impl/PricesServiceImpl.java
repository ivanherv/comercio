package com.zara.comercio.service.impl;

import com.zara.comercio.dto.PriceDto;
import com.zara.comercio.entity.Price;
import com.zara.comercio.exception.PriceNotFoundException;
import com.zara.comercio.repository.PriceRepository;
import com.zara.comercio.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implementación del servicio que contiene la lógica de negocio para
 * devolver el resultado de la consulta
 */
@Service
public class PricesServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PricesServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Método para convertir una entidad de Price a un DTO
     * @param price Entidad price
     * @return PriceDto Dto price
     */
    private PriceDto convertToDto(Price price) {

            PriceDto priceDto = new PriceDto();
            priceDto.setId(price.getId());
            priceDto.setBrandId(price.getBrandId());
            priceDto.setProductId(price.getProductId());
            priceDto.setPriceList(price.getPriceList());
            priceDto.setStartDate(price.getStartDate());
            priceDto.setEndDate(price.getEndDate());
            priceDto.setPrice(price.getPrice());

            return priceDto;
    }

    /**
     * Método para obtener el price según los parámetros de la consulta
     * @param applicationDate Fecha de aplicación
     * @param productId Id de producto
     * @param brandId Id de cadena
     * @return PriceDto Dto con el resultado
     */
    @Override
    public PriceDto getByApplicationDateProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepository.getByApplicationDateProductIdAndBrandId(applicationDate, productId, brandId)
                .map(this::convertToDto)
                .orElseThrow(() -> new PriceNotFoundException());
    }

}
