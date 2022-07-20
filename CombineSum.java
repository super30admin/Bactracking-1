// Time Complexity : O(n^(t/m)) n is the number of candidates, t is target and m is min among candidates
// Space Complexity : O(t/m) t is target and m is min among candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some problem implementing the code. I was able to think the logic

import java.util.*;

class CombineSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //null
        result = new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){
        //base
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i==candidates.length || target<0) return;
        //logic
        helper(candidates, target, i+1, path);
        //choose
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, target - candidates[i], i, path);
        //backtrack remove
        path.remove(path.size()-1);
    }

    public static void main(String [] args){
        CombineSum cs = new CombineSum();
        System.out.println(cs.combinationSum(new int[]{2,3,6,7},7));
    }
}