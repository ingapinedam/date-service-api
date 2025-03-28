package com.example.dateservice.service;

import com.example.dateservice.model.DateEntity;
import com.example.dateservice.model.DateResponse;
import com.example.dateservice.repository.DateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateService {

    private static final Logger log = LoggerFactory.getLogger(DateService.class);

    private DateRepository dateRepository;

    @Autowired
    public DateService(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    public DateResponse getCurrentDateAndSave() {
        ZonedDateTime now = ZonedDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));

        log.info("Date service called - returning: {}", formattedDate);

        DateResponse response = new DateResponse();
        response.setCurrentDate(now.toLocalDate().toString());
        response.setFormattedDate(formattedDate);
        response.setTimestamp(now.toInstant().toEpochMilli());
        response.setTimezone(now.getZone().toString());

        DateEntity dateEntity = new DateEntity();
        dateEntity.setRequestTime(LocalDateTime.now());
        dateEntity.setCurrentDate(response.getCurrentDate());
        dateEntity.setFormattedDate(response.getFormattedDate());
        dateEntity.setTimestamp(response.getTimestamp());
        dateEntity.setTimezone(response.getTimezone());

        dateRepository.save(dateEntity);
        log.debug("Date information saved to database with ID: {}", dateEntity.getId());

        return response;
    }

}