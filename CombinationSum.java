class Solution {
    /**
     * Backtrack.
     * Choose, not choose
     * Action, recurse, backtrack. -> Save the oath space and deepcopies
     * TC- Exponential
     */
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        backtrack(candidates, target, 0, 0, new ArrayList());
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int index, List<Integer> path) {
        //base
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        if (sum > target || index == candidates.length) return;

        // logic
        //no-choose
        backtrack(candidates, target, sum, index + 1, path);
        //Choose,
        path.add(candidates[index]);

        backtrack(candidates, target, sum + candidates[index], index, path);
        path.remove(path.size() - 1);
    }
}
