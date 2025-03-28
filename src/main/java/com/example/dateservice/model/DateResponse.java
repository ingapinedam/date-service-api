package com.example.dateservice.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateResponse {
    private String currentDate;
    private String formattedDate;
    private Long timestamp;
    private String timezone;
}