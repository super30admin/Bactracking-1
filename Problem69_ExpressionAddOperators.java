// Time Complexity : O(n * 4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    List<String> result;
    int target;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();
        this.target = target;
        if(num == null || num.length() == 0)
            return result;
        helper(num, "", 0, 0, 0);
        return result;
    }
    private void helper(String num, String path, long calc, long tail, int index) {
        // base
        if(index == num.length()) {
            if(target == calc) {
                result.add(path);
            }
            return;
        }
        // logic     
        for(int i = index; i < num.length(); i++) {
            // preceding zero
            if(num.charAt(index) == '0' && index != i) break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0) {
                helper(num, path + curr, curr, curr, i + 1);
            } else {
                // +
                helper(num, path + "+" + curr, calc + curr, curr, i + 1);
                // -
                helper(num, path + "-" + curr, calc - curr, -curr, i + 1);
                // *
                helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);
            }
        }
    }
}