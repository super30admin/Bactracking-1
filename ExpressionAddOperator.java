class Solution {
    /**
     * Recursion - backtracking
     * Use for loop based resursion to creating the numbers 1 12 123 1234 etc.
     * Use Calculations for each +, - and *
     * Backtracking - string bulder for path.
     * TC: Exponential
     * SC: Exponential or O(nums.length?)
     */
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String nums, int target, int idx, long currNum, long tail, String path) {
        // base

        if (idx == nums.length()) {
            if (target == currNum) {
                result.add(path);
            }
            return;
        }

        //logic
        for (int i = idx; i < nums.length(); i++) {
            // preceding zero case
            if (nums.charAt(idx) == '0' && idx != i) continue;

            long curr = Long.parseLong(nums.substring(idx, i + 1));

            if (idx == 0) {
                helper(nums, target, i + 1, curr, curr, path + curr);
            } else {
                // +
                helper(nums, target, i + 1, curr + currNum, curr, path + "+" + curr);

                // -
                helper(nums, target, i + 1, currNum - curr, -curr, path + "-" + curr);

                // *
                helper(nums, target, i + 1, currNum - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}
