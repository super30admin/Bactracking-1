//Time Complexity: O(N) or Exponential(in case we are doing Backtracking)
//Space Complexity: O(N) or Exponential(in case we are doing Backtracking)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
   
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0){
            return result;
        }
        helper(num, target, "", 0, 0, 0);
        return result;  
    }
    private void helper(String num, int target, String path, long calc, long tail, int index){
        if(index == num.length()){
            if(calc == target){
                result.add(path);
            }
        }
        
        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && index != i){
                continue;
            }
            Long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
               helper(num, target, path + curr, curr, curr, i + 1); 
            }
            else{
                //+
                helper(num, target, path + "+" + curr, calc + curr, curr, i + 1); 
                //-
                helper(num, target, path + "-" + curr, calc - curr, -curr, i + 1); 
                //*
                helper(num, target, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1); 
            }
        }
        
    }
}