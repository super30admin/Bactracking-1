package com.ds.rani.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
//Approach: find out all the combinations and add those combinations who meet the criteria
//Time complexity:n*(2^n)
//Space complexity:o(n) as we are maintaning only single list
public class CombinationSum {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return result;

        List<Integer> combination = new ArrayList<>();
        findCombinationToTarget_backtrack( candidates, combination, 0, target, 0 );
        return result;
    }

    private void findCombinationToTarget_backtrack(int[] candidates, List<Integer> combinations, int sum, int target, int start) {

        //base case
        if (sum == target) {
            result.add( new ArrayList<>( combinations ) );
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {

            //action
            combinations.add( candidates[i] );

            //recursion
            findCombinationToTarget_backtrack( candidates, combinations, sum + candidates[i], target, i ); // not i + 1 because we can reuse same elements

            //backtrack
            combinations.remove( combinations.size() - 1 );


        }
    }
}
