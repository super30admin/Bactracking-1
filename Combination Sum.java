/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

// T: O(k ^ n) where n - no of candidates; k - largest number of elements possible in the path
// S: Using recursion Stack


class Solution {
    
    // T: O(n ^ k) where n - no of candidates; k - largest number of elements possible in the path
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(candidates.length == 0)  return result;
        
        // Without sort also works but more calculations
        // With sort we can have a if condition where the candidate is gretater than target
        // and just skip that case
        Arrays.sort(candidates);
        
        List<Integer> path = new ArrayList<Integer>();
        
        backtrack(result, path, candidates, target, 0);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index){
        
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            
            if(candidates[i] > target)  break;
            
            path.add(candidates[i]);
            backtrack(result, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}