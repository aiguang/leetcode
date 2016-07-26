import java.util.HashMap;
import java.util.Map;

/**
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 click to show hint.

 You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class problem211 {

}
class WordDictionary {
  private class Trie{
    boolean isEnd=false;
    Trie[] next;
    Trie()
    {
      next=new Trie[26];
    }
  }
  Trie[] wd=new Trie[26];
  // Adds a word into the data structure.
  public void addWord(String word) {
    Trie[] c=wd;
    for(int i=0;i<word.length();i++)
    {
      char cur=word.charAt(i);
      if(c[cur-'a']==null)
      {
        c[cur-'a']=new Trie();
      }
      if(i==word.length()-1) c[cur-'a'].isEnd=true;
      c=c[cur-'a'].next;
    }
  }
  // Returns if the word is in the data structure. A word could
// contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return dfs(word,0,wd,new Trie());
  }
  public boolean dfs(String word,int index, Trie[] dic,Trie pre)
  {   if(index==word.length()&&pre.isEnd==true) return true;
    if(index==word.length()&&pre.isEnd==false) return false;
    char cur=word.charAt(index);
    if(cur=='.')
    {
      for(int i=0;i<26;i++)
      {
        if(dic[i]!=null) if(dfs(word,index+1,dic[i].next,dic[i])==true) return true;
      }
    }
    else
    {
      if(dic[cur-'a']!=null) if(dfs(word,index+1,dic[cur-'a'].next,dic[cur-'a'])==true) return true;
    }
    return false;
  }
 }