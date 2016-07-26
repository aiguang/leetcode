/**
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */
public class problem151 {
  public static void main(String[] args){
    String s = " ";
    System.out.println(new problem151().reverseWords(s));
  }
  public String reverseWords(String s) {
    if(s == null || s.isEmpty()) return s;
    String[] array = s.split(" ");
    if(array.length == 0) return "";
    StringBuilder sb = new StringBuilder();
    for(int i = array.length - 1; i>= 0;i--){
      if(array[i].length() > 0){
        sb.append(array[i]).append(" ");
      }
    }
    return sb.substring(0, sb.length() - 1);
  }
}
