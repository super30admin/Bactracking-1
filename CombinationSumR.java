/**
 * Time Complexity: Exponential
 * Space Complexity: Exponential
 * Approach: 
 *  At each point, either you can select a number or not select a number
 *  Explore the possibilities by not selecting a number
 *  Explore all the possibilities by selecting a number
 *  This approach consumes too much space as it creates a deep copy if temp everytime it performs recursion.
 */

class Solution {
    // Declare result
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initialize result
        result = new ArrayList<>();
        
        // Start recursion
        helper(candidates, target, 0, 0, new ArrayList<>());
        
        // return result
        return result;
    }
    
    private void helper(int[] candidates, int target, int currentIndex, int currentSum, List<Integer> temp) {
        // check if current sum exceeds target or currentIndex exceeds input array length then skip
        if(currentSum > target || currentIndex >= candidates.length) {
            return;
        }
        
        // check if current sum equals target so add temp to result
        if(currentSum == target) {
            result.add(temp);
            return;
        }
        
        // Explore all possibilities by not selecting element at currentIndex
        helper(candidates, target, currentIndex + 1, currentSum, new ArrayList<>(temp));
        
        // Add number at currentIndex to selection 
        temp.add(candidates[currentIndex]);
        
        // Explore all possibilities by selecting element at currentIndex
        helper(candidates, target, currentIndex, currentSum + candidates[currentIndex], new ArrayList<>(temp));
        
    }
}
