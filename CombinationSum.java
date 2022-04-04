class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target, new ArrayList<>(), 0);    
        return result;
    }
    
    public void helper(int[] candidates, int target, List<Integer> path, int index){
        
        //base
        if(index==candidates.length || target < 0){
            return;
        }
        if(target==0){
            result.add(path);
            return;
        }
        
        //logic
        
        //not choose
        helper(candidates,target, new ArrayList<>(path), index+1);
        
        //choose
        path.add(candidates[index]);
        helper(candidates,target-candidates[index], new ArrayList<>(path), index);        
    }
}
