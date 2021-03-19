package SatAndWedClass20182020;

import java.util.*;
/*
Hint : graph problem, may be you need PriorityQueue
Given a list of airline tickets represented by pairs of airports [from, to],
reconstruct the itinerary in order. the itinerary must begin with JFK.
1.If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order.
   For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
2. All airports are represented by three capital letters (IATA code).
3. all tickets form at least one valid itinerary.
4. One must use all the tickets once and only once.
Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
---------------- init code --------------
public class WednesdayClass.BuildItinerary {
    public List<String> buildItinerary(List<List<String>> tickets) {}
}
 */
public class BuildItinerary {
    public static Map<String, ArrayList<String>> data;
    public static Map<String, PriorityQueue<String>> data2;
    public static Map<String, Set<String>> visited;
    public static Set<String> mapKeys;
    public static List<String> buildItinerary(List<List<String>> tickets) {
        data = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (List<String> x : tickets) {
            String airport1 = x.get(0);
            String airport2 = x.get(1);
            data.computeIfAbsent(airport1, key -> new ArrayList<>());
            data.get(airport1).add(airport2);
        }
        //System.out.println(data);
        mapKeys = data.keySet();
        for(String s: mapKeys) {
            ArrayList<String> arr = data.get(s);
            arr.sort(Comparator.naturalOrder());
            if(DFS(s).size() > answer.size()) {
                answer = DFS(s);
            }
        }
        //System.out.println(data);
        //System.out.println(paths);
        return answer;
    }
    public static ArrayList<String> DFS(String start) {
        ArrayList<String> path = new ArrayList<>();
        path.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited = new HashMap<>();
        for(String s1: mapKeys) {
            visited.put(s1, new HashSet<>());
        }

        while (!q.isEmpty()) {
            String from = q.poll();
            if (data.get(from) == null) {
                break;
            }
            for (String to : data.get(from)) {
                if(!visited.get(from).contains(to)) {
                    path.add(to);
                    q.add(to);
                    visited.get(from).add(to);
                    break;
                }
            }
        }
        return path;
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> child = new ArrayList<>();
        child.add("JFK");
        child.add("SFO");
        tickets.add(child);
        child = new ArrayList<>();
        child.add("JFK");
        child.add("ATL");
        tickets.add(child);
        child = new ArrayList<>();
        child.add("SFO");
        child.add("ATL");
        tickets.add(child);
        child = new ArrayList<>();
        child.add("ATL");
        child.add("JFK");
        tickets.add(child);
        child = new ArrayList<>();
        child.add("ATL");
        child.add("SFO");
        tickets.add(child);
        System.out.println(buildItinerary(tickets));
    }
}