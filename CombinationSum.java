// Time Complexity: Exponential
// Space Complexity:
// Did this code successfully run on Leetcode : Yes

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if(remain < 0)
            return;
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = start; i < nums.length; i++) {
                //action
                tempList.add(nums[i]);
                //recurse
                backtrack(list, tempList, nums, remain - nums[i], i);
                //backtrack
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
