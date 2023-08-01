package Backtracking_1;

import java.util.ArrayList;
import java.util.List;
/**
 * Using choose-no choose based recursion and also for loop based recursion to solve the problem.
 * 
 * Time Complexity :
 * O(2^(m+n))- where n is the no of values given and m is the target.
 * 
 * Space Complexity :
 * O(m+n), actually is the height of the tree in worst case(skewed tree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // helper(candidates,0, target, new ArrayList<>());
        forLoopRecursion(candidates,0, target, new ArrayList<>());
        return result;
    }

    void helper(int[] candidates, int idx, int target, List<Integer> path){
        //base
        if(idx>=candidates.length || target<0)
            return;
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], path);
        path.remove(path.size()-1);
        //no choose
        helper(candidates, idx+1, target, path);

    }

    void forLoopRecursion(int[] candidates, int pivot, int target, List<Integer> path)
    {
        //base
        if(target<0)
            return;
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            forLoopRecursion(candidates, i, target-candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}
