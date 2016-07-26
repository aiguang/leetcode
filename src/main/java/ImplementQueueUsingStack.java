import java.util.Stack;

/**
 * Created by Administrator on 15-7-15.
 *
 *
 * Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStack {
    private Stack<Integer> inputStack = new Stack<Integer>();
    private Stack<Integer> outputStack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        inputStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!outputStack.isEmpty()) {
            outputStack.pop();
            return;
        }
        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }
        outputStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(!outputStack.isEmpty()){
            return outputStack.peek();
        }

        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }
        return outputStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }
}
