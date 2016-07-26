package cci.pra3;

import java.util.Stack;
import java.util.TreeSet;

/**
 原文：

 Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented.
 The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.

 译文：

 写程序将一个栈按升序排序。对这个栈是如何实现的，你不应该做任何特殊的假设。
 程序中能用到的栈操作有：push | pop | peek | isEmpty。
 */
public class cci3_6 {
  public static void main(String[] args){
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(4);
    stack.push(2);
    stack.push(1);
    stack.push(3);

    new cci3_6().sort(stack);
    while (!stack.isEmpty()){
      System.out.print(stack.pop() + ",");
    }
  }
  public void sort(Stack<Integer> stack){
    TreeSet<Integer> set = new TreeSet<Integer>();
    while(!stack.isEmpty()){
      set.add(stack.pop());
    }
    while (!set.isEmpty()){
      stack.add(set.pollFirst());
    }
  }

}
