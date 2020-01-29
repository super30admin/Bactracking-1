// Time Complexity : O(N!)
// Space Complexity : O(N!)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        dfs(candidates, target, 0, 0, res, temp);	// recursively call the dfs function and backtrack one left up all the time to find the unique combinations
        
        return res;
    }
    
    private void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> res, List<Integer> temp){
        //base case
        if(sum > target){		// if sum is greater than target, return 
            return;
        }
        
        if(sum == target){		// if we find the combination, add it to the result list.
            res.add(new ArrayList(temp));
            return;
        }
        //logic
        
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);		// add the node, before we move forward to keep track of the combinations
            dfs(candidates, target, i, sum + candidates[i], res, temp);		// recursion
            temp.remove(temp.size() - 1);			// if the combination is found, remove the elements after the combination to get the correct list. BackTracking
        }
    }
}