// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We search through the entire tree, and try to find the element x and y 
    along with their corresponding parent and depth
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