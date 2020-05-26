// Time Complexity : O(2^n) where n is hte number of candidates 
// Space Complexity : O(target/min(n)) where n is the number of candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Start with the choices of selecting the first element or not. If we skip the element
we move to the next index, if we choose it, we explore it with infinite length first, then we explore it with the next element, we explore their combination
with infinite length of either one and so on. But we backtrack as we notice if the sum exceeds the target, or the summ is equal to the target because
we have achieved our result here. Now we will do new explorations, where we would explore the next element either with its own infinite occurances
or combining with the next available element to get new sum and at the end, each time check the sum and target on being equal, if yes, add to result.  */

// RECURSION
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length == 0){return result;}                                                // Base Case
        helper(candidates, 0, 0, temp);
        return result;
    }
    private void helper(int[] candidates, int sum, int i, List<Integer> temp){
        if(i >= candidates.length){return;}
        if(sum == targ){                                                                                // if sum equal to target, add to result
            result.add(temp);
            return;
        }
        if(sum > targ){return;}                                                                        // if sum exceeds the target, return 
        // No choose
        helper(candidates, sum, i+1, new ArrayList<Integer>(temp));                                    // Check on next element, I dont choose
        // Choose
        temp.add(candidates[i]);                                                                        // I choose this element
        System.out.println(temp);
        helper(candidates, sum + candidates[i], i, new ArrayList<Integer>(temp));                   // Check the sum and with infinite occurance of the element
    }
}


// BACKTRACKING
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length == 0){return result;}                            // Base Case
        backtrack(candidates, 0, 0, temp);
        return result;
    }
    private void backtrack(int[] candidates, int sum, int index, List<Integer> temp){
        if(sum == targ){                                                                            // Sum == target, add to result
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > targ){
            return;}                                                                              // Sum exceeds target, return, no point
        for(int i = index ; i < candidates.length; i++){                                            // iterating over the next available element for the sum
        // Choose
        temp.add(candidates[i]);                                                                    // Choosing the element, adding to the temp list
        backtrack(candidates, sum + candidates[i], i, temp);                                    // Check the sum along with infinite occurances of the element 
        temp.remove(temp.size()-1);                                                                     // Backtrack, remove the last element as the job is done!
        }
    }
}