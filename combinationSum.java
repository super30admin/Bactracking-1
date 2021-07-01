// Time Complexity: O(2^n)
//Space Complexity: O(2^n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i, List<Integer> path){
        
        // base case
        if(target < 0 || i == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
    //not choose case
        helper(candidates, target, i+1, path);
        
    //choose case
        
        // action
        path.add(candidates[i]);
        
        //recurse
        helper(candidates, target - candidates[i], i, path);
        
        //backtrack action
        path.remove(path.size() -1);
    }
}