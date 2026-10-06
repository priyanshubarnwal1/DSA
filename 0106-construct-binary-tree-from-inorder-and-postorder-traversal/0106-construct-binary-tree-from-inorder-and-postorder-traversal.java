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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1,postorder, 0, postorder.length - 1,inMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,int[] postorder, int postStart, int postEnd,
        Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of postorder = root
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Root position in inorder
        int inRoot = inMap.get(root.val);

        // Number of nodes in left subtree
        int numsLeft = inRoot - inStart;

        // Left subtree
        root.left = buildTree(inorder, inStart,inRoot - 1, postorder, postStart,postStart + numsLeft - 1, inMap );

        // Right subtree
        root.right = buildTree(inorder,inRoot + 1, inEnd,postorder,postStart + numsLeft, postEnd - 1,inMap);

        return root;
    }
}