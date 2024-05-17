package com.kipaskipas.order.gatewayserver.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

@EnableWebFluxSecurity
public class GatewayConfig {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

    http.cors().and().csrf().disable();

    return http.build();
  }

  @Component
  public class GatewayErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {

      Throwable error = super.getError(request);
      Map<String, Object> errorAttributes = new HashMap<>(8);
      errorAttributes.put("message", error.getMessage());
      errorAttributes.put("method", request.methodName());
      errorAttributes.put("path", request.path());
      MergedAnnotation<ResponseStatus> responseStatusAnnotation = MergedAnnotations
          .from(error.getClass(), MergedAnnotations.SearchStrategy.TYPE_HIERARCHY).get(ResponseStatus.class);
      HttpStatus errorStatus = determineHttpStatus(error, responseStatusAnnotation);
      errorAttributes.put("status", errorStatus.value());
      errorAttributes.put("statusCode", errorStatus.value());
      errorAttributes.put("timestamp", new Date());
      errorAttributes.put("error", errorStatus.getReasonPhrase());
      return errorAttributes;
    }

    // Copy from DefaultErrorWebexceptionHandler
    private HttpStatus determineHttpStatus(Throwable error, MergedAnnotation<ResponseStatus> responseStatusAnnotation) {
      if (error instanceof ResponseStatusException) {
        return ((ResponseStatusException) error).getStatus();
      }
      return responseStatusAnnotation.getValue("code", HttpStatus.class).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}
