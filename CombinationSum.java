// Time Complexity : O(2^n)
// Space Complexity : O(2^n) ; n = min value in list
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result;
    int count;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        count = 0;
        // helper_01_recursion(candidates, 0, new ArrayList<>(), target);
        // helper_01_recursion_backtracking(candidates, 0, new ArrayList<>(), target);
        // helper_forloop_recursion(candidates, 0, new ArrayList<>(), target);
        helper_forloop_recursion_backtracking(candidates, 0, new ArrayList<>(), target);
//        permutation_forloop_recursion_backtracking(candidates, 0, new ArrayList<>(), target);
        System.out.println("count : "+count);
        return result;
    }

    private void helper_01_recursion(int[] candidates,int index, List<Integer> path, int target){
        count++;
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if(target<0 || index == candidates.length) return;

        //logic

        //not choose
        helper_01_recursion(candidates, index + 1,path, target);

        //choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(candidates[index]);
        helper_01_recursion(candidates, index,temp, target - candidates[index]);
    }

    private void helper_01_recursion_backtracking(int[] candidates,int index, List<Integer> path, int     target){
        count++;
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index == candidates.length) return;

        //logic

        //not choose
        helper_01_recursion_backtracking(candidates, index + 1,path, target);

        //choose
        path.add(candidates[index]);
        helper_01_recursion_backtracking(candidates, index, path,target - candidates[index]);
        path.remove(path.size()-1);
    }

    private void helper_forloop_recursion(int[] candidates,int pivot, List<Integer> path, int target)     {
        count++;
        //base
        if(target == 0){
            result.add(path);
            return;
        }
        if(target<0 || pivot == candidates.length) return;

        //logic
        for(int i = pivot; i < candidates.length; i++){
            //action - - create a copy of path before next recursion
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            //recursion
            helper_forloop_recursion(candidates, i, temp, target - candidates[i]);
        }
    }

    private void helper_forloop_recursion_backtracking(int[] candidates,int pivot, List<Integer> path, int target)     {
        count++;
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || pivot == candidates.length) return;

        //logic
        for(int i = pivot; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recursion
            helper_forloop_recursion_backtracking(candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }

    }

    private void permutation_forloop_recursion_backtracking(int[] candidates,int pivot, List<Integer> path, int target)     {
        count++;
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || pivot == candidates.length) return;

        //logic
        for(int i = 0; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recursion
            helper_forloop_recursion_backtracking(candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Combination : " + new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
