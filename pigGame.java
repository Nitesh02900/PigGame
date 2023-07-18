package com.techlabs.Reflection;

import java.util.Random;
import java.util.Scanner;

public class pigGame {

	public static void main(String[] args) {
		System.out.println("******************Welcome to pig Dice Game:*****************");
		Scanner scanner=new Scanner(System.in);
		int length=6;
		int turn=0;
		int score=0;
		while(true) {
			while(score!=20) {
				System.out.print("Roll or hold?(r/h):");
				char decision=scanner.next().charAt(0);
				if(decision=='h') {
					turn++;
					System.out.println("Score for turn:"+turn);
					System.out.println("Total score:"+score);
				}
				else {
					int Die=generateRandomNumber(length);
					System.out.println("Die:"+Die);
					if(Die==1) {
						score=0;
						System.out.println("Your turn is over :no score");
						System.out.println("in total turn :"+turn);
						turn++;
						break;
					}
					else {
						score+=Die;
						if(score>=20) {
							System.out.println("Total Sum is:"+score);
							System.out.println("in Total Turn:"+turn);
		                    break;
						}
					}
				}
		  }
			if(score>=20) {
			 break;
		  }
		}

	}

	public static int generateRandomNumber(int length) {
		Random random = new Random();
        int digit = random.nextInt(6) + 1; // Generate a random digit between 1 and 6
        return digit;
    }
}
