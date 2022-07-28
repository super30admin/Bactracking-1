import java.util.ArrayList;
import java.util.List;

//Time Complexity: exponential.
//Space Complexity: Recursive stack space.

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;

        helper(num, target, 0, "", 0, 0);
        return result;
    }

    private void helper(String num, int target, int index, String path, long calc, long tail) {
        // base
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        // logic
        for (int i = index; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, target, i + 1, path + curr, curr, curr);
            } else {
                // + case
                helper(num, target, i + 1, path + '+' + curr, calc + curr, curr);
                // - case
                helper(num, target, i + 1, path + '-' + curr, calc - curr, -curr);
                // - case
                helper(num, target, i + 1, path + '*' + curr, calc - tail + tail * curr, tail * curr);
            }
        }
    }
}