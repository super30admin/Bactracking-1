class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    
    public void helper(int[] candidates,int pivot, int amt, List<Integer> path){
        //base case
        if(amt < 0 ) return;
        if(amt==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,i,amt - candidates[i],path);
            path.remove(path.size()-1);
        }
        
    }
}
