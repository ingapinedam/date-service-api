package com.example.dateservice.model;


import lombok.*;


public class DateResponse {
    private String currentDate;
    private String formattedDate;
    private Long timestamp;
    private String timezone;

    public DateResponse() {
    }

    public DateResponse(String currentDate, String formattedDate, Long timestamp, String timezone) {
        this.currentDate = currentDate;
        this.formattedDate = formattedDate;
        this.timestamp = timestamp;
        this.timezone = timezone;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}