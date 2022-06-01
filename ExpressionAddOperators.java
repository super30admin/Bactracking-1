// Time Complexity: Exponential
// Space Complexity:
// Did this code successfully run on Leetcode : Yes

import java.awt.*;
import java.util.ArrayList;

public class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, long calc, long tail, int idx, String path) {
        //base
        if(idx == num.length()) {
            if(calc == target) {
                result.add(path);
            }
            return;
        }
        //logic
        for(int i = idx; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(idx, i+1));
            //preceeding zero
            if(num.charAt(idx) == '0' && idx != i) {
                continue;
            }
            if(idx == 0) {
                helper(num, target, curr, curr, i + 1, path + curr);
            }
            else {
                // +
                helper(num, target, calc + curr, curr, i + 1, path + "+" + curr);
                // -
                helper(num, target, calc - curr, -curr, i + 1, path + "-" + curr);
                // *
                helper(num, target, calc - tail + tail * curr, tail * curr, i + 1, path + "*" + curr);
            }
        }
    }
}
