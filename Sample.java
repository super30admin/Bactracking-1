// # Bactracking-1


// ## Problem1 
// Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity : O(2 ^ (m+n))
// Space Complexity : O(2 ^ (m+n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.



class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path){
        if(index == candidates.length || target < 0) return; 
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        helper(candidates, target, index+1, path);
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        path.remove(path.size()-1);
        }
}