// Time Complexity : O(2^(m+n)) where m is target and n is number of candidates
// Space Complexity : O(2^(m+n)) where m is target and n is number of candidates
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : forgot Integer.MIN_VALUE


// Your code here along with comments explaining your approach


class Solution {
    //Declaring result in global scope
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Initialize result
        result = new ArrayList<>();
        //Recursively call helper function
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base condition
        //When target is 0, we got the result so add the path to result
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //If target goes less than zero, stop the recursion
        if(target<0){
            return;
        }
        //If we reach end of elements, stop the resursion
        if(pivot == candidates.length) return;
        

        //don't choose
        helper(candidates, target, pivot+1, path);
        
        //Action
        path.add(candidates[pivot]);
        //choose
        helper(candidates, target-candidates[pivot], pivot, path);

        //Backtrack
        path.remove(path.size()-1);
        return;
    }
}