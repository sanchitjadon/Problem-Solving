class Solution {
    HashMap<Integer, Set<Integer>> adj = new HashMap<>();
    Set<Integer> exploring = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
  
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new HashSet());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                boolean hasCycle = dfsDetectCycle(i);
                if (hasCycle) 
                  return false; 
            }
        }
        return true;
    }
    public boolean dfsDetectCycle(int n) {
        if (visited.contains(n)) 
          return false;
        if (exploring.contains(n)) 
          return true;
        exploring.add(n);
        for (int e: adj.get(n)) {
            if (!visited.contains(e)) {
                boolean hasCycle = dfsDetectCycle(e);
                if (hasCycle)
                  return true;
            }
        }
        exploring.remove(n);
        visited.add(n);
        return false;
    }
}
