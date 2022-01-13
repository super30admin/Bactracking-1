// Time Complexity : Exponential towards (4 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/**
 * we have 4 options to choose as operators between digits. We us ebacktraacking for this question
 * We use a number curr to hold current number formed so far and tail to go back to previos case in multiplication
 * We add current digits to stringbuilder and call recursively to get combinations
 * whenever curr is equal to target we add current string formed so far to result
 * In multiplication, we use tail and formula (curr - tail) + (tail * digit) to get valid result
*/




class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0)return result;
        StringBuilder sb = new StringBuilder();
        helper(num, target, 0, 0, 0, sb);
        return result;
    }
    
    private void helper(String num, int target, int index, long curr, long tail, StringBuilder sb){
        
        //base
        if(index == num.length()){
            if(curr == target)result.add(sb.toString());
        }
        
        //logic
        for(int i = index; i < num.length();i++){
            if(i > index && num.charAt(index) == '0')continue;
            long digit = Long.parseLong(num.substring(index, i+1));
            int size = sb.length();
            if(index == 0){
	     //no operator
             helper(num, target, i+1, digit, digit, sb.append(digit)); 
              sb.setLength(size);
            }
            else{
                //add
                sb.append('+' + String.valueOf(digit));
                helper(num, target, i+1, curr + digit, digit, sb);
                sb.setLength(size);
                //sub
                sb.append('-' + String.valueOf(digit));
                helper(num, target, i+1, curr - digit, -digit, sb);
                sb.setLength(size);
                //mul
                sb.append('*' + String.valueOf(digit));
                helper(num, target, i+1,(curr - tail) + (tail * digit) ,(tail * digit) , sb);
                sb.setLength(size);
            }
        }
    }
}