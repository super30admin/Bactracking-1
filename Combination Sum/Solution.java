/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) - temp list to store current list
 * Idea:
 * 1. Iterate through each element and check if runningSum == target. Include duplicates
 * 2. Maintain a tempList to track summed elements so far. Backtrack a step if runningSum crosses target or end of array
 * 3. Return result
 * Leetcode: Yes
 */


import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void combinationSumHelper(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remainingSum, int start){

        if(remainingSum < 0){
            return;
        }

        else if(remainingSum == 0){
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i=start;i<candidates.length;i++){
                tempList.add(candidates[i]);
                combinationSumHelper(result, tempList, candidates, remainingSum-candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Combination Sum");
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }
}