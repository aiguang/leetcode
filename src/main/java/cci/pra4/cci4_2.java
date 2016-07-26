package cci.pra4;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 原文：
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two
 * nodes.
 *
 * 译文：
 *
 * 给定一个有向图，设计算法判断两结点间是否存在路径。
 */
public class cci4_2 {
  public boolean isConnect(GraphNode a, GraphNode b) {
    Set<GraphNode> visited = new HashSet<GraphNode>();
    Queue<GraphNode> queue = new ArrayDeque<GraphNode>();
    queue.add(a);
    while (!queue.isEmpty()){
      GraphNode tmp = queue.poll();
      if (tmp == b) return true;
      List<GraphNode> list = tmp.next;
      for(int i = 0; i < list.size();i++){
        GraphNode node = list.get(i);
        if(!visited.contains(node)){
          visited.add(node);
        }
      }
    }
    return false;
  }
}
