import java.util.ArrayList;
import java.util.List;
//Time Complexity : No idea
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Start with 0th index. iterate till the last index. In each iteration, add the index
 * to the list and then update the target after subtracting it and call the same helper
 * for the decremented target with the index as current index until target is <= 0. Once
 * target is reached or crossed, index will be moved to next one.
 *
 */
class Solution {
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