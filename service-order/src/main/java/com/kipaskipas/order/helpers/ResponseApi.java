package com.kipaskipas.order.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@RestController
public class ResponseApi {

  private Number statusCode;
  private String message;
  private Object data;

  public ResponseApi(Number statusCode, String message, Object data) {

    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }

  public static final ResponseApi SetResponse(HttpStatus httpStatus, String message, Object data) {

    return new ResponseApi()
        .setStatusCode(httpStatus.value())
        .setMessage(message)
        .setData(data);
  }

  public static final ResponseEntity<Object> Empty(String message) {

    HttpStatus httpStatus = HttpStatus.OK;

    return ResponseEntity.status(httpStatus).body(SetResponse(httpStatus, message, null));
  }

  public static final ResponseEntity<Object> Success(String message, Object data) {

    HttpStatus httpStatus = HttpStatus.OK;

    return ResponseEntity.status(httpStatus).body(SetResponse(httpStatus, message, data));
  }

  public static final ResponseEntity<Object> Failed(HttpStatus httpStatus, String message) {

    return ResponseEntity.status(httpStatus).body(SetResponse(httpStatus, message, null));
  }
}
