class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[]indegree=new int[n];
        for(int i=0;i<edges.size();i++){
            int x=edges.get(i).get(1);
            indegree[x]++;
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}
