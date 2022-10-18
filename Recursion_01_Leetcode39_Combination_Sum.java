//approach -1
//choose element, add to the path, dont increment index , update target and do recursive call
// not choose lement and update index only , and no other parms. 

//TC -Exponential
//sc- Exponential
//We create n local arraylist here

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        
        return result;
    }
    
    private void  helper(int[] candidates, int index, int target, List<Integer> path)
    {
        //action
        //base case
        if(target <0 || index==candidates.length) return;
        if(target == 0)
        {
            result.add(path);
            return;
        }
        
        //recurse
        //not choose
        helper(candidates, index+1, target, new ArrayList<>(path));
        
        
        //choose
        path.add(candidates[index]);
        helper(candidates, index, target-candidates[index], new ArrayList<>(path));
        
        //backtracking
    }
}

//approach -2 Backtracking - Action, recurse, backtrack
//choose element, add to the path, dont increment index , update target and do recursive call
// not choose lement and update index only , and no other parms. 

//TC -Exponential
//sc- Exponential
//We do back tracking here and only create new array ist when target  == 0. 


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        
        return result;
    }
    
    private void  helper(int[] candidates, int index, int target, List<Integer> path)
    {
        //action
        //base case
        if(target <0 || index==candidates.length) return;
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //recurse
        //not choose
        helper(candidates, index+1, target, path);
        
        
        //choose
        path.add(candidates[index]);
        helper(candidates, index, target-candidates[index], path);
        
        //backtracking
        path.remove(path.size()-1);

    }
}