package com.kipaskipas.order.gatewayserver.helper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseJson<T extends Object> {

    private Number statusCode = 200;
    private String message = null;

}
