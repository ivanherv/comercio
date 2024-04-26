package com.zara.comercio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zara.comercio.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Clase con los tests especificados para validar los resultados
 */
@SpringBootTest
@AutoConfigureMockMvc
class ComercioApplicationTests {

    private final MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    private static final String ENDPOINT_MAPPING = "/price/search";

    private static final MultiValueMap<String, String> paramsTest1 = new LinkedMultiValueMap<>();
    private static final MultiValueMap<String, String> paramsTest2 = new LinkedMultiValueMap<>();
    private static final MultiValueMap<String, String> paramsTest3 = new LinkedMultiValueMap<>();
    private static final MultiValueMap<String, String> paramsTest4 = new LinkedMultiValueMap<>();
    private static final MultiValueMap<String, String> paramsTest5 = new LinkedMultiValueMap<>();

    static {
        paramsTest1.add("applicationDate", "2020-06-14T10:00:00");
        paramsTest1.add("productId", "35455");
        paramsTest1.add("brandId", "1");

        paramsTest2.add("applicationDate", "2020-06-14T16:00:00");
        paramsTest2.add("productId", "35455");
        paramsTest2.add("brandId", "1");

        paramsTest3.add("applicationDate", "2020-06-14T21:00:00");
        paramsTest3.add("productId", "35455");
        paramsTest3.add("brandId", "1");

        paramsTest4.add("applicationDate", "2020-06-15T10:00:00");
        paramsTest4.add("productId", "35455");
        paramsTest4.add("brandId", "1");

        paramsTest5.add("applicationDate", "2020-06-16T21:00:00");
        paramsTest5.add("productId", "35455");
        paramsTest5.add("brandId", "1");

    }

    @Autowired
    ComercioApplicationTests(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    /**
     * Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA).
     * El precio resultante deberia ser 35.50
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        PriceDto priceDtoTest = objectMapper
                .readValue(mockMvc
                        .perform(get(ENDPOINT_MAPPING)
                                .params(paramsTest1))
                        .andReturn()
                        .getResponse()
                        .getContentAsString(), PriceDto.class);

        Assertions.assertEquals(new BigDecimal("35.50"), priceDtoTest.getPrice());

    }

    /**
     * Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     * El precio resultante deberia ser 25.45
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        PriceDto priceDtoTest = objectMapper
                .readValue(mockMvc
                        .perform(get(ENDPOINT_MAPPING)
                                .params(paramsTest2))
                        .andReturn()
                        .getResponse()
                        .getContentAsString(), PriceDto.class);

        Assertions.assertEquals(new BigDecimal("25.45"), priceDtoTest.getPrice());

    }

    /**
     * Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     * El precio resultante deberia ser 35.50
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        PriceDto priceDtoTest = objectMapper
                .readValue(mockMvc
                        .perform(get(ENDPOINT_MAPPING)
                                .params(paramsTest3))
                        .andReturn()
                        .getResponse()
                        .getContentAsString(), PriceDto.class);

        Assertions.assertEquals(new BigDecimal("35.50"), priceDtoTest.getPrice());

    }

    /**
     * Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
     * El precio resultante deberia ser 30.50
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {

        PriceDto priceDtoTest = objectMapper
                .readValue(mockMvc
                        .perform(get(ENDPOINT_MAPPING)
                                .params(paramsTest4))
                        .andReturn()
                        .getResponse()
                        .getContentAsString(), PriceDto.class);

        Assertions.assertEquals(new BigDecimal("30.50"), priceDtoTest.getPrice());

    }

    /**
     * Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     * El precio resultante deberia ser 38.95
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {

        PriceDto priceDtoTest = objectMapper
                .readValue(mockMvc
                        .perform(get(ENDPOINT_MAPPING)
                                .params(paramsTest5))
                        .andReturn()
                        .getResponse()
                        .getContentAsString(), PriceDto.class);

        Assertions.assertEquals(new BigDecimal("38.95"), priceDtoTest.getPrice());

    }

}
