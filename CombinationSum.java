// Time Complexity : exponential
// Space Complexity : exponential
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*

1. Solved the problem using recursion first, created copies of the target list all the time
2. Tried backtracking by maintainting single reference to the target list
*/
class combinationSum {
     List<List<Integer>> result;
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(null == candidates || candidates.length == 0) {
            return result;
        }
        backtrack(candidates, target, 0, new ArrayList<Integer>(), 0);
        return result;
     }
    
     private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index) {
        //base
         if(sum == target) {
            result.add(new ArrayList<Integer>(temp));
            return;
         }
         
         if(sum > target) return;
         //logic
         for(int i = index; i < candidates.length; i++) {
            //logic
             temp.add(candidates[i]);
             //recurse
             backtrack(candidates, target, sum + candidates[i], temp, i);
             //backtrack
             temp.remove(temp.size() -1);
         }
     }
    
    
    
    /*
    // Normal recursive logic
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(null == candidates || candidates.length == 0) {
            return result;
        }
        helper(candidates, target, 0, new ArrayList<Integer>(), 0);
        return result;
        
    }
    private void helper(int[] candidates, int target, int sum, List<Integer> temp, int i) {
        //base
        if(sum > target || i >= candidates.length) return;
        
        if(sum == target) {
            result.add(temp);
            return;
        }
        
        //logic
        //do not choose
        // i+1 to jump to next index
        helper(candidates, target, sum, new ArrayList<Integer>(temp), i+1);
        
        //choose
        temp.add(candidates[i]);
        helper(candidates, target, sum + candidates[i], new ArrayList<Integer>(temp), i);
        
    }
    */
}