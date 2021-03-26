class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        backtracking( candidates, target, 0, new ArrayList<>());
        
        return output;
    }
    
    private void backtracking(int[] candidates, int target, int index, List<Integer> path){
        //base case
        if(target < 0){
            return;
        }
        if(target == 0){
           output.add( new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            
            //recursion
            backtracking(candidates, target - candidates[i], i, path);
            
            //backtrack
            path.remove(path.size()-1);
        }
    }
}