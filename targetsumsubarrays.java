// Time Complexity : O(2 power n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
used for loop based recursion and backtracked when evere returned.


class Solution {
    List<List<Integer>>result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return result;
        helper(candidates ,target,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target,int idx,List<Integer>path){
        //base
        if(target == 0 ){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || idx ==  candidates.length){
            return;
        }
        
        //logic
        for(int i = idx;i<candidates.length;i++){
            
            
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,target-candidates[i],i,path);
           
            //backtrack
            path.remove(path.size()-1);
        }
    }
}