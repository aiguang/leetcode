import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 Given two words (beginWord and endWord), and a dictionary's word list,
 find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class problem126 {
  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    List<List<String>> result = new ArrayList<List<String>>();
    if(beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length()  == 0
        || beginWord.length() != endWord.length()){
      return result;
    }
    return null;
  }
}
