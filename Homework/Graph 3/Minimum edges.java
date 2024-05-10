import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] {v, 0});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] {u, 1});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, src});
        
        while (!pq.isEmpty()) {
            int[] topElement = pq.poll();
            int topDist = topElement[0];
            int topNode = topElement[1];
            
            if (topDist > dist[topNode]) {
                continue; // Skip processing if we have found a shorter path
            }
            
            for (int[] nbrPair : adj.getOrDefault(topNode, new ArrayList<>())) {
                int nbrNode = nbrPair[0];
                int nbrDist = nbrPair[1];
                
                if (topDist + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = topDist + nbrDist;
                    pq.offer(new int[] {dist[nbrNode], nbrNode});
                }
            }
        }
        
        if (dist[dst] != Integer.MAX_VALUE) {
            return dist[dst];
        }
        
        return -1; // If destination is unreachable
    }
}
