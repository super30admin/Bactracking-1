// Time Complexity : O(4^n)
// Space Complexity : O(h), where h is the depth of recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*

    Approach:

    We use a recursive approach to explore all possible combinations of operators and numbers.

    When code reaches the end of the string, it checks if the accumulated value plus the previous
    value equals the target. If it does, the current expression is added to the result list.

    For each position in the string, it considers three possibilities: adding '+', '-', or '*'
    between the current and next numbers and recursively explores each option, updating the value
    and previous accordingly.

 */



import java.util.*;

class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperators(num, target, result, 0, 0, 0, "");
        return result;
    }

    private void addOperators(String num, int target, List<String> result, int index, long value, long previous, String current) {
        if(index == num.length()) {
            if(value + previous == target) {
                result.add(current);
            }
            return;
        }

        int end = num.length();
        if(num.charAt(index) == '0') {
            end = index + 1;
        }

        for(int i = index + 1; i <= end; i ++) {
            long currentValue = Long.valueOf(num.substring(index, i));

            if(index == 0) {
                addOperators(num, target, result, i, 0, currentValue, String.valueOf(currentValue));
                continue;
            }

            // Add +
            addOperators(num, target, result, i, value + previous, currentValue, current + "+" + currentValue);
            // Add -
            addOperators(num, target, result, i, value + previous, -currentValue, current + "-" + currentValue);
            // Add *
            addOperators(num, target, result, i, value, previous * currentValue, current + "*" + currentValue);
        }
    }
}