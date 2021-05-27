class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, List<Integer> path, int index){
        //base case
        if(target < 0 || index >= candidates.length){
            return;
        }
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            //action 
            path.add(candidates[i]);
            
            //recurse
            helper(candidates, target - candidates[i], path, i);
            
            //backtarck
            path.remove(path.size() - 1);
        
        }
    }
}
