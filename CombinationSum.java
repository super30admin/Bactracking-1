class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return res;
        
    }
    private void  helper(int[] candidates, int pivot, List<Integer> path, int target){
        if(pivot == candidates.length || target<0) return;
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<candidates.length;i++){
             path.add(candidates[i]);
             helper(candidates, i, path, target-candidates[i]);
             path.remove(path.size()-1);

        }
        
      
    }
}
