/**
 * Created by Administrator on 16-6-24.
 */
public class problem36ValidSoduku {

  public boolean isValidSudoku(char[][] board) {
    int n = board.length;
    boolean[][] row = new boolean[n][9];
    boolean[][] col = new boolean[n][9];
    boolean[][] sub = new boolean[n * n / 9][9];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (row[i][board[i][j] - '1'] || col[j][board[i][j] - '1'] || sub[i / 3 + j / 3 * 3][
            board[i][j] - '1']) {
          return false;
        }

        row[i][board[i][j] - '1'] = true;
        col[j][board[i][j] - '1'] = true;
        sub[i / 3 + j / 3 * 3][board[i][j] - '1'] = true;
      }
    }
    return true;
  }
}
