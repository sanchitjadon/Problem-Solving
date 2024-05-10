class Solution {
    public class Pair {
        public int j;
        public double wt;
        public Pair(int j, double wt) {
            this.j = j;
            this.wt = wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        double[] dist = new double[n];
        Arrays.fill(dist, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.wt, a.wt));
        pq.add(new Pair(start, 1.0));
        dist[start] = 1.0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            for(Pair next: adj.get(p.j)) {
                if(dist[p.j] != Double.MIN_VALUE && dist[p.j] * next.wt > dist[next.j]) {
                    dist[next.j] = dist[p.j] * next.wt;
                    pq.add(new Pair(next.j, next.wt));
                }
            }
        }

        return dist[end];
    }
}
