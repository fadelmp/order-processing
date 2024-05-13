package com.kipaskipas.order.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.exceptions.ValidateRequest;

@Service
@RestController
public class Validate {

  public static final void Request(Errors errors) {

    if (!errors.hasErrors())
      return;

    List<String> listMessages = new ArrayList<String>();
    for (ObjectError error : errors.getAllErrors())
      listMessages.add(error.getDefaultMessage());

    String messages = String.join(", ", listMessages);

    throw new ValidateRequest(messages);
  }

}
