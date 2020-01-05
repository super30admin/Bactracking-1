// Time Complexity : O(4^N) Exponential
// Space Complexity : O(N) N is the length of the String.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class ExpressionAndOperators {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        //edge cases
        if(num==null){ return result;}

        //logic
        helper("", num, 0, target, 0, 0);
        return result;
    }

    private void helper(String path, String num, int index, int target, long calc, long tail) {
        //base case
        if(calc==target && index==num.length()){
            result.add(path);
            return;
        }

        //logic
        for(int i = index; i<num.length(); i++){

            //Zero case
            if(num.charAt(index)=='0'){
               if(i!=index)
                   break;
            } //Important

            Long current = Long.parseLong(num.substring(index, i+1));
            if(index==0){
                helper(path+current, num, i+1, target, current, current); //Initial case reduces redundant useless conventions
            }
            else {
                helper(path + "+" + current, num, i + 1, target, calc + current, +current);
                helper(path + "-" + current, num, i + 1, target, calc - current, -current);
                helper(path + "*" + current, num, i + 1, target, calc - tail + (tail * current), tail * current);
            }

        }
    }

    public static void main(String... args){
        List<String> result = new ExpressionAndOperators().addOperators("105", 5);
        for(String s: result){
            System.out.println(s);
        }
    }

}
