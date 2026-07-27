// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//           int n = nums.length;

//         for(int i=0; i<n; i++){
//           int  count = 0;
            
//             for(int j=0; j<n; j++){
//                 if(nums[i] == nums[j]){
//                 count++;
//             }
//             }
//             if(count > n/3 && !ans.contains(nums[i])){
//             ans.add(nums[i]);
//         }
//         }
//         return ans;
//     }
// }


// optimal

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        // First Pass: Find possible majority candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }

            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            else {
                count1--;
                count2--;
            }
        }

        // Second Pass: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}