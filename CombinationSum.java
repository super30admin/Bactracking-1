// Time Complexity : O(k * 2^n) wher k is max length of candidates, and n is leaf nodes
// Space Complexity : O(k * 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : some difficulty with concept but understood now


// Your code here along with comments explaining your approach

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();

        //edge
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, new ArrayList<>(), target);


        return result;

    }
    public void helper(int[] candidates, int i, List<Integer> path, int target){
        //base
        if(i == candidates.length || target < 0) return;
        if(target == 0){
            result.add(path);
            return;
        }

        //dont choose
        helper(candidates, i+1, new ArrayList(path), target);


        //choose

        //backtrack
        path.add(candidates[i]);
        helper(candidates, i, new ArrayList(path), target - candidates[i]);
    }
}