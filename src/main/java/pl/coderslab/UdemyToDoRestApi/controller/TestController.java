package pl.coderslab.UdemyToDoRestApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.UdemyToDoRestApi.adapter.SQLTaskGroupsRepository;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroups;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

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

