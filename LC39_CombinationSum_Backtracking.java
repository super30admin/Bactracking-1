/**
 * 
 */
package LC39_CombinationSum_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neha
 * Leetcode problem 39 using Backtracking
 *
 */
public class LC39_CombinationSum_Backtracking {
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        
        //Edge case
        
        if(candidates == null || candidates.length == 0)
        {
            return result;
        }
          backtrack(candidates, target, 0, new ArrayList<>(), 0);
          return result;
    }

    private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index)
    {
        //Base Case
        if(sum == target)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum > target)
        {
            return;
        }
        
        
        
        
   //Logic
 //Incase of backtraking we should make sure that in the for loop i should begin from index, not 0       
        for (int i = index; i<candidates.length; i++)
        {
            temp.add(candidates[i]);
            backtrack(candidates, target, sum+candidates[i], temp, i);
            temp.remove(temp.size()-1);
        }    
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] candidates = {2,3,5,7};
		int target = 7;
		LC39_CombinationSum_Backtracking obj = new LC39_CombinationSum_Backtracking();
		System.out.println(obj.combinationSum(candidates,target));
		
	}

}
