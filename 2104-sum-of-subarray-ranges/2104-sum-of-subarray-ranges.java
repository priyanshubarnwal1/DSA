class Solution {
    public long subArrayRanges(int[] nums) {
         int n = nums.length;

        long maxSum = 0;
        long minSum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Greater or Equal
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            maxSum += (long) nums[i] * leftCount * rightCount;
        }

        st.clear();

        // Previous Smaller or Equal
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            minSum += (long) nums[i] * leftCount * rightCount;
        }

        return maxSum - minSum;
    }
}