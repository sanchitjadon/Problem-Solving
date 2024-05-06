class Solution {
    class Node implements Comparator<Node>{
        int node;
        int distance;
        
        Node(){}

        Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        public int compare(Node o1, Node o2){
            return Integer.compare(o1.distance, o2.distance);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0;  i < n + 1;  i++){
            adjList.add(new ArrayList<>());
        }
        //create adjList
        for(int[] edge : times){
            //u --> v
            int u = edge[0];
            int v = edge[1];
            int uvDistance = edge[2];

            Node node = new Node(v, uvDistance);
            adjList.get(u).add(node);
        }

        dijkstra(k, n, adjList, distance);

        int max = Integer.MIN_VALUE;

        for(int city = 1; city <= n; city++){
            if(distance[city] == Integer.MAX_VALUE) return -1;
            if(distance[city] > max) max = distance[city];
        }

        return max;
    }

    private void dijkstra(int source, int n, List<List<Node>> adjList, int[] distance){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Node());
        minHeap.add(new Node(source, 0));

        while(!minHeap.isEmpty()){
            Node u = minHeap.poll();
            int uDistance = distance[u.node];

            for(Node v : adjList.get(u.node)){
                int uvDistance = v.distance;
                if(uDistance + uvDistance < distance[v.node]){
                    distance[v.node] = uDistance + uvDistance;
                    minHeap.add(new Node(v.node, distance[v.node]));
                }
            }
        }
    }
}
