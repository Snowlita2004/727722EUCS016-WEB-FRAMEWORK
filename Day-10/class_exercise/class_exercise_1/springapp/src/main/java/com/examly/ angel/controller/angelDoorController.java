package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.angelDoor;
import com.examly.springapp.service.angelDoorService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class angelDoorController {

    @Autowired
    public angelDoorService doorService;

    @PostMapping("/door")
    public ResponseEntity<angelDoor> postData(@RequestBody angelDoor door) {
        angelDoor doorData = doorService.postData(door);
        if (doorData != null) {
            return new ResponseEntity<>(doorData, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("door/bycolor/{color}")
    public ResponseEntity<List<angelDoor>> getBycolor(@PathVariable String color) {
        List<angelDoor> door = doorService.getBycolor(color);
        if (door != null) {
            return new ResponseEntity<>(door, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("door/{doorid}")
    public ResponseEntity<angelDoor> updateDetailResponseEntity(@PathVariable int doorid, @RequestBody angelDoor door) {
        angelDoor doorData = doorService.updateDetail(doorid, door);
        if (doorData != null) {
            return new ResponseEntity<>(doorData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("door/{doorid}")
    public ResponseEntity<String> deleteDoor(@PathVariable int doorid) {
        if (doorService.deleteDoor(doorid)) {
            return new ResponseEntity<>("Door deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/door/bydoortype/{doortype}")
    public ResponseEntity<List<angelDoor>> getByDoor(@PathVariable String doortype) {
        List<angelDoor> door = doorService.getByDoorType(doortype);
        if (door != null) {
            return new ResponseEntity<>(door, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/door")
    public ResponseEntity<List<angelDoor>> getAllDetails() {
        List<angelDoor> door = doorService.getAllDetails();
        if (door != null) {

            return new ResponseEntity<>(door, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/door/{doorid}")
    public ResponseEntity<angelDoor> getDetailsById(@PathVariable int doorid) {
        angelDoor door = doorService.getDetailsById(doorid);
        if (door != null) {
            return new ResponseEntity<>(door, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}