import java.util.Random;
import java.util.*;
public class guessingnumber 
{
    public static void main(String[] args)
 {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int numbergen = 5;
        int guess;
        int attempts = -1;
	System.out.println("Welcome to Guessing a NUmber Game");
	System.out.println("I Guess a number between 1 to 100");
	System.out.println("Can you Guess the number !");
        while (true) 
	{
	  System.out.print("Enter your guess: ");
          guess = sc.nextInt();
          attempts++;
	 if (guess < numbergen) 
	 {
	  System.out.println("Too low! Try again.");
	 } 
	 else if (guess > numbergen) 
	 {
          System.out.println("Too high! Try again.");
	 } 
	 else 
	 {
          System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
 	  System.out.println("you have score :" +(100-2*attempts));
          break;
	 }
        }
    }
}

