class Solution {
    //tc - 2(m*n) m= no of candidates, n = total sum
    //sc-2(m*n)
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
           result.add(path);
           return;
       }
       if(amount<0 || idx == candidates.length) return;
       //logic    
        //not chooose
       helper(candidates,idx+1,amount,new ArrayList<>(path));

       // if we want to interchange choose and not choose we need to add path.remove(path.size()-1) or
// List<Integer> temp = new ArrayList<>(path); temp.add(candidates[i]); pass temp to choose call 
       //chooose
       path.add(candidates[idx]);
       helper(candidates,idx,amount-candidates[idx],new ArrayList<>(path));
      
    }
}