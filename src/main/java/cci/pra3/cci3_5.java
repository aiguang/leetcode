package cci.pra3;

import java.util.Stack;

/**
 原文：

 Implement a MyQueue class which implements a queue using two stacks.

 译文：

 使用两个栈实现一个队列MyQueue。
 */
public class cci3_5 {
  class MyQueue{
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();
    void add(int num){
      inStack.add(num);
    }
    int poll(){
      if(!popStack.isEmpty()){
        return popStack.pop();
      }
      while (!inStack.isEmpty()){
        popStack.push(inStack.pop());
      }
      return popStack.pop();
    }
  }
}
