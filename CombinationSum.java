package s30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/* 
    * Constrains to consider:
    * Do we have duplicate elements in the candidates list?
    * Are the elements positive?
    * Do they follow any particular order like ascending or descending?
    */
	/* Time complexity - O(N^N) in the worst case
	 * Space Complexity:
	 * space of recursion stack -> O(M) where, M = (targetElement/minElement in the list)
	 * for path list --> maximum size of the list M, where, M = (targetElement/minElement in the list)
	 */
	public static void main(String[] args) {
		int[] candidates = new int[] {2,3,6,7};
		int target = 7;
		List<List<Integer>> output = combinationSum(candidates, target);
		System.out.println(output);
		
		candidates = new int[] {2,3,5};
		target = 8;
		output = combinationSum(candidates, target);
		System.out.println(output);
	}
	
	//output list that stores list of valid combinations
	static List<List<Integer>> output;
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	output = new ArrayList<List<Integer>>();
    	
        //sort the elements in the candidates array for optimization
        Arrays.sort(candidates);
        
        //recursively call the helper method to store the elements in the output list.
        helper(candidates, 0, target, new ArrayList<Integer>());
        
        return output;
    }
    
    static private void helper(int[] candidates, int index, int remTarget, List<Integer> parentNodes){
        
        //add the elements to output if remaining target value is zero
        if(remTarget == 0){
            output.add(new ArrayList<>(parentNodes));
            return;
        } 
        
        //recursive call
        for(int i=index; i<candidates.length; i++){
        	
            /* 
            * Since the elements are in ascending order, we can stop processing the rest of the list
            * when the remaining target value is negative.
            */
            if(remTarget - candidates[i] < 0){
                break;
            }
            
            //add the current node to the parentNodes path
            parentNodes.add(candidates[i]);
            
            //call the child node
            helper(candidates, i, remTarget - candidates[i], parentNodes);
            
            //remove the current node from the path once all combinations under it are completed
            parentNodes.remove(parentNodes.size()-1);
        }
        
    }
}
