import java.util.Stack;

/**
 * Created by Administrator on 15-8-17.
 */
public class problem20 {
  public static void main(String[] args){
    String s = "([{])";
    System.out.println(new problem20().isValid(s));
  }
  public boolean isValid(String s) {
    if(s == null || s.length() == 0) return true;
    Stack<Character> stack = new Stack<Character>();
    char[] array = s.toCharArray();
    stack.push(array[0]);
    for(int i = 1; i < array.length; i++){
      char tmp = array[i];
      if(stack.isEmpty()){
        stack.push(tmp);
      }else{
        char prev = stack.peek();
        if((prev == '{' && tmp == '}') ||
           (prev == '[' && tmp == ']') ||
           (prev == '(' && tmp == ')')){
          stack.pop();
        }else {
          stack.push(tmp);
        }
      }
    }
    return stack.isEmpty();
  }
}
