// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1 - Using Recursion - choose, not choose approach
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

        //not choose
        helper(candidates, target, currSum, index+1, path);

        //choose
        List<Integer> list = new ArrayList<>(path);
        list.add(candidates[index]);
        currSum += candidates[index];
        helper(candidates, target, currSum, index, list);
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2 - Using backtracking - choose, not choose approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int currSum, int index, List<Integer> path) {
        if(currSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(currSum > target || index == candidates.length) {
            return;
        }

        //not choose
        helper(candidates, target, currSum, index+1, path);

        //choose
        path.add(candidates[index]);
        currSum += candidates[index];
        helper(candidates, target, currSum, index, path);
        path.remove(path.size()-1);
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 3 - Using backtracking - for loop recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int currSum, int index, List<Integer> path) {
        if(currSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(currSum > target || index == candidates.length) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            //List<Integer> temp = new ArrayList<>(path);
            path.add(candidates[i]);
            currSum += candidates[i];
            helper(candidates, target, currSum, i, path);
            path.remove(path.size()-1);
            currSum -= candidates[i];
        }
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 4 - for loop recursion
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

        for(int i = index; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            currSum += candidates[i];
            helper(candidates, target, currSum, i, temp);
            currSum -= candidates[i];
        }
    }
}