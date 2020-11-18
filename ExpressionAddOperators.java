// Time Complexity : O(4^n) exponential time complexity where n is length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We will be using the backtracking approach as we need to explore all the possible solutions and use string builder to avoid
 * creating new string at each node.
 * */


import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    List<String> result;
    int targ;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num==null || num.length()==0) return result;
        targ = target;
        helper(num, new StringBuilder(), 0, 0, 0);
        return result;

    }

    private void helper(String num, StringBuilder sb, long calc, long tail, int index) {
        //base
        if(index==num.length()){
            if(calc==targ){
                result.add(sb.toString());
            }
            return;
        }

        //logic
        for(int i=index; i<num.length(); i++){

            //preceding zero case
            if(index != i && num.charAt(index)=='0') continue;

            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index==0){
                sb.append(curr);
                helper(num, sb, curr, curr, i+1);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(curr);
                helper(num, sb, calc+curr, +curr, i+1);
                sb.setLength(len);

                sb.append("-");
                sb.append(curr);
                helper(num, sb, calc-curr, -curr, i+1);
                sb.setLength(len);

                sb.append("*");
                sb.append(curr);
                helper(num, sb, calc-tail+tail*curr, tail*curr, i+1);
                sb.setLength(len);
            }
        }
    }
}
