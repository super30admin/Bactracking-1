import java.util.*;

// Time Complexity : O(n) where n is the size of the decoded string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class ExpressionAddOperators {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }

    private void helper(String num, int index, long calculated, long tail, StringBuilder path, int target) {
        // base
        if (index == num.length()) {
            if (calculated == target) {
                result.add(path.toString());
                return;
            }
        }
        // logic
        for (int i = index; i < num.length(); i++) {
            // preceeding 0 case -- if 0 is not at the index
            if (i != index && num.charAt(index) == '0')
                continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = path.toString().length();
            if (index == 0) {
                path.append(curr);
                helper(num, i + 1, curr, curr, path, target);
                path.setLength(len);
            } else {
                // +
                path.append("+");
                path.append(curr);
                helper(num, i + 1, calculated + curr, curr, path, target);
                path.setLength(len); // backtrack
                // -
                path.append("-");
                path.append(curr);
                helper(num, i + 1, calculated - curr, -curr, path, target);
                path.setLength(len); // backtrack
                // *
                path.append("*");
                path.append(curr);
                helper(num, i + 1, calculated - tail + (tail * curr), tail * curr, path, target);
                path.setLength(len); // backtrack
            }
        }
    }
}
