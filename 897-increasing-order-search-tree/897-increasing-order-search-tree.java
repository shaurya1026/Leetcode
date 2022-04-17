/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
     public TreeNode dfs(TreeNode root) {
        if(root == null) return null;
        TreeNode leftNode = null;
        
        if(root.left!=null) {
        leftNode = dfs(root.left);
        TreeNode actualHead = leftNode;
        while(leftNode.right!=null) 
            leftNode = leftNode.right;
        actualHead.left = null;
        root.right = dfs(root.right);
        root.left = null;
        leftNode.right = root; 
        return actualHead;
        } 
        else {
        leftNode = root;
        leftNode.left = null;
        leftNode.right = dfs(leftNode.right);
        }
        return leftNode;
    }
    public TreeNode increasingBST(TreeNode root) {
        return dfs(root);
    }
}