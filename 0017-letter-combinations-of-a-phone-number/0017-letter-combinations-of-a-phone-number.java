class Solution {
   void func(
        int ind,
        String digits,
        String[] map,
        List<String> ans,
        StringBuilder ds
    ) {

        // All digits processed
        if (ind == digits.length()) {
            ans.add(ds.toString());
            return;
        }

        // Get current digit
        int digit = digits.charAt(ind) - '0';

        // Get corresponding letters
        String letters = map[digit];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            // Pick
            ds.append(letters.charAt(i));

            // Move to next digit
            func(ind + 1, digits, map, ans, ds);

            // Backtrack
            ds.deleteCharAt(ds.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        StringBuilder ds = new StringBuilder();

        func(0, digits, map, ans, ds);

        return ans;
        
    }
}