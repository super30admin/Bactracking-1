//Problem 1: Combination Sum
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> every number has 2 choices, to choose and not choose
//Choose -> call recursive function on same number(1 number can be selected multiple times) and reduce the target by the selected number
//NOT choose-> call recursive func on next number(as we didnt choose that) keep the target same. 
//Can be done with 01 recursion or for loop based recursion (basically both are same)
class Solution {
    List<List<Integer>> res;
    //brute force TC: O(m+n) SC: O(m+n)(height of tree)
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     this.res=new ArrayList<>();
    //     if(candidates==null) return res;
    //     helper(candidates,0, target,new ArrayList<>());
    //     return res;
    // }
    // private void helper(int[] candidates, int i, int target, List<Integer> path){
    //     //base
    //     //if candidate addition has passed actual target, return, or else all elements are passed, return
    //     if(target<0 || i ==candidates.length) return;
    //     if(target==0){ 
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }
    //     //logic
    //     //not choose
    //     helper(candidates, i+1, target, path);

    //     //choose
    //     //action
    //     path.add(candidates[i]);
    //     //reverse
    //     helper(candidates, i, target-candidates[i], path);

    //     path.remove(path.size()-1);
    // }

    // for loop based recursion
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res=new ArrayList<>();
        if(candidates==null) return res;
        helper(candidates,0, target,new ArrayList<>());
        return res;
    }
    private void helper(int[] candidates, int pivot, int target, List<Integer> path){
        //base
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        
        for(int i=pivot;i<candidates.length;i++){ //for loop from pivot onwards to last element
            //action
            path.add(candidates[i]);
            helper(candidates, i, target-candidates[i], path);
            path.remove(path.size()-1);
            //choose
        }
    }
}