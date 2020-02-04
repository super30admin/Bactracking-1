// Time Complexity : O(2 ^ mn) where m is target and n is the length of the candidates array
// Space Complexity : O(n) where n is the length of the candidates array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Backtracking

class combinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        backtrack(candidates, target, 0, new ArrayList());
        return ans;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> list) {
        // base case
        if (target == 0) {
            ans.add(new ArrayList(list));
        }
        if (target < 0) return;
        // logic
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}