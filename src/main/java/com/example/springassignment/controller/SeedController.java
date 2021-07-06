package com.example.springassignment.controller;

import com.example.springassignment.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seed")
public class SeedController {
    @Autowired
    private SeedService seedService;

    @RequestMapping(method = RequestMethod.POST, value = "/generate")
    public boolean findAllEmployees() {
        return seedService.seed();
    }
}
