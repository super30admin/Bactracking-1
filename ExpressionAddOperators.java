package backtracking1;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	//Time Complexity : O(3^n), where n is length of string num and 3 operators
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, "", 0, 0, 0, target, res);
        return res;
    }
    
    private void helper(String num, String path, int idx, long calc, long tail, int target, List<String> res) {
        // base
        if(idx == num.length()) {
            if(calc == target)
                res.add(path);
            return;
        }
        
        // logic
        for(int i=idx; i<num.length(); i++) {
            if(i != idx && num.charAt(idx) == '0')
                continue;
            long curr = Long.parseLong(num.substring(idx, i + 1));
            if(idx == 0)
                helper(num, path + curr, i + 1, curr, curr, target, res);
            else {
                // +
                helper(num, path + "+" + curr, i + 1, calc + curr, curr, target, res);
                
                // -
                helper(num, path + "-" + curr, i + 1, calc - curr, -curr, target, res);
                
                // *
                helper(num, path + "*" + curr, i + 1, calc - tail + (tail * curr), tail * curr, target, res);
            }
        }
    }
}
