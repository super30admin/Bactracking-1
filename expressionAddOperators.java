// Time Complexity : O(N^2)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    
    private void helper(String num, int target, long calc, long tail, int pivot, String path){
        //base
        if(pivot==num.length()){
            if(calc==target){
                result.add(path);
            }
            return;
        }
        
        //logic
        for(int i=pivot;i<num.length();i++){
            
            long currSum = Long.parseLong(num.substring(pivot, i+1));
            
            //precedding zero
            if(num.charAt(pivot)=='0' && pivot!=i){
                continue;
            }
            
            //for expressions
            if(pivot==0){
                helper(num, target, currSum, currSum, i+1, path+currSum);
            } else{
                //'+'
                helper(num, target, calc+currSum, currSum, i+1, path+ "+" +currSum);
                //'-'
                helper(num, target, calc-currSum, -currSum, i+1, path+ "-" +currSum);
                //'*'
                helper(num, target, calc-tail+tail*currSum, tail*currSum, i+1, path+ "*" +currSum);
            }
        }
    }
}