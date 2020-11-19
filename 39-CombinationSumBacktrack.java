/**LC-39
 * 
 * Time Complexity : 
 * Space Complexity : 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:  
 Here we avoid creating a new list at every node, and maintain a single ArrayList as auxiliary space
 Since we are maintaining a single list, we will backtrack our action explicitly.
 for example, here we will be remove the last node from the list when we backtrack
 */
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index){
        
        //base
        if(sum > target) return;   //index check would be taken care of by the for loop
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
       
        
        //logic
        
        for(int i = index; i < candidates.length; i++){
            
            //action
            temp.add(candidates[i]);
            
            //recurse
            backtrack(candidates, target, sum+candidates[i], temp, i);
            
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}