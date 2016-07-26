import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result
 * graph is then a rooted tree. Among all possible rooted trees, those with minimum height are
 * called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and
 * return a list of their root labels.
 *
 * Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number
 * n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,
 * 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1:
 *
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 * 0 | 1 / \ 2   3 return [1]
 *
 * Example 2:
 *
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 * 0  1  2 \ | / 3 | 4 | 5 return [3, 4]
 */
public class problem310MinimumHeightTrees {
//  Basically my code starts from the leaf nodes.
//
//  For leaf nodes, their degree = 1, which means each of them is only connected to one node.
//
//  In our loop, each time we delete the leaf nodes from our graph(just by putting their degrees to 0),
// and meanwhile we add the new leaf nodes after deleting them(just add their connected nodes with degree as 2) to the queue.
//
//  So basically in the end, the nodes in the queue would be connected to no other nodes but each other. They should be the answer.
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
    List<Integer> res = new ArrayList<Integer>();
    if (n == 1) {
      res.add(0);
      return res;
    }
    int[] degree = new int[n];
    for (int i = 0; i < n; i++) {
      myGraph.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < edges.length; i++) {
      myGraph.get(edges[i][0]).add(edges[i][1]);
      myGraph.get(edges[i][1]).add(edges[i][0]);
      degree[edges[i][0]]++;
      degree[edges[i][1]]++;
    }
    Queue<Integer> myQueue = new ArrayDeque<Integer>();

    for (int i = 0; i < n; i++) {
      if (degree[i] == 0) {
        return res;
      } else if (degree[i] == 1) {
        myQueue.offer(i);
      }
    }

    while (!myQueue.isEmpty()) {
      res = new ArrayList<Integer>();
      int count = myQueue.size();

      for (int i = 0; i < count; i++) {
        int curr = myQueue.poll();
        res.add(curr);
        degree[curr]--;
        for (int k = 0; k < myGraph.get(curr).size(); k++) {
          int next = myGraph.get(curr).get(k);
          if (degree[next] == 0) {
            continue;
          }
          if (degree[next] == 2) {
            myQueue.offer(next);
          }
          degree[next]--;
        }
      }
    }
    return res;
  }
//  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//    if(n < 0) return new ArrayList<Integer>();
//    if(edges == null || edges.length == 0 || edges[0].length == 0){
//      List<Integer> list = new ArrayList<Integer>();
//      for(int i = 0; i < n;i++){
//        list.add(i);
//      }
//      return list;
//    }
//    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//    for(int i = 0; i< edges.length;i++){
//      int from = edges[i][0];
//      int to = edges[i][1];
//      List<Integer> fList = map.get(from);
//      if(fList == null){
//        fList = new ArrayList<Integer>();
//      }
//      fList.add(to);
//      map.put(from, fList);
//      List<Integer> tList = map.get(to);
//      if(tList == null){
//        tList = new ArrayList<Integer>();
//      }
//      tList.add(from);
//      map.put(to, tList);
//    }
//    Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
//    int min = Integer.MAX_VALUE;
//    for(int i = 0; i < n ;i++){
//      int level = bfs(i, map, min);
//      List<Integer> r = result.get(level);
//      if(r == null){
//        r = new ArrayList<Integer>();
//      }
//      r.add(i);
//      result.put(level, r);
//      min = Math.min(min, level);
//    }
//    return map.get(min);
//  }
//  private int bfs(int start, Map<Integer, List<Integer>> edges, int curMin){
//    Queue<Integer> queue = new ArrayDeque<Integer>();
//    queue.add(start);
//    List<Integer> visited = new ArrayList<Integer>();
//    visited.add(start);
//    int level = 1;
//    int curTotal = 1;
//    int num = 0;
//    while (!queue.isEmpty()){
//      int node = queue.poll();
//      List<Integer> edge = edges.get(node);
//
//      for(int n : edge){
//        if(!visited.contains(n)){
//          visited.add(n);
//          queue.offer(n);
//          num++;
//        }
//      }
//      curTotal--;
//      if(curTotal == 0){
//        curTotal = num;
//        num = 0;
//        level++;
//        if(level > curMin) {
//          level = Integer.MAX_VALUE;
//          break;
//        }
//      }
//    }
//    return level;
//  }
}
