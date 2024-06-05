package com.dalmofelipe.StockMicroSrvc.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void mustList3ProductsSuccessfully()
            throws JsonMappingException, JsonProcessingException {

        ResponseEntity<String> response = restTemplate
            .getForEntity("/api/products", String.class);

        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonObj = objMapper.readTree(response.getBody());
        ArrayNode productsListNode = (ArrayNode) jsonObj;

        assertThat(productsListNode.size()).isEqualTo(3);
    }

    @Test
    void mustReturnOneProductSuccessfully() {
        ResponseEntity<String> response = restTemplate
            .getForEntity("/api/products/1", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String details = documentContext.read("$.details");
        String categoryName = documentContext.read("$['category']['name']");

        assertThat(details).isEqualTo("500GB 8GB RAM 4GHz 4CORE");
        assertThat(categoryName).isEqualTo("COMPUTADORES");
    }

}
