/**
 Assume you have an array of length n initialized with all 0's and are given k update operations.

 Each operation is represented as a triplet: [startIndex, endIndex, inc]
 which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

 Return the modified array after all k operations were executed.

 Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]
 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]
 */
public class problem370RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
//    int[] res = new int[length];
//    for (int[] n : updates){
//      // we can consider the array as a water flow from the start to the end.
//      // after each operation, the water level is changed
//      res[n[0]] += n[2]; // when entering into the start point of one operation, the water level is increased
//      if (n[1] != length - 1) res[n[1] + 1] -= n[2]; // when leaving the end point(reach the next element of the end point), the water level is decreased
//    }
//    for (int i = 1; i < length; i++) res[i] += res[i - 1];
//    return res;
    int[] res = new int[length];
    for(int[] array : updates){
      res[array[0]] += array[2];
      if(array[1] < length - 1) res[array[1] + 1] -= array[2];
    }
    for(int i = 1; i < length;i++){
      res[i] += res[i - 1];
    }
    return res;
  }
}
