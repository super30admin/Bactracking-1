// Time Complexity : O(2^n), We have 2 choices.
// Space Complexity : O(n), Length of the candidates list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //for loop based recursion without backtracking
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    public void helper(int[] candidates, int target, int index, List<Integer> path){
        if(target==0){
            result.add(path);
            return;
        }
        if(target<0)return;
        //logic
        //starting from index not from 0 cause we need to move from pivot
        for(int i=index;i<candidates.length;i++){
            //action
            //adding the path to newli if not we get only last elements
            List<Integer> newli = new ArrayList<>(path);
            newli.add(candidates[i]);
            //recurse
            helper(candidates,target-candidates[i],i,newli);
        }
        
    }
}