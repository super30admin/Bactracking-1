//Time complexity: O(4^N), where N is the length of num.
//Space complexity: O(N)

import java.util.*;

class Solution2 {
    List<String> output;
    public List<String> addOperators(String num, int target) {
        output = new ArrayList<>();
        if(num == null || num.length() == 0) return output;
        helper(num, target, 0, new StringBuilder(), 0, 0);
        return output;
    }
    
    public void helper(String num, long target, int index, StringBuilder expression, long prev, long result) {
        //base case
        if(index == num.length()) {
            if(result == target) output.add(expression.toString()); 
            return;
        }
        
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) return;
            Long curr = Long.parseLong(num.substring(index, i+1)); 
            int size = expression.length(); 
            if(index == 0) {
                expression.append(curr);
                helper(num, target, i+1, expression, curr, curr); 
                expression.setLength(size); 
            } else {
                //addition
                expression.append("+");
                expression.append(curr);
                helper(num, target, i+1, expression, curr, result+curr);
                expression.setLength(size); 
                //subtraction
                expression.append("-");
                expression.append(curr);
                helper(num, target, i+1, expression, -curr, result-curr);
                expression.setLength(size); 
                //multiplication
                expression.append("*");
                expression.append(curr);
                helper(num, target, i+1, expression, prev*curr, result-prev+prev*curr);
                expression.setLength(size); 
            }
        }
    }
    
}