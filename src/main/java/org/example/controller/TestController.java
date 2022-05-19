package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getMsg")
    public String getMessaage(){
        return " Docker Test succesfull";
    }
}
