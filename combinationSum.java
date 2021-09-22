// Time Complexity : O(N^N)
// Space Complexity : O(N^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int valueSoFar = 0;
        List<Integer> list = new ArrayList<>();
        helperCombinationSum(candidates, target, list, 0);
        return solution;
    }
    
    public void helperCombinationSum(int[] candidates, int target, List<Integer> list, int start) {
        if(target < 0){
            return;
        }
        
        if(target == 0){
            solution.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=start; i<candidates.length; i++){
            
            list.add(candidates[i]);
            helperCombinationSum(candidates, target-candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    
    }  
}