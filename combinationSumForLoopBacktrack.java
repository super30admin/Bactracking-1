//tc: exponential ( 2 ^ n) sc: size of recursive stack
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) {
            return;
        }
       
        for(int i = index; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}