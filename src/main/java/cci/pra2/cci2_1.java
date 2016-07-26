package cci.pra2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 16-1-14.
 */
public class cci2_1 {


  public void removeDuplcateListNode(ListNode root){
    Set<Integer> set = new HashSet<Integer>();
    ListNode numb = new ListNode(0);
    ListNode tmp = root;
    numb.next = tmp;
    while (tmp != null){
      if(set.contains(tmp.val)){
        ListNode t = tmp;
        numb.next = t.next;
        numb = numb.next;
        tmp = numb.next;
      }else
        set.add(tmp.val);
    }
  }
}
