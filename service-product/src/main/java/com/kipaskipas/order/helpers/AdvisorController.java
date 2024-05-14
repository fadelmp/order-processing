package com.kipaskipas.order.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kipaskipas.order.helpers.exceptions.BadRequest;
import com.kipaskipas.order.helpers.exceptions.InternalServer;
import com.kipaskipas.order.helpers.exceptions.NotFound;

@ControllerAdvice
public class AdvisorController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<Object> handleValidateRequestException(
      BadRequest ex, WebRequest request) {

    return ResponseApi.Failed(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(NotFound.class)
  public ResponseEntity<Object> handleNotFoundException(
      NotFound ex, WebRequest request) {

    return ResponseApi.Failed(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(InternalServer.class)
  public ResponseEntity<Object> handleQueryException(
      InternalServer ex, WebRequest request) {

    return ResponseApi.Failed(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
  }

}