package com.senseOn.api.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Response {

    private int responseCode;
    private String message;
    private Furniture furniture;
}
