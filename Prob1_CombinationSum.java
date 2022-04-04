
// Time Complexity : target / min(candidates) * N - Same as before
// Space Complexity : Depth(Tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)    return result;
        
        helper(candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    public void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //Base
        if(target < 0) return; //Here in For-Loop Recursion, index will not out of bound because,
                               //it will iterate till last element of candidates
        if(target == 0){
         // result.add(new ArrayList<>(path)); //When we do Backtrack and not creating new path while Recursion 
            result.add(path);//If we make we are backtracking, don't need to add copy of current path 
            return;
        }
        
        for(int i = pivot; i < candidates.length; i++){
//             //Choose case - With Backtracking
//             path.add(candidates[i]);
//             helper(candidates, target - candidates[i], i, path);
            
            
//             path.remove(path.size() - 1);
            
            
            //Choose case - Another approach - W/O Backtracking
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], i, temp);
        }
        return;
    }

}
/*
//TC : target / min(candidates) * N
//SC : Depth(Tree)

class Solution { //0-1 Recursion same as Coin Chnage problem
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)    return result;
        
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    public void helper(int[] candidates, int target, int index, List<Integer> path){
        //Base case
        if(index >= candidates.length || target < 0)    return;
        
        if(target == 0){
            result.add(path);
            return;
        }
        
        //Logic
        
        //Choose case
        List<Integer> temp = new ArrayList<>(path);
        temp.add(candidates[index]);
        helper(candidates, target - candidates[index], index, temp);
        
        
        //Don't choose case
        
        helper(candidates, target, index + 1, path);
    }
}


*/