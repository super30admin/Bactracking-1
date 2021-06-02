// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For each node we have two options to skip the element or to take the element and hence reducing the target.
    The base condition being either the target becoming 0 or index running out of bounds
*/

class Solution {
    List<List<Integer>> result; 
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(candidates, target, 0);
        return result;
    }
    
    public void backtrack(int[] candidates, int target, int index){        
        
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        else if (target < 0 || index >= candidates.length) return;
        
        backtrack(candidates, target, index+1);
        path.add(candidates[index]);
        backtrack(candidates, target-candidates[index], index);
        path.remove(path.size()-1);
    }
}
