// TC : O(nm) ... m = target
// SC : O(nm)
// Problems faced : None.

class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 res = new ArrayList<>();
		 
		 if(candidates == null || candidates.length == 0) return res;
		 
		 helper(candidates, 0, target, new ArrayList<>());
		 
		 return res;
	}
	
	private void helper(int[] candidates, int i, int amount, List<Integer> path) {
		 // base
		 if(amount == 0) {
			  res.add(new ArrayList<>(path));
			  return;
		 }
		 
		 if(amount < 0 || i == candidates.length) return;
		 
		 // logic
		 
		 // choose
		 path.add(candidates[i]);
		 helper(candidates, i, amount - candidates[i], path);
		 path.remove(path.size() - 1);
		 
		 // not choose
		 helper(candidates, i+1, amount, path);
		 
	}
}