package com.kipaskipas.order.helpers.exceptions;

import java.lang.String;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalServer extends RuntimeException {

  public InternalServer(final String errorMessage) {

    super(errorMessage);
  }
}
