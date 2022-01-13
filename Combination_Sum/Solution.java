// Time Complexity : Exponential towards (2 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/**
 * We will use backtracking approach to generate comibations and whichever combo is right we will add it to result.
 * For combo, we will run a for loop from current index to last element and then generate recursive call
 * Once we have seen all combos from current index, we will remove it from current path.
 * In base conditions, whenever our target becomes 0, we know that we have found correct path so we copy it into new list and add it to result
 * we return from current iteration as soon as target becomes negative and for 0 we have added current path to result
*/




class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        helper(candidates, target, 0, new ArrayList<Integer>());
        
        return result; 
    }
    
    private void helper(int[] candidates, int target, int index, ArrayList<Integer> curr){
        //base case
        if(target == 0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target < 0){
            return;
        }
        //logic
        for(int i = index; i < candidates.length;i++){
            curr.add(candidates[i]);
            helper(candidates, target - candidates[i], i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}