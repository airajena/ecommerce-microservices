package com.microservices.product_service;

import com.microservices.product_service.dto.ProductRequest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceApplicationTests {

	@BeforeEach
	public void setup() {
		RestAssured.defaultParser = Parser.JSON;
	}

	@Test
	public void shouldCreateProduct() {
		String productRequest = """
            {
                "name": "Wireless Keyboard",
                "description": "Ergonomic wireless keyboard",
                "price": 49.99
            }
        """;

		given()
				.contentType("application/json")
				.body(productRequest)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201);
	}
}