class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int [] indegree =  new int [n];

        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
           int l = edges[i][0];
           int m = edges[i][1];
           indegree[m]++;
           adj.get(l).add(m);
        }

        Queue<Integer>q = new LinkedList<>();
        int ans = 1;
        int visitedNodes = 0;
        int [][] count = new int [n][26];
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }

        while(!q.isEmpty()){
            int node  = q.poll();
            visitedNodes++;
            ans  = Math.max(ans,++count[node][colors.charAt(node)-'a']);
            for(int i : adj.get(node)){
                
                indegree[i]--;
                if(indegree[i]==0)q.offer(i);
                
                for(int j=0;j<26;j++){
                    count[i][j]=  Math.max(count[node][j],count[i][j]);
                }
            
            } 
        }
        if(visitedNodes<n)return -1;
        return ans;
    }
}
