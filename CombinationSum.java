import java.util.*;

//Time complexisty: O(N*2^N) where N is size of array
//space complexity: O(N*2^N)

//Approach
/**
 * 1. Since repeated numbers are allowed, add a number into list and keep adding until the sum is greater 
 * than equal to target value.
 * 2. Then backtrack the steps (remove the numbers added in temp list) and add numbers at other indices 
 * and check whether sum equals target value.
 */

class CombinationSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int sum, int index, List<Integer> temp,  List<List<Integer>> result) {
        
        //Base
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum > target || index == candidates.length){
            return;
        }
        
        //Logic
        
        for(int i = index; i<candidates.length; i++) {
            
            temp.add(candidates[i]);
            helper(candidates, target, sum+candidates[i], i, temp , result);
            temp.remove(temp.size()-1);
        }
        
//         helper(candidates, target, sum, index+1, temp , result);
        
//         temp.add(candidates[index]);
        
//         helper(candidates, target, sum+candidates[index], index, new ArrayList<>(temp), result);
        
        
    }
}