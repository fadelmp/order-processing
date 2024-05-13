package com.kipaskipas.order.exceptions;

import java.lang.String;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotFound extends RuntimeException {

  public NotFound(final String errorMessage) {

    super(errorMessage);

  }
}
