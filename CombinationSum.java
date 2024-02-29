// https://leetcode.com/problems/combination-sum/

// Time Complexity: O(2^n)
// Space Complexity: O(n^2)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();

        helper(candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {

        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length) return;

        for(int i = pivot; i < candidates.length; i++) {

            //not choose
            // helper(candidates, i+1, path, target);

            //choose
            path.add(candidates[i]);
            helper(candidates, i, path, target - candidates[i]);

            // backtrack
            path.remove(path.size() - 1);
        }

    }
}