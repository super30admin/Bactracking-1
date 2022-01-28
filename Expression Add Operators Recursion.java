// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, "", 0, 0, 0, target);
        return result;
    }
    
    private void helper(String num, String path, int index, long calc, long tail , int target){
        // base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
                return;
            }
        }
        
        // logic
        for(int i = index; i < num.length(); i++){
            // preceding zero
            if(i != index && num.charAt(index) == '0') continue;
            
            long curr = Long.parseLong(num.substring(index, i + 1));      
            if(index == 0){
                helper(num, path + curr, i + 1, curr, curr, target);
            }else{
                // +
                helper(num, path + "+" + curr, i + 1, calc + curr, curr, target);
                
                // -
                helper(num, path + "-" + curr, i + 1, calc - curr, -curr, target);

                // *
                helper(num, path + "*" + curr, i + 1, calc - tail + (tail * curr), tail * curr, target);

            }
        }
    }
}