/**
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class problem171 {
  public static void main(String[] args){
    System.out.println(new problem171().titleToNumber("AB"));
  }
  public int titleToNumber(String s) {
    int result = 0;
    int index = 0;
    for(int i = 0; i < s.length();i++){
      char c = s.charAt(i);
      result += (c - 'A' + 1) * Math.pow(26, s.length() - i - 1);
    }
    return result;
  }
}
