/**
 * Created by Administrator on 15-7-27.
 */
public class Search2DMatrixII {
    public static void main(String[] args){
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;
        matrix[0][3] = 11;
        matrix[0][4] = 15;

        matrix[1][0] = 2;
        matrix[1][1] = 5;
        matrix[1][2] = 8;
        matrix[1][3] = 12;
        matrix[1][4] = 19;

        matrix[2][0] = 3;
        matrix[2][1] = 6;
        matrix[2][2] = 9;
        matrix[2][3] = 16;
        matrix[2][4] = 22;

        matrix[3][0] = 10;
        matrix[3][1] = 13;
        matrix[3][2] = 14;
        matrix[3][3] = 17;
        matrix[3][4] = 24;

        matrix[4][0] = 18;
        matrix[4][1] = 21;
        matrix[4][2] = 23;
        matrix[4][3] = 26;
        matrix[4][4] = 30;

        Search2DMatrixII instance = new Search2DMatrixII();
        System.out.println(instance.searchMatrix(matrix, 5));

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int[] column = new int[matrix.length];
        for(int i = 0 ; i < matrix.length;i++){
            column[i] = matrix[i][0];
        }
        int result = binarySearch(column, target, 0, column.length);
        if(result == -1) return false;
        for(int i = 0; i < matrix[result].length;i++){
            column[i] = matrix[result][i];
        }
        result = binarySearch(column, target, 0, column.length);
        return result >= 0;
    }
    private int binarySearch(int[] array, int i,int start, int end){
        if(end < start) return -1;
        int middle = (end - start)/ 2;

        if(array[middle] > i){
            return binarySearch(array, i, start, middle - 1);
        }else if(array[middle] < i){
            return binarySearch(array, i, middle + 1, end);
        }else{
            return middle;
        }
    }

}
