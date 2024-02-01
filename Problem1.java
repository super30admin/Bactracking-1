
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 code generates all possible combinations of expressions by recursively exploring all possible
 choices of operations between digits in the input string
 num, and returns those expressions that evaluate to the target sum.
 *
 */

import java.util.ArrayList;
import java.util.List;
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper(num, target, 0, "", 0, 0);
        return ans;
    }

    public void helper(String num, int target, int start, String sb, long curr, long prev) {
        if (start == num.length() && curr == target) {
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < num.length(); i++) {
            // when two consecutive 0s are present, we have to break the loop.
            if (i != start && num.charAt(start) == '0')
                break;

            long temp = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                helper(num, target, i + 1, sb + (temp), temp, temp);
            } else {
                helper(num, target, i + 1, sb + ("+") + (temp), curr + temp, temp);
                helper(num, target, i + 1, sb + ("-") + (temp), curr - temp, -temp);
                var multi = (curr - prev) + (prev * temp);
                helper(num, target, i + 1, sb + ("*") + (temp), multi, temp * prev);
            }
        }
    }
}