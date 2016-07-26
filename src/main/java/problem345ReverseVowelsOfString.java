import java.util.ArrayList;
import java.util.List;

/**
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".
 */
public class problem345ReverseVowelsOfString {
  public static void main(String[] args){
    String s = "hello";
    System.out.println(new problem345ReverseVowelsOfString().reverseVowels(s));
  }
  public String reverseVowels(String s) {
    if(s == null || s.length() == 0) return s;
    List<Character> list = new ArrayList<Character>();
    list.add('a');
    list.add('e');
    list.add('i');
    list.add('o');
    list.add('u');
    list.add('A');
    list.add('E');
    list.add('I');
    list.add('O');
    list.add('U');
    int i = 0, j = s.length() - 1;
    char[] array = s.toCharArray();

    while (i < j){
      while (i < s.length() - 1 && !list.contains( s.charAt(i))) i++;
      while (j > 0 && !list.contains(s.charAt(j))) j--;
      if(i < j){
        swap(array, i, j);
        i++;
        j--;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(char c : array){
      sb.append(c);
    }
    return sb.toString();
  }
  public void swap(char[] array, int i, int j){
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
