// TC: O(N) where n is length of the string
// SC : O(N) for the recursion stack

// We are trying to provide every combinations possible with the string provided and for the operators, we check which values give us the required target and store them in the result
// So we need a result list, path which we are considering which we are supposed to add in our result list and calculations that are required with those operators and the value they provide during calculation
// We are ignoring repetitive patterns and if number is 0.

import java.util.*;

public class ExpressionOperators {
	
	public List<String> exop(String nums, int target){
		
		List<String> res = new ArrayList<>();
		if(nums == null || nums.length() == 0)
			return res;
		exopBacktrack(nums, target, "", 0, res, 0, 0);
		return res;
	}
	
	public void exopBacktrack(String nums, int target, String path, int pos, List<String> res, long eval, long mult) {
		
		if(pos == nums.length())
		{
			if(target == eval) {
				res.add(path);
			}
			return;
		}
		
		for(int i = pos;i<nums.length();i++) {
			if(i!=pos && nums.charAt(pos)=='0')
				break;
			
			long curr = Long.parseLong(nums.substring(pos, i+1));
			if(pos == 0) {
				exopBacktrack(nums, target, path+curr, i+1, res, curr, curr);
			}
			else{
				exopBacktrack(nums, target, path+"+"+curr, i+1, res, eval+curr, curr);
				exopBacktrack(nums, target, path+"-"+curr, i+1, res, eval-curr, -curr);
				exopBacktrack(nums, target, path+"*"+curr, i+1, res, eval-mult+mult*curr, mult*curr);
			
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		ExpressionOperators eo = new ExpressionOperators();
		String nums = "123";
		System.out.println(eo.exop(nums, 6));
	}

}
