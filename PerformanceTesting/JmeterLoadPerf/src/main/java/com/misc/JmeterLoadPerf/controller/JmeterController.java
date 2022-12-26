package com.misc.JmeterLoadPerf.controller;

import com.misc.JmeterLoadPerf.entities.Books;
import com.misc.JmeterLoadPerf.service.JmeterSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jmeterDemo")
public class JmeterController {

    @Autowired
    JmeterSvcImpl jmeterSvcImpl;

    @PostMapping("/saveAllBooks")
    public ResponseEntity saveAllBooks(){
        jmeterSvcImpl.saveAllBooks();
        return ResponseEntity.ok("Saved Successfully!");
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity getAllBooks(){
        List<Books> booksList = jmeterSvcImpl.getBooksList();
        return ResponseEntity.ok(booksList);
    }

}
