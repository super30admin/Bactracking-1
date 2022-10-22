package Bactracking-1;

public class problem1 {
    // Time Complexity : O(2^n), n is no. of elements in an array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return res;
        
        helper(candidates,target, 0, new ArrayList<>());
        
        return res;
    }
    
    public void helper(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target < 0) return;
        
        if(target == 0){
            res.add(path);
            return;
        }
        
        //logic
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, new ArrayList<>(path));
            path.remove(path.size()-1);
        }
        
    }
}
