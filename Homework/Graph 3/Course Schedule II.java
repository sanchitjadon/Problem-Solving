class Solution {
    int idx = -1;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] courses = new boolean[numCourses];
        int[] order = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        idx = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int src = edge[1];
            int dst = edge[0];
            graph[src].add(dst);
        }
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && isCyclic(graph,visited,courses,i)){
                return new int[] {};
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(!courses[i]) {
                topSort(graph,order,courses,i);
            }
        }

        return order;
    }
    public void topSort(ArrayList<Integer>[] graph,int[] order,boolean[] courses,int node){
        if(courses[node]){
            return;
        }
        courses[node] = true;
        for(int i = 0; i < graph[node].size(); i++){
           topSort(graph,order,courses,graph[node].get(i)); 
        }
        order[idx--] = node;
    }
    public boolean isCyclic(ArrayList<Integer>[] graph,boolean[] visited,boolean[] courses,int node) {
        if(courses[node]){
            return true;
        }
        if(visited[node]) {
            return false;
        }
        visited[node] = true;
        courses[node] = true;
        for(int i = 0; i < graph[node].size(); i++){
            if(isCyclic(graph,visited,courses,graph[node].get(i))) {
                courses[node] = false;
                return true;
            }
        }
        courses[node] = false;
        return false;
    }
}
