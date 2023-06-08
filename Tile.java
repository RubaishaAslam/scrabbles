/**
 * Class tile to add get random letter to play the scrabble game
 * @Rubaisha  CS1027 Assignment 1 
 */

import java.util.Random;
public class Tile{
	// set value as a variable- private to not allow to change it later 
	private char value;
	
	
	public Tile() {
		// create an empty character value  
		this.value = '\u0000';;
	}
	
	
	public Tile(char value) {
		// set the character as this value (this.value vs other.value)
		this.value =  value ;
	}
	
	
	public void pickup() {
		// pickup random capital alphabet 
		Random random = new Random();
        char letter = (char) (random.nextInt(26) + 'A');
		this.value = letter;
	}
	
	
	
	public char getValue() {
		// return the value selected 
		return value;
	}

}

