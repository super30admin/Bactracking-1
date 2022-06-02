import java.util.*;

class Solution {
    // Loop based Recursion with Backtracking Solution
    // Time complexity is exponential
    // Space complexity is exponential
    // This solutionn is submitted on leetcode with zero errors
    private List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        // Edge case
        if(num == null || num.length() ==0) return result;
        helper(num,target,0,0,0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, long calc, long tail, int idx, StringBuilder path){
        // base case
        if(idx== num.length()){
            if(calc == target)
                result.add(path.toString());
            return;
        }
        
        // logic
        for(int i = idx; i<num.length();i++){
            long curr = Long.parseLong(num.substring(idx,i+1));
            int length = path.length();
            // Preceding zero case
            if(num.charAt(idx)== '0' && idx!=i) continue;
            
            // Initial num case
            if(idx==0){
                // 1 12 123 1234 12345 case
                // action
                path.append(curr);
                //recurse
                helper(num, target,curr, curr, i+1, path);
                //backtrack
                path.setLength(length);
            } else {
                
                // + case
                // action
                path.append("+");
                path.append(curr);
                //recurse
                helper(num, target, calc+curr, curr, i+1, path);
                //backtrack
                path.setLength(length);
                
                // - case
                // action
                path.append("-");
                path.append(curr);
                //recurse
                helper(num, target, calc-curr, -curr, i+1, path);
                //backtrack
                path.setLength(length);
                
                // * case
                //action
                path.append("*");
                path.append(curr);
                //recurse
                helper(num, target, calc - tail + tail*curr, tail*curr, i+1, path);
                //backtrack
                path.setLength(length);
            }
        }
    }
}