/*
 * @author Levi Overcast
 * 
 * Here's a sketch of what I think we need.. 
 * in order of priority
 * TODO: change input/ouput to match what Irene expects,
 * TODO: add hashmap functionality (ie. prepare for input in excess of 10000 words),
 * TODO: expand to cover advanced cases, eg. "guinea pig" = "ageing I up".
 * 
 * Here's where I see this going forward:
 * It probably has to change a lot to adapt to searching a dictionary.
 * The way it works right now:
 *   Loads words from text file into words (ArrayList<String>)
 *   starts at the left end of words
 *   creates an Anagram object for the first word 
 *   removes the original word from the beginning of the list
 *   searches through the list, looking for anagrams
 *   when it finds an anagram, it adds the spelling to the values array in the Anagram object
 *   it also stores the index of the anagram in toDelete (ArrayList<Integer>)
 *   when it can't find any more anagrams, it goes through the list, deleting the words that were anagrams
 *   starts back at the beginning of the list
 *  
 * The way it needs to work:
 *   implement HashMap (key:Anagram)
 *   do a simple for loop through words, 
 *   for each word, check if the key is already in the Hash table
 *   if it is, add word to values[]
 *   if not, add a new key:Anagram pair to the table
 *   
 * 
 * I have included some test statements in comments.
 */
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class AnagramsList {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		ArrayList<String> words = new ArrayList<String>();
		//Read in words from file
		FileInputStream fileIn = new FileInputStream("text");
		Scanner input = new Scanner(fileIn);
		String tmp = "";
		while (input.hasNext()) {
			tmp = input.next();
			//account for duplications
			if (words.indexOf(tmp) == -1) { 
				words.add(tmp);
			}
		}
		fileIn.close();
		input.close();
		//for (int i = 0; i < words.size(); i++) {
			//System.out.print(words.get(i) + " ");
		//}
		//begin searching for anagrams
		ArrayList<Anagram> anagramList = new ArrayList<Anagram>();
		int i;
		ArrayList<Integer> toDelete = new ArrayList<Integer>();
		
		while (words.size() > 0) {
			//System.out.println(strArrToString(words));
			toDelete.clear();
			anagramList.add(new Anagram(words.get(0)));
			words.remove(0);
			for (i = 0; i < words.size(); i++) {
				//System.out.println(Anagram.computeKey(words.get(i)) +" " + anagramList.get(anagramList.size()-1).getKey());
				//if key(words[i]) == key(newest anagram), ie. the word is an anagram
				if (Anagram.computeKey(words.get(i)).equals( anagramList.get(anagramList.size()-1).getKey())) {
					//if (!words.get(i).equals(anagramList.get(anagramList.size()-1).getKey())) {
					anagramList.get(anagramList.size()-1).addAnagram(words.get(i));
						
					//}
					toDelete.add(i);
				}
			}
			//System.out.println(intArrToString(toDelete));
			//Delete (in reverse order so it doesn't screw itself up) the words from
			//   words that were anagrams of words[i]
			//System.out.println("Before: " + strArrToString(words));
			for (i = toDelete.size()-1; i >= 0; i--) {
				words.remove((int)toDelete.get(i));
			}
			//System.out.println("After: "+strArrToString(words));
		}
		
		//Print
		for (i = 0; i < anagramList.size(); i++) {
			System.out.println(anagramList.get(i).toString());
		}
		
		return;
	}
	
	//toString for ArrayList<Integer>
	//public static String intArrToString(ArrayList<Integer> arr) {
		//String retStr = "";
		//if (arr.size() == 0) {return "Empty";}
		//for (int i = 0; i < arr.size(); i ++) {
			//retStr = retStr + arr.get(i) + " ";
		//}
		//return retStr;
	//}
	
	//toString for ArrayList<String>
	//public static String strArrToString(ArrayList<String> arr) {
		//String retStr = "";
		//if (arr.size() == 0) {return "Empty";}
		//for (int i = 0; i < arr.size(); i ++) {
			//retStr = retStr + arr.get(i) + " ";
		//}
		//return retStr;
	//}
	
	//return combines anagram object of two inputs
	//updates anagram A in place
	//public static void merge(Anagram A, Anagram B) { 
		//if (B.getNumAnagrams() > 1) {
			//A.addAnagram(B.getValues()[1]);
		//}
		//return;
	//}

}
