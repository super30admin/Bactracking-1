/*
Time: O(2^N) and space: O(N)

Algorithm:
=========
1. Keep track of sum so far and index 
2. From index to the end of the array, iterate through every possible combination of the elements to get target sum.
3. Add element to the temporary list, call backtrack method with element index as start and then if target is not found, remove from the list
4. If found, add the temporary list to the result
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        backtrack(candidates, target, 0, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void backtrack(int[] candidates, int target, long sum, int start, List<Integer> state) {
        //base
        if(sum == target) {             // if combination found, add arraylist to result
            result.add(new ArrayList<>(state));
            return;
        }
        
        if(sum > target) return;            // no target sum found
        //logic
        for(int i = start; i < candidates.length; i++) {
            state.add(candidates[i]);                                        // add element to the temporary list
            backtrack(candidates, target, sum + candidates[i], i , state);   // backtrack with update sum at same index because of possible duplicates
            state.remove(state.size()-1);                                   // remove element from temporary list
        }
    }
}
