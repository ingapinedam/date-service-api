package com.example.dateservice.controller;

import com.example.dateservice.model.DateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/date")
public class DateController {

    private static final Logger log = LoggerFactory.getLogger(DateController.class);

    @GetMapping
    public DateResponse getCurrentDate() {
        ZonedDateTime now = ZonedDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));

        log.info("Date service called - returning: {}", formattedDate);
        DateResponse response = new DateResponse();
        response.setCurrentDate(now.toLocalDate().toString());
        response.setFormattedDate(formattedDate);
        response.setTimestamp(now.toInstant().toEpochMilli());
        response.setTimezone(now.getZone().toString());
        return response;
    }
}
