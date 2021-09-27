package Bactracking1;
// Time Complexity : O(2^n / 2) = O(2^n) where n is target ( 2^n / 2 is because if we implement choose not choose recursion which is 2^n
// , here we are doing on choose cases, hence 2^n / 2)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int pivot, int target, List<Integer> path){
        //base
        if(target < 0 || pivot == candidates.length)
            return;
        if(target == 0)
            result.add(new ArrayList<>(path));
        //logic
        for(int i=pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
