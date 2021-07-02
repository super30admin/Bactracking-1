package Backtracking1;

import java.util.ArrayList;
import java.util.List;

public class question68_CombinationSum {
    /* Created by palak on 6/30/2021 */

    /*
        Time Complexity: O(2 ^ n)
        Space Complexity: O(n)
    */
    List<List<Integer>> result1;
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        result1 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result1;

        helper1(candidates, target, 0, new ArrayList<>());
        return result1;
    }

    private void helper1(int[] candidates, int target, int index, List<Integer> path) {
        //Base Case
        if(index == candidates.length || target < 0) return;
        if(target == 0) {
            result1.add(new ArrayList<>(path));
            return;
        }
        //Logic
        //Not Choose
        helper1(candidates, target, index + 1, path);
        //Choose
        path.add(candidates[index]);
        helper1(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);
    }


    /*
        Time Complexity: O(2 ^ n)
        Space Complexity: O(n)
    */
    List<List<Integer>> result2;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result2 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result2;

        helper2(candidates, target, 0, new ArrayList<>());
        return result2;
    }

    private void helper2(int[] candidates, int target, int index, List<Integer> path) {
        //Base Case
        if(index == candidates.length || target < 0) return;
        if(target == 0) {
            result2.add(new ArrayList<>(path));
            return;
        }
        //Logic

        //Choose
        path.add(candidates[index]);
        helper2(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);

        //Not Choose
        helper2(candidates, target, index + 1, path);
    }

    /*
        Time Complexity: O(2 ^ n)
        Space Complexity: O(n)
    */
    List<List<Integer>> result3;
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        result3 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result3;

        helper3(candidates, target, 0, new ArrayList<>());
        return result3;
    }

    private void helper3(int[] candidates, int target, int index, List<Integer> path) {
        //Base
        if(target == 0) {
            result3.add(path);
            return;
        }
        if(target < 0) return;
        //Logic
        for(int i = index ; i < candidates.length ; i++) {
            List<Integer> copy = new ArrayList<>(path);
            copy.add(candidates[i]);
            helper3(candidates, target - candidates[i], i, copy);
        }
    }

    /*
        Time Complexity: O(2 ^ n)
        Space Complexity: O(n)
    */
    List<List<Integer>> result4;
    public List<List<Integer>> combinationSum4(int[] candidates, int target) {
        result4 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result4;

        helper4(candidates, target, 0, new ArrayList<>());
        return result4;
    }

    private void helper4(int[] candidates, int target, int index, List<Integer> path) {
        //Base
        if(target == 0) {
            result4.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        //Logic
        for(int i = index ; i < candidates.length ; i++) {

            path.add(candidates[i]);
            helper4(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {

    }
}
