// Time Complexity : O(4^n) we have four choices to make at each point.
// Space Complexity : O(n) at each level current path will be updated with new char value.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() ==0)
            return result;
        
        helper(num, target, 0,0,"",0);
        return result;
    }
    
    
    private void helper(String nums, int target, long earlierCalculated, long tail, String currPath, int index){

        // Base
        // Check the tareget value once all the chars are processed. i.e - index is at the end of string.
        if(index == nums.length()){
            if(earlierCalculated == target){
                result.add(currPath);
                return;
            }else{
                return;
            }
        }
    
        // Logic
        for(int i = index; i< nums.length(); i++){
        
            if(index != i && nums.charAt(index) == '0') break;
            
            long curr = Long.parseLong(nums.substring(index, i+1));
            
            // Initial case has to be handled seperately as the earlier calculated value and tail will be defailt first char in string.
            if(index == 0){
     //  Parameters - input,  tgt, first char will be passed as earlier calculated,
     //  first char will be passed as tail, first value will be added to path,
                helper(nums, target,curr, curr, currPath + curr , i+1 );
            }
            else{
                // case '+'  
                    // EalierCalculated = EalierCalculated+curr;
                    // Tail =  curr
                    // Path = path + curr
               helper(nums, target, earlierCalculated + curr, curr, currPath + "+"+ curr, i+1 );    
                // case '-'
                 // EalierCalculated = EalierCalculated-curr;
                    // Tail =  - curr
                    // Path = path + curr
               helper(nums, target, earlierCalculated - curr, -curr, currPath +"-"+ curr, i+1 );
                // case '*'
                 // Since multiply has higher precedence over '+'' & '-' we have to move to previous level values and perform and then multiply with the current value.
                // earlierCalculated-tail --> gives us the previously calculated value
                // tail*curr --> new value to be added as part of multiplication
                // Add them both to handle operator precedence
                // EalierCalculated = EalierCalculated+curr;
                // Tail =  curr
                // Path = path + curr
               helper(nums, target, earlierCalculated-tail + tail*curr, tail*curr, currPath +"*"+ curr, i+1 );                           
            }
            
            
        }
        
    }
}
