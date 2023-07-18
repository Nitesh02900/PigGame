package com.techlabs.Reflection;


import java.util.Random;
import java.util.Scanner;

public class RefectorPigDice {

    private static final int WINNING_SCORE = 20;
    private static final int DIE_SIDES = 6;

    private int turn;
    private int score;
    private final Scanner scanner;

    public RefectorPigDice() {
        turn = 0;
        score = 0;
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("******************Welcome to Pig Dice Game*****************");

        while (score < WINNING_SCORE) {
            System.out.print("Roll or hold? (r/h): ");
            char decision = scanner.next().charAt(0);

            if (decision == 'h') {
                hold();
            } else {
                int die = rollDie();
                if (die == 1) {
                    endTurnWithNoScore();
                } else {
                    score += die;
                    if (score >= WINNING_SCORE) {
                        endGame();
                    }
                }
            }
        }
    }

    private void hold() {
        turn++;
        System.out.println("Score for turn: " + turn);
        System.out.println("Total score: " + score);
    }

    private int rollDie() {
        Random random = new Random();
        return random.nextInt(DIE_SIDES) + 1;
    }

    private void endTurnWithNoScore() {
        score = 0;
        System.out.println("Your turn is over: no score");
        System.out.println("In total turn: " + turn);
        turn++;
    }

    private void endGame() {
        System.out.println("Total sum is: " + score);
        System.out.println("In total turn: " + turn);
    }

    public static void main(String[] args) {
    	RefectorPigDice pigGame = new RefectorPigDice();
    	pigGame.play();
    }
}
