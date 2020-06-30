
// Time Complexity : O(2^N)
// Space Complexity : O((2^N) * N)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.*;

public class Combination_Sum_Recursive {
	List<List<Integer>> result;
	int tar;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		tar = target;
		if (candidates == null || candidates.length == 0)
			return result;
		helper(candidates, new ArrayList<>(), 0, 0);
		return result;
	}

	private void helper(int candidates[], List<Integer> list, int Sum, int Index) {
		// base
		if (Sum > tar || Index == candidates.length)
			return;
		if (Sum == tar) {
			result.add(list);
			return;
		}
		// logic
		// Don't choose
		helper(candidates, new ArrayList<>(list), Sum, Index + 1);
		// choose
		list.add(candidates[Index]);
		helper(candidates, new ArrayList<>(list), Sum + candidates[Index], Index);
	}
}