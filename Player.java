/* Instantiable class to store player information
Author = Karen O' Donoghue x20144148 - NCIRL HDSDEV-SEP TABA - 09.01.2021
*/

public class Player{
	private String name;
	//private int score;
	//private String word;

	public Player(String name){
		this.name = name;

	}

	// -------------------------------------- Name -------------------------------------

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}



	// -------------------------------------- Score -------------------------------------
	/*public void setScore(int score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}



	// -------------------------------------- Word -------------------------------------

	public void setWord(String word){
		this.word = word;
	}
	public String getWord(){
		return word;
	}

	public void displayWord(){
		System.out.println(word);
	}
 */

	// -------------------------------------- METHODS -------------------------------------
	public void welcomeMessage(){
		System.out.println("Hello " + name);
	}

	public void nameDisplay(){
			System.out.print(name + " ");
	}

}
