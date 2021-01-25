// https://leetcode.com/problems/combination-sum/
// Time complexity : O(2^number of candidates) 
// Space complexity : O(target) height of the tree will be at the max target(when one of the candidates is 1) 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int index, int target, List<List<Integer>> res, List<Integer> l) {
        if (target < 0 || index > candidates.length - 1)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(l));
            return;
        }

        l.add(candidates[index]);
        dfs(candidates, index, target - candidates[index], res, l);
        l.remove(l.size() - 1);
        dfs(candidates, index + 1, target, res, l);
    }
}