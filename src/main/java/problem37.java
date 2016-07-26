/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 */
public class problem37 {

  private boolean[][] rows = new boolean[9][9];
  private boolean[][] col = new boolean[9][9];
  private boolean[][] sub = new boolean[9][9];
  private boolean isFound = false;

  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          int area = i * 3 / 3 + j / 3;
          int num = board[i][j] - '0' - 1;
          rows[i][num] = true;
          col[j][num] = true;
          sub[area][num] = true;
        }
      }
      helper(board, 0, 0);
    }
  }

  public void helper(char[][] board, int row, int column) {
    if (row == 9) {
      isFound = true;
      return;
    }
    if (board[row][column] == '.') {
      for (int i = 0; i < 9; i++) {
        int num = i - '0' + 1;
        int area = row * 3 / 3 + column / 3;
        if (!rows[row][num] && !col[column][num] && !sub[area][num]) {
          rows[row][num] = true;
          col[column][num] = true;
          sub[area][num] = true;

          if (column == 8) {
            helper(board, row + 1, column);
          }
        } else {
          helper(board, row, column + 1);
        }
        if (isFound) {
          break;
        }
        board[row][column] = '.';
        rows[row][num] = false;
        col[column][num] = false;
        sub[area][num] = false;
      }
    } else {
      int area = row * 3 / 3 + column / 3;
      int i = board[row][column] - '0' - 1;
      rows[row][i] = true;
      col[column][i] = true;
      sub[area][i] = true;

      if (column == 8) {
        helper(board, row + 1, 0);
      } else {
        helper(board, row, column + 1);
      }
    }
  }
}
