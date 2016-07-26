import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class problem150 {
  public static void main(String[] args){
    String[] array = {"4", "13", "5", "/", "+"};
    System.out.println(new problem150().evalRPN(array));
  }
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < tokens.length; i++) {
      String value = tokens[i];
      if (value.equals("*") || value.equals("/") || value.equals("+") || value.equals("-")) {
        int e1 = stack.pop();
        int e2 = stack.pop();
        if (value.equals("*")) {
          stack.push(e1 * e2);
        } else if (value.equals("/")) {
          stack.push(e2 / e1);
        } else if (value.equals("+")) {
          stack.push(e2 + e1);
        } else if (value.equals("-")) {
          stack.push(e2 - e1);
        }
      } else {
        stack.push(Integer.parseInt(value));
      }
    }
    return stack.pop();
  }
}
