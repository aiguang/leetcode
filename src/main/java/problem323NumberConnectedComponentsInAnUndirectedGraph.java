import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class problem323NumberConnectedComponentsInAnUndirectedGraph {
  public static void main(String[] args){
    int[][] matrix = new int[2][2];

//    [[0,1],[0,2],[1,2],[2,3],[2,4]]
    matrix[0][0] = 1;
    matrix[0][1] = 0;
//
    matrix[1][0] = 2;
    matrix[1][1] = 0;
//
//    matrix[2][0] = 1;
//    matrix[2][1] = 2;

//    matrix[3][0] = 2;
//    matrix[3][1] = 3;
//
//    matrix[4][0] = 2;
//    matrix[4][1] = 4;

    int result = new problem323NumberConnectedComponentsInAnUndirectedGraph().countComponents(3, matrix);
    System.out.println(result);
  }
  public int countComponents(int n, int[][] edges) {
    if(edges == null || edges.length == 0 || edges[0].length == 0 ) return n;
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for(int i = 0;i < edges.length;i++){
      int from = edges[i][0];
      int to = edges[i][1];
      List<Integer> fList = map.get(from);
      if(fList == null){
        fList = new ArrayList<Integer>();
      }
      fList.add(to);
      map.put(from, fList);

      List<Integer> tList = map.get(to);
      if(tList == null){
        tList = new ArrayList<Integer>();
      }
      tList.add(from);
      map.put(to, tList);
    }
    int result = 0;
    for(int i = 0; i < n;i++){
      List<Integer> l = map.get(i);
      if(l == null){
       result++;
      }
    }
    Queue<Integer> queue = new ArrayDeque<Integer>();
    List<Integer> visited = new ArrayList<Integer>();
    for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
      if(!entry.getValue().isEmpty()){
        queue.add(entry.getKey());
        visited.add(entry.getKey());
        break;
      }
    }

    while (true){
      result++;
      while (!queue.isEmpty()){
        int node = queue.poll();
        List<Integer> otherNode = map.get(node);
        if(otherNode != null && !otherNode.isEmpty()){
          ListIterator<Integer> iter = otherNode.listIterator();
          while (iter.hasNext()){
            int tmpN = iter.next();
            if(!visited.contains(tmpN)){
              visited.add(tmpN);
              queue.offer(tmpN);
            }
          }
        }
      }
      for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
        if(!visited.contains(entry.getKey())){
          queue.add(entry.getKey());
          visited.add(entry.getKey());
          break;
        }
      }
      if(queue.isEmpty()) break;
    }
    return result;
  }
}
