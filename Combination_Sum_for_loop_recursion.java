// TC : O(2^n)
// SC : O(n)
// BackTrack_for_loop_recurse
class Solution {
    List<List<Integer>> result;
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index ; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        
        return result;
    }
}
