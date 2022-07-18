// Time Complexity : O(2^x) x = T/m +1
// Space Complexity : O(x)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    private static List<List<Integer>> result;

    // approch 1
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        // to store result
        result = new ArrayList<>();
        // null case
        if (candidates.length == 0)
            return result;
        // helper function for recursion
        helper(0, candidates, target, new ArrayList<>());
        return result;
    }

    private static void helper(int ind, int[] candidates, int target, List<Integer> path) {
        // base function
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || ind == candidates.length) {
            return;
        }

        // main logic
        // case 1 not choose
        // for not choose I am skipping current element and jump to the next one
        helper(ind + 1, candidates, target, path);
        // case 2 choose
        // for choose I am remaining on to the current element and add element to my
        // path
        path.add(candidates[ind]);
        helper(ind, candidates, target - candidates[ind], path);
        // after I am coming back to parent I will remove last element from the path.
        path.remove(path.size() - 1);

    }

    // approch 1
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // to store result
        result = new ArrayList<>();
        // null case
        if (candidates.length == 0)
            return result;
        // helper function for recursion
        helper2(0, candidates, target, new ArrayList<>());
        return result;
    }

    private static void helper2(int ind, int[] candidates, int target, List<Integer> path) {
        // base function
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        // main logic
        // for loop based recursion
        // I will start from the pivot element
        for (int i = ind; i < candidates.length; i++) {
            // choose element at pivot element and remain at the same pivot index
            path.add(candidates[i]);
            // after my base case i will go to next index
            helper2(i, candidates, target - candidates[i], path);
            // after I am coming back to parent I will remove last element from the path.
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[] { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum1(candidates, target));
        System.out.println(combinationSum2(candidates, target));

    }
}