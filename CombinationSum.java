// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each element, either choose or dont choose that element recursively, while adding and removing the elements from the path until target == 0.

public class CombinationSum {
    // Solution 1 : Backtracking
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null ) return result;
        
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, 0, path);
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        if(index == candidates.length || target < 0) return;
        
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //no choose case
        helper(candidates, target, index+1, path);
        
        //add the candidate to the path
        path.add(candidates[index]);
        
        //choose case
        helper(candidates, target - candidates[index] , index, path);
        
        //remove the candidates while backtracking
        path.remove(path.size() - 1);
    }

    // Solution 2 : Recursion
    // List<List<Integer>> result = new ArrayList<>();
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     if(candidates == null ) return result;
        
    //     List<Integer> path = new ArrayList<>();
    //     helper(candidates, target, 0, path);
        
    //     return result;
    // }
    
    // private void helper(int[] candidates, int target, int index, List<Integer> path){
    //     if(index == candidates.length || target < 0) return;
        
    //     if(target == 0) {
    //         result.add(path);
    //         return;
    //     }
        
    //     //no choose case
    //     helper(candidates, target, index+1, new ArrayList<>(path));
        
    //     //add the candidate to the path
    //     path.add(candidates[index]);
        
    //     //choose case
    //     helper(candidates, target - candidates[index] , index, new ArrayList<>(path));
    // }
}
