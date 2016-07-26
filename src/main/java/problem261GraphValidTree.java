import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Hint:

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 In other words, any connected graph without simple cycles is a tree.”
 */
public class problem261GraphValidTree {
  public static void main(String[] args){
    int n = 4;
//    [[0,1],[0,2],[2,3],[2,4]]
    int[][] edges = new int[3][2];
    edges[0][0] = 2;
    edges[0][1] = 3;

    edges[1][0] = 1;
    edges[1][1] = 2;

    edges[2][0] = 1;
    edges[2][1] = 3;

//    edges[3][0] = 2;
//    edges[3][1] = 4;

    System.out.println(new problem261GraphValidTree().validTree(n, edges));
  }
  public boolean validTree(int n, int[][] edges) {
    if(n == 1) return true;
    if(edges == null || edges.length == 0 || edges[0].length == 0) return false;
    List<Integer> visited = new ArrayList<Integer>();
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for(int i = 0; i < edges.length ;i++){
      int from = edges[i][0];
      int to = edges[i][1];
      List<Integer> l = map.get(from);
      if(l == null){
        l = new ArrayList<Integer>();
      }
      l.add(to);
      map.put(from, l);

      List<Integer> toList = map.get(to);
      if(toList == null){
        toList = new ArrayList<Integer>();
      }
      toList.add(from);
      map.put(to, toList);
    }
    visited.add(0);
    boolean value = dfs(map, 0, visited);
    return value && (visited.size() == n);
  }
  private boolean dfs(Map<Integer, List<Integer>> map, int from, List<Integer> visited){
    List<Integer> toList = map.get(from);
    if(toList == null) return false;
    for(int to : toList){
      if(visited.contains(to)) return false;
      visited.add(to);
      if(map.get(to).contains(from)){
        map.get(to).remove((Integer)from);
      }
      if(!dfs(map, to, visited)){
        return false;
      }
    }
    return true;
  }
}
