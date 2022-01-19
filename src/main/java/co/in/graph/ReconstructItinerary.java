package co.in.graph;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/reconstruct-itinerary/">Reconstruct Itinerary</a>
 */
public class ReconstructItinerary {

    private Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    private LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {

        // 1. Build a graph first - Adjacency List
        for(List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);

            if(!flightMap.containsKey(origin)) {
                flightMap.put(origin, new PriorityQueue<>()); // 2. order the destinations i.e. sort adjacent items
            }

            flightMap.get(origin).offer(dest);
        }

        // 3. post order DFS
        result = new LinkedList<>();

        dfs("JFK");

        return result;
    }

    private void dfs(String origin) {

        if(flightMap.containsKey(origin)) {
            PriorityQueue<String> destList = flightMap.get(origin);
            while(!destList.isEmpty()) {
                dfs(destList.poll());
            }
        }

        result.offerFirst(origin);
    }
}
