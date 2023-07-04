import java.util.ArrayList;
import java.util.List;

public class CombinationSumForLoopRecursiveBacktracking {

        // For loop recursion with backtracking

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

                //action
                path.add(candidates[i]);

                //recurse
                forRecurseBacktrack(candidates, i, target - candidates[i], path);

                //backtrack
                path.remove(path.size() - 1);
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
If no reuse of elements for solution, Pivot would be moved to i+1 in for loop recursion call
 */