class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
	    if(root==null){
	        return 0;
	    }
	    return root.data-getLevelDiff(root.left)-getLevelDiff(root.right);
	}
}
