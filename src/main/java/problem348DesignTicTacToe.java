/**
 Design a Tic-tac-toe game that is played between two players on a n x n grid.

 You may assume the following rules:

 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 Example:
 Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

 TicTacToe toe = new TicTacToe(3);

 toe.move(0, 0, 1); -> Returns 0 (no one wins)
 |X| | |
 | | | |    // Player 1 makes a move at (0, 0).
 | | | |

 toe.move(0, 2, 2); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 2 makes a move at (0, 2).
 | | | |

 toe.move(2, 2, 1); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 1 makes a move at (2, 2).
 | | |X|

 toe.move(1, 1, 2); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 2 makes a move at (1, 1).
 | | |X|

 toe.move(2, 0, 1); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 1 makes a move at (2, 0).
 |X| |X|

 toe.move(1, 0, 2); -> Returns 0 (no one wins)
 |X| |O|
 |O|O| |    // Player 2 makes a move at (1, 0).
 |X| |X|

 toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 |X| |O|
 |O|O| |    // Player 1 makes a move at (2, 1).
 |X|X|X|
 Follow up:
 Could you do better than O(n2) per move() operation?
 */
public class problem348DesignTicTacToe {
  public static void main(String[] args){
    TicTacToe t = new TicTacToe(2);
    System.out.println(t.move(0,1,1));
    System.out.println(t.move(1,1,2));
    System.out.println(t.move(1,0,1));

  }
}

class TicTacToe {

  /** Initialize your data structure here. */
  int[] board = null;
  int size = 0 ;
  public TicTacToe(int n) {
    board = new int[n * n];
    size = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    if(row < 0 || row > size - 1 || col < 0 || col > size - 1) return 0;
    if(board[row * size  + col] != 0) return 0;
    board[row * size  + col] = player;
    if(checkRow(row, player) || checkCol(col, player) || checkLine(row, col, player) || checkOtherLine(row, col, player)) return player;
    return 0;
  }
  private boolean checkRow(int row, int player){
    int k = board[row * size];
    if(k != player) return false;
    for(int i = 0; i < size;i++){
      if(k != board[row * size + i]) return false;
    }
    return true;
  }
  private boolean checkCol(int col, int player){
    int k = board[col];
    if(k != player) return false;
    for(int i = 0; i < size;i++){
      if(k != board[i * size + col]) return false;
    }
    return true;
  }
  private boolean checkLine(int row, int col, int player){
    if(row != col) return false;
    int k = board[0];
    if(k != player) return false;
    for(int i = 0; i < size;i++){
      if(k != board[i * size + i]) return false;
    }
    return true;
  }

  private boolean checkOtherLine(int row, int col, int player){
    if(row + col != size - 1) return false;
    int k = board[size - 1];
    if(k != player) return false;
    for(int i = 0; i < size;i++){
      if(k != board[i * size + size - i - 1]) return false;
    }
    return true;
  }

}
