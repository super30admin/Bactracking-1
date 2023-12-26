// Time Complexity : O(2 pow(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

import java.util.ArrayList;
import java.util.List;

//Given array of candidates, need to find path sum that meets the target. Repetition of nums allowed
//Sol: This is same as DP Coin Change. Solve using choose, dont choose recursion, use backtracking to maintain
//path List
public class CombinationSum {

    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        result = new ArrayList<>();
        path = new ArrayList<>();
        //recursively call helper function - DFS
        helper(candidates, target, 0);
        return result;
    }

    private void helper(int[] candidates, int target, int currIndex){
        //base
        if(target < 0 || currIndex == candidates.length)
            return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //don't choose
        helper(candidates, target, currIndex+1);
        //choose
        //bktrck - action
        path.add(candidates[currIndex]);
        //bktrck - recurse
        helper(candidates, target - candidates[currIndex],currIndex);
        //bktrck - backtrack
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        var res = cs.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(res);
    }
}
