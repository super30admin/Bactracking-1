// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Using Recursion 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int currSum, int index, List<Integer> path) {
        if(currSum == target) {
            result.add(path);
            return;
        }

        if(currSum > target || index == candidates.length) {
            return;
        }

      
        helper(candidates, target, currSum, index+1, path);
        List<Integer> list = new ArrayList<>(path);
        list.add(candidates[index]);
        currSum += candidates[index];
        helper(candidates, target, currSum, index, list);
    }
}
