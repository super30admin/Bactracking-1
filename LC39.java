class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates.length == 0 || candidates == null) {
            return result;
        }
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    public void helper(int[] candidates, int index, int target, List<Integer> path) {
        
        //base cases
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(target < 0 || index == candidates.length) {
            return;
        }
        
        //logic
        
        //dontChoose
        helper(candidates, index + 1, target, path);
        
        //choose
        path.add(candidates[index]);
        helper(candidates, index, target - candidates[index], path);
        //Backtracking
        path.remove(path.size() - 1);
    }
}