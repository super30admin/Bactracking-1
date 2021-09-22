// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// traditional recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        // null
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int currSum, int target, int index, List<Integer> path){
        // base
        if(currSum == target){
            //push the path in result
            result.add(path);
            return;
        }
        if(currSum > target || index == candidates.length) return;
        
        //logic
        List<Integer> newList = new ArrayList<>(path);
        newList.add(candidates[index]);
            // case 1:
        helper(candidates, currSum + candidates[index], target, index, newList);
            // case 2:
        helper(candidates, currSum, target, index+1, path);
    }
}

// *****************************************

// Backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        // null
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        // base
        if(target == 0){
            //push the path in result
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length) return;
        
        //logic
        // List<Integer> newList = new ArrayList<>(path);
            // case no choose:
        helper(candidates, target, index+1, path);
        path.add(candidates[index]); // action
        //recursion
            // case choose:
        helper(candidates, target - candidates[index], index, path);
        //backtracking
        path.remove(path.size() - 1);
    }
}

// *****************************************
// for loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        // null
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        // base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //  logic 
        for(int i=index; i < candidates.length; i++){ // i=0
            // action
            path.add(candidates[i]); // common mistake: to add index
            // recursion
            helper(candidates, target-candidates[i], i, path);
            // backtrack
            path.remove(path.size() - 1);    
        }
        
    }
}
