import java.util.ArrayList;
import java.util.List;

public class CombinationSumForLoopRecursionNoBacktracking {

        // For loop recursion - no backtracking

        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            result = new ArrayList<>();

            forRecurseBacktrack(candidates, 0, target, new ArrayList<>());

            return result;

        }

        private void forRecurseBacktrack(int[] candidates, int pivotFor, int target,
                                         List<Integer> path) {

            //base
            if(target == 0) {

                result.add(new ArrayList<>(path));
                return;
            }

            if(target < 0) return;

            //logic
            for(int i = pivotFor; i < candidates.length; i++) {

                // create a deep copy of path from the forRecurseBacktrack call function, then take action of adding candidate i to that new path li
                List<Integer> li = new ArrayList<>(path);

                //action
                li.add(candidates[i]);

                //recurse
                forRecurseBacktrack(candidates, i, target - candidates[i], li);

                // No backtracking
            }
        }

}

/*

Time Complexity = O(2^m+n)

m = given target
n = number of elements in candidate

Space Complexity =

 */

/*
Permutations
If we make pivot = zero always,
I.e., start iterating i from zero each time instead of pivot,
In other words, if we iterate i from pivot = zero always, then pivot becomes trivial
Instead remove pivot from recursive call function, make for loop starting from zero
This will give all possible permutations (not just unique combinations, which is the case when pivot is used)
*/
