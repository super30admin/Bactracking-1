// Time Complexity : O(n 2^n+k), n - no of elements and k is the maximum levels
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * choose not choose approach - not choose does not make any changes to the path or target.
 * BUt before choose , we have to create a sublist of path reference and then add new number to it and pass it to the helper function for next recursive call
*/
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void helper(int[] candidates, int index, List<Integer> path, int target) {
        // base
        if (target < 0 || index == candidates.length)
            return;

        if (target == 0) {
            result.add(path);
            return;
        }
        // logic

        // don't choose
        helper(candidates, index + 1, path, target);

        List<Integer> sublist = new ArrayList<>(path);
        sublist.add(candidates[index]);

        // choose
        helper(candidates, index, sublist, target - candidates[index]);
    }
}

// backtrack approach

// Time Complexity : O(2^n+k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the backtrack approach, we add and remove the unwanted number from the
 * same path list.
 * It reduces the need of creating a new Array list for every level.
 */
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void helper(int[] candidates, int index, List<Integer> path, int target) {
        // base
        if (target < 0 || index == candidates.length)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic

        // don't choose
        helper(candidates, index + 1, path, target);

        // action
        path.add(candidates[index]);

        // choose
        // recurse
        helper(candidates, index, path, target - candidates[index]);
        // backtrack
        path.remove(path.size() - 1);
    }
}

// forloop based

// Time Complexity : O(2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the for loop based approach, MOve from pivot to the end of the array.
 * While calling the helper function we call the i varibale not pivot bcoz pivot
 * is stationary and i is moving in the for loop based approach
 */
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        // base
        if (target < 0 || pivot == candidates.length)
            return;

        if (target == 0) {
            result.add(path);
            return;
        }
        // logic
        for (int i = pivot; i < candidates.length; i++) {
            List<Integer> sublist = new ArrayList<>(path);
            sublist.add(candidates[i]);
            helper(candidates, i, sublist, target - candidates[i]);
        }
    }
}

// backtracking based for loop approach,

// Time Complexity : O(2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the backtracking based for loop approach, MOve from pivot to the end of
 * the array.
 * While calling the helper function we call the i varibale not pivot bcoz pivot
 * is stationary and i is moving in the for loop based approach
 */
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        // base
        if (target < 0 || pivot == candidates.length)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}