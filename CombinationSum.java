// Time Complexity :O(N^M)   -  where N is the length of the candidates array and M is the target value.
// Space Complexity : O(M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.result = new ArrayList<>();
    if (candidates == null || candidates.length == 0 ) return this.result;
    helper(candidates, target, 0, new ArrayList<>());
    return result;
    }
    
    public void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base condition
        if (target < 0 )  return;  
            
        if(target == 0) {
        result.add(new ArrayList<>(path));
        return;
        }
        
        for(int i= pivot; i < candidates.length; i++){
        
         //Action  
         path.add(candidates[i]);
       
         //Recursive   
         helper(candidates, target - candidates[i], i, path);
         //Backtrack
         path.remove(path.size()-1);
     }
       
 
        
        
    }
    
        
    
}
