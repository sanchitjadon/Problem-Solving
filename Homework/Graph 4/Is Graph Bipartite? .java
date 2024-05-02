class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean res = true;
        for(int i = 0; i<n;i++){
            res = res && bfs(graph, i);
        }
        return res;
    }
    public boolean bfs(int[][] graph, int s){
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i<graph.length;i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int i = 0; i< graph.length;i++){
            for(int j : graph[i]){
                adjList.get(i).add(j);
            }
        }

        boolean[] isVisited = new boolean[graph.length];
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        isVisited[s] = true;
        color[s] = 1;
        while (!q.isEmpty()){
            int a = q.poll();
            for(int u : adjList.get(a)){
                if(!isVisited[u]){
                    q.offer(u);
                    color[u] = color[a]==1?2:1;
                    isVisited[u] = true;
                }else if(isVisited[u]){
                    if(color[u] == color[a]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
