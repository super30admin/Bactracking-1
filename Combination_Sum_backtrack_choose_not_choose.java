// TC : O(2^n)
// SC : O(n)
// BackTrack_choose/not_choose
class Solution {
    List<List<Integer>> result;
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        if(target < 0 || index == candidates.length) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        helper(candidates, index+1, target, path);
        
        path.add(candidates[index]);
        
        helper(candidates, index, target - candidates[index], path);
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        
        return result;
    }
}
