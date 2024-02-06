/*
* Approach:
*  1. 2d recursion:
        recursion to extract digits from the string:
            for loop based recursion using pivot.
        recursion to apply different operators
* 
*  2. if pivot == 0, consider the value and tail as extracted number.
        else, recurse and apply operators as follows:
                    value                   tail
             + => value + num               +num
             - => value - num               -num
             * => value-tail+(tail*num)     tail*num
*            / => value-tail+(tail/num)     tail/num
*  3. Also, handle trailing zeros condition,
        conversion of substring 004 -> 4 which is not valid(all characters should be present)
        dont recurse if you have trailing zeros
    
        in division, condition, dont recurse if num == 0(divison by zero)
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(5^n)
    4 - operators + 1 digit case
* 
* Space Complexity: O(n)
    n - len of num string
* 
*/

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> result;

    private void helper(String num, int target, int pivot,
            StringBuilder expression, Long value, Long tail) {
        // base case
        if (pivot == num.length()) {
            if (value == target) {
                result.add(expression.toString());
            }
            return;
        }

        for (int index = pivot; index < num.length(); index++) {
            String substr = num.substring(pivot, index + 1);
            // handling trailing zeros
            if (substr.length() > 1 && substr.charAt(0) == '0') {
                continue;
            }

            Long curr = Long.parseLong(substr);

            if (pivot == 0) {
                expression.append(substr);
                helper(num, target, index + 1, expression, curr, curr);
                expression.delete(expression.length() - substr.length(), expression.length());
            } else {
                expression.append('+');
                expression.append(substr);
                helper(num, target, index + 1, expression, value + curr, curr);
                expression.delete(expression.length() - substr.length() - 1, expression.length());

                expression.append('-');
                expression.append(substr);
                helper(num, target, index + 1, expression, value - curr, -curr);
                expression.delete(expression.length() - substr.length() - 1, expression.length());

                expression.append('*');
                expression.append(substr);
                helper(num, target, index + 1, expression, value - tail + (tail * curr), tail * curr);
                expression.delete(expression.length() - substr.length() - 1, expression.length());
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();

        helper(num, target, 0, new StringBuilder(), null, null);

        return result;
    }
}
