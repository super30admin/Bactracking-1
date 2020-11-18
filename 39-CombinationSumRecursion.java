/**LC-39
 * 
 * Time Complexity : 
 * Space Complexity : 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
 * 
 * At each node, i.e in recursive helper function call, i forgot to create new arraylist
 *
 Algorithm:  Problem is similar to the coin change problem
 At each node, we either choose or not choose a number
 We need to create new list at every node, since if we dont do that, since in the recursive stack, ref is passed
 so the same list is manipulated at every node.
 
 */
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates, target, 0, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int sum, List<Integer> temp, int i){
        
        //base
        if(sum > target || i >= candidates.length) return;
        if(sum == target){
            
            result.add(temp);
            return;
        }
        
        //logic
        
        //not choose
        helper(candidates, target, sum, new ArrayList<>(temp), i+1);
        
        //choose
        temp.add(candidates[i]);
        helper(candidates, target, sum + candidates[i], new ArrayList<>(temp), i);
    }
}