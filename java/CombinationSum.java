// Time Complexity : exponential
// Space Complexity : O(n) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Similar to coin change problem, we either choose or don't choose each candidate and we add it to our path
backtrack by removing last added elements and if target hits 0 then we add it to our final result
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path) {

        //base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        //dont choose
        helper(candidates, index + 1, target, path);
        //choose
        path.add(candidates[index]);
        helper(candidates, index, target - candidates[index], path);

        path.remove(path.size() - 1);
    }
}

Approach 2------------------backtrack+for loop

//same complexity
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path) {

        //base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}