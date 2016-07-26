import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-7-11.
 */
public class problem323NumberofConnectedComponentsinanUndirectedGraph {

  public static void main(String[] args) {
    int[][] edges = new int[3][2];
    edges[0][0] = 0;
    edges[0][1] = 1;

    edges[1][0] = 1;
    edges[1][1] = 2;

    edges[2][0] = 3;
    edges[2][1] = 4;

    System.out.println(
        new problem323NumberofConnectedComponentsinanUndirectedGraph().countComponents(4, edges));
  }

  public int countComponents(int n, int[][] edges) {
    if (n < 0 || edges == null) {
      return 0;
    }
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < edges.length; i++) {
      int from = edges[i][0];
      int end = edges[i][1];
      List<Integer> l = map.get(from);
      if (l == null) {
        l = new ArrayList<Integer>();
        map.put(from, l);
      }
      l.add(end);

      List<Integer> e = map.get(end);
      if (e == null) {
        e = new ArrayList<Integer>();
        map.put(end, e);
      }
      e.add(from);
    }
    List<Integer> visited = new ArrayList<Integer>();
    int result = 0;

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (visited.contains(entry.getKey())) {
        continue;
      }
      result++;
      helper(n, map, entry.getKey(), visited);
    }
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      result++;
    }

    return result;
  }

  public void helper(int total, Map<Integer, List<Integer>> edges, int curNode,
                     List<Integer> visited) {
    if (visited.size() >= total) {
      return;
    }
    if (visited.contains(curNode)) {
      return;
    }
    visited.add(curNode);
    List<Integer> e = edges.get(curNode);
    if (e == null) {
      return;
    }
    for (int i = 0; i < e.size(); i++) {
      if (visited.contains(e.get(i))) {
        continue;
      }
      helper(total, edges, e.get(i), visited);
    }
  }

}

class unionFind {

  int[] parent;

  private int findParent(int n) {
    while (parent[n] != n) {
      n = parent[n];
    }

    return n;
  }

  private boolean unionFind(int p, int q) {
    int pp = findParent(p);
    int qq = findParent(q);

    if (pp == qq) {
      return true;
    } else if (pp < qq) {
      parent[pp] = qq;
      return false;
    } else {
      parent[qq] = pp;
      return false;
    }
  }

  public int countComponents(int n, int[][] edges) {

    if (n == 0) {
      return 0;
    }

    parent = new int[n];
    int p, q;

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int[] pair : edges) {
      p = pair[0];
      q = pair[1];
      if (!unionFind(p, q)) {
        n--;
      }
    }

    return n;
  }
}
