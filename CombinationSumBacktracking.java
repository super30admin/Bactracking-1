class Solution {
    List<List<Integer>> res;
    private void helper(int[] candidates, int target, int ind, List<Integer> path) {
        if(target < 0 || ind == candidates.length) {
            return;
        }

        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // choose
        path.add(candidates[ind]);
        helper(candidates, target - candidates[ind], ind, path);
        path.remove(path.size() - 1);

        // don't choose
        helper(candidates, target, ind + 1, path);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        helper(candidates, target, 0, new ArrayList<>());
        return res;

    }
}