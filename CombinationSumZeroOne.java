/*
* Approach:
*  1. Apply choose, not choose scenario.    
        Proceed forward for not choose.
        Add candidate to path and proceed forward for choose
*       
*  2. backtrack the addition of candidate to path for next calls.
* 
*  3. If sum == target, add to result
    or return if sum> target or index out of bounds
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2^n)
    n = no of candidates
* 
* Space Complexity: O(n)
* 
*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumZeroOne {
    List<List<Integer>> result;

    private void combinationSum(int[] candidates, int index, int sum,
            int target, List<Integer> path) {
        if (index < 0 || sum > target)
            return;

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // not choose
        combinationSum(candidates, index - 1, sum, target, path);

        path.add(candidates[index]);

        combinationSum(candidates, index, sum + candidates[index], target, path);

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();

        combinationSum(candidates, candidates.length - 1, 0, target, new ArrayList<>());

        return result;
    }
}
