class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

      for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
       sum += num;

       maxSum = Math.max(maxSum, sum);

       if(sum < 0) {
        sum = 0;
       }
    }
    return maxSum;
}
}