/**
 * Created by Administrator on 15-9-6.
 */
public class problem74 {
  public static void main(String[] args){
    int[][] matrix = new int[3][4];
    matrix[0][0] = 1;
    matrix[0][1] = 3;
    matrix[0][2] = 5;
    matrix[0][3] = 7;

    matrix[1][0] = 10;
    matrix[1][1] = 11;
    matrix[1][2] = 16;
    matrix[1][3] = 20;

    matrix[2][0] = 23;
    matrix[2][1] = 30;
    matrix[2][2] = 34;
    matrix[2][3] = 50;

    System.out.println(new problem74().searchMatrix(matrix, 67));
  }
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0) return false;
    return find(0,matrix[0].length - 1,matrix,target);
  }
  private boolean find(int row, int column, int[][] matrix, int target){
    if(row > matrix.length - 1 || column < 0) return false;
    if(row == matrix.length - 1 && column == 0) return matrix[row][column] == target;
    if(matrix[row][column] > target){
      return find(row, column - 1, matrix, target);
    }else if(matrix[row][column] < target){
      return find(row + 1, column, matrix, target);
    }else {
      return true;
    }
  }
}
