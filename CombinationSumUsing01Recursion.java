package BackTracking;

// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class CombinationSumUsing01Recursion {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();

        helper(candidates, target, 0);
        return result;

    }

    public void helper(int[] candidates, int target, int i)
    {
        if(i == candidates.length || target < 0) return;
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        //not choose
        helper(candidates, target, i+1);

        path.add(candidates[i]);
        //choose
        helper(candidates, target-candidates[i], i);

        path.remove(path.size()-1);

    }
}