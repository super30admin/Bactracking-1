package BackTracking;

// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class CombinationSumUsingForLoopBasedRecursion {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>());
        return result;

    }

    public void helper(int[] candidates, int target, int pivot, List<Integer> path)
    {
        if(target<0 || pivot==candidates.length) return;

        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=pivot; i<candidates.length; i++)
        {
            List<Integer> temp = new ArrayList<Integer>(path);
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], i, new ArrayList<>(temp));
        }
    }
}
