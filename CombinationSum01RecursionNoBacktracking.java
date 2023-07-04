import java.util.ArrayList;
import java.util.List;

public class CombinationSum01RecursionNoBacktracking {


        // 01 RECURSION - NO BACKTRACKING SOLUTION

        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            result = new ArrayList<>();

            recursion(candidates, 0, target, new ArrayList<>());

            return result;

        }

        private void recursion(int[] candidates, int i, int target, List<Integer> path) {

            // base
            if(target == 0) {

                result.add(path);
                return;
            }

            if(target < 0 || i == candidates.length) return;

            //logic
            // no choose
            // create a new reference for each path or deep copy of path for every recursive call
            // costs time and space, instead backtracking helps
            recursion(candidates, i+1, target, new ArrayList<>(path));

            // choose
            path.add(candidates[i]);
            recursion(candidates, i, target - candidates[i], new ArrayList<>(path));

            /* alternative logic if choose comes before no choose

           // choose
           List<Integer> li = new ArrayList<>(path);
           li.add(candidates[i]);
           recursion(candidates, i, target - candidates[i], li);

           // no choose
           recursion(candidates, i+1, target, new ArrayList<>(path));

           */


        }

}

/*
Time Complexity = O(2^m+n)

m = given target
n = number of elements in candidate

Space Complexity =

 */