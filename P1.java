//Time O(2^(n*target))
//Space O(H)
    class Solution {

    protected void backtrack(
            int target,
            LinkedList<Integer> path,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (target == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(path));
            return;
        } else if (target < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            path.add(candidates[i]);
            this.backtrack(target - candidates[i], path, i, candidates, results);
            // backtrack, remove the number from the combination
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();

        this.backtrack(target, path, 0, candidates, results);
        return results;
    }
}