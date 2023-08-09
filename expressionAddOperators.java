// Time Complexity : O(4^n), n is the length of the candidates array
// Space Complexity : O(n), n is the length of the candidates array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Recursively generate all combinations of the string and check if the result is equal to target.
 * 2. On the fly, evaluate the expresion according to BODMAS rule.
 * 3. If the expression is equal to target, add it to result.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, 0, 0, 0, target, new StringBuilder(), result);
        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, 
    int target, StringBuilder path, List<String> result){
        if(pivot == num.length()){
            if(target == calc){
                result.add(path.toString());
            }
            return;
        }

        for(int i=pivot; i<num.length(); i++){
            String str = num.substring(pivot, i+1);
            if(str.charAt(0) == '0' && pivot != i)
                continue;

            long curr = Long.parseLong(str);
            int len = path.length();
            if(pivot == 0){
                path.append(curr);
                helper(num, i+1, curr, curr, target, path, result);
                path.setLength(len);
            }else {

                path.append("+");
                path.append(curr);
                helper(num, i+1, calc + curr, curr, target, path, result);
                path.setLength(len);

                path.append("-");
                path.append(curr);
                helper(num, i+1, calc - curr, -curr, target, path, result);
                path.setLength(len);

                path.append("*");
                path.append(curr);
                helper(num, i+1, calc - tail + tail * curr, tail * curr, target, path, result);
                path.setLength(len);
            }
        }
    }
}