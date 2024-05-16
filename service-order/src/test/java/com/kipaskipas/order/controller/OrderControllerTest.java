package com.kipaskipas.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {

  private String dir = "src/test/resources/";

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  public String GetPayload(String filename) throws Exception {

    String path = dir + filename;
    Object json = objectMapper.readValue(Paths.get(path).toFile(), Object.class);
    String payload = objectMapper.writeValueAsString(json);
    return payload;
  }

  @Test
  @Order(1)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void CustomerNotFound() throws Exception {

    Mock(
        "customer_not_found.json",
        500,
        "Customer Not Found. Please Check Again the Customer.");
  }

  @Test
  @Order(2)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void ProductNotFound() throws Exception {

    Mock(
        "product_not_found.json",
        500,
        "Product Not Found. Please Check Again the Product.");
  }

  @Test
  @Order(3)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void QuantityNotEnough() throws Exception {

    Mock(
        "quantity_not_enough.json",
        500,
        "Product Stock is Insufficient.");
  }

  @Test
  @Order(4)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void QuantityOutStock() throws Exception {

    Mock(
        "quantity_out_stock.json",
        500,
        "Product is Out of Stock.");
  }

  @Test
  @Order(5)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void AmountMismatch() throws Exception {

    Mock(
        "amount_mismatch.json",
        500,
        "Mismatch Amount.");
  }

  @Test
  @Order(6)
  @Timeout(value = 3, unit = TimeUnit.SECONDS)
  void Success() throws Exception {

    Mock(
        "success.json",
        200,
        "Successfully Create New Order.");
  }

  private void Mock(String filename, Integer statusCode, String message) throws Exception {

    mockMvc.perform(post("/orders")
        .content(GetPayload(filename))
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.statusCode", is(statusCode)))
        .andExpect(jsonPath("$.message", is(message)))
        .andReturn();
  }

}
