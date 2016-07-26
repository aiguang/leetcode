import java.util.HashSet;
import java.util.Set;

/**
 Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?

 Hint:

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at y = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.
 */
public class problem356LineReflection {
  public static void main(String[] args){
    int[][] points = new int[2][2];
    points[0][0] = 1;
    points[0][1] = 1;

    points[1][0] = -1;
    points[1][1] = -1;

    System.out.println(new problem356LineReflection().isReflected(points));
  }
  public boolean isReflected(int[][] points) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Set<String> set = new HashSet<String>();
    for(int i = 0; i < points.length;i++){
      if(points[i][0] < min){
        min = points[i][0];
      }
      if(points[i][0] > max){
        max = points[i][0];
      }
      set.add(points[i][0] + "_" + points[i][1]);
    }
    double middle = (double)(min + max) / 2;
    Set<String> visited = new HashSet<String>();
    for(int i = 0; i < points.length;i++){
      int x = points[i][0];
      int y = points[i][1];
      if(visited.contains(x + "_" + y)) continue;
      int target = 0;
      if(x < middle){
         target = (int)(middle + middle - x);
      }else if(x > middle){
        target = (int)(middle - (x - middle));
      }else{
        continue;
      }
      if(set.contains(target + "_" + y)){
        visited.add(x + "_" + y);
        visited.add(target + "_" + y);
      }else {
        return false;
      }
    }
    return true;
  }
}
