// Time Complexity : O(2^(n+m))  -->  max of length of array and target
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int pivot,List<Integer> list )
    {
        // base case
        if(target < 0 || pivot == candidates.length) return;
        if(target ==0){
            result.add(new ArrayList<>(list));  // make a deep copy of array as we are back tracking and can loose all paths
        }

        // logic
        for(int i =pivot; i< candidates.length;i++)
        {
            //action
            list.add(candidates[i]); // add the element to path and see target can be reached
           //recurse
            helper(candidates, target-candidates[i], i, list);  // target should be decreased by candidates[i] as it is taken in path
           //backtrack
            list.remove(list.size()-1);// remove that element added to use same list
            
        }
    }
}