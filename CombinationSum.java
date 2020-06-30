/**
 * Time Complexity : O(2^N)
 * Space Complexity : O(N) where N is the size of candidates array
 */

import java.util.*;

public class CombinationSum{
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length==0) return result;
        backtrack(candidates, new ArrayList<>(), 0,0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index ){
        //base
        if(sum==targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        //logic
        
        if(sum>targ) return;
        
        for(int i=index; i<candidates.length;i++){
        //action
        temp.add(candidates[i]);
        //recurse
        backtrack(candidates,temp,sum+candidates[i],i);
        //backtrack
        temp.remove(temp.size()-1);
        
        }
        
    }

    /* Recursive approach 
     private void helper(int[] candidates, List<Integer> temp, int sum, int index ){
        
        //base
        if(sum == targ) {
            result.add(temp);
            return;
        } 
        
        if(sum>targ || index==candidates.length) return;
        
        //logic
        
        //dont choose
        helper(candidates,new ArrayList<>(temp),sum,index+1);
        
        //choose
        temp.add(candidates[index]);
        helper(candidates,new ArrayList<>(temp),sum+candidates[index],index);
}       
    */
}