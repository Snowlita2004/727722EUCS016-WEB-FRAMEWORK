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
import com.example.springapp.model.angelProduct;
import com.example.springapp.service.angelProductService;

@RestController
public class angelProductController {
    @Autowired
    private angelProductService ser;

    @PostMapping("/product")
    public ResponseEntity<angelProduct> post(@RequestBody angelProduct person) {
        if (ser.post(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/distinct/startwith/{name}")
    public ResponseEntity<List<angelProduct>> getAll(@PathVariable("name") String name) {
        List<angelProduct> li = ser.start(name);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/distict/endswith/{name}")
    public ResponseEntity<List<angelProduct>> getbyAge(@PathVariable("name") String name) {
        List<angelProduct> li = ser.end(name);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/sortBy/price")
    public ResponseEntity<List<angelProduct>> getbyge() {
        List<angelProduct> li = ser.sort();
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
