/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public List<Integer> distanceK(TreeNode root,TreeNode target,int k) {

        List<Integer> ans = new ArrayList<>();

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        // Step 1: Parent map
        makeParentMap(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.add(node.left);
                }

                // Right
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.add(node.right);
                }

                // Parent
                TreeNode par = parent.get(node);

                if (par != null &&
                    !visited.contains(par)) {

                    visited.add(par);
                    q.add(par);
                }
            }

            distance++;
        }

        return ans;
    }

    private void makeParentMap(TreeNode node,
                               TreeNode par,
                               Map<TreeNode, TreeNode> parent) {

        if (node == null) {
            return;
        }

        parent.put(node, par);

        makeParentMap(node.left, node, parent);
        makeParentMap(node.right, node, parent);
    }
}