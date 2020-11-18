// Time Complexity : O(n^m) exponential time complexity where n = no. of elements in the array and
// m is the target value
// Space Complexity : O(m) m levels in the recursive stack, m is the target value
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We will be using the backtracking approach as we need to explore all the possible solutions using only single extra
 * data structure ie Array list.
 * */


import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;

        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index) {
        //base
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target){
            return;
        }

        //logic
        for(int i = index; i<candidates.length; i++){
            //action
            temp.add(candidates[i]);
            //recursion
            backtrack(candidates, target, sum+candidates[i], temp, i);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
