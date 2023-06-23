package com.example.knightTourProblem.controller;

import com.example.knightTourProblem.service.KnightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KnightController {
    private static final Logger logger = LoggerFactory.getLogger(KnightController.class);
    @Autowired
    KnightService knightService;

    @GetMapping("/knight-tour")
    public List<int[]> solveKnightTour(@RequestParam int n, @RequestParam int x, @RequestParam int y) throws Exception {
        logger.info("Received a request to /knight-tour");
        return knightService.solveKnightTour1(n,x,y);
    }


}

