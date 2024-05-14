package com.kipaskipas.order.helpers.exceptions;

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
