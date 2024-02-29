package week6.day1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_01 {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		helper(candidates, 0, path, target); // starting index is 0
		System.out.println(result);
		return result;
	}

	private void helper(int[] candidates, int idx, List<Integer> path, int target) {
		if (target == 0) {
			result.add(new ArrayList<>(path));
			
			return;
		}
		if (target < 0 || candidates.length == idx)
			return;
		
		
		helper(candidates, idx + 1, path, target);
		
		path.add(candidates[idx]);
		helper(candidates, idx, path, target - candidates[idx]);	
		path.remove(path.size() - 1);

		

	}

	public static void main(String[] args) {
		CombinationSum_01 solution = new CombinationSum_01();
		int[] candidates = { 2, 3 , 1};
		int target = 7;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		System.out.println("Result: " + result);
	}
}