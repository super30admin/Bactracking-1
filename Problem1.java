class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (index == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(path);
            return;
        }
        helper(candidates, target, index + 1, new ArrayList<>(path));
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}