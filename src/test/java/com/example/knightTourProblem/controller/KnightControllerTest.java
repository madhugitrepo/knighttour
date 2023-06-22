package com.example.knightTourProblem.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class KnightControllerTest {

    @InjectMocks
    private KnightController knightController;

    @Mock
    private final List<int[]> listOfIntegers = new ArrayList<>();

    @Test
    public void testSolveKnightTour() throws Exception {
        Mockito.when(knightController.solveKnightTour(3,1,2)).thenReturn(listOfIntegers);
        Assert.assertEquals(listOfIntegers, knightController.solveKnightTour(3,1,2));
    }
}
