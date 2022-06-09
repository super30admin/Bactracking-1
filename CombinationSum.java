//https://leetcode.com/problems/combination-sum/

// Time Complexity :O(exponential) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
        List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     result=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] nums,int idx,int target,List<Integer> path)
    {
        //base
        // if(idx==nums.length || target<0)
        //     return;
        
        if(target==0) //as the target becomes zero we have the correct path
        {
            ArrayList<Integer> temp=new ArrayList<>(path);
            result.add(temp);
            return;
        }
        //logic
        for(int i=idx;i<nums.length;i++)
        {
            //action
            path.add(nums[i]);
            //recurse
            if(target-nums[i]>=0) //only if target is not negative consider next element of the path
                helper(nums,i,target-nums[i],path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}