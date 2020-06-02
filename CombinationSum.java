package s30Coding;
import java.util.*;

//Time Complexity :- O(2^n)
//Space Complexity :- O(n)
public class CombinationSum {
	 List<List<Integer>> result;
	    int targ;
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        result = new ArrayList<>();
	        targ = target;
	        if(candidates == null || candidates.length == 0) return result;
	        
	        backtrack(candidates, new ArrayList<>(),0,0);
	        return result;
	    }
	    
	    private void backtrack(int[] candidates, List<Integer> temp, int sum,int index){

	        if(sum == targ){
	            result.add(new ArrayList<>(temp));
	        }
	        if(sum > targ) return;
	       for(int i = index; i < candidates.length; i++){
	           temp.add(candidates[i]);
	           
	           backtrack(candidates,temp,sum + candidates[i],i);
	           temp.remove(temp.size() - 1);
	       }
	    }
}
