// Time Complexity : 2^(m+n), in worst case there will m+n level ( choose all the way and then don't choose for rest). n = length of array & m = target
// Space Complexity : 2^(m+n), in worst case there will m+n level 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : We have the option to choose or not the number, create new path reference for each recursion which adds to the space.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        helper(0,0,candidates,target,new ArrayList<>());
        return result;
    }

    private void helper(int i ,int currSum, int[] candidates, int target, List<Integer> path){
        //base
        if(currSum > target || i == candidates.length) return;
        if(currSum == target){
            result.add(path);
            return;
        }

        //dont choose
        helper(i+1, currSum, candidates, target, new ArrayList<>(path));
        //choose
        path.add(candidates[i]);
        helper(i,currSum + candidates[i], candidates, target, new ArrayList<>(path));
    }
}

//Backtrack to save on the space by using single list.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        helper(0,0,candidates,target,new ArrayList<>());
        return result;
    }

    private void helper(int i ,int currSum, int[] candidates, int target, List<Integer> path){
        //base
        if(currSum > target || i == candidates.length) return;
        if(currSum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        //dont choose
        helper(i+1, currSum, candidates, target, path);
        //choose

        //action
        path.add(candidates[i]);
        helper(i,currSum + candidates[i], candidates, target, path);
        //backtrack
        path.remove(path.size()-1);
    }
}

//For loop based recursion.

// Complexities would remain same, as we are doing the same thing. The tree will be made horizontally as we are iterating over for loop at each level.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        helper(0,target,candidates,new ArrayList<>());
        return result;
    }

    private void helper(int pivot, int target, int[] candidates, List<Integer> path){
        if(target < 0) return;
        if( target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < candidates.length ; i++){
            path.add(candidates[i]);
            helper(i, target - candidates[i], candidates,path);
            path.remove(path.size()-1);
        }
       
    }
}