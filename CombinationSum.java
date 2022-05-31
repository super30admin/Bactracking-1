// Time Complexity : O(N), N length of input array
// Space Complexity :O(N) + O(N), recursion stack and the path arraylist combined
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CombinationSum {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        //base
        if(i == candidates.length  || target < 0) return;

        //logic
        //Action
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //recursion
        //choose;
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path);
        //backtrack
        path.remove(path.size()-1);
        //no choose
        helper(candidates, target, i+1, path);

    }
}
