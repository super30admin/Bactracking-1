/**
Problem: https://leetcode.com/problems/combination-sum/
*/

/**
Approach 1: Choose or not choose
TC: O(exponential)
SC: depends on height of the tree -> target / min(ele) + 1
*/
class Solution {
    List<List<Integer>> result = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        combinationSum(candidates, new ArrayList<>(), 0, 0, target);
        return result;
    }
    
    private void combinationSum(int[] candidates, List<Integer> curCombination, int index, int curSum, int target) {
        if (index >= candidates.length || curSum > target) {
            return;
        }
        
        if (curSum == target) {
            result.add(new ArrayList<>(curCombination));
            return;
        }
        
        // Case 1: do not choose the element
        combinationSum(candidates, curCombination, index + 1, curSum, target);
        // Case 2: choose the element
        curCombination.add(candidates[index]);
        combinationSum(candidates, curCombination, index, curSum + candidates[index], target);
        curCombination.remove(curCombination.size() - 1);
    }
}

/**
Approach 2: For loop based recursion
TC: O(exponential)
SC: depends on height of the tree -> target / min(ele) + 1
*/
class Solution {
    List<List<Integer>> result = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        combinationSum(candidates, new ArrayList<>(), 0, 0, target);
        return result;
    }
    
    private void combinationSum(int[] candidates, List<Integer> curCombination, int index, int curSum, int target) {
    	// Don't have to check for index going out of bounds because the for loop below ensures that won't happen
        if (curSum > target) {
            return;
        }
        
        if (curSum == target) {
            result.add(new ArrayList<>(curCombination));
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            curCombination.add(candidates[i]);
            combinationSum(candidates, curCombination, i, curSum + candidates[i], target);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}