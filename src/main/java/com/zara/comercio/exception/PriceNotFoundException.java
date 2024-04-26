package com.zara.comercio.exception;

/**
 * Clase de excepción a lanzar cuando no hay un resultado que se ajuste
 * a los parámetros de búsqueda
 */
public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException() {
        super("No se ha encontrado un resultado con los parámetros especificados");
    }

}
