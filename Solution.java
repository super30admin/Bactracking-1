// Time Complexity : o(2^n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return res;
        helper(candidates, 0, path, target);
        return res;
    }
    private void helper(int[] candidates, int index, List<Integer> path, int target)
    {
        if(index == candidates.length || target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        path.add(candidates[index]);
        helper(candidates, index, path, target - candidates[index]);
        path.remove(path.size()-1);
        helper(candidates, index+1, path, target);
    }
}