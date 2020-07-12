// Time Complexity :O(2^n) n is the length of the candidate array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates,target,new ArrayList<>(),0);
        return result;
    }
    
    public void backtrack(int[] candidates, int target,List<Integer> temp , int start){
        //base cases
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
            }
        if(target<0) return;
        
        //logic
        for(int i =start;i<candidates.length;i++){
            //action
            temp.add(candidates[i]);
            
            //recurse
            backtrack(candidates,target-candidates[i],temp,i);
            
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}