class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = index;  i< candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates,i, path, target-candidates[i]);
            path.remove(path.size()-1);
        }
        
    }
}