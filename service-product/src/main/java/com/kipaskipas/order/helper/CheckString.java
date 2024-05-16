package com.kipaskipas.order.helper;

import org.springframework.stereotype.Service;

@Service
public class CheckString {

  public static final Boolean Check(String str1, String str2) {

    return (str1.toLowerCase().replaceAll("\\s", "")
        .replaceAll(".", "")
        .replaceAll(",", "")
        .replaceAll("-", "")
        .replaceAll("_", "")
        .equals(str2.toLowerCase().replaceAll("\\s", "")
            .replaceAll(".", "")
            .replaceAll(",", "")
            .replaceAll("-", "")
            .replaceAll("_", "")));
  }

}
