package com.kipaskipas.order.config;

import org.springframework.stereotype.Service;

@Service
public class CustomerMessage {

  public static final String INTERNAL_SERVER = "Try Again Next Time.";
  public static final String NAME_EXISTS = "Customer Name Exists. Please Create with Another Name.";
  public static final String NOT_FOUND = "Customer Not Found. Please Check Again the Customer Data.";

  public static final String GET_SUCCESS = "Successfully Get Customer Data.";
  public static final String GET_FAILED = "Failed To Get Customer Data.";

  public static final String CREATE_SUCCESS = "Successfully Create New Customer.";
  public static final String CREATE_FAILED = "Failed To Create New Customer.";

  public static final String UPDATE_SUCCESS = "Successfully Update Existing Customer.";
  public static final String UPDATE_FAILED = "Failed To Update Existing Customer.";

}