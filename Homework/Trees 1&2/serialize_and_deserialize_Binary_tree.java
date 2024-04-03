import java.util.LinkedList;
import java.util.Queue;

public class copySerializeDeserislize {
    public static String serialize(BinaryTreeNode<Integer> root) {
        if (root == null) return "";
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node == null) {
                res.append("+ ");
                continue;
            }
            res.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }
    public static BinaryTreeNode<Integer> deserialize(String data) {
        if (data == "") return null;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        String[] values = data.split(" ");
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            BinaryTreeNode<Integer> parent = q.poll();
            if (!values[i].equals("+")) {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("+")) {
                BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void printBT(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        String s=root.data+":";
        if(root.left!=null){
            s=s+"L:"+root.left.data+",";
        }
        if(root.right!=null){
            s=s+"R:"+root.right.data+",";
        }
        System.out.println(s);
        printBT(root.left);
        printBT(root.right);
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>( 12);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(31);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        String str=serialize(root);
        System.out.println(str);
        root =deserialize(str);
        printBT(root);
    }
}
