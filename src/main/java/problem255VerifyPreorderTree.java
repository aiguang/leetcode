import java.util.Stack;

/**
 Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.
 */
public class problem255VerifyPreorderTree {
  public boolean verifyPreorder(int[] preorder) {
    if(preorder == null || preorder.length == 0) return true;
    int min = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0; i < preorder.length;i++){
      int num = preorder[i];
      if(num < min) return false;
      while (!stack.isEmpty() && stack.peek() < num){
        min = stack.pop();
      }
      stack.add(num);
    }
    return true;
  }
}
