// Time Complexity :exponential
// Space Complexity :n^2 where n is no of recursive calls
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//here we are doing recursive calls, using approach choose or not choose
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        // edge
        if (target == 0) {
            result.add(path);
            return;
        }
        if (index >= candidates.length || target < 0)
            return;
        // logic
        // don't choose
        helper(candidates, target, index + 1, new ArrayList<>(path));
        // choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}

// -------------------------------BAcktracking---------------------
// Time Complexity :exponential
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// using same choose not choose approach, but instead of creating new list at
// every recursive call, we
// are removing last element after choose call is completed to get previous
// state of the path

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        // edge
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length || target < 0)
            return;
        // logic
        // don't choose
        helper(candidates, target, index + 1, path);
        // choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);
    }
}

// ---------------------FOR LOOP RECURSION----------------------
// Time Complexity :exponential
// Space Complexity :O(h)stack space and O(n) path list space
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// here we are using pivot and calling method recursively starting from each
// index as for loop manner
// and whenever we find sum target, we add path in our result list
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        // edge
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length || target < 0)
            return;
        // logic
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
} 