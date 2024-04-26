package com.zara.comercio.repository;

import com.zara.comercio.entity.Price;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Clase repositorio para gestionar las consultas a la base de datos
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Método que realiza la consulta a la base de datos mediante SQL
     * @param applicationDate Fecha de aplicación
     * @param productId Id de producto
     * @param brandId Id de cadena
     * @return Optional<Price> Optional con el resultado (si lo hay)
     */
    @Query("SELECT p FROM Price p WHERE :applicationDate BETWEEN p.startDate AND p.endDate AND p.productId = :productId" +
            " AND p.brandId = :brandId ORDER BY p.priority DESC LIMIT 1")
    Optional<Price> getByApplicationDateProductIdAndBrandId(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);

}
