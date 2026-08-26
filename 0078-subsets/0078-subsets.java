class Solution {
    public List<List<Integer>> subsets(int[] nums) {
          int n = nums.length;

 
        int subsets = 1 << n;

    
        List<List<Integer>> ans = new ArrayList<>();


        for (int num = 0; num < subsets; num++) {
        
            List<Integer> subset = new ArrayList<>();

           
            for (int i = 0; i < n; i++) {
            
                if ((num & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

        
            ans.add(subset);
        }
        return ans;
    }
}