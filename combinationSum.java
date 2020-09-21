// TC : O(N pow(T/M)) where N is number of candidates and T is target and M is number of candidates which are valid (minimal value of candidates)
// SC : O(T/M) for the recursion stack;

// We are trying to create every  combination of candidates who match the given target. We are considering each candidate and checking if the target is greater than candidate value, if so, we subtract the target from candidate
// value and check if it 0, if the difference is 0, we know the these are candidates who are giving our required target. if remains gets negative, we need to discard that scenario/combination because that is invalid
// Since we can take the same candidate repeatedly, i am checking the same candidate again and again to check with target. Once we have processed a combination, we track to our previous combination and move ahead with other candidates in the array


import java.util.*;

public class combinationSum {

	public List<List<Integer>> CombinationSum(int[] candidate, int target){
		
		List<List<Integer>> res = new ArrayList<>();
		
		if(candidate == null || candidate.length==0)
			return res;
		backTrack(candidate, target, res, 0, new ArrayList<>());
		return res;
	}
	
	public void backTrack(int[] candidates, int remains, List<List<Integer>> res, int st, List<Integer> temp) {
		
		if(remains < 0)
			return;
		
		if(remains == 0)
			res.add(new ArrayList<>(temp));
		
		else{
			for(int i = st;i < candidates.length; i++) {
		
				if(remains < candidates[i])
					continue;
				
				temp.add(candidates[i]);
				backTrack(candidates, remains-candidates[i], res, i, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		combinationSum cs = new combinationSum();
		int[] candidate = {2, 3, 6, 7};
		int target = 7;
		System.out.println(cs.CombinationSum(candidate, target));
		
	}
}
