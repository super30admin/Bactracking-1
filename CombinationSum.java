// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(2powern) since we have two choices (choose or not choose) that are being selected exponentially
//Space Complexity: O(n) where n is the height of the choices tree
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int i, List<Integer> path){
        
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(target < 0 || i == candidates.length){
            return;
        }
        
        //case 1  - Not choose
        backtrack(candidates, target, i+1, path);
        
        //case 2 - Choose
        // once the not choose backtrack call ends, control goes to the right most child
        path.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i, path);       
        
        //backtrack
        path.remove(path.size() - 1); // remove last element added 
    }
}