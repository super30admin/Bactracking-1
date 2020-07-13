class Solution {
    
// Time Complexity : O(2^n)  n: number of candidates;     all possible combinations of choosing and not choosing
// Space Complexity : O(max(n,target)^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 Rrecursion --> use new list at every call
 1. Choose and don't choose candidiate so that all possible combinations (valid/invalid) are explored.

 */
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(candidates == null) return result;
    
        helper(candidates, 0,  target, 0, new ArrayList<Integer>(), result);

        return result;
    }
    
    private void helper(int[] candidates, int index,  int target, int sum,List<Integer> list, List<List<Integer>> result){
        
        if(sum>target || index==candidates.length){
            return;
        }

        //base
        if(sum == target){        
            result.add(list);
            return;
        }
        
        
        //don't choose
        helper(candidates, index+1,  target, sum, new ArrayList(list), result);
        //choose
        list.add(candidates[index]);
        helper(candidates, index,  target, sum+candidates[index], new ArrayList(list), result);
            
    }
}




class Solution {
    
// Time Complexity : O(2^n)  n: number of candidates;     all possible combinations of choosing and not choosing
// Space Complexity : O(max(n,target)) ; copying the new list & recursion stack -->backtrack function --> dfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 Backtracking --> use the same list and copy it result when target reaches.
 1. If a candidiate value is less than or equal to target add to list
 2. Once sum equals target, copy the list to result
 3. Then undo the first step by removing the last candidate value, so that we can further explore other possible solutions
 */
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(candidates == null) return result;
    
        backtrack(candidates, 0,  target, 0, new ArrayList<Integer>(), result);

        return result;
    }
    
    private void backtrack(int[] candidates, int index,  int target, int sum,List<Integer> list, List<List<Integer>> result){

        //base1
        if(sum>target){
            return;
        }
        //base2
        if(sum == target){        
            result.add(new ArrayList(list));
            return;
        }
        
        //logic
        for(int i = index ; i < candidates.length; i++){
                list.add(candidates[i]);     //action
                backtrack(candidates, i, target, sum+candidates[i], list, result); //recurse
                list.remove(list.size()-1);   //backtrack--> undo action
        }
    }
}