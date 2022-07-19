// Time Complexity : Time Complexity: O(N^(T/M + 1)) where Let N is no of candidates, T is target and M be the minimum among candidates
// Space Complexity : O(T/M)
// Did this code successfully run on Leetcode : Yes

///Problem statement: https://leetcode.com/problems/combination-sum/

class Problem1 {

    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
}