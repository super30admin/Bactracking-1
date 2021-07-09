class CombinationSum {

    //Time: Exponential Algo
    //Space: Optimized by backtracking

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates.length == 0 || candidates == null) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;

    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {

        if (target < 0 || i == candidates.length) return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //Case 1: Dont pick
        helper(candidates, target, i + 1, path);
        //Case 2: Pick
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path);

        //Backtrack
        path.remove(path.size() - 1);

    }

}