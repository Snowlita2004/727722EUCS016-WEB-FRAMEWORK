package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.angelPerson;
import com.example.springapp.service.angelPersonService;

@RestController
public class angelPersonController {
    @Autowired
    private angelPersonService ser;

    @PostMapping("/person")
    public ResponseEntity<angelPerson> post(@RequestBody angelPerson person) {
        if (ser.post(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/startsWithName/{value}")
    public ResponseEntity<List<angelPerson>> getAll(@PathVariable String value) {
        List<angelPerson> li = ser.start(value);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/endsWithName/{value}")
    public ResponseEntity<List<angelPerson>> getbyAge(@PathVariable String value) {
        List<angelPerson> li = ser.end(value);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
