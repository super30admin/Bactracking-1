/*
* Approach:
*  1. Extract digits combinations using for-loop based recursion(pivot)
* 
*  2. add to sum, path and recurse.
        if pivot reaches end, check sum with target and add to path
* 
*  3. backtrack the action by removing the candidate from path,
        when recursion is completed.
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

public class CombinationSumForloop {
    List<List<Integer>> result;

    private void combinationSum(int[] candidates, int pivot, int sum,
            int target, List<Integer> path) {
        if (pivot == candidates.length || sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int index = pivot; index < candidates.length; index++) {
            path.add(candidates[index]);

            combinationSum(candidates, index, sum + candidates[index],
                    target, path);

            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();

        combinationSum(candidates, 0, 0, target, new ArrayList<>());

        return result;
    }
}
