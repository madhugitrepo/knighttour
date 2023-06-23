package com.example.knightTourProblem.service;

import org.apache.tomcat.util.descriptor.web.Injectable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class KnightServiceTest {

    @InjectMocks
    private KnightService knightService;

    @Mock
    private List<int[]> listOfIntegers;


    @Test
    public void testSolveKnightTour1() throws Exception {
        Mockito.when(knightService.solveKnightTour1(8,4,5)).thenReturn(listOfIntegers);
        Assert.assertEquals(listOfIntegers, knightService.solveKnightTour1(8,4,5));
    }

    @Test
    public void solveKnightTour1_PositiveScenario_ReturnsMoveList() throws Exception {
        int n = 8;
        int x = 0;
        int y = 0;

        List<int[]> moveList = knightService.solveKnightTour1(n, x, y);

        Assertions.assertNotNull(moveList);
        Assertions.assertFalse(moveList.isEmpty());
        Assertions.assertEquals(n * n, moveList.size());
    }

    @Test
    public void solveKnightTour1_NegativeScenario_ReturnsEmptyMoveList() throws Exception {
        int n = 5;
        int x = 2;
        int y = 3;


        List<int[]> moveList = knightService.solveKnightTour1(n, x, y);

        Assertions.assertNotNull(moveList);
        Assertions.assertTrue(moveList.isEmpty());
    }
}
