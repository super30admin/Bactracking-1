// N : number of elements
// T : target value
// M : minimum value in the input

// Time Complexity : O(N^(T/M))
// Space Complexity : O(T/M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 ) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates,int index, int target, List<Integer> path){
//         // base
//         if(target == 0) result.add(new ArrayList<>(path));
//         if(candidates.length == index || target <= 0) return;
//         for(int i = index; i < candidates.length ; i ++){
//             path.add(candidates[i]);
//             helper(candidates,i,target-candidates[i], path);
//             path.remove(path.size()-1);
            
//         }

        // base
        if(target == 0) result.add(new ArrayList<>(path));
        if(candidates.length == index || target <= 0) return;
        //recursion
        // Don't Choose
        helper(candidates,index+1,target, path);
        // Action
        path.add(candidates[index]);
        // Choose
        helper(candidates,index,target-candidates[index], path);
        // Backtrack
        path.remove(path.size()-1);
        
        
    }
}