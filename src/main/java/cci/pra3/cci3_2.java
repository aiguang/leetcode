package cci.pra3;

import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 原文：

 How would you design a stack which, in addition to push and pop,
 also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.

 译文：

 实现一个栈，除了push和pop操作，还要实现min函数以返回栈中的最小值。 push，pop和min函数的时间复杂度都为O(1)。
 */
public class cci3_2 {
  class myStack{
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MIN_VALUE;
    void push(int num){
      stack.push(num);
      Integer count = map.get(num);
      if(count == null) map.put(num, 1);
      else map.put(num, count++);

      min = Math.min(num, min);
    }
    int pop() throws Exception {
      int r = stack.pop();
      Integer count = map.get(r);
      if(count < 1) throw new Exception("no count");
      if(count == 1) {
        map.remove(r);
        if(min == r) min = map.lastEntry().getKey();
      }else{
        map.put(r, count--);
      }
      return r;
    }
    int min(){
      return min;
    }



  }

}
