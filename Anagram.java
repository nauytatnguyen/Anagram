/*
 * @author
 */
import java.util.Arrays;
public class Anagram {
	
	private final int MAX_SIZE = 12; //the record number of anagrams for an English word
	private String key = null;
	private String [] values = null;
	private int num_anagrams = 0;
	
	public Anagram(String word) {
		values = new String[12];
		key = computeKey(word);
		values[0] = word;
		//if (!word.equals(key)) {
			//values[1] = word;
			//num_anagrams++;
		//}
		num_anagrams++;
		return;
	}
	public static String computeKey(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	public void addAnagram(String new_anagram) {
		values[num_anagrams] = new_anagram;
		num_anagrams++;
		return;
	}
	
	public String getKey() {
		return key;
	}
	
	public String[] getValues() {
		return values;
	}
	
	public int getNumAnagrams() {
		return num_anagrams;
	}
	
	public String toString() {
		String retStr = key + ": [";
		for (int i = 0; i < num_anagrams; i++) {
			retStr = retStr + " " + values[i];
		}
		retStr = retStr + " ]";
		return retStr;
	}
	

}
