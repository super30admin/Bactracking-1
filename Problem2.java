//Problem2
//Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

// Time complexity - O(4^n) Space complexity O(n * 4 ^ n) where n is string size
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num == null || num.isEmpty())
            return res;
        
        addOperators(num, target, 0, "", 0, 0);
        return res;
    }
    
    private void addOperators(String num, int target, int idx, String currString, long sum, long tail){
       
        if(idx == num.length()){
            if(target == sum){
                res.add(currString);
                
            }
            return;
        }
        
        for(int i = idx; i < num.length();i++){
            // case with preceding zero
            if(idx != i && num.charAt(idx) == '0') break;
            long curr = Long.parseLong(num.substring(idx, i + 1));
             
            if(idx == 0){
               addOperators(num, target, i + 1, currString + curr, curr, curr); 
            }else{
               addOperators(num, target, i + 1, currString +"+"+ curr, sum + curr, curr); 
                addOperators(num, target, i + 1, currString +"-"+ curr, sum - curr, -curr); 
                addOperators(num, target, i + 1, currString +"*"+ curr, sum - tail + tail * curr, tail * curr); 
                
            }
        }
    }
}