import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 Subscribe to see which companies asked this question
 */
public class problem133 {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) return null;
    UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    visited.put(node, clone);
    queue.offer(node);
    while(!queue.isEmpty()){
      UndirectedGraphNode tmp = queue.poll();
      List<UndirectedGraphNode> list = tmp.neighbors;
      for(int i = 0; i < list.size();i++){
        if(!visited.containsKey(list.get(i))){
          UndirectedGraphNode tmpNode = new UndirectedGraphNode(list.get(i).label);
          queue.offer(list.get(i));
          visited.put(list.get(i), tmpNode);
        }
        visited.get(tmp).neighbors.add(visited.get(tmp.neighbors.get(i)));
      }
    }
    return visited.get(node);
  }

}
