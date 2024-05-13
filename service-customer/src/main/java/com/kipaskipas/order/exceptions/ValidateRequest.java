package com.kipaskipas.order.exceptions;

import java.lang.String;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ValidateRequest extends RuntimeException {

  public ValidateRequest(final String message) {

    super(message);
  }
}
