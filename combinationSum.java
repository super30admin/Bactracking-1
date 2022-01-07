// Time Complexity = O(2^n)
// Space Complexity = O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is the recursive approach with backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }

        //logic: 0-1 template
        // 0 case : Do not choose case
        helper(candidates, target, index+1, path);

        // 1 case : Choose case
        int val = candidates[index];
        path.add(val);
        helper(candidates, target-val, index, path);

        //backtrack
        path.remove(path.size()-1);
    }
}


// This is the recursive approach, without backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(path);
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }

        //logic: 0-1 template
        // 0 case : Do not choose case
        helper(candidates, target, index+1, path);

        // 1 case : Choose case
        int val = candidates[index];
        List<Integer> newList = new ArrayList<>(path);
        newList.add(val);
        helper(candidates, target-val, index, newList);
    }
}

// This is the iterative recursive approach with backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }

        //logic: Iterative recursive template
        for (int i=index; i<candidates.length; i++) {
            int val = candidates[i];
            path.add(val);
            helper(candidates, target-val, i, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}