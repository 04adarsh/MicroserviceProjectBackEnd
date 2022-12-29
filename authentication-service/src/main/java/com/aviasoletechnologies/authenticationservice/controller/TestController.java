package com.aviasoletechnologies.authenticationservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testing")
    public ResponseEntity<TestResponse> check(){
        TestResponse obj=new TestResponse();
        return ResponseEntity.ok(obj);
    }

}

class TestResponse{
     public String response="test successfull...";
}
