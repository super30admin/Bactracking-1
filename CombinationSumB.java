/**
 * Time Complexity: Exponential
 * Space Complexity: O(n + target)
 * LeetCode: Y(https://leetcode.com/problems/combination-sum)
 * Approach:
 *   With backtracking, there is a great improvement of space complexity over normal recursion as we are only maintaining a single temp arraylist
 *   Create a deep copy of temp arraylist and add it to result only when temp is a part of the solution
 *   Algorithm: Take action(add), explore the possibilities of action ,backtrack(retrace)
 */

class Solution {
    // 
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initialize result
        result = new ArrayList<>();
        
        // Check for edge case
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        
        // Start recursion
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        
        // return result
        return result;
    }

    /** Helper function to perform recursion */
    private void backtrack(int[] candidates, int target, int currentSum, int currentIndex, List<Integer> temp) {
        // if the current sum exceeds target then return
        if(currentSum > target) {
            return;
        }
        
        // if the current temp leads to the solution then append temp to result
        if(currentSum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // Loop from currentIndex to the end of the array
        for(int i = currentIndex ; i < candidates.length ; i++) {
            // Take Action: Append candidates[i] to temp as candidates[i] could be a part of solution
            temp.add(candidates[i]);
            
            // Recursion: Evaluate all the possibilities by adding candidates[i] 
            backtrack(candidates, target, currentSum + candidates[i], i, temp);
            
            // After evaluating all the possibilities of candidates[i], remove it i.e. perform backtracking
            temp.remove(temp.size() - 1);
        }
    }
}
