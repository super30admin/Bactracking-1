// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tar = target;
        bactracking(candidates,new ArrayList<>(), 0, 0);
        return result;
    }
    private void bactracking(int[] candidates, List<Integer> temp, int sum , int index){
        //base
        if(sum == tar){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum > tar)return;
        //logic
        for(int i = index; i < candidates.length; i++){
            
        //action
            temp.add(candidates[i]);
        //recursion
            bactracking(candidates, temp, sum + candidates[i] , i);
        //bactracking
            temp.remove(temp.size()-1);
        
        }
    
    }
}