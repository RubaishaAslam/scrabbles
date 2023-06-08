/**
 * Scrabble class to get 7 random letters, check if it is in the scrabble dictionary, what is the total value and if there are two equal words
 * @Rubaisha - CS1027 Assignment 1 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Scrabble {
	
	// set a private variable tiles and connect it to tile class
	private Tile[] tiles;
	
	
	
	public Scrabble() { 
		// create a new tile object and add it to the array and call pickup method
		tiles = new Tile[7];
		for (int t = 0; t < tiles.length; t++) {
            tiles[t] = new Tile();
            tiles[t].pickup();
        }
	}
	
	
	public Scrabble(Tile[] tilesNew) {
		// set tiles in the class to get random characters
		this.tiles = tilesNew;
		
	}

	
	
	
	public String getLetters() {
		// change the array to string by looping through array and adding it to the empty string
		
		String stringLetters;
		stringLetters = ""; // create empty string
		
		for (int w =0 ; w < 7; w++) { // do a for look to add the tiles character in the string 
			stringLetters = stringLetters + tiles[w].getValue();
		}
		return stringLetters; // @return the strings
	}
	
	
	
	public ArrayList<String> getWords() {
		
		ArrayList<String> wordLists = new ArrayList<String>();  // create a new array 
        String letters = getLetters(); // call getLetters object
        Scanner sannerC;
        char[] chars2 = letters.toCharArray(); // turn the tiles letters in characters and sort the character 
        Arrays.sort(chars2);

        try {
            sannerC = new Scanner(new File("CollinsScrabbleWords2019.txt")); // input file and read file 

            for (String currentFileWord = sannerC.nextLine(); sannerC.hasNextLine(); currentFileWord = sannerC.nextLine()) { // for loop to read all line
                    char[] chars1 = currentFileWord.toCharArray(); // string on each line turn to character 


                    ArrayList<Character> tileCharArr = new ArrayList<Character>(); // create a new Array 
                    for (int x = 0; x < chars2.length; x++) { // with a for loop add tiles to Array list 
                        tileCharArr.add(chars2[x]);
                    }


                    ArrayList<Character> saveWordarr = new ArrayList<Character>();

                    for (int i = 0; i < chars1.length; i++) {

                        for (int j = 0; j < tileCharArr.size(); j++) { // create a nested for loop 
                            if (chars1[i] == tileCharArr.get(j)) { //remove same letter from one array file and add to a new Array list
                                tileCharArr.remove(j);
                                saveWordarr.add(chars1[i]);
                                break;
                            }
                        }
                    }

                    String saveWord = saveWordarr.stream().map(Object::toString).collect(Collectors.joining()); //Convert the array list into a string to compare it with the current word

                    if (currentFileWord.equals(saveWord)) {
                        wordLists.add(currentFileWord); // add to word list the words that are made from the tiles
                    }
                }
        }
        catch (FileNotFoundException e) { // have an exception raised if file does not exist
            e.printStackTrace();
        }
        return wordLists; // return the words list 

	}
	
	
	
	
	public int[] getScores() {
		ArrayList<String> word = getWords(); // call getWords
		int[] scoreSet = new int[word.size()];  //@return the value arrayList
		int counter = 0; //counter
		
		
		HashMap <Character, Integer> value = new HashMap<Character, Integer>(); // create a hashmap to sort character and value
		
		value.put('A',1); //  add characters and its value 
		value.put('I',1);
		value.put('E',1);
		value.put('L',1);
		value.put('T',1);
		value.put('S',1);
		value.put('O',1);
		value.put('U',1);
		value.put('R',1);
		value.put('N',1);
		value.put('D',2);
		value.put('G',2);
		value.put('P',3);
		value.put('M',3);
		value.put('C',3);
		value.put('B',3);
		value.put('Y',4);
		value.put('H',4);
		value.put('W',4);
		value.put('F',4);
		value.put('V',4);
		value.put('K',5);
		value.put('J',8);
		value.put('X',8);
		value.put('Q',10);
		value.put('Z',10);
		
		
		for(String currentWord : word) { // do a for loop to add to counter 
			int addValue = 0;
			for(int j =0; j< currentWord.length(); j++ ) { // start the for loop to get value 
				addValue = addValue + value.get(currentWord.charAt(j));} // Add value is the total of old value and value from the hashmap such as A = 1
				scoreSet[counter] = addValue; //add addValue value to scoreSet
				counter++; // increase the counter	
		}
		Arrays.sort(scoreSet); // sort in ascending order 
	
		return scoreSet; // @return the array of scores
	}
	
	
	
	
	public Boolean equals(Scrabble other) { // boolean to return true or false 
        int[] tileScore = this.getScores(); // call getScore for this and other tile 
		int[] otherScore = other.getScores();
		
		if (Arrays.equals(otherScore, tileScore)) { //checks the score and if same it @return true else return false
			return true;
		} else {
			return false;} 
	}
}
