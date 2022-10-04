class Solution {
     //tc&sc-o(2(m*n))
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates,0,target,new ArrayList<>());
        return result;
        
    }
   private void helper(int[] candidates,int idx,int amount,List<Integer> path)
    {
        //base case
       if(amount == 0) 
       {
           result.add(new ArrayList<>(path));
           return;
       }
       if(amount<0 || idx == candidates.length) return;
       //logic    
        //not chooose
       helper(candidates,idx+1,amount,path);
       //chooose
       //action
       path.add(candidates[idx]);
      // recurse
       helper(candidates,idx,amount-candidates[idx],path);
       //backtracking
       path.remove(path.size()-1);
       
      
    }
}