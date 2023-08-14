class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList<>();
        if (candidates.length==0 || candidates==null) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int pivot, int amount, List<Integer> path){
        
        //base case
        if(amount ==0){
            result.add(path);
            return;
        }
        if(amount<0 || pivot==candidates.length){
            return;
        }
        
        //logic
        for(int i=pivot; i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates, i, amount-candidates[i], new ArrayList<>(path));
            path.remove(path.size()-1);
        }
        
    }
    
}
