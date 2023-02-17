package com.senseOn.api.rest;

import com.senseOn.api.helpers.Furniture;
import com.senseOn.api.helpers.Response;
import com.senseOn.api.helpers.ResponseBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    private final ResponseBuilder RESPONSE_BUILDER = new ResponseBuilder();

    @GetMapping("/{data}")
    public Response getResponse(@PathVariable String data) {

        return RESPONSE_BUILDER.buildGetResponse(data);
    }

    @PostMapping
    public Response postResponse(@RequestBody ){
        return RESPONSE_BUILDER.buildPostResponse();
    }



}
