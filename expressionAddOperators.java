/*
Problem: https://leetcode.com/problems/expression-add-operators/
TC: O(4^n) because we have 4 choices at every step
SC: O(n) for recursive stack



Input: "123", target = 6, Output => "1+2+3", "1*2*3"
Input: "123", target = 9, Output => "12-3"
*/

class Solution {
    List<String> expressions = null;
    
    public List<String> addOperators(String num, int target) {
        expressions = new ArrayList<>();
        
        if (num == null || num.length() == 0)  return expressions;
        
        backtrack(num, 0, target, 0, 0, new StringBuilder());
        return expressions;
    }
    
    private void backtrack(String num, int index, int target, long calcValue, long actionTaken, StringBuilder sb) {
        // Base
        if (index == num.length()) {
            if (calcValue == target) {
                expressions.add(sb.toString());
                return;
            }
        }
        
        // Logic
        for (int i = index; i < num.length(); ++i) {
            /*
                If we didn't have the below index check,
                If num = "105" and target = 5, output would be ["1*0+5" (correct), "10-5" (correct), "1*5" (incorrect -> missing 0)]
                
                when we parseLong("05") => 5 which is not correct. So we must skip numbers that start with 0
            */
            if (i != index && num.charAt(index) == '0') break;
            String curValueStr = num.substring(index, i + 1);
            long curValue = Long.parseLong(curValueStr);
            int sbLen = sb.length();
            
            if (index == 0) {
                backtrack(num, i + 1, target, curValue, curValue, sb.append(curValueStr));
                sb.setLength(sbLen);
            } else {
                // operator +
                backtrack(num, i + 1, target, calcValue + curValue, curValue, sb.append("+").append(curValueStr));
                sb.setLength(sbLen);
                
                // operator -
                backtrack(num, i + 1, target, calcValue - curValue, -curValue, sb.append("-").append(curValueStr));
                sb.setLength(sbLen);
                
                // operator *
                backtrack(num, i + 1, target, ((calcValue - actionTaken) + (actionTaken * curValue)), (actionTaken * curValue), sb.append("*").append(curValueStr));
                sb.setLength(sbLen);
            }
        }
    }
}