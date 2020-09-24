// Time Complexity : O(Math.pow(n,(target/smallest element) + 1 )) because we are checking for each possibility for each candidate
// Space Complexity : O(target / smallest element) ; target / smallest element will give the length of the path i.e. our arraylist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)    return new ArrayList();
        
        List<Integer> path = new ArrayList();
        
        backtrack(candidates, target, 0, path);
        
        return output;
    }
    
    private void backtrack(int[] candidates, int target, int index, List<Integer> path){
        //base case
        if(target < 0){
            return;
        }else if(target == 0){ //adds the path to the output arraylist which contains integers which sums up to the target
            output.add(new ArrayList<>(path));
        }
        
        for(int i = index; i < candidates.length; i++){
            
            //add the element
            path.add(candidates[i]);
            
            //backtracking to check all the possibilities
            backtrack(candidates, target - candidates[i], i, path);
            
            //remove the element
            path.remove(path.size() - 1);
            
        }
    }
}
