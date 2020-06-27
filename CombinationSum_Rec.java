// Time Complexity : O(2^n) --> where n is length of input array
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode (39): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int trgt;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        trgt = target;
        result = new ArrayList<>();
        
        // edge
        if (candidates == null || candidates.length == 0) return result;
        helper(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void helper(int[] candidates, List<Integer> temp, int sum, int index) {
        // base case
        if (sum == trgt) {
            result.add(temp);
            return;
        }
        
        if (sum > trgt || index == candidates.length) return;
        
        // logic
        // don't choose candidate
        helper(candidates, new ArrayList<>(temp), sum, index + 1);
        
        // choose candidate
        temp.add(candidates[index]);
        helper(candidates, new ArrayList<>(temp), sum + candidates[index], index);
    }
}