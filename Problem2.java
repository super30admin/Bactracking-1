
//Time Complexity : O(k^n)
//k is the average number of options per position.
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/**
 finds all unique combinations of elements from the candidates array that sum up to the target,
 using a backtracking approach to explore all possible combinations.
 */
import java.util.ArrayList;
import java.util.List;

class Problem2 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates, target, 0, new ArrayList<>());

        return ans;

    }

    public void helper(int[] candidates, int target, int start, List<Integer> list) {

        if (target == 0) {

            ans.add(new ArrayList<>(list));

            return;

        } else if (target < 0)

            return;

        for (int i = start; i < candidates.length; i++) {

            list.add(candidates[i]);

            helper(candidates, target - candidates[i], i, list);

            list.remove(list.size() - 1);

        }

    }

}