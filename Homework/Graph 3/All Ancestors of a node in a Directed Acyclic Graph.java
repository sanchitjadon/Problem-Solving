class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<Integer>> parent = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            parent.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> ancestors = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int current = stack.pop();
                for (int p : parent.getOrDefault(current, Collections.emptySet())) {
                    if (ancestors.add(p)) {
                        result.get(i).add(p);
                        stack.push(p);
                    }
                }
            }
            Collections.sort(result.get(i));
        }
        return result;
    }
