class Solution {
    //tc&sc-o(2(m*n))
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates.length == 0) return result;
       helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int amount,int pivot,List<Integer> path)
    {
     //basecase
        if(amount == 0) 
        {
            result.add(new ArrayList<>(path);
            return;
        }
        if(amount <0) return;
      //logic  
        for(int i = pivot;i<candidates.length;i++)
        {
            path.add(candidates[i]);
            helper(candidates,amount-candidates[i],i,path);
            path.remove(path.size()-1);
        }
        
    }
 
}