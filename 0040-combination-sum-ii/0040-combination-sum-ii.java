class Solution {
     private void findCombinations(int ind,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if(i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if(candidates[i] > target) {
                break;
            }

            // Pick
            ds.add(candidates[i]);

            // Move to next index because
            // each element can be used only once
            findCombinations(i + 1,candidates,target - candidates[i],ans,ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombinations(0,candidates,target,ans,ds);

        return ans;
    }
}