class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int maxfreq = 0;

        for(int i=0; i<n; i++){
            if(nums[i] %2 != 0)
            continue;

            int count=0;

            for(int j=0; j<n; j++){
                if(nums[i]==nums[j])
                count++;
            }
            if(count>maxfreq){
                maxfreq=count;
                ans= nums[i];
            }
          else if(count == maxfreq && nums[i]<ans){
            ans = nums[i];
          }
        }
        return ans;
    }
}