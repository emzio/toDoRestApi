package pl.coderslab.UdemyToDoRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    private DataSourceProperties properties;

    @Value("${my.taskAllowMultipleTasksFromTemplate}")
    private String myProp;


    @GetMapping("info/url")
    String url(){
        return properties.getUrl();
    }

    @GetMapping("info/prop")
    String myProp(){
        return myProp;
    }
}
