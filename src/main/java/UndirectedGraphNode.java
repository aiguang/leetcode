import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-12-25.
 */
public class UndirectedGraphNode {

  int label;
  List<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
}
