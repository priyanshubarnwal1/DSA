class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = next(slow);          // move 1 step
            fast = next(fast);          // move 2 steps
            fast = next(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int next(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}