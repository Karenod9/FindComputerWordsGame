/* Application to play Find Computer Words Game.
Author = Karen O' Donoghue x20144148 - NCIRL HDSDEV-SEP TABA - 09.01.2021
*/

import java.util.Scanner;

public class FindComputerWordsGame{
	public static void main(String []args){
		System.out.println("    |------------------------------------------------------------------------------------------|");
		System.out.println("    |******************************** FIND COMPUTER WORDS GAME ********************************|");
		System.out.println("    |------------------------------------------------------------------------------------------|");
		System.out.println("    12 random letters will appear on your screen. You must take turns to try and make a word using \n       as many of the 12 letters as possible. The scoring system is as follows:");
		System.out.println("");
		System.out.println("                             You will receive 3 points for a word starting with a vowel");
		System.out.println("                          You will receive 1 point for a word starting with a consonant");
		System.out.println("                                       E.G: 'algorithm' = 3 points");
		System.out.println("                                       E.G:  'bit' = 1 point");
		System.out.println("");

//---------------------------------------------------LOCAL VARIABLES---------------------------------------------------------

		//declare & create obj type Scanner & FindComputerWordsLogic

		Scanner input = new Scanner(System.in);
		FindComputerWordsLogic game = new FindComputerWordsLogic();

		String name;
		int p1Score = game.getP1Score();
		int p2Score = game.getP2Score();



//----------------------------------------------------- CREATE NEW PLAYERS ---------------------------------------------------------

		//take input from users & declare & create obj of type Player
		//display welcome message
		//send names to FindComputerWordsLogic class

		System.out.println("Player one" + " Enter your name: ");
		name = input.nextLine();
		Player p1 = new Player(name);
		p1.welcomeMessage();
		game.setP1Name(name);

		System.out.println("Player two" + " Enter your name: ");
		name = input.nextLine();
		Player p2 = new Player(name);
		p2.welcomeMessage();
		game.setP2Name(name);

//--------------------------------------------------------- BEGIN GAME  -------------------------------------------------------------

		int continueGame = 1;

		//While player inputs 1 the game will continue.

		while(continueGame == 1){
			//invoke randomGenerator to create 12 random letters
			//Use getter to display these 12 random letters
			System.out.println(" ");
			game.randomGenerator();
			String newRandomString = game.getRandomWord();
			System.out.println("Make a computer related word from these letters: " + newRandomString);

//-----------------------------------------------PLAYER 1 --------------------------------------------------------------


			//Invoke display name method from Player class
			//Ask user to input word
			//assign word to p1Word variable

			System.out.println(" ");
			Scanner inp = new Scanner(System.in);
			p1.nameDisplay();
			System.out.print("please enter your word: ");
			System.out.println("");
			String p1Word = inp.nextLine();
			game.setWord(p1Word);


			//check if the input letters match random letters & If they do check against dictionary
			//invoke validateInput method & checkWordBank method
			game.validateInput();
			int valid = game.getValid();
			if (valid == 2){
				//check if word is listed in the computer words dictionary
				game.checkWordBank();
				int wordBankValidate = game.getWordBankValidate();
				if(wordBankValidate == 2){
					System.out.println("Well done!! " + p1Word + " is a computer related word!");
					game.scoringP1();
				}else if (wordBankValidate == 1){
					System.out.println(p1Word + " is not a computer related word. You scored 0 points");
					System.out.println("Your total score is: " + p1Score);
				}
			}else if (valid == 1){
				System.out.println("Invalid word: You can only use the letters provided. You scored 0 points");
				System.out.println("Your total score is: " + p1Score);
			}

//-----------------------------------------------PLAYER 2 --------------------------------------------------------------

			//Invoke display name method from Player class
			//Ask user to input word
			//assign word to p1Word variable

			System.out.println(" ");
			p2.nameDisplay();
			System.out.print("please enter your word: ");
			System.out.println("");
			String p2Word = inp.nextLine();
			game.setWord(p2Word);

			//check if player 2 word is the same as player 1 word
			//if they are the same ask player 2 to enter a different word, otherwise continue with programme
			while(p2Word.equalsIgnoreCase(p1Word)){
				System.out.println("INVALID! You cannot have the same word as player one");
				System.out.println("Please enter a different word");
				p2Word = inp.nextLine();
				game.setWord(p2Word);
			}

			//check if the input letters match random letters & If they do check against dictionary
			//invoke validateInput method & checkWordBank method
			game.validateInput();
			valid = game.getValid();
			if (valid == 2){
				//check if word is listed in the computer words dictionary
				game.checkWordBank();
				int wordBankValidate = game.getWordBankValidate();
				if(wordBankValidate == 2){
					System.out.println("Well done!! " + p2Word + " is a computer related word!");
					game.scoringP2();
				}else if (wordBankValidate == 1){
					System.out.println(p2Word + " is not a computer related word. You scored 0 points");
					System.out.println("Your total score is: " + p2Score);
				}
			}else if (valid == 1){
				System.out.println("Invalid word: You can only use the letters provided. You scored 0 points");
				System.out.println("Your total score is: " + p2Score);
			}

			//check if players want to continue with the game
			System.out.println(" ");
			System.out.println("Type 1 to continue or any other number to quit");
			continueGame = input.nextInt();
		}
		//if players do not want to continue with game - display scores and winner by invoking displayScore method from FindComputerWordsLogic class
		game.displayScore();

	}
}
