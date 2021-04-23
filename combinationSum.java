// runtime :exponential
//space : Just the space to the call stack size

class Solution {
    protected void backtrack(int[] candidates,int remain,int start,List<List<Integer>> result,LinkedList<Integer> addcomb )
    {
        if(remain==0)
        {
            result.add(new ArrayList<Integer>(addcomb)); // Otherwise all the elements would be removed
            return;
        }
        else if(remain<0)
            return;
        for(int i=start;i<candidates.length;++i)
        {
            addcomb.add(candidates[i]);
            this.backtrack(candidates,remain-candidates[i],i,result,addcomb);
            addcomb.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        LinkedList<Integer> addcomb=new LinkedList<Integer>();
        this.backtrack(candidates,target,0,result,addcomb);
        return result;
    }
    

}
