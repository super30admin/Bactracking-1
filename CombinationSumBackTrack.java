// Time Complexity : 2^N
//Space Complexity : O(N) the width of the tree 
//Did this code successfully run on Leetcode : Yes
// -----BackTracking-------
class Solution {
    List<List<Integer>> result;
    int targ;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        targ = target;
    //    if(candidates == null || candidates.length = 0) return result;
        backTracking( candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    
    public void backTracking(int[] candidates, List<Integer> temp, int sum, int index){
        //base
        if(sum == targ) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > targ) return;
        //logic
        for(int i = index; i< candidates.length; i++){
            //action
            temp.add(candidates[i]);
            //recurse
            backTracking(candidates, temp, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
        
        //backtrack
        
    }
}