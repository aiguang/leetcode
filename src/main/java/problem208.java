import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 16-1-6.
 */
public class problem208 {
  public static void main(String[] args){
    Trie trie = new Trie();
    trie.insert("ab");
    System.out.println(trie.search("a"));
    System.out.println(trie.startsWith("a"));
  }
}
class TrieNode {
  // Initialize your data structure here.
  boolean hasWord;
  Map<Character, TrieNode> map ;
  char c;
  public TrieNode() {
    hasWord = false;
    map = new HashMap<Character, TrieNode>();
  }
}

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode tmp = root;
    for(int i = 0; i < word.length();i++){
      char c = word.charAt(i);
      if(tmp.map.containsKey(c)){
        tmp = tmp.map.get(c);
      }else{
        TrieNode node = new TrieNode();
        node.c = c;
        tmp.map.put(c, node);
        tmp = node;
      }
    }
    tmp.hasWord = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode tmp = root;
    for(int i = 0; i < word.length() ;i++){
      char c = word.charAt(i);
      if(tmp.map.containsKey(c)){
        tmp = tmp.map.get(c);
      }else{
        return false;
      }
    }
    return tmp.hasWord;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode tmp = root;
    for(int i = 0; i < prefix.length() ;i++){
      char c = prefix.charAt(i);
      if(i == prefix.length() - 1){
        break;
      }
      if(tmp.map.containsKey(c)){
        tmp = tmp.map.get(c);
      }else{
        return false;
      }
    }
    char c = prefix.charAt(prefix.length() - 1);
    TrieNode node = tmp.map.get(c);
    return node != null && (node.hasWord || node.map.size() > 0);
  }
}
