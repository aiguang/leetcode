import java.util.ArrayList;
import java.util.List;

/**
 * Given words = ["oath","pea","eat","rain"] and board =
 *
 * [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v'] ] Return
 * ["eat","oath"].
 */
public class problem212WordSearchII {

  public static void main(String[] args) {
    char[][] board = new char[4][4];
    board[0][0] = 'o';
    board[0][1] = 'a';
    board[0][2] = 'a';
    board[0][3] = 'n';

    board[1][0] = 'e';
    board[1][1] = 't';
    board[1][2] = 'a';
    board[1][3] = 'e';

    board[2][0] = 'i';
    board[2][1] = 'h';
    board[2][2] = 'k';
    board[2][3] = 'r';

    board[3][0] = 'i';
    board[3][1] = 'f';
    board[3][2] = 'l';
    board[3][3] = 'v';

    String[] words = {"oath", "pea", "eat", "rain"};
//    String[] words = {"pea"};
    List<String> list = new problem212WordSearchII().findWords(board, words);
    for (String s : list) {
      System.out.print(s + ",");
    }
  }

  List<String> res = new ArrayList<String>();
  public List<String> findWords(char[][] board, String[] words) {
    if (board == null || board.length == 0 || board[0].length == 0
        || words == null || words.length == 0) {
      return new ArrayList<String>();
    }
    Trie trie = new Trie();
    for(String s : words){
      trie.insert(s);
    }
    for (int j = 0; j < board.length; j++) {
      for (int k = 0; k < board[0].length; k++) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        helper(board,   "", j, k, trie, visited);
      }

    }
    return res;
  }

  public void helper(char[][] board, String curValue, int row,
                        int column, Trie trie, boolean[][] visited) {
    if (row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1 ||
        visited[row][column]) {
      return;
    }

    String s = curValue + board[row][column];
    if (trie.search(s)) {
      res.add(s);
      return;
    }
    if (!trie.startsWith(s)) {
      return;
    }

    visited[row][column] = true;
    helper(board, s, row + 1, column, trie, visited);
    helper(board, s, row - 1, column, trie, visited);
    helper(board, s, row, column + 1, trie, visited);
    helper(board, s, row, column - 1, trie, visited);
    visited[row][column] = false;
    return;
  }
}
