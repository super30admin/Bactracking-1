/*
Author: Akhilesh Borgaonkar
Problem: find all unique combinations in candidates where the candidate numbers sums to target
Approach: Used backtracking approach here. Start with first candidate and find the difference between the candidate and target sum. If the difference is 0 then, add the
    candidate to result list. If the difference is negative then, ignore the current candidate. If the difference is positive then, call the function recursively 
    on the subset of candidates starting from current to last.
Time Complexity: O(n^n)
Space complexity: O(n)
LC verified.
*/


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        Arrays.sort(candidates);

        if(candidates.length == 0)
            return result;
        else
            return getCombinations(result, currResult, candidates, target, 0);
    }
    
    private static List<List<Integer>> getCombinations(List<List<Integer>> result, List<Integer> currResult, int[] candidates, int target, int start){
        if(target==0){
            result.add(new ArrayList<Integer>(currResult));
            return result;
        }
        for(int i=start ; i<candidates.length; i++){
            if(candidates[i]>target)
                break;
            currResult.add(candidates[i]);
            getCombinations(result, currResult, candidates, target - candidates[i], i);
            currResult.remove(currResult.size()-1);
        }
        return result;
    }
}
