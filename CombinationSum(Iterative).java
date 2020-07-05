// Time Complexity :O(2^n)
// Space Complexity :O(n^2) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tar = target;
        helper(candidates,new ArrayList<>(), 0, 0);
        return result;
    }
    private void helper(int[] candidates, List<Integer> temp, int sum , int index){
        //base
        if(sum == tar){
            result.add(temp);
            return;
        }
        
        if(sum > tar || index == candidates.length)return;
        //logic
        
        
        //dont choose
        helper(candidates, new ArrayList<>(temp) , sum , index + 1);
        //choose
        temp.add(candidates[index]);
        helper(candidates, new ArrayList<>(temp) , sum + candidates[index], index );
        
        
        }
    
    }