import java.util.*;
 
public class AnagramCheck { 
 
public static boolean isAnagram(String word, String anagram)
{ if(word.length() != anagram.length())
{return false; } 
char[] chars = word.toLowerCase().toCharArray();
 for(char c : chars)
{ int index = anagram.indexOf(c);
if(index != -1)
{anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length()); }
else{ return false; } } 
return anagram.isEmpty(); } 
 
public static boolean iAnagram(String word, String anagram)
{char[] charFromWord = word.toLowerCase().toCharArray(); 
char[] charFromAnagram = anagram.toLowerCase().toCharArray();
 Arrays.sort(charFromWord); 
Arrays.sort(charFromAnagram); 
return Arrays.equals(charFromWord, charFromAnagram); } 
 
 
public static boolean checkAnagram(String first, String second)
{ char[] characters = first.toCharArray(); 
StringBuilder sbSecond = new StringBuilder(second); 
for(char ch : characters)
{ int index = sbSecond.indexOf("" + ch); 
if(index != -1)
{ sbSecond.deleteCharAt(index); }
else
{ return false; } } 
return sbSecond.length()==0 ? true : false; } }



afnwalghjwerjg;weajhy;ehaw
