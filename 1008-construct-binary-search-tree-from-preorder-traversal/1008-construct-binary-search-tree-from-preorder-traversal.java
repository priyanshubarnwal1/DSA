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
// class Solution {
//     public TreeNode bstFromPreorder(int[] A) {
//         return bstFromPreorder(A,Integer.MAX_VALUE, new int[] {0});
//     }
//     public TreeNode bstFromPreorder(int[] A, int bound, int[] i){
//         if(i[0]==A.length || A[i[0]]>bound) return null;
//         TreeNode root = new TreeNode(A[i[0]++]);
//         root.left = bstFromPreorder(A, root.val, i);
//         root.right = bstFromPreorder(A, bound, i);
//         return root;
//     }
// }

class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, long min, long max) {
        if (i == preorder.length) {
            return null;
        }

        int val = preorder[i];

        if (val <= min || val >= max) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        i++;

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}