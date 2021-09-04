package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RequestCountStatsService {

    public static String GET = "GET";
    public static String POST = "POST";
    public static String PUT = "PUT";
    public static String DELETE = "DELETE";
    public static String PATCH = "PATCH";
    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private final Map<String, Integer> stats = new HashMap<>();

    public void increaseCounter(String method) {
//        if (!stats.containsKey(method)) {
//            stats.put(method, 1);
//        } else {
//            stats.put(method, stats.get(method)+1);
//        }

        stats.merge(method, 1, (existingValue, valueToAdd) -> Integer.sum(existingValue, valueToAdd));
    }

    public List<Statistics> getStatistics() {
        return stats.entrySet()
                .stream()
                .map((entry) -> new Statistics(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());



        // 1st version - to remove in production

//        List<Statistics> statisticsList = new ArrayList<>();
//        for (String method : stats.keySet()) {
//            Statistics statistics = new Statistics();
//            statistics.setMethodName(method);
//            statistics.setUsage(stats.get(method));
//            statisticsList.add(statistics);
//        }
//
//        return statisticsList;
    }
}