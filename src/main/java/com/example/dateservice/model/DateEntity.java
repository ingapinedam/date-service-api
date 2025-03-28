package com.example.dateservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name = "date_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime requestTime;
    private String formattedDate;

    // Evitamos el uso de palabras reservadas SQL
    @Column(name = "date_timestamp")
    private Long timestamp;

    private String timezone;

    // Renombramos current_date (palabra reservada) a stored_date
    @Column(name = "stored_date")
    private String currentDate;
}