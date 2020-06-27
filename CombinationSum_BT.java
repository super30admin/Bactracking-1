// Time Complexity : O(2^n) --> where n is length of input array
// Space Complexity : O(n)
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
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index) {
        // base case
        if (sum == trgt) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if (sum > trgt) return;
        
        // logic
        for (int i = index; i < candidates.length; i++) {
            // action
            temp.add(candidates[i]);
            
            // recurse
            backtrack(candidates, temp, sum + candidates[i], i);
            
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}