package com.ds.rani.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 */

//Approach:Used backtracking, take 4 decisions at every node and calculate the value ,once I visit whole string and
// my calculated value is equal to target then add that in my final result
//Time complexity: o(4^n) as at every node there are 4 decisions
//Space Complexity:o(n)
public class ExpressionAndOperator {
    List<String> result;

    /**
     *
     * @param num
     * @param target
     * @return
     */
    public List<String> addOperators(String num, int target) {

        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking( num, target, sb, 0, 0, 0 );
        return result;
    }

    private void backtracking(String num, int target, StringBuilder sb, long calc, long tail, int currIndex) {
        //base case
        if (currIndex == num.length()) {
            if (calc == target) {
                result.add( sb.toString() );
                return;
            }
        }
        //logic
        for (int i = currIndex; i < num.length(); i++) {
            if (currIndex != i && num.charAt( currIndex ) == '0') break;

            long curr = Long.valueOf( num.substring( currIndex, i + 1 ) );
            int len = sb.toString().length();
            if (currIndex == 0) {
                //action
                sb.append( curr );
                //recurse
                backtracking( num, target, sb, curr, curr, i + 1 );
                //backtrack
                sb.setLength( len );
            } else {
                /*********for  + *************************/
                //action
                sb.append( "+" );
                sb.append( curr );
                //recurse
                backtracking( num, target, sb, calc + curr, curr, i + 1 );
                //backtrack
                sb.setLength( len );

                /*********for  - *************************/
                //action
                sb.append( "-" );
                sb.append( curr );
                //recurse
                backtracking( num, target, sb, calc - curr, -curr, i + 1 );
                //backtrack
                sb.setLength( len );

                /*********for  * *************************/
                //action
                sb.append( "*" );
                sb.append( curr );
                //recurse
                backtracking( num, target, sb, calc - tail + tail * curr, tail * curr, i + 1 );
                //backtrack
                sb.setLength( len );
            }

        }
    }
}

