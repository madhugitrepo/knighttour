package com.example.knightTourProblem.controller;

import com.example.knightTourProblem.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KnightController {

    @Autowired
    KnightService knightService;

    @GetMapping("/knight-tour")
    public List<int[]> solveKnightTour(@RequestParam int n, @RequestParam int x, @RequestParam int y) throws Exception {
        return knightService.solveKnightTour1(n,x,y);
    }


}

