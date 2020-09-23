// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Backtracking

class Solution {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0)
            return res;
        
        backtracking(candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    private void backtracking(int[] candidates, int target, int index, List<Integer> path){
        // base case
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }else if (target < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        // recursion
        for(int i=index; i< candidates.length; i++){
            path.add(candidates[i]);
            backtracking(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        } 
    }
}