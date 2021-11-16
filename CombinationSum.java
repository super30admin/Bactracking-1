// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result=new ArrayList<>();
        helper(candidates,target,result,new ArrayList<>(),0);
        return result;
    }
    
    public void helper(int[] candidates, int target,List<List<Integer>> result, List<Integer> currList, int index){
        if(index==candidates.length){
            return;
        }
        
        if(target==0){
            result.add(new ArrayList(currList));
            return;
        }
        
        if(target<0){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            currList.add(candidates[i]);
            helper(candidates,target-candidates[i],result,currList,i);
            currList.remove(currList.size()-1);
        }
        
    }
}