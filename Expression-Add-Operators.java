import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n*4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution2 {
    List<String> result;
    int tar;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        tar = target;
        helper(num, 0, 0, 0, "");

        return result;
    }

    private void helper(String num, int index, long calc, long tail, String path) {
        // base
        if (index == num.length()) {
            if (calc == tar) {
                result.add(path);
                return;
            }
        }

        // logic
        for (int i = index; i < num.length(); i++) {
            // preceding zero
            if (num.charAt(index) == '0' && index != i)
                continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, i + 1, curr, curr, path + curr);
            } else {
                // +
                helper(num, i + 1, calc + curr, curr, path + "+" + curr);
                // -
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr);
                // *
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}