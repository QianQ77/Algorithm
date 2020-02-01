package main.java.leetCode;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by qiuqian on 1/13/19.
 */
public class SnakeGame {
    char[][] board;
    int[][] food;
    Deque<int[]> snake;
    int foodId;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        board = new char[height][width];
        this.food = food;
        foodId = 0;
        markFood(foodId);
        snake = new LinkedList<>();
        markSnake(0, 0);
    }

    private void markFood(int i) {
        //error point: should check if foodId < food.length
        if (i < food.length && posValid(food[i][0], food[i][1])) {
            board[food[i][0]][food[i][1]] = 'F';
        }
    }

    private boolean posValid(int r, int c) {
        return r >= 0 && c >= 0 && r < board.length
                && c < board[0].length;
    }

    private void markSnake(int r, int c) {
        board[r][c] = 'S';
        snake.addFirst(new int[]{r, c});
    }

    private void unMark(int r, int c) {
        board[r][c] = (char)0;
    }

    private void eatFood() {
        markSnake(food[foodId][0], food[foodId][1]);
        foodId += 1;
        if (foodId < food.length) markFood(foodId);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.getFirst();
        int[] newPos = new int[2];
        int[] move = null;
        //"U", "L", "R", "D";
        int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        if (direction.equals("U")) {
            move = moves[0];
        } else if (direction.equals("L")) {
            move = moves[1];
        } else if (direction.equals("R")) {
            move = moves[2];
        } else if (direction.equals("D")) {
            move = moves[3];
        }
        newPos[0] = head[0] + move[0];
        newPos[1] = head[1] + move[1];
        if (newPos[0] < 0 || newPos[1] < 0 || newPos[0] >= board.length || newPos[1] >= board[0].length) {
            return -1;
        }
        if (board[newPos[0]][ newPos[1]] == 'F') {
            eatFood();
        } else {
            int[] tail = snake.removeLast();
            unMark(tail[0], tail[1]);
            if (board[newPos[0]][newPos[1]] == 'S') {
                return -1;
            }
            markSnake(newPos[0], newPos[1]);
        }
        return foodId;
    }

    private void print() {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};
        SnakeGame game = new SnakeGame(3, 3, food);
        String[] moves = {"D", "D", "R", "U", "U", "L", "D", "R", "R", "U", "L", "D"};
        for (String move : moves) {
            System.out.println(game.move(move));
            game.print();
        }
    }
}
