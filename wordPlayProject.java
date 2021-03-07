/*
 * CSE 389 HW2

 * @author: Jiaqi Li
 */
package CSE389;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
class playGame{
	//method for commonWord practice
	
		String welcomeMessage = "Welcome to the GRE vocabulary matching game!" + "\n"
		+ "Instruction: A definition will be displayed on the "
				+ "screen one at a time, enter the correct vocabulary or its corresponding number to get credit." + "\n"
		+"+1 point for correct answer, -1 point otherwise";
		public String getString() {
			return this.welcomeMessage;
			
		}
		static void commonWord() throws Exception {
			ArrayList<String> common = new ArrayList<String>(); //array list for common words
			common.add("1.ambiguous");
			common.add("2.extant");
			common.add("3.calumny");
			common.add("4.parsimonious");
			common.add("5.prevaricate");
			//print out all the words for player to see
			for (String w : common) {
				System.out.println(w);
		}
			int total_score = 0;
			//beginning of the game
			System.out.println("Common word practice begins!");
			System.out.println("1. to speak in an evasive way");
			Scanner answer = new Scanner (System.in);//ask user to input a word
			String word1 = answer.nextLine().toLowerCase();//convert the answer to lower case letter.
			if (word1.equals("prevaricate") || word1.equals("5")) {
				total_score += 1;//if answer correctly, add 1 point
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("2. making of a false statement to injure a person's reputation");
			String word2 = answer.nextLine().toLowerCase();
			if (word2.equals("calumny") || word2.equals("3")) {
				
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {//to avoid negative point, only deduct point when total_score != 0
				total_score -= 1;//deduct point for incorrect answer
				}
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("3.still in existence, usually referred to documents.");
			String word3 = answer.nextLine().toLowerCase();
			//user can either enter the word or the corresponding number in front 
			if (word3.equals("extant") || word3.equals("2")) {	
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
				total_score -=1;
				}
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("4. open to more than one interpretation");
			String word4 = answer.nextLine().toLowerCase();
			if (word4.equals("ambiguous") || word4.equals("1")) {	
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -=1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
			}	
			System.out.println("5. unwilling to spend money or use resources");
			String word5 = answer.nextLine().toLowerCase();
			if (word5.equals("parsimonious") || word5.equals("4")) {
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -=1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
				
			}//end of common word practice
			System.out.println("This is the end of common word, press 2 if you like to practice advanced words, otherwise, press"
					+ " any other number to exit the practice");
			//handles the exception if user enters a non-numeric value
		try {
				Scanner wordSelection = new Scanner (System.in);
				int selection1 = wordSelection.nextInt();
				if (selection1 == 2) {
					advancedWord();//call advancedWord() to allow user to practice for advanced word
				}
			}catch(InputMismatchException e) {
				throw new InputMismatchException("values must be numbers");//if non-numeric value is entered, throw an exception
			}
			System.out.println("You just exited the game");
			System.exit(0);//exit the game if user enters a number other than 1 and 2
		}//end of commonWord()
		//method for advancedWord practice
		static void advancedWord() throws Exception {
			ArrayList<String> advanced = new ArrayList<String>();
			advanced.add("1.jingoist");
			advanced.add("2.ponderous");
			advanced.add("3.conciliate");
			advanced.add("4.imbibe");
			advanced.add("5.malfeasance");
			//print out all the words
			for (String s : advanced) {
				System.out.println(s);
			}
			int total_score = 0;
			System.out.println("Advanced word practice begins!");
			Scanner answer = new Scanner (System.in);
			System.out.println("1. stop (someone) from being angry or discontented");
			String word1 = answer.nextLine().toLowerCase();	
			if (word1.equals("conciliate") || word1.equals("3")) {
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("2. an extreme bellicose nationalist");
			String word2 = answer.nextLine().toLowerCase();
			if (word2.equals("jingoist") || word2.equals("1")) {
				
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -= 1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("3.wrongdoing, especially by a public official.");
			String word3 = answer.nextLine().toLowerCase();
			if (word3.equals("malfeasance") || word3.equals("5")) {
				
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -= 1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
			}
			System.out.println("4. drink (alcohol)");
			String word4 = answer.nextLine().toLowerCase();
			if (word4.equals("imbibe") || word4.equals("4")) {
				
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -= 1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
			}	
			System.out.println("5. weighed-down;moving slowly");
			String word5 = answer.nextLine().toLowerCase();
			if (word5.equals("ponderous") || word5.equals("2")) {
				
				total_score += 1;
				System.out.println("correct! You have " + total_score + " point");
			}
			else {
				if(total_score != 0) {
					total_score -= 1;
					}
				System.out.println("incorrect, You have " + total_score + " point");
				
			}
			System.out.println("This is the end of advanced word, press 1 if you like to practice common words, otherwise, press any"
					+ " other number to exit the practice. ");
			//handles exceptions if the user enters a non-numeric value
			try {
				
				Scanner wordSelection = new Scanner (System.in);
				int selection2 = wordSelection.nextInt();
				if (selection2 == 1) {//if 1 is pressed, call the commonWorld() method
					commonWord();
				}
			}catch(InputMismatchException e) {
				throw new InputMismatchException("values must be numbers");
			}
			System.out.println("You just exited the game");
			System.exit(0);//if enter a number other than 1 or 2, quit the game, program terminated
			
		}//end of advancedWord
}//end of playGame class
public class CSE389hw2 {
	public static void main (String[] args) throws Exception {
		playGame myGame = new playGame();
		System.out.println(myGame.getString());	
		boolean done = false;
		do {
		System.out.println("Press 1 for common words");
	    System.out.println("Press 2 for advanced words");
		Scanner wordSelection = new Scanner (System.in);
		int selection = wordSelection.nextInt();
		if (selection == 1) {//if user chooses 1, call commonWord()	
			playGame.commonWord();
		}
		else if (selection == 2){//if user chooses 2, call advancedWord()
			playGame.advancedWord();
		}
		else {
			System.out.println("Invalid entry. Please enter either 1 or 2");
		}
	}while(!done);//in case user enters a number other than 1 and 2, ask them to enter again to get them a chance to play.
	}//end of main
}
