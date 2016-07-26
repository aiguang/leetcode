/**
 * Created by Administrator on 16-2-23.
 */
public class problem73_1 {

  public void setZeroes(int[][] matrix) {
    if (matrix == null) {
      return;
    }
    boolean cleanFirstRow = false;
    boolean cleanFirstColumn = false;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        cleanFirstColumn = true;
        break;
      }
    }
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        cleanFirstRow = true;
        break;
      }
    }
    for (int i = 1; i < matrix.length; ++i) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        } else {
          if (matrix[i][j] == 0) {
            matrix[i][0] = 0;
            matrix[0][j] = 0;
          }
        }
      }
    }

    if (cleanFirstColumn) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
    if (cleanFirstRow) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }
  }
}
