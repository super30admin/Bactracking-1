//Ruccurance with backtracking

// Time Complexity : O(2^n)
// Space Complexity : O(n) recurssive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, 0, target, new ArrayList());

        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path){
        //base
        if(target < 0 || index == candidates.length) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //not choose or 0 case
        helper(candidates, index+1, target, path);

        //choose or 1 case
        //action
        path.add(candidates[index]);

        //recurrance
        helper(candidates, index, target - candidates[index], path);

        //backtrack
        path.remove(path.size()-1);
    }
}


//for loop bvased recurrsion with backtrack
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;

        helper(candidates, 0, target, new ArrayList());

        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path){
        //base
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = index; i<candidates.length; i++) {
            //action
            path.add(candidates[i]);

            //recurrsion
            helper(candidates, i, target - candidates[i], path);

            //backtrack
            path.remove(path.size()-1);
        }
    }
}