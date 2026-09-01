class Solution {
     void func(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds) {

        // Add current subset
        ans.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {

            // Pick
            ds.add(nums[i]);

            func(i + 1, nums, ans, ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(0, nums, ans, ds);

        return ans;
    }
}