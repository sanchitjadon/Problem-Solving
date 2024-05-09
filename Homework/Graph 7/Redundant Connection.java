class Dsu{
        int []parent;
        Dsu(int n){
            parent= new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }

        int find(int i){
            if(parent[i]==i)
             return i;
             return find(parent[i]);
        }

        boolean union(int u, int v){
            int u_rep=find(u);
            int v_rep=find(v);
    //both belong to the same set so union will be cycle
            if(u_rep==v_rep)
              return true;
            parent[u_rep]=v_rep;
            return false;
        }
    }
class Solution {
    public int[] findRedundantConnection(int[][] edges) {      
        int length=edges.length;
        Dsu disjointSet = new Dsu(length+1);
        int[] result= new int[2];
        for(int i=0;i<length;i++)
        {
             if(disjointSet.union(edges[i][0],edges[i][1]))
               {
                   result[0]=edges[i][0];
                   result[1]=edges[i][1];
                   return result;
               }      
        }
        return result;   
    }
}
