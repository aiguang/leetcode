import java.util.HashMap;
import java.util.HashSet;

/**
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class problem138 {
  public static void main(String[] args){
    RandomListNode first = new RandomListNode(-1);
    RandomListNode second = new RandomListNode(-1);
    first.random = second;
    new problem138().copyRandomList(first);
  }
  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) return null;
    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode newRoot = new RandomListNode(head.label);
    RandomListNode tmp = newRoot;
    map.put(head, tmp);
    while (head != null){
      if(head.random != null){
        RandomListNode newRandom = map.get(head.random);
        if(newRandom == null){
          newRandom = new RandomListNode(head.random.label);
          map.put(head.random, newRandom);
        }
        tmp.random = newRandom;
      }
      if(head.next != null){
        RandomListNode newNext = map.get(head.next);
        if(newNext == null){
          newNext = new RandomListNode(head.next.label);
          map.put(head.next, newNext);
        }
        tmp.next = newNext;
      }
      head = head.next;
      tmp = tmp.next;
    }
    return newRoot;
  }
}
