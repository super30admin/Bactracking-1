// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail, String path){
        // base
        if(index == num.length()) {
            if(calc == target){
                result.add(path);
            }return;
        }
        
        // logic
        for(int i=index; i<num.length(); i++){
            // placeholder preceding zero
            if(i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i+1));
            // 1 12 123 1234 | 2 23 234 | 3 34
            if(index == 0){
                helper(num, target, i+1, curr, curr, path + curr);
            } else{
                // + case
                helper(num, target, i+1, calc+curr, curr, path + '+' + curr);
                
                // - case
                helper(num, target, i+1, calc-curr, -curr, path + '-' + curr);
                
                // * case
                helper(num, target, i+1, calc-tail+tail*curr, tail*curr, path+ '*' + curr);
            }
        }
    }
}