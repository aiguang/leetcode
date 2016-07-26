import java.util.HashMap;
import java.util.Map;

/**
 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class problem243ShortestWordDistance {
  public static void main(String[] args){
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "coding";
    String word2 = "makes";
    System.out.println(new problem243ShortestWordDistance().shortestDistance(words, word1, word2));
  }
  public int shortestDistance(String[] words, String word1, String word2) {
    Map<String,Integer> map = new HashMap<String, Integer>();
    int length = Integer.MAX_VALUE;
    for(int i = 0; i < words.length ;i++){
      String cur = words[i];
      if(cur.equals(word1)){
        Integer i2 = map.get(word2);
        if(i2 != null){
          length = Math.min(length, i - i2);
        }
        map.put(cur, i);
      }else if(cur.equals(word2)){
        Integer i1 = map.get(word1);
        if(i1 != null){
          length = Math.min(length, i - i1);
        }
        map.put(cur, i);
      }
    }
    return length;
  }

}
