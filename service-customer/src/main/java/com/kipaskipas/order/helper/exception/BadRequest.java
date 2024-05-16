package com.kipaskipas.order.helper.exception;

import java.lang.String;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BadRequest extends RuntimeException {

  public BadRequest(final String errorMessage) {

    super(errorMessage);
  }
}
