// Time complexity - O(nxn)
// Space complexity - O(nxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        result = new ArrayList<>();
        List<Integer> path = new ArrayList();
        
        helper(candidates, target, 0, path);
        
        return result;
        
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path ){
        
        //base case
        if(target < 0){
            
            return;
        }
        if(target == 0){
            
            result.add(new ArrayList(path));
            return;
        }
        
        if(index >= candidates.length){
            
            return;
        }
        
        //case when not taking 
        
             helper(candidates, target, index + 1, path);
            
            path.add(candidates[index]); //action
            
            helper(candidates, target - candidates[index] , index, path); //recurse
            
            //backtrack
            path.remove(path.size()-1);
            
        }
    }
