package com.kipaskipas.order.config;

import org.springframework.stereotype.Service;

@Service
public class OrderMessage {

  public static final String INTERNAL_SERVER = "Try Again Next Time.";

  public static final String CUSTOMER_NOT_FOUND = "Customer Not Found. Please Check Again the Customer.";
  public static final String PRODUCT_NOT_FOUND = "Product Not Found. Please Check Again the Product.";

  public static final String OUT_STOCK = "Product is Out of Stock.";
  public static final String INSUFFICIENT_STOCK = "Product Stock is Insufficient.";
  public static final String AMOUNT_MISMATCH = "Mismatch Amount.";

  public static final String CREATE_SUCCESS = "Successfully Create New Order.";
  public static final String CREATE_FAILED = "Failed To Create New Order.";

}