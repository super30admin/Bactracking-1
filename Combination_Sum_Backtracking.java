
// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.*;

public class Combination_Sum_Backtracking {
	List<List<Integer>> result;
	int tar;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		tar = target;
		if (candidates == null || candidates.length == 0)
			return result;
		backtrack(candidates, new ArrayList<>(), 0, 0);
		return result;
	}

	private void backtrack(int candidates[], List<Integer> list, int Sum, int Index) {
		// base
		if (Sum > tar)
			return;
		if (Sum == tar) {
			result.add(new ArrayList<>(list));
			return;
		}
		// logic
		for (int i = Index; i < candidates.length; i++) {
			// action
			list.add(candidates[i]);
			// recurse
			backtrack(candidates, list, Sum + candidates[i], i);
			// backtrack
			list.remove(list.size() - 1);
		}
	}
}