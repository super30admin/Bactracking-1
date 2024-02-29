package week6.day1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_Forbased {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		helper(candidates, 0, path, target); // starting index is 0
		return result;
	}

	private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}
		if (target < 0 || candidates.length == pivot)
			return;
		for (int i = pivot; i < candidates.length; i++) {
			path.add(candidates[i]); // action
			System.out.println(path);
			helper(candidates, i, path, target - candidates[i]); // recursive
			path.remove(path.size() - 1); // Backtracking
		}
	}

	public static void main(String[] args) {
		CombinationSum_Forbased solution = new CombinationSum_Forbased();
		int[] candidates = { 2, 3,4 };
		int target = 8;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		System.out.println("Result: " + result);
	}
}
