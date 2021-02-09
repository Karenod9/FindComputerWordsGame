/* Instantiable class to compute FindComputerWordsGame rules and scores
Author = Karen O' Donoghue x20144148 - NCIRL HDSDEV-SEP TABA - 09.01.2021
*/

//IMPORT JAVA LIBRARIES
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FindComputerWordsLogic{

	//DECLARE DATA MEMBERS
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String randomWord;
	private String word;
	private int valid;
	private int p1Score;
	private int p2Score;
	private String randomToEdit;
	private String p1Name;
	private String p2Name;
	private String dictionary[] = {"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus",
								"cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database",
								"digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development", "download", "dynamic",
								"email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon",
								"inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse",
								"mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online", "path", "process",
								"protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue",
								"resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam",
								"screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread",
							    "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"};


//----------------------------------------------------- SETTERS/GETTERS ---------------------------------------------------------

	//send random string to game class
	public String getRandomWord(){
		return randomWord;
	}

	//make player input work available for use in this class
	public void setWord(String word){
		this.word = word;
	}
	//make player input name available for use in this class
	public void setP1Name(String p1Name){
		this.p1Name = p1Name;
	}

	public void setP2Name(String p2Name){
		this.p2Name = p2Name;
	}

	public int getP1Score(){
		return p1Score;
	}
	public int getP2Score(){
		return p2Score;
	}

//----------------------------------------------------- RANDOM LETTER GENERATOR ---------------------------------------------------------
	// Generate 12 random letters from the English alphabet
	public void randomGenerator(){
		Random r = new Random();
		StringBuilder sb = new StringBuilder(11);
		for (int i = 0; i < 12; i++){
			sb.append(alphabet.charAt(r.nextInt(alphabet.length()))+" "); //add a random char to string buffer
		}
		randomWord =  sb.toString(); //turn into a string
		randomToEdit = randomWord; //duplicate so same string can be validated multiple times
	}
//----------------------------------------------------- VALIDATION - INPUT Vs RANDOM LETTERS ---------------------------------------------------------
	// validate user input against random letters
	public void validateInput(){
		char k = '\u0000';
		String captialWord = word.toUpperCase(); //convert input word to upper case
		StringBuilder sb2 = new StringBuilder(randomWord); //random letters into string buffer

		for(int i = 0; i<captialWord.length(); i++){ //traverse the input word and store each letter in c
			char c = captialWord.charAt(i);
			for(int j = 0; j<randomWord.length(); j++){ //traverse the random letters string
				k = randomWord.charAt(j); //store each letter in k
				if (c != k){ //check to see if letter stored in c is equal to letter stored in k -- if not keep traversing the random word (letters) string to see if we can find that letter
				} else if (c == k){ // if letter is found - delete from string - end loop and move on to the next letter to be checked
					sb2.deleteCharAt(j);
					break;
				}
			}
				if (c != k){ //if the letter is not found break from loop and update validation variable
					valid = 1;
					break;
				}
			randomWord = sb2.toString(); //create new string with deleted char to ensure that letters can only be used once
			valid = 2;
		}
		randomWord = randomToEdit; //reset string of random letters so we can reuse this to validate player 2 input
	}
	public int getValid(){
		return valid;
	}
//----------------------------------------------------- VALIDATION - INPUT WORD Vs ARRAY OF COMPUTER RELATED WORDS---------------------------------------------------------
	// validate input word against dictionary
	private int wordBankValidate;

	public void checkWordBank(){
		List wordBank = Arrays.asList(dictionary); //convert array into list - more concise code than traversing array
		if (wordBank.contains(word.toLowerCase())){ //check to see if input word is in list array
			wordBankValidate = 2;
		}else
			wordBankValidate = 1;
	}

	public int getWordBankValidate(){
		return wordBankValidate;
	}
//----------------------------------------------------- SCORING ---------------------------------------------------------
	// scoring for Player 1
	public void scoringP1(){
		boolean isVowel = false;
		char c = word.charAt(0); //check first letter of input word

		switch (c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
		isVowel = true;
		}
		if(isVowel == true){ //is it a vowel?
			p1Score = p1Score + 3;
			System.out.println("You played " + word + ". You scored 3 points");
		}else{
			if (isVowel ==false){ //is it a consonant?
				p1Score = p1Score + 1;
				System.out.println("You played " + word + ". You scored 1 point");
			}
		}
		System.out.println("Total points : " + p1Score);
	}

	// scoring for Player 2
	public void scoringP2(){
		boolean isVowel = false;
		char c = word.charAt(0);

		switch (c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
		isVowel = true;
		}
		if(isVowel == true){
			p2Score = p2Score + 3;
			System.out.println("You played " + word + ". You scored 3 points");
		}else{
			if (isVowel == false){
				p2Score = p2Score + 1;
				System.out.println("You played " + word + ". You scored 1 point");
			}
		}
	System.out.println("Total points : " + p2Score);
	}
//----------------------------------------------------- SCORING AND WINNER ---------------------------------------------------------
// Display scores and calculate who winner is
	public void displayScore(){
		System.out.println(p1Name + " Your total score is: " + p1Score);
		System.out.println(p2Name + " Your total score is: " + p2Score);
		if (p1Score > p2Score){
			System.out.println("CONGRATULATIONS " + p1Name + " you are the winner!!");
			System.out.println("Better luck next time " + p2Name);
		}if (p1Score < p2Score){
			System.out.println("CONGRATULATIONS " + p2Name + " You are the winner!!");
			System.out.println("Better luck next time " + p1Name);
		}if (p1Score == p2Score){
			System.out.println("It's a DRAW!");
		}
	}

}
