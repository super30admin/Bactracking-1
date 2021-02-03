// Time Complexity : O(2n) (exponantial)
// Space Complexity : O(n) where n is the length of the path + O(n) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Used recursion + backtracking
// Chose and dont chose approach. When target is met, add to the result and stop recursion thread there.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        if(candidates == null) return result;
        helper(candidates, new ArrayList(), 0, target);
        return result;
    }
    public void helper(int[] candidates, List<Integer> path, int i, int target){

        if(i >= candidates.length || target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(path)); //Need a deep copy here
            return; //dont process any further. If we do, duplicates will be reported for next element dont chose option
        }

        //chose
        path.add(candidates[i]);
        helper(candidates, path, i, target - candidates[i]);

         //dont chose
        path.remove(path.size()-1); //backtracking
        helper(candidates, path, i+1, target);


    }
}
