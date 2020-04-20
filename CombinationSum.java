//Time complexity: O(n!)
//Space complexity: O(1)

import java.util.*;

class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
	backtrack(combinations, new ArrayList<>(), candidates, target, 0, 0);
	return combinations;
}
    
// for different permutations of result ...make i = 0 in for loop

private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int sum, int start) {
	if (sum > target)
		return;
	if (sum == target) 
		combinations.add(new ArrayList<>(combination));
	else 
		for (int i = start; i < candidates.length; i++) {
			combination.add(candidates[i]);
			backtrack(combinations, combination, candidates, target, sum + candidates[i], i);
			combination.remove(combination.size() - 1);
		}
}
}