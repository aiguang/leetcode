import java.util.HashMap;
import java.util.Map;

/**
 This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 word1 and word2 may be the same and they represent two individual words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “makes”, word2 = “coding”, return 1.
 Given word1 = "makes", word2 = "makes", return 3.
 */
public class problem245ShortestWordDistanceIII {
  public static void main(String[] args){
    String[] array = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "makes";
    String word2 = "makes";
    System.out.println(new problem245ShortestWordDistanceIII().shortestWordDistance2(array, word1,
                                                                                     word2));
  }
  public int shortestWordDistance(String[] words, String word1, String word2) {
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

  public int shortestWordDistance2(String[] words, String word1, String word2) {
    int length = Integer.MAX_VALUE;
    int p1 = -1, p2=-1;
    for(int i = 0; i < words.length ;i++){
      String cur = words[i];
      if(word1.equals(word2) && cur.equals(word1)){
        if(p1 != -1){
          length = Math.min(length, i - p1);
        }
        p1 = i;
      }else {
        if(cur.equals(word1)){
          p1 = i;
        }else if(cur.equals(word2)){
          p2 = i;
        }
        if(p1 != -1 && p2 != -1){
          length = Math.min(length, Math.abs(p1 - p2));
        }
      }
    }
    return length;
  }
}
