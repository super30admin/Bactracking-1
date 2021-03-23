class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length== 0)
            return result;
        
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
        
    }
    private void helper(int[] candidates , int i, List<Integer> path , int target){
        
        if(i == candidates.length || target < 0)
            return ;
        
        if (target == 0){
            result.add(path);
        return;
        }
        
        helper(candidates, i+1, new ArrayList(path), target);
        
        path.add(candidates[i]);
        
        helper(candidates, i, new ArrayList(path), target - candidates[i]);

}

}