
package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class StudentController {
    @GetMapping("/start")
    public String welcome(){
        return "Welcome to ALl";
    }

}
