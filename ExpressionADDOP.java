// Time Complexity : O(n*4^n) where n is the length of the string num
// Space Complexity : O(n) where n is the length of the string num
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, "", result, 0, 0, 0);
        return result;
    }
    
    private void backtrack(String num, int target, String currStr, List<String> result, int index, long sum, long tail) {
        if(index == num.length() && target == sum)
            result.add(currStr);
        
        for(int i = index; i < num.length(); i++) {
            if(i != index && num.charAt(index) == '0') break;           // Multiple 0's at the beginning ignored
            
            long curr = Long.parseLong(num.substring(index, i+1));      // Get current to process 
            
            if(index == 0) {
                backtrack(num, target, currStr + curr, result, i+1, curr, curr );
            }
            else {
                 backtrack(num, target, currStr + "+" + curr, result, i+1, sum+curr, curr); //+ operator
                 backtrack(num, target, currStr + "-" + curr, result, i+1, sum-curr, -curr); // - operator
                 backtrack(num, target, currStr + "*" + curr, result, i+1, sum-tail+(tail*curr), tail * curr); //* operator
            }
        }
    }
}