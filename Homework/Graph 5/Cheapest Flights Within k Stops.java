class Pair{
        int node;
        int wt;
        int st;
        Pair(int n,int w,int s){
            node=n;
            wt=w;
            st=s;
        }
}

class Solution {  
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int f[]:flights){
            int u =f[0];
            int v=f[1];
            int w=f[2];
            ArrayList<Integer> t=new ArrayList<>();
            t.add(v);
            t.add(w);
            graph.get(u).add(new ArrayList<>(t));
        }
        int visited[]=new int[n];
        Arrays.fill(visited,k+10);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{  return  a.wt-b.wt;});
        pq.add(new Pair(src,0,0));
        
        while(pq.size()>0){
            int size=pq.size();  
                Pair r=pq.remove();
                System.out.println(r.node+" "+r.wt);
                visited[r.node]=r.st;
                if(r.node == dst){
                    return r.wt;
                }
                for(ArrayList<Integer> nbr:graph.get(r.node)){
                    int nb=nbr.get(0);
                    int wt=nbr.get(1);
                    if(visited[nb]<r.st+1)
                        continue;
                    if(r.st+1>k+1)
                        continue;    
                    pq.add(new Pair(nb,r.wt+wt,r.st+1)) ;   
                }        
        }
            return -1;
    }
}
