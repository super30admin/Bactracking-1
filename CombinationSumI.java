// Time Complexity : O((n^2) *(2^n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    // Set
    public List<List<Integer>> combinationSumWithSet(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int remaining = target;
        int startIndex = 0;
        backtrack(result, candidates, new ArrayList<Integer>(), remaining, startIndex);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates, ArrayList<Integer> temp, int remaining, int startIndex){
        if(remaining < 0){
            return;
        } else if (remaining == 0){
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = startIndex ; i < candidates.length; i++){
                temp.add(candidates[i]);
                backtrack(result, candidates, temp, remaining - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

        // Backtracking

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if(candidates == null|| candidates.length == 0){
                return result;
            }
            backtrack(result,target,candidates,0, new ArrayList<>(),0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, int target, int[] candidates, int sum, List<Integer> temp, int index){
            // Base Case
            if(sum == target){
                result.add(new ArrayList<>(temp));
                return;
            }

            // Termination Case
            if(sum > target){
                return;
            }
            // Logic

            for(int i = index; i < candidates.length; i++){
                if(sum + candidates[i] > target){
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(result,target,candidates, sum + candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }

        }
}
