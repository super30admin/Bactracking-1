//TC: O(m+n)
//m=target ,n=size of candidates array
//SC: O(m+n)
class Solution {
    List<List<Integer>> result;
private void helper(int[] candidates, int target,int idx,List<Integer> path)
{
   if(target<0||idx==candidates.length)return;
   if(target==0)
   {
       
       result.add(new ArrayList<>(path));
       return;
   }

    helper(candidates,target,idx+1,path);
    path.add(candidates[idx]);
    helper(candidates,target-candidates[idx],idx,path);
    path.remove(path.size()-1);
}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>());
        return result;

        
    }
}