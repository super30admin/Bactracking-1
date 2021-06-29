// Time Complexity : O(2 POW N) // at every node we can take 2 decisions.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. it is DP problem as we can see sub problems in the tree
 * 2. at each node we can take two decision chose or not chose
 * 3. when chosen you can use same element again.
 * 4. remove the element from list when backtracking
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] candidates, int target,int index,List<Integer> list){
        //when target reached add to result and return
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        //end of the array or target is -ve return
        if(index>=candidates.length || target<0) return;
        
        //not chose
        helper(candidates,target,index+1,list);
        //chose
        list.add(candidates[index]);
        helper(candidates,target-candidates[index],index,list);
        //back track
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7));
	}
}
