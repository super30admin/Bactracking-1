// Time Complexity : O((Target/Min value in list) + Length(n))
// Space Complexity : largest number of nested brackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

//forward recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int [] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        //logic
        for(int i = index; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recursive
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
    
}

/*// doing it with backtrack to remove element in recurssion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int [] candidates, int target, int i, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path)); //result.add(path); if we don't add then we return 2 empty list
            return;
        }
        if( i == candidates.length || target < 0) return;
        //logic
        // we can do it choose first
        
        //case 1 no choose
        helper(candidates, target, i + 1, path);
        //choose
        //action
        path.add(candidates[i]);
        //recurssion happens
        helper(candidates, target - candidates[i], i, path);
        //backtrack
        path.remove(path.size() - 1);
        
    }
    
}
*/
/*
// choose ,no choose  - scenario (brute force recurssion)
//we have to add it to a new list due to pre order
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int [] candidates, int target, int i, List<Integer> path){
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if( i == candidates.length || target < 0) return;
        //logic
        //choose
        List<Integer> li = new ArrayList<>(path);
        li.add(candidates[i]);
        helper(candidates, target - candidates[i], i, li);
        //case 1 no choose
        helper(candidates, target, i + 1, new ArrayList<>(path));
        
    }
    
}
*/
/* no choose, choose - scenario (brute force recurssion)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int [] candidates, int target, int i, List<Integer> path){
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if( i == candidates.length || target < 0) return;
        //logic
        //case 1 no choose
        helper(candidates, target, i + 1, new ArrayList<>(path));
        //choose
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, new ArrayList<>(path));
    }
    
}
*/