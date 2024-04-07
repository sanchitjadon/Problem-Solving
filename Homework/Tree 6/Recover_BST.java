class Solution {
	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;

	public void recoverTree(TreeNode root) {
		inOrder(root);
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		if (prev != null && root.val < prev.val) {
			if (first == null) {
				first = prev;
				second = root;
			} else {
				second = root;
			}
		}
		prev = root;
		inOrder(root.right);
	}
}
