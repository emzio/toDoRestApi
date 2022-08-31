package pl.coderslab.UdemyToDoRestApi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    ResponseEntity<String> test(){
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @GetMapping("/headertest")
    ResponseEntity<String> headerTest(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test1", "another header");
        return new ResponseEntity<>("header test", httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/bodytest")
    ResponseEntity<String[]> bodyTest(){
        String[] body = {"body test", "body2"};
        return ResponseEntity.ok().body(body);
    }

}
