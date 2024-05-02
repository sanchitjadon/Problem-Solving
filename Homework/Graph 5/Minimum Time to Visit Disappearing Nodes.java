class edg{
    int e;
    int w;
    public edg(int a,int b){
        e=a;
        w=b;
    }
}
class Pair{
    int nd;
    int val;
    public Pair(int a,int b){
        nd=a;
        val=b;
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        boolean[] vis=new boolean[n];
        ArrayList<ArrayList<edg>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int e[]:edges){
             ArrayList<edg> l1 = adj.get(e[0]);
             ArrayList<edg> l2 = adj.get(e[1]);
             l1.add(new edg(e[1],e[2]));
             l2.add(new edg(e[0],e[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                return a.val-b.val;
            }
        });
        pq.add(new Pair(0,0));
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int nd = p.nd;
            int val = p.val;
            if(!vis[nd]){
                vis[nd]=true;
                if(val<disappear[nd]){
                    ans[nd] = val;
                    for(edg a:adj.get(nd)){
                        pq.offer(new Pair(a.e,a.w+val));
                    }
                }
            }
        }
        return ans;
    }
}
