package com.wdn.wtrack.gatewayserver.helpers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResponseJson<T extends Object> {

    private Number statusCode = 200;
    private String message = null;

}
