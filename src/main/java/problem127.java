import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of
 * shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time Each intermediate word must exist in the word list For
 * example,
 *
 * Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log"] As one
 * shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 *
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All
 * words contain only lowercase alphabetic characters.
 */
public class problem127 {
  public static void main(String[] args){
    String begin = "hot";
    String end = "dog";
    Set<String> set = new HashSet<String>();
    set.add("hot");
    set.add("dog");
    set.add("dot");
    System.out.println(new problem127().ladderLength(begin, end, set));
  }

  public int ladderLength(String beginWord, String endWord, Set<String> wordList){
    if(beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0
       || beginWord.length() != endWord.length()){
      return 0;
    }
    LinkedList<String> queue = new LinkedList<String>();
    HashSet<String> visited = new HashSet<String>();
    queue.offer(beginWord);
    visited.add(beginWord);
    int level = 1;
    int lastNum = 1;
    int curNum = 0;
    while (!queue.isEmpty()){
      String curValue = queue.poll();
      lastNum--;
      for(int i = 0; i < curValue.length();i++){
        char[] curChar = curValue.toCharArray();
        for(char c = 'a';c <= 'z'; c++){
          curChar[i] = c;
          String tmp = new String(curChar);
          if(tmp.equals(endWord)){
            return level + 1;
          }
          if(!visited.contains(tmp) && wordList.contains(tmp)){
            curNum++;
            visited.add(tmp);
            queue.offer(tmp);
          }
        }
      }
      if(lastNum == 0){
        lastNum = curNum;
        curNum = 0;
        level++;
      }
    }
    return 0;
  }

}
