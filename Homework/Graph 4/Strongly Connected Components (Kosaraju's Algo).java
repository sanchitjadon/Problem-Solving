class Solution
{
    //To find number of strongly connected components in the graph.
    private void dfs(int sv, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph) {
        visited[sv] = true;
        for (int i : graph.get(sv)) {
            if (!visited[i]) {
                dfs(i, visited, st, graph);
            }
        }
        st.push(sv);
    }
    private void dfsReverse(int sv, boolean[] visited, ArrayList<ArrayList<Integer>> revGraph) {
        visited[sv] = true;
        for (int i : revGraph.get(sv)) {
            if (!visited[i]) {
                dfsReverse(i, visited, revGraph);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, st, adj);
            }
        }
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            for (int j : adj.get(i)) {
                revGraph.get(j).add(i);
            }
        }
        int cnt = 0;
        while (!st.isEmpty()) {
            int f = st.pop();
            if (!visited[f]) {
                cnt++;
                dfsReverse(f, visited, revGraph);
            }
        }
        return cnt;
    }  
}
