package com.zara.comercio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase para gestionar el caso en el que no haya un resultado
 * con los parámetros especificados
 */

@ControllerAdvice
public class PriceNotFoundAdvice {

    /**
     * Método para devolver HTTP 404 informativo cuando no hay un resultado
     * @param priceNotFoundException Excepcion de que no hay resultado
     * @return String Mensaje de la excepcion
     */
    @ResponseBody
    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePriceNotFound(PriceNotFoundException priceNotFoundException) {
        return priceNotFoundException.getMessage();
    }

}
