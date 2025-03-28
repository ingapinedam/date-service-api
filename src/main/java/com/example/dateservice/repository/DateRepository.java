package com.example.dateservice.repository;

import com.example.dateservice.model.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, Long> {

}