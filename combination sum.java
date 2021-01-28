// k = the max length of the given candidates array and n is the numbers of leaf nodes
// Time Complexity : O(k * 2^n)
// Space Complexity : O(k * 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //master list where we will put the paths
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //initialize res
        res = new ArrayList<>();
        //edge 
        if(candidates == null || candidates.length == 0) return res;
        //call backtrack
        backtrack(candidates, new ArrayList<>(), 0, target);
        return res;
    }
    
    //we will take candidates as paramater, just one path not a new arraylist each time since we will be back tracking, index to keep track of choose and no choose and target
    private void backtrack(int[] candidates, List<Integer> path, int index, int target){
        //base
        //boundaries
        if(target < 0 || index == candidates.length) return;
        //if the target == 0 then add it to the result 
        if(target == 0){
            //you want to create a new array list here and add it to the result because we are back tracking and removind end elements from the path array so create a copy and add it to the final result array.
            res.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        
        //no choose
        //call backtrack with same parametrs but increase index by one since it wasn't chosen
        backtrack(candidates, path, index + 1, target);
        
        //choose
        //call backtrack with same parameters but don't increase index and decresae your target but the num you chose
        //and add the path because you are choosing this num
        path.add(candidates[index]);
        backtrack(candidates, path, index, target - candidates[index]);
        
        //backtrack
        //remove the last index from the array list since we are backtracking and don't want to create a new copy of the array list each time
        path.remove(path.size()-1);
    }
}


