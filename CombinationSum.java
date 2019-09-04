import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(n^k) where n is number of elements in array, k is depth of tree
 * Space: O(target/k) where k is the smallest element among given candidates
 * Leetcode accepted: yes
 * Problems faced: Handling the recursion in backtracking
 */
public class CombinationSum {
	static List<List<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(combinedSum(candidates, 7));
	}
	
	private static List<List<Integer>> combinedSum(int[] candidates, int target) {
		backtracking3(candidates, new ArrayList<Integer>(), target, 0);
		return result;
	}

	private static void backtracking(int[] candidates, List<Integer> temp, int target, int index) {
		//base case
		if(index >= candidates.length || target < 0) {
			return;
		}
		
		if(target == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for(int i=index; i<candidates.length; i++) {
			temp.add(candidates[i]); 
			backtracking(candidates, temp, target-candidates[i], i); // Passing the same temp, updated target and same i(because repetition is allowed)
			temp.remove(temp.size()-1);
		}
	}
	
	// Tried using the approach discussed for Subsets. Accepted on Leetcode.
	private static void backtracking2(int[] candidates, List<Integer> temp, int target, int index) {
		for(int i=index; i<candidates.length; i++) {
			temp.add(candidates[i]);
			if(target == candidates[i]) { //case (i)
				result.add(new ArrayList<>(temp));
			} else if(target > candidates[i]) { //case (ii)
				backtracking2(candidates, temp, target-candidates[i], i);
			}
			temp.remove(temp.size()-1); //In case of (iii) target < candidates[i] element still gets added and removed in this approach, so there is scope for improvement
		}
	}
	
	// Improving the runtime in the above approach, optimizing in case (iii) by avoiding unnecessary addition and removal of elements
	private static void backtracking3(int[] candidates, List<Integer> temp, int target, int index) {
		for(int i=index; i<candidates.length; i++) {
			if(target < candidates[i]){
               continue;
            }
			temp.add(candidates[i]);
			if(target == candidates[i]){
				result.add(new ArrayList<>(temp));
			} else {
				backtracking(candidates, temp, target-candidates[i], i);
			}
			temp.remove(temp.size()-1);
		}
	}
}
