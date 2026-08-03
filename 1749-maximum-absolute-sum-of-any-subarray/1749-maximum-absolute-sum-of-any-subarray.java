class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding = 0;
        int minEnding = 0;

        int maxSum = 0;
        int minSum = 0;
        
        for(int num:nums){

            // max
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            //min
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);
        }

        return Math.max(maxSum, -minSum);
    }
}