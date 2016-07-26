import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 Given a string, determine if it is a palindrome, considering
 only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class problem125 {
  public static void main(String[] args){
    String s = "0P";
    System.out.println(new problem125().isPalindrome(s));
  }

  public boolean isPalindrome(String s) {
    if(s == null || s.isEmpty()) return true;
    s = s.toLowerCase();
    Stack<Character> stack = new Stack<Character>();
    Queue<Character> queue = new ArrayDeque<Character>();
    for(int i = 0 ; i < s.length();i++){
      char value = s.charAt(i);
      if((value >= 'a' && value <= 'z') || (value >= '0' && value <= '9')){
        stack.push(value);
        queue.add(value);
      }
    }
    while (!stack.isEmpty() && !queue.isEmpty()){
      if(stack.pop() != queue.poll()){
        return false;
      }
    }
    return true;
  }
}
