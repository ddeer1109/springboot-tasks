package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    private final RequestCountStatsService service;

    @Autowired
    public StatisticsController(RequestCountStatsService service) throws InterruptedException {
        this.service = service;
    }

    @GetMapping("/api/statistics")
    public List<Statistics> get() throws InterruptedException {
        return service.getStatistics();
    }

}
