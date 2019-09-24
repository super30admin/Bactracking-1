
// Time Complexity: O(3^n) we could go down recursion each with + and - and *
// Space Complexity: Used by recursion stack plus the space required to store results which could also be O(3^n) in worst case.

// *Approach*
// Using backtracking to generate all possible expressions, also keeping track of evaluated expression on the fly.
// When given string is parsed, we match this evaluated value with target, if matched add to result

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
