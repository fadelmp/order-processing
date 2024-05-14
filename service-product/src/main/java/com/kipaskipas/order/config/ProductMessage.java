package com.kipaskipas.order.config;

import org.springframework.stereotype.Service;

@Service
public class ProductMessage {

  public static final String INTERNAL_SERVER = "Try Again Next Time.";
  public static final String NAME_EXISTS = "Product Name Exists. Please Create with Another Name.";
  public static final String NOT_FOUND = "Product Not Found. Please Check Again the Product Data.";
  public static final String OUT_STOCK = "Product is Out of Stock.";

  public static final String GET_SUCCESS = "Successfully Get Product Data.";
  public static final String GET_FAILED = "Failed To Get Product Data.";

  public static final String CREATE_SUCCESS = "Successfully Create New Product.";
  public static final String CREATE_FAILED = "Failed To Create New Product.";

  public static final String UPDATE_SUCCESS = "Successfully Update Existing Product.";
  public static final String UPDATE_FAILED = "Failed To Update Existing Product.";

}