// Time Complexity : O(4^(N))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For each node we have 4 options - Add, Subtract, Multiply, Append
*/

class Solution {
    
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        addOperators(num, "", 0, target, 0, 0);
        return result;
    }
    
    
    public void addOperators(String num, String expression, int index, int target, long value, long last){
        
        if (index == num.length() && value == target){
            result.add(expression);
            return;
        }
        
        for (int i=index; i<num.length(); i++){
            
            if (num.charAt(index) == '0' && index != i) continue; 
            
            long curr = Long.parseLong(num.substring(index, i+1));
            
            if (index == 0){
                addOperators(num, expression + curr, i+1, target, curr, curr);
            } else {
                addOperators(num, expression + "+" + curr, i+1, target, value + curr, curr);
            
                addOperators(num, expression + "-" + curr, i+1, target, value - curr, -curr);

                addOperators(num, expression + "*" + curr, i+1, target, value - last + last * curr, last * curr);  
            }   
        }  
    }
    
}
