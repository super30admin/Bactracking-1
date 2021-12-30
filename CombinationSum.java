// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We see that for each candidate we have two choices, take or not take
// we write the recursive approach for the same
// we expand on it by doing the backtracking i.e remove the element that doesnt give the answer

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length || target < 0)
            return;
        helper(candidates, target, index + 1, path);
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);
    }
}

// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We use the iterative recursion as our second approach
// we write the recursive approach for the same
// we expand on it by doing the backtracking i.e remove the element that doesnt
// give the answer
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}