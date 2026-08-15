// class Solution {
//     public int splitArray(int[] nums, int k) {
//          int low = 0;
//         int high = 0;

//         for (int num : nums) {
//             low = Math.max(low, num);
//             high += num;
//         }

//         // Brute force
//         for (int maxSum = low; maxSum <= high; maxSum++) {

//             int parts = 1;
//             int sum = 0;

//             for (int num : nums) {

//                 if (sum + num <= maxSum) {
//                     sum += num;
//                 } else {
//                     parts++;
//                     sum = num;
//                 }
//             }

//             if (parts <= k) {
//                 return maxSum;
//             }
//         }

//         return -1;
//     }
// }

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int num:nums){
            low= Math.max(low , num);
            high += num;
        }
        while(low<= high){
            int mid = low + (high -low)/2;
              if (countPartitions(nums, mid) > k) {
            low = mid+1;
        } else {
            high = mid-1;
        }
    }
    return low;
}
    public int countPartitions(int[]nums, int maxSum){
        int partitions = 1, sum = 0;
        for(int num : nums){
            if(sum + num <= maxSum){
                sum+= num;
            } else{
                partitions++;
                sum= num;
            }
        }
        return partitions;
    }
}