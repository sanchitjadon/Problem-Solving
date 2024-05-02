/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node newG = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, newG);
        while(!q.isEmpty()) {
            Node current = q.remove();
            Node cloned = map.get(current.val);
            for(Node n: current.neighbors) {
                if(!map.containsKey(n.val)) {
                    q.add(n);
                    map.put(n.val, new Node(n.val));
                }
                cloned.neighbors.add(map.get(n.val));
            }
        }
        return newG;
    }
}
