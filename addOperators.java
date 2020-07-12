// Time Complexity :O(3^n) n is the length of the string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> result = new LinkedList<>();

        backtrack(result, num, target, 0, "", 0, 0);

        return result;

    }

    private void backtrack(List<String> result, String num, int target, int cursor, String expr, int currentValue, int prevSignedOperand) {

        if(cursor == num.length()){

            if (currentValue == target) {

                result.add(expr);

            }

        }

        else {

            int operand = Integer.parseInt(""+num.charAt(cursor));

            if(cursor == 0) {

                backtrack(result, num, target, cursor + 1, expr + num.charAt(cursor), operand, operand);

            } else {

                backtrack(result, num, target, cursor + 1, expr + "*" + num.charAt(cursor), currentValue - prevSignedOperand + prevSignedOperand*operand, prevSignedOperand*operand);

                backtrack(result, num, target, cursor + 1, expr + "+" + num.charAt(cursor), currentValue + operand, operand);

                backtrack(result, num, target, cursor + 1, expr + "-" + num.charAt(cursor), currentValue - operand, -operand);

            }

        }

    }

}