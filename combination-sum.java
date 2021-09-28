// Time Complexity : O(2^n)  n=no of elements in array
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null || candidates.length==0){return null;}
        
        helper(candidates,0,target,new ArrayList<>());
        return result;
        
    }
   void helper(int[] cand,int index,int target, List<Integer> path)
    {
        if(target==0)
        {result.add(new ArrayList<>(path)); return;}
        //base
        if(target<0 || index==cand.length){ return; }
        //logic
        //no-choose
        helper(cand,index+1,target,path);
        //choose
        path.add(cand[index]);
        helper(cand,index,target-cand[index],path);
       path.remove(path.size()-1);
    }
}