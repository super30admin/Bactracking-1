//TC - Exponential
//SC - O(t/n) (where t is the target and nis the smallest element in candidates )

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        
        if(candidates.length==0) return res;
        
        helper(candidates,target,0,new ArrayList<Integer>());
        
        return res;
    }
    
    private void helper(int[] candidates, int target,int index,List<Integer> path){
        
        
        //Base
        if(target<0) return;
        
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //Logic
        for(int i=index;i<candidates.length;i++){
            
            //action
            path.add(candidates[i]);
            
            //recurse
            helper(candidates,target-candidates[i],i,path);
            
            //backtrack
            path.remove(path.size()-1);
        }
    }
}