import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from,
 * to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Note: If there are multiple valid itineraries, you should return the itinerary that has the
 * smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"]
 * has a smaller lexical order than ["JFK", "LGB"]. All airports are represented by three capital
 * letters (IATA code). You may assume all tickets form at least one valid itinerary. Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] Return ["JFK", "MUC",
 * "LHR", "SFO", "SJC"]. Example 2: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"]. Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class problem332ReconstructItinerary {

  HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
  LinkedList<String> result = new LinkedList<String>();

  public static void main(String[] args) {
    String[][] tickets = new String[5][2];
//    [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    tickets[0][0] = "JFK";
    tickets[0][1] = "SFO";

    tickets[1][0] = "JFK";
    tickets[1][1] = "ATL";

    tickets[2][0] = "SFO";
    tickets[2][1] = "ATL";

    tickets[3][0] = "ATL";
    tickets[3][1] = "JFK";

    tickets[4][0] = "ATL";
    tickets[4][1] = "SFO";

    List<String> result = new problem332ReconstructItinerary().findItinerary(tickets);
    for (String value : result) {
      System.out.print(value + ",");
    }
  }


  public List<String> findItinerary(String[][] tickets) {
    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();
    for (String[] ticket : tickets) {
      if (!map.containsKey(ticket[0])) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        map.put(ticket[0], q);
      }
      map.get(ticket[0]).offer(ticket[1]);
    }
    dfs("JFK", map, result);
    return result;
  }

  public void dfs(String s, HashMap<String, PriorityQueue<String>> map, LinkedList<String> result) {
    PriorityQueue<String> q = map.get(s);
    while (q != null && !q.isEmpty()) {
      dfs(q.poll(), map, result);
    }
    result.addFirst(s);
  }
//  public List<String> findItinerary(String[][] tickets) {
//    List<String> result = new ArrayList<String>();
//    List<String> visited = new ArrayList<String>();
//    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//    for (int i = 0; i < tickets.length; i++) {
//      List<String> list = map.get(tickets[i][0]);
//      if (list == null) {
//        list = new ArrayList<String>();
//      }
//      list.add(tickets[i][1]);
//      Collections.sort(list);
//      map.put(tickets[i][0], list);
//    }
//    result.add("JFK");
//    dfs(tickets, "JFK", map, result, visited);
//    return result;
//  }
//
//  public boolean dfs(String[][] tickets, String from, Map<String, List<String>> map,
//                     List<String> result, List<String> visited) {
//    if (result.size() == tickets.length + 1) {
//      return true;
//    }
//    List<String> list = map.get(from);
//    if (list != null) {
//      for (String s : list) {
//        if (!visited.contains(from + "_" + s)) {
//          result.add(s);
//          visited.add(from + "_" + s);
//          if (dfs(tickets, s, map, result, visited)) {
//            return true;
//          }
//          result.remove(s);
//          visited.remove(from + "_" + s);
//        }
//      }
//    }
//    return false;
//  }
}
