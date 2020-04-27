// Time Complexity : O(m *(2^n))
// Space Complexity : O(1) //excluding result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    // Backtracking
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, StringBuilder sb, long cal, long tail, int index){
        // base
        if(index == num.length() && cal == target){
            result.add(sb.toString());
            return;
        }
        // logic
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0'){
                break;
            }

            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length(); // set length for backtracking

            if(index == 0){
                sb.append(curr);
                helper(num, target, sb, curr,curr, i+1);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(curr);
                helper(num, target, sb, cal + curr, curr, i+1);
                sb.setLength(len);

                sb.append("-");
                sb.append(curr);
                helper(num, target, sb, cal - curr, 0-curr, i+1);
                sb.setLength(len);

                sb.append("*");
                sb.append(curr);
                helper(num, target, sb, (cal -tail) + (curr * tail), curr * tail, i+1);
                sb.setLength(len);

            }

        }
    }
}
