class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results =  new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return results;
    }
    public void helper(int[] candidates, int target, int start, List<Integer> res){
        // base case I
        if(target == 0){
            results.add(new ArrayList<>(res));
            return;
        }
        // base case II
        if(target < 0){
            return;
        }
        
        // backtracking with dfs to search goog combination
        for(int i = start; i < candidates.length; i++){
            res.add(candidates[i]);
            helper(candidates, target - candidates[i], i, res);
            res.remove(res.size() - 1);
        }
    }
}