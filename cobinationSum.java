// Time Complexity : exponential
// Space Complexity : O(No.of elements + target)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took time to understand
// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();        
        helper(candidates, target, 0, 0, new ArrayList());
        return result;
    }
    
    public void helper(int[] candidates, int target, int index, int sum, List<Integer> temp) {
        
        // base case
        if(sum > target)
            return;
        
        if(sum == target) {
            result.add(new ArrayList(temp));
            return;
        }
        
        // logic        
        for(int i = index; i < candidates.length; i++){        
            temp.add(candidates[i]);
            helper(candidates, target, i, sum + candidates[i], temp); 
            temp.remove(temp.size() - 1);

        }
        
    }
    
}