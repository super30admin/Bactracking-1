// Time Complexity - O(2^target) -- check once
// Space Complexity - O(2^target) -- check once

class Solution {
    List<List<Integer>> finRes;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        finRes = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>());
        return finRes;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> result){
        // base
        
        if(target<0 || pivot>=candidates.length) return;
        if(target==0){
            finRes.add(new ArrayList<>(result));
            return;
        }
        // logic for 'for loop' based recursion
        for(int i=pivot;i<candidates.length;i++){
            result.add(candidates[i]);
            helper(candidates, i, target-candidates[i],result);
            result.remove(result.size()-1);
        }
        // logic for 0,1 based recursion 
        // choose
        // result.add(candidates[pivot]); //action
        // helper(candidates, pivot,target-candidates[pivot],result);//recurse
        // result.remove(result.size()-1);//backtrack

        // // not choose
        // helper(candidates,pivot+1,target,result);

    }
}