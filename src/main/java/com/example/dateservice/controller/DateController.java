package com.example.dateservice.controller;

import com.example.dateservice.model.DateEntity;
import com.example.dateservice.model.DateResponse;
import com.example.dateservice.service.DateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/date")
public class DateController {

    private static final Logger log = LoggerFactory.getLogger(DateController.class);

    private DateService dateService;

    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping
    public DateResponse getCurrentDate() {
        log.info("Received request for current date");
        return dateService.getCurrentDateAndSave();
    }

}