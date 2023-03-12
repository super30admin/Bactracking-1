class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        // base
        if(target < 0 || i == candidates.length) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        helper(candidates, target, i + 1, path);

        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path);
        path.remove(path.size() - 1);
    }
}