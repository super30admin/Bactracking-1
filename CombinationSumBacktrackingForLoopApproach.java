class Solution {
    List<List<Integer>> res;
    private void helper(int[] candidates, int target, List<Integer> path, int ind) {
        if(target < 0 || ind == candidates.length) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        helper(candidates, target, new ArrayList<>(), 0);
        return res;
    }
}