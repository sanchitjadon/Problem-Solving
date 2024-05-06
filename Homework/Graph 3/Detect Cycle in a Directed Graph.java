class Solution {
    // Function to detect cycle in a directed graph.
   public boolean checkdfs(int x, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] back) {
        vis[x] = 1;
        back[x] = 1;
        for (int i : adj.get(x)) {
            if (vis[i] == 0) {
                if (checkdfs(i, adj, vis, back))
                    return true;
            } else if (back[i] == 1) {
                return true;
            }
        }
        back[x] = 0; 
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V]; 
        int[] back = new int[V];
        Arrays.fill(vis, 0);
        Arrays.fill(back, 0);
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (checkdfs(i, adj, vis, back))
                    return true;
            }
        }
        return false;
    }
}
