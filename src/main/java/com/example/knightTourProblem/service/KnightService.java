package com.example.knightTourProblem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KnightService {
    private static final Logger logger = LoggerFactory.getLogger(KnightService.class);
    private static final int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public List<int[]> solveKnightTour1(int n, int x, int y) throws Exception {
        int[][] chess = new int[n][n];
        List<int[]> moveList = new ArrayList<>();
        List<int[]> move = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], -1);
        }
        try {
            move.add(new int[]{x, y});
            chess[x][y] = 0;

            if (findKnightPath(chess, x, y, 1, move)) {
                logger.info("Knight's tour path:");
                for (int[] pos : move) {
                    moveList.add(pos);
                }
            } else {
                logger.info("No solution exists.");
            }
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
        }
        return moveList;
    }

    private boolean findKnightPath(int[][] chess, int x, int y, int move, List<int[]> path) {
        logger.debug("move count :" + move);
        if (move == chess.length * chess.length) {
            return true; // All squares visited
        }
        for (int i = 0; i < rowMoves.length; i++) {
            int nextX = x + rowMoves[i];
            int nextY = y + colMoves[i];

            if (isValidMove(chess, nextX, nextY)) {
                chess[nextX][nextY] = move;
                path.add(new int[]{nextX, nextY});
                logger.info("chess: " + chess + ", nextX: " + nextX + " , nextY: " + nextY);
                if (findKnightPath(chess, nextX, nextY, move + 1, path)) {
                    return true; // Solution found
                }
                // Backtracking in case of move not found
                chess[nextX][nextY] = -1;
                path.remove(path.size() - 1);
            }
        }

        return false; // No Move found
    }

    private boolean isValidMove(int[][] chess, int x, int y) {
        int n = chess.length;
        return (x >= 0 && x < n && y >= 0 && y < n && chess[x][y] == -1);
    }
}
